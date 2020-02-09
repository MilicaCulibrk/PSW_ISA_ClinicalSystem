package main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.dto.LekarDTO;
import main.dto.PregledDTO;
import main.dto.TipPregledaDTO;
import main.dto.ZahtevZaOdmorDTO;
import main.dto.ZahtevZaPregledDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pacijent;
import main.model.Pregled;
import main.model.ZahtevZaOdmor;
import main.model.ZahtevZaPregled;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;
import main.repository.ZahtevZaPregledRepository;
import main.service.AdminKlinikeService;
import main.service.MailService;
import main.service.PacijentService;
import main.service.PregledService;
import main.service.ZahtevZaPregledService;

@CrossOrigin
@RestController
@RequestMapping(value = "/pregled")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private ZahtevZaPregledService zahtevZaPregledService;

	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private PacijentService pacijentService;
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;


	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;


	
	@Autowired
	private MailService mailService;

	
	
	@GetMapping(value = "/izlistajUDP/{idKlinike}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getIzlistajUDP(@PathVariable Long idKlinike) {
		
		List<Pregled> listaPregleda = pregledService.findAll();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		
		
		for (Pregled p : listaPregleda) {
			if( p.getIdPacijenta() == null)
				if(p.getLekar().getKlinika().getId().equals(idKlinike))
					
			listaPregledaDTO.add(new PregledDTO(p));
			
										}
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<List<PregledDTO>> getPreglede() {
		
		List<Pregled> listaPregleda = pregledService.findAll();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		
		
		for (Pregled p : listaPregleda) {
					
			listaPregledaDTO.add(new PregledDTO(p));
		}	
										
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/zavrsi")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<List<PregledDTO>> zavrsiPregled( @RequestBody PregledDTO pregledDTO) {
		
		List<Pregled> listaPregleda = pregledService.findAll();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		
		
		for (Pregled p : listaPregleda) {
			if(p.getId() == pregledDTO.getId()) {
				p.setZavrsen(true);
				pregledRepository.save(p);
				break;
			}
		}	
		
		List<Pregled> listaPregleda2 = pregledService.findAll();
		
		for (Pregled p : listaPregleda2) {
			listaPregledaDTO.add(new PregledDTO(p));
		}	
										
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/zakaziUDPregled/{idPacijenta}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<PregledDTO> zakaziPregled( @RequestBody PregledDTO pregledDTO, @PathVariable Long idPacijenta) {
		
		Pregled pregled = (Pregled) pregledService.findOne(pregledDTO.getId());

				
		if (pregled == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Pregled zakazanPregled = pregledService.zakaziPregled(idPacijenta, pregled);
		PregledDTO newPregledDTO = new PregledDTO(zakazanPregled);


		return new ResponseEntity<>( newPregledDTO, HttpStatus.OK);
		
	}
	
	
	//dodaj predefinisani pregled kao administrator klinike sa ogranicenjima
	@PostMapping(value = "/dodajPregled", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<PregledDTO> dodajPregled(@RequestBody PregledDTO pregledDTO) {

		System.out.println("LALALALLA");
		
		PregledDTO pregleddto = new PregledDTO();
		boolean flag = false;
		
		System.out.println(pregledDTO.getLekar().getPocetak());
		System.out.println(pregledDTO.getVreme());
		
		 Integer pocetakRV = pregledDTO.getLekar().getPocetak();
		 Integer krajRV = pregledDTO.getLekar().getKraj();
		 
		 String pocetakPstr = pregledDTO.getVreme();
		 Integer pocetakP = Integer.parseInt(pocetakPstr);
		 Integer trajanjeP = pregledDTO.getTrajanjePregleda();
	
		 Integer krajP = pocetakP + trajanjeP;
		 
			//termin ne sme pocinjati pre radnog vremena lekara i zavrsavati se posle radnog vremena lekara
		    if(pocetakP < pocetakRV || pocetakP > krajRV) {
				flag = true;
				System.out.println("udji ovdeeee");
			}
			
			//termin ne sme pocinjati posle radnog vremena lekara, a zavrsavati se posle radnog vremena lekara
		    if(pocetakP >= pocetakRV && krajP > krajRV) {
				flag = true;
				System.out.println("udji ovdeeee2");
			}
			
		 
		 //ako postoji predefinisan pregled sa istom salom i datumom proverimo da li se vreme poklapa, jer ne sme
		 List<Pregled> pregledi = pregledService.findAll();
			for(Pregled pregled : pregledi) {
				
				
				String vremeStr = pregled.getVreme();
				Integer pocetakPregleda =  Integer.parseInt(vremeStr);
				Integer trajanjePregleda = pregledDTO.getTrajanjePregleda();
				Integer krajPregleda = pocetakPregleda + trajanjePregleda;
				
				
				if(pregledDTO.getDatum().equals(pregled.getDatum()) && pregled.getSala().getId() == pregledDTO.getSala().getId()) {
				
					//pregled ne sme da pocne u terminu drugog pregleda
					if(pocetakP > pocetakPregleda && pocetakP < krajPregleda) {
						flag = true;
					}
					
					//termin ne sme da pocne pre pocetka drugog pregleda a zavrsi se posle pocetka drugog pregleda
					else if(pocetakP <= pocetakPregleda && krajP > pocetakPregleda) {
						flag = true;
					}
					
				//ako postoji pregled sa istim datumom i razlicitom salom ali istim lekarom
				}else if(pregledDTO.getDatum().equals(pregled.getDatum()) && pregled.getSala().getId() != pregledDTO.getSala().getId() && pregled.getLekar().getId() == pregledDTO.getLekar().getId()) {
						
				    //ako pregled pocinje u terminu drugog pregleda
					if(pocetakP > pocetakPregleda && pocetakP < krajPregleda) {
						flag = true;
					}
					
					//termin ne sme da pocne pre pocetka drugog pregleda a zavrsi se posle pocetka drugog pregleda
					else if(pocetakP <= pocetakPregleda && krajP > pocetakPregleda) {
						flag = true;
					}
					
			
				}
			}
			
			if(!flag) {
				pregleddto = pregledService.dodajPregled(pregledDTO);
			}
		 
			if(flag) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			
			}			
	
			return new ResponseEntity<>(pregleddto, HttpStatus.OK);
	}
  
  @GetMapping(value = "/nadjiOdradjen/{idPacijenta}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> nadjiOdradjen(@PathVariable Long idPacijenta) {
		
		List<Pregled> listaPregleda = pregledService.findAll();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		
		
		for (Pregled p : listaPregleda) {
			if( p.isZavrsen()==true) {
				if(p.getIdPacijenta().equals(idPacijenta)) {
					
			listaPregledaDTO.add(new PregledDTO(p));
			
				}		}
		}
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/podnesiZahtevLekar/{idPregleda}")
	@PreAuthorize("hasAuthority('LEKAR')")
	//dinamicki pravi id pregleda
	public ResponseEntity<?> podnesiZahtevLekar(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO, @PathVariable Long idPregleda)
			
	    throws MailException, InterruptedException {
		
		System.out.println("Usao u funkciju");

			Pregled pregled = pregledService.findOne(idPregleda);
			Boolean flag = false;
			
			zahtevZaPregledDTO.setLekar(new LekarDTO(pregled.getLekar()));
			zahtevZaPregledDTO.setTipPregleda(new TipPregledaDTO(pregled.getLekar().getTipPregleda()));
			zahtevZaPregledDTO.setIdPacijenta(pregled.getIdPacijenta());
			zahtevZaPregledDTO.setCena(pregled.getTipPregleda().getCena());
			zahtevZaPregledDTO.setStatus("na_cekanju");		
			
			System.out.println(zahtevZaPregledDTO.getVrstaPregleda());
			
			Integer radnoOd = pregled.getLekar().getPocetak();
			Integer radnoDo = pregled.getLekar().getKraj();
			
			List<Pregled> pregledi = pregledService.findAll();
			List<ZahtevZaPregled> zahtevi = zahtevZaPregledService.findAll();
		
			Double vreme = Double.parseDouble(zahtevZaPregledDTO.getVreme());
			Double trajanje = Double.valueOf(zahtevZaPregledDTO.getTrajanje());
			
			//ako je zakazan pre radnog vremena lekara ili posle
			if(vreme < pregled.getLekar().getPocetak() || vreme >= pregled.getLekar().getKraj())
			{
				flag = true;
				System.out.println(zahtevZaPregledDTO.getDatum());
				System.out.println("USAO 3");
			}
			
			//ako je zakazan unutar radnog vremena ali traje duze od radnog vremena
			if(vreme >= pregled.getLekar().getPocetak() && vreme <= pregled.getLekar().getKraj() && (vreme + trajanje) >= pregled.getLekar().getKraj())
			{
				flag = true;
				System.out.println("USAO 4");
			}
			
			//ako hocu da rezervisem datum za koji vec imam preglede
			for (Pregled p : pregledi) {
				 if (zahtevZaPregledDTO.getDatum().equals(p.getDatum())
						&& p.getLekar().getId() == zahtevZaPregledDTO.getLekar().getId()) 
				 {				
					    //ako hocemo da zakazemo pregled usred nekog drugog pregleda
						if(vreme >= Double.parseDouble(p.getVreme()) && vreme < (Double.parseDouble(p.getVreme()) + p.getTrajanje()))
						{
							flag = true;
							
							System.out.println("USAO 1");
						}
						
						//ako hocemo da zakazemo pregled koji pocinje pre nekog ali se zavrsava posle njega
						if(vreme <= Double.parseDouble(p.getVreme()) && (vreme + trajanje) >= Double.parseDouble(p.getVreme()))
						{
							flag = true;
							System.out.println("USAO 2");
						}
						
					
				 }
					 
			}
			
			
			
			//ako hocu da rezervisem datum za koji vec imam zahteve za preglede
			for(ZahtevZaPregled z : zahtevi) {

				
				if(zahtevZaPregledDTO.getDatum().equals(z.getDatum()) && zahtevZaPregledDTO.getLekar().getId() == z.getLekar().getId()) {
					 //ako hocemo da zakazemo pregled usred nekog drugog pregleda
					if(vreme >= Double.parseDouble(z.getVreme()) && vreme < (Double.parseDouble(z.getVreme()) + Double.valueOf(z.getTrajanje())))
					{
						flag = true;
						System.out.println("USAO 5");
					}
					
					//ako hocemo da zakazemo pregled koji pocinje pre nekog ali se zavrsava posle njega
					if(vreme <= Double.parseDouble(z.getVreme()) && (vreme + trajanje) >= Double.parseDouble(z.getVreme()))
					{
						flag = true;
						System.out.println("USAO 6");
					}
					
				}
			}
				
				System.out.println(flag);
			
			//ne mozes tada da zakazes pregled
			if (flag == true) {
			
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			
			if(flag == false) {
			
				
				
				List<AdministratorKlinike> adminiKlinika = adminKlinikeService.findAll();
				AdministratorKlinike admin = new AdministratorKlinike();
				
				
				for (AdministratorKlinike adminKlinike : adminiKlinika) {
					System.out.println("Usao u listu admina klinike");
					System.out.println(adminKlinike.getKlinika().getId());
					System.out.println(zahtevZaPregledDTO.getLekar().getIdKlinike());
					if (adminKlinike.getKlinika().getId() == zahtevZaPregledDTO.getLekar().getIdKlinike()) {
						System.out.println("Nasao admina klinike");
						String message = "Podneli ste zahtev za pregled/operaciju na Vasoj klinici od lekara "
								+ zahtevZaPregledDTO.getLekar().getIme() + " " + zahtevZaPregledDTO.getLekar().getPrezime();
						mailService.sendNotificaitionAsync(adminKlinike, message);
						
						admin = adminKlinike;
					}
				}
				
				pregledService.dodajZahtev(zahtevZaPregledDTO, admin);
				
			}
			

		 return new ResponseEntity<>(null, HttpStatus.OK);
			
	}
	
	@PostMapping(value = "/podnesiZahtevPacijent")
	@PreAuthorize("hasAuthority('PACIJENT')")
	//dinamicki pravi id pregleda
	public ResponseEntity<?> podnesiZahtevPacijent(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO)
			
	    throws MailException, InterruptedException {
	
			zahtevZaPregledDTO.setVrstaPregleda("pregled");
			zahtevZaPregledDTO.setTrajanje(1);
			zahtevZaPregledDTO.setStatus("odobren");
		
			Pacijent pacijent = pacijentService.findOne(zahtevZaPregledDTO.getIdPacijenta());
			List<AdministratorKlinike> adminiKlinika = adminKlinikeService.findAll();
			AdministratorKlinike admin = new AdministratorKlinike();

			for (AdministratorKlinike adminKlinike : adminiKlinika) {
				System.out.println("Usao u listu admina klinike");
				System.out.println(adminKlinike.getKlinika().getId());
				System.out.println(zahtevZaPregledDTO.getLekar().getIdKlinike());
				if (adminKlinike.getKlinika().getId() == zahtevZaPregledDTO.getLekar().getIdKlinike()) {
					System.out.println("Nasao admina klinike");

					String message = "Pacijent "
							+ pacijent.getIme() + " " + pacijent.getPrezime() + " je podneo zahtev za pregled.";
					mailService.sendNotificaitionAsync(adminKlinike, message);
					
					admin = adminKlinike;
				}
			}

	     pregledService.dodajZahtev(zahtevZaPregledDTO, admin);		
			
		 return new ResponseEntity<>(null, HttpStatus.OK);
			
	}
	
	@PostMapping(value = "/dodajZakazaniPregled/{datum}/{vreme}/{idSale}/{idZahteva}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	//dinamicki pravi id pregleda
	public ResponseEntity<String> dodajZakPregled(@PathVariable String datum, @PathVariable String vreme, @PathVariable Long idSale, @PathVariable Long idZahteva) throws MailException, InterruptedException{
			

		ZahtevZaPregled zahtevZaPregled = zahtevZaPregledRepository.findById(idZahteva).orElse(null);
			
		String errormessage = "";
		
		 String[] datumm = zahtevZaPregled.getDatum().split("T");
		
		 System.out.println(datum);
		 System.out.println(datumm[0]);
		 
		 Pregled pregled = new Pregled();
		 
		 if(datum.equals(datumm[0]) && vreme.equals(zahtevZaPregled.getVreme())) {

			  pregled.setCena(zahtevZaPregled.getCena());
			  pregled.setDatum(zahtevZaPregled.getDatum());
			  pregled.setIdPacijenta(zahtevZaPregled.getIdPacijenta());
			  pregled.setTrajanje(zahtevZaPregled.getTrajanje());
			  pregled.setVreme(zahtevZaPregled.getVreme());
			  pregled.setVrstaPregleda(zahtevZaPregled.getVrstaPregleda());
			  pregled.setZavrsen(false);
			  pregled.setLekar(lekarRepository.findById(zahtevZaPregled.getLekar().getId()).orElse(null));
			  pregled.setSala(salaRepository.findById(idSale).orElse(null));
			  pregled.setTipPregleda(tipPregledaRepository.findById(zahtevZaPregled.getTipPregleda().getId()).orElse(null));
			  
			  pregledRepository.save(pregled);
			  
			  zahtevZaPregled.setDatum(datum + "T00:00:00.000Z");
			  zahtevZaPregled.setVreme(vreme);
			  zahtevZaPregled.setSala(salaRepository.findById(idSale).orElse(null));
			  zahtevZaPregled.setStatus("odobren");
			 
			  
			  zahtevZaPregledRepository.save(zahtevZaPregled);
			
			  

			 String messagePacijent = "Odobren Vam je zahtev za pregled kod lekara " + pregled.getLekar().getIme() + " " + pregled.getLekar().getPrezime()  + " za vreme " + datumm[0] + " " + pregled.getVreme() + " sati" +  " u sali " + pregled.getSala().getNaziv(); 
			 mailService.sendNotificaitionAsync(pacijentService.findOne(pregled.getIdPacijenta()), messagePacijent);
						

			 String messageLekar = "Odobren Vam je zahtev za pregled za vreme " + datumm[0]  + " u " + pregled.getVreme() + " sati" + " u sali " + pregled.getSala().getNaziv(); 
			 mailService.sendNotificaitionAsync(pregled.getLekar(), messageLekar);			
  
			 
			 errormessage = "Pregled odobren!";
			 return new ResponseEntity<String>(errormessage, HttpStatus.OK);
			 
		 }else {
			 
			 System.out.println("jaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			 
			 Lekar lekar = lekarRepository.findById(zahtevZaPregled.getLekar().getId()).orElse(null);
			 List<Pregled> pregledi = pregledService.findAll();
			 Boolean flag = false;
			 
			 Integer vremeInt = Integer.parseInt(vreme);
			 
			//ako je zakazan pre radnog vremena lekara ili posle
				if(vremeInt < lekar.getPocetak() || vremeInt > lekar.getKraj())
				{
					flag = true;
					System.out.println("USAO 3");
				}
				
				//ako je zakazan unutar radnog vremena ali traje duze od radnog vremena
				if(vremeInt >= lekar.getPocetak() && vremeInt <= lekar.getKraj() && (vremeInt + zahtevZaPregled.getTrajanje()) >= lekar.getKraj())
				{
					flag = true;
					System.out.println("USAO 4");
				}
				
				//ako hocu da rezervisem datum za koji vec imam preglede
				for (Pregled p : pregledi) {
				    
					String[] datumPregleda2 = p.getDatum().split("T");
					
					 if (datumPregleda2[0].equals(datum) && p.getLekar() == lekar) {
						 System.out.println("Usaoooooooooooooooooooooooooooooooooo");
					 				
						    //ako hocemo da zakazemo pregled usred nekog drugog pregleda
					
							if(vremeInt >= Integer.parseInt(p.getVreme()) && vremeInt <= (Integer.parseInt(p.getVreme()) + p.getTrajanje()))
							{
								flag = true;
								
								System.out.println("USAO 1");
							}
							
							//ako hocemo da zakazemo pregled koji pocinje pre nekog ali se zavrsava posle pocetka
							if(vremeInt <= Integer.parseInt(p.getVreme()) && (vremeInt + zahtevZaPregled.getTrajanje()) >= Integer.parseInt(p.getVreme()))
							{
								flag = true;
								System.out.println("USAO 2");
							}
							
						
					 }
						 
				}
				
				List<ZahtevZaPregled> zahtevi = zahtevZaPregledService.findAll();
				
				//ne moramo da menjamo lekara
				if(flag == false) {
					
					System.out.println("NIJE PUKO");
					  
					  zahtevZaPregled.setDatum(datum + "T00:00:00.000Z");
					  zahtevZaPregled.setVreme(vreme);
					  zahtevZaPregled.setSala(salaRepository.findById(idSale).orElse(null));
					  zahtevZaPregled.setStatus("odobren");
					 
					  
					  zahtevZaPregledRepository.save(zahtevZaPregled);
					  
					  System.out.println("Nije ni ovde puko");
					  
					  
						 String messagePacijent = "Potvrdite promenu termina pregledda kod lekara " + lekar.getIme() + " " + lekar.getPrezime()  + " za vreme " + datumm[0] + " " + zahtevZaPregled.getVreme() + " sati" +  " u sali " + zahtevZaPregled.getSala().getNaziv(); 
						 mailService.sendNotificaitionAsync(pacijentService.findOne(zahtevZaPregled.getIdPacijenta()), messagePacijent);
									

						 String messageLekar = "Ceka se da pacijent odobri promenu termina pregleda na " + datumm[0]  + " u " + zahtevZaPregled.getVreme() + " sati" + " u sali " + zahtevZaPregled.getSala().getNaziv(); 
						 mailService.sendNotificaitionAsync(zahtevZaPregled.getLekar(), messageLekar);			
					  
						 errormessage = "Poslat mejl pacijentu da odobri promenu termina za istog lekara!";
						 
				
						 return new ResponseEntity<String>(errormessage, HttpStatus.OK);	
				
				//moramo dodeliti drugog lekara, nas nije slobodan
				}else {
					if(zahtevZaPregled.getVrstaPregleda().equals("pregled")) {
						List<Lekar> lekari = lekarRepository.findAll();
						
						Boolean zastava = false;
						Boolean zastava2 = false;
						
						for(Lekar l: lekari) {
							if(l.getTipPregleda() == zahtevZaPregled.getTipPregleda()) {
								System.out.println(lekari.size());
								System.out.println(l.getIme());
								//ako je zakazan pre radnog vremena lekara ili posle
								if(vremeInt < l.getPocetak() || vremeInt > l.getKraj())
								{
									zastava = true;
									System.out.println("Z1 3");
								}
								
								//ako je zakazan unutar radnog vremena ali traje duze od radnog vremena
								if(vremeInt >= l.getPocetak() && vremeInt <= l.getKraj() && (vremeInt + zahtevZaPregled.getTrajanje()) >= l.getKraj())
								{
									zastava = true;
									System.out.println("Z1 4");
								}
								
								
								//ako hocu da rezervisem datum za koji vec imam preglede
								
								List<Pregled> pregledi2 = new ArrayList<Pregled>();
								 
								
								
								for(Pregled p: pregledi) {
									 String[] datumPregleda = p.getDatum().split("T");
									 if (datum.equals(datumPregleda[0]) && p.getLekar() == l){ 	
										 pregledi2.add(p);
									 }
								}
								
								if(pregledi2.isEmpty()) {
									
									  zahtevZaPregled.setDatum(datum + "T00:00:00.000Z");
									  zahtevZaPregled.setVreme(vreme);
									  zahtevZaPregled.setSala(salaRepository.findById(idSale).orElse(null));
									  zahtevZaPregled.setStatus("odobren");
									 
									  
									  zahtevZaPregledRepository.save(zahtevZaPregled);
									  

										 String messagePacijent = "Potvrdite promenu termina i lekara.";
										 mailService.sendNotificaitionAsync(pacijentService.findOne(pregled.getIdPacijenta()), messagePacijent);
													

										 String messageLekar = "Dodeljen Vam je novi pregled.";
										 mailService.sendNotificaitionAsync(pacijentService.findOne(zahtevZaPregled.getIdPacijenta()), messageLekar);	
										 
										 String messageLekar2 = "Vas pregled je prebacen na drugog lekara";
										 mailService.sendNotificaitionAsync(l, messageLekar);	
									
									  errormessage = "Dodeljen je drugi lekar tog tipa i pregled je zakazan!";
									  return new ResponseEntity<String>(errormessage, HttpStatus.OK);
								}
								
								
								for (Pregled p : pregledi2) {
									 zastava2 = false;
									 System.out.println(datum);
									 System.out.println(p.getDatum());
									
									 
											
										 System.out.println("Datumi");
										    //ako hocemo da zakazemo pregled usred nekog drugog pregleda
									
											if(vremeInt >= Integer.parseInt(p.getVreme()) && vremeInt <= (Integer.parseInt(p.getVreme()) + p.getTrajanje()))
											{
												zastava2 = true;
												
												System.out.println("Z21");
											}
											
											//ako hocemo da zakazemo pregled koji pocinje pre nekog ali se zavrsava posle pocetka
											if(vremeInt <= Integer.parseInt(p.getVreme()) && (vremeInt + zahtevZaPregled.getTrajanje()) >= Integer.parseInt(p.getVreme()))
											{
												zastava2 = true;
												System.out.println("Z22");
											}
											
											System.out.println(zastava);
											System.out.println(zastava2);
											if(zastava == false && zastava2 == false) {
												
												  System.out.println(l.getIme());
												  
												  zahtevZaPregled.setDatum(datum + "T00:00:00.000Z");
												  zahtevZaPregled.setVreme(vreme);
												  zahtevZaPregled.setSala(salaRepository.findById(idSale).orElse(null));
												  zahtevZaPregled.setStatus("odobren");
												 
												  
												  zahtevZaPregledRepository.save(zahtevZaPregled);
								
												  
												  if(l == zahtevZaPregled.getLekar()) {
													  
													  String messagePacijent = "Potvrdite promenu termina kod istog lekara. "; 
														 mailService.sendNotificaitionAsync(pacijentService.findOne(zahtevZaPregled.getIdPacijenta()), messagePacijent);
																	

														 String messageLekar = "Ceka se da pacijent odobri promenu termina.";
														 mailService.sendNotificaitionAsync(l, messageLekar);	
													  
													  
													  errormessage = "Poslat mejl pacijentu da odobri promenu termina za istog lekara!";
													  return new ResponseEntity<String>(errormessage, HttpStatus.OK);
												  }else {
													 

														 String messagePacijent = "Pomeren Vam je termin i promenjen lekar.";
														 mailService.sendNotificaitionAsync(pacijentService.findOne(pregled.getIdPacijenta()), messagePacijent);
																	

														 String messageLekar = "Dodeljen Vam je novi pregled";
														 mailService.sendNotificaitionAsync(zahtevZaPregled.getLekar(), messageLekar);	
														 
														 String messageLekar2 = "Vas pregled je prebacen na drugog lekara";
														 mailService.sendNotificaitionAsync(l, messageLekar);	
													
													  
													  errormessage = "Dodeljen je drugi lekar tog tipa i pregled je zakazan!";
													  return new ResponseEntity<String>(errormessage, HttpStatus.OK);
												  }
												
										
										//ako smo nasli slobodnog lekara za taj tip pregleda
											
											
										}
										
									
									}							
								}
						
							}
				 		
					}else {
						
						 errormessage = "Lekar nije slobodan da izvrsi operaciju u toj sali u tom terminu! Promenite termin!";
						  return new ResponseEntity<String>(errormessage, HttpStatus.OK);
						
					}
					
			
				
				}
				
				  errormessage = "Nema slobodnih lekara za taj termin izaberite drugi!";
				  return new ResponseEntity<String>(errormessage, HttpStatus.OK);
			
		
		 }
		}
	@PutMapping(value = "/odobri", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> odobri(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO) {
	
			zahtevZaPregledService.odobri(zahtevZaPregledDTO);
			

		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	@PutMapping(value = "/azurirajPreglede/{idPacijenta}")
	@PreAuthorize("hasAnyAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAzurirajPreglede(@PathVariable Long idPacijenta ,@RequestBody String sortBy) {
		
		List<Pregled> listaPregleda = pregledService.sortirajPreglede(sortBy);
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		for (Pregled p : listaPregleda) {
			
			if( p.isZavrsen()==true) {

				if(p.getIdPacijenta().equals(idPacijenta) && p.getVrstaPregleda().equals("pregled") )
					listaPregledaDTO.add(new PregledDTO(p));

		}
		}
		
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	@PutMapping(value = "/azurirajOperacije/{idPacijenta}")
	@PreAuthorize("hasAnyAuthority('PACIJENT')")
	public ResponseEntity<List<PregledDTO>> getAzurirajOperacije(@PathVariable Long idPacijenta ,@RequestBody String sortBy) {
		
		List<Pregled> listaPregleda = pregledService.sortirajOperacije(sortBy);
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		for (Pregled p : listaPregleda) {
			if( p.isZavrsen()==true) {

					if(p.getIdPacijenta().equals(idPacijenta) && p.getVrstaPregleda().equals("operacija"))
							listaPregledaDTO.add(new PregledDTO(p));
		
		
		}
		}
		
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
		
}