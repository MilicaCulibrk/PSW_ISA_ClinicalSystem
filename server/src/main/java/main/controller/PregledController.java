package main.controller;

import java.util.ArrayList;
import java.util.List;

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

import main.dto.LekarDTO;
import main.dto.PregledDTO;
import main.dto.TipPregledaDTO;
import main.dto.ZahtevZaPregledDTO;
import main.model.AdministratorKlinike;
import main.model.Pacijent;
import main.model.Pregled;
import main.model.ZahtevZaPregled;
import main.repository.PregledRepository;
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
	private AdminKlinikeService adminKlinikeService;

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
			}
			
			//termin ne sme pocinjati posle radnog vremena lekara, a zavrsavati se posle radnog vremena lekara
		    if(pocetakP > pocetakRV && krajP > krajRV) {
				flag = true;
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
			zahtevZaPregledDTO.setCena(Double.parseDouble(pregled.getTipPregleda().getCena()));
					
			
			Integer radnoOd = pregled.getLekar().getPocetak();
			Integer radnoDo = pregled.getLekar().getKraj();
			
			List<Pregled> pregledi = pregledService.findAll();
			List<ZahtevZaPregled> zahtevi = zahtevZaPregledService.findAll();
		
			Double vreme = Double.parseDouble(zahtevZaPregledDTO.getVreme());
			Double trajanje = Double.parseDouble(zahtevZaPregledDTO.getTrajanje());
			
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
					if(vreme >= Double.parseDouble(z.getVreme()) && vreme < (Double.parseDouble(z.getVreme()) + Double.parseDouble(z.getTrajanje())))
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
			
				pregledService.dodajZahtev(zahtevZaPregledDTO);
				
				List<AdministratorKlinike> adminiKlinika = adminKlinikeService.findAll();

				for (AdministratorKlinike adminKlinike : adminiKlinika) {
					System.out.println("Usao u listu admina klinike");
					System.out.println(adminKlinike.getKlinika().getId());
					System.out.println(zahtevZaPregledDTO.getLekar().getIdKlinike());
					if (adminKlinike.getKlinika().getId() == zahtevZaPregledDTO.getLekar().getIdKlinike()) {
						System.out.println("Nasao admina klinike");
						String message = "Podneli ste zahtev za pregled/operaciju na Vasoj klinici od lekara "
								+ zahtevZaPregledDTO.getLekar().getIme() + " " + zahtevZaPregledDTO.getLekar().getPrezime();
						mailService.sendNotificaitionAsync(adminKlinike, message);
					}
				}
				
			}
			

		 return new ResponseEntity<>(null, HttpStatus.OK);
			
	}
	
	@PostMapping(value = "/podnesiZahtevPacijent")
	@PreAuthorize("hasAuthority('PACIJENT')")
	//dinamicki pravi id pregleda
	public ResponseEntity<?> podnesiZahtevPacijent(@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO)
			
	    throws MailException, InterruptedException {
		

			pregledService.dodajZahtev(zahtevZaPregledDTO);
			
			List<AdministratorKlinike> adminiKlinika = adminKlinikeService.findAll();
			
			Pacijent pacijent = pacijentService.findOne(zahtevZaPregledDTO.getIdPacijenta());

			for (AdministratorKlinike adminKlinike : adminiKlinika) {
				System.out.println("Usao u listu admina klinike");
				System.out.println(adminKlinike.getKlinika().getId());
				System.out.println(zahtevZaPregledDTO.getLekar().getIdKlinike());
				if (adminKlinike.getKlinika().getId() == zahtevZaPregledDTO.getLekar().getIdKlinike()) {
					System.out.println("Nasao admina klinike");
					String message = "Pacijent "
							+ pacijent.getIme() + " " + pacijent.getPrezime() + " je podneo zahtev za pregled.";
					mailService.sendNotificaitionAsync(adminKlinike, message);
				}
			}

		 return new ResponseEntity<>(null, HttpStatus.OK);
			
	}
	
	
}
