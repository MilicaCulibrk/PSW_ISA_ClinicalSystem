package main.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.PregledDTO;
import main.dto.PretragaKlinikeDTO;
import main.dto.PretragaLekaraDTO;
import main.dto.PromenaLozinkeDTO;
import main.dto.ZahtevZaOdmorDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.Pregled;
import main.model.ZahtevZaOdmor;
import main.model.ZahtevZaPregled;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.ZahtevZaOdmorRepository;
import main.repository.ZahtevZaPregledRepository;
import main.service.LekarService;
import main.service.MailService;
import main.service.PregledService;

@CrossOrigin
@RestController
@RequestMapping(value = "/lekar")
public class LekarController {

	@Autowired
	private LekarService lekarService;
	
	@Autowired
	private PregledService pregledService;


	@Autowired
	private LekarRepository	lekarRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	@Autowired
	private PregledRepository	pregledRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private AdminKlinikeRepository	adminKlinikeRepository;
	
	
	@Autowired
	private ZahtevZaOdmorRepository	zahtevZaOdmorRepository;
	
	
	@GetMapping(value = "/izlistajLekare/{idKlinike}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getIzlistajLekare(@PathVariable Long idKlinike) {      
		

    

		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
	
		for (Lekar l : listaLekara) {
			if(l.getKlinika().getId().equals(idKlinike))
				
				listaLekaraDTO.add(new LekarDTO(l));
	
		}
		
			
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/izlistajLekarePoTP/{idKlinike}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<LekarDTO>> getIzlistajLekarePoTP(@RequestBody PretragaKlinikeDTO pretragaKlinikaDTO, @PathVariable Long idKlinike) throws ParseException {      
		
		
		System.out.println(pretragaKlinikaDTO.getTipPregleda());

   		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
	
		
		
		String datumm=pretragaKlinikaDTO.getDatum();
		
		String[] datum1=pretragaKlinikaDTO.getDatum().split("'");
		
		SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
			Date dtIn = inFormat.parse(datum1[0]);
		
			List<Lekar> lekari  =  new ArrayList<Lekar>();
			lekari=lekarRepository.findAll();
			
			List<Pregled> pregledi  =  new ArrayList<Pregled>();
			pregledi=pregledRepository.findAll();

			List<ZahtevZaOdmor> zahtevi  =  new ArrayList<ZahtevZaOdmor>();
			
					
					int radnoVreme=0;
					int ukupnoTrajanje=0;
		
		
		for (Lekar l : listaLekara) {
			
			if(l.getKlinika().getId().equals(idKlinike) && l.getTipPregleda().getNaziv().equals(pretragaKlinikaDTO.getTipPregleda())) {
				
				
				
				radnoVreme = l.getKraj() - l.getPocetak();
				zahtevi= (List<ZahtevZaOdmor>) l.zahtevZaOdmor;
				
				
				if(!zahtevi.isEmpty()) {
				
					
					
				for(ZahtevZaOdmor z: zahtevi) {
			
					String[] pocetak=z.getStartDate().split("'");
					SimpleDateFormat inFormat1 = new SimpleDateFormat("yyyy-MM-dd");
					Date p = inFormat1.parse(pocetak[0]);
						
					
					String[] kraj=z.getEndDate().split("'");
					SimpleDateFormat inFormat2 = new SimpleDateFormat("yyyy-MM-dd");
					Date k = inFormat2.parse(kraj[0]);
						

					if( dtIn.after(k) || dtIn.before(p))  {
						
						System.out.println("ne nalazi se izmedju");
						
						
						for(Pregled pr: pregledi) {
							
							if(pr.getLekar().getId().equals(l.getId()) && pr.getDatum().equals(datumm)) {
							
								System.out.println("pogresio za bojanu");
							 ukupnoTrajanje=(int) (ukupnoTrajanje+pr.getTrajanje());
							}
							}
					
						System.out.println(ukupnoTrajanje);
						System.out.println(radnoVreme);
						
						
								if(radnoVreme - ukupnoTrajanje>=1) {

									listaLekaraDTO.add(new LekarDTO(l));
									
									}
								ukupnoTrajanje=0;
				} else
					System.out.println("nalazi se izmedju");
			}
	} 
	
	else {
				
		
					
					System.out.println("usao u else");
						for(Pregled pr: pregledi) {
							
							if(pr.getLekar().getId().equals(l.getId()) && pr.getDatum().equals(datumm)) {
								System.out.println("usao u dobro za pecu i dimija");
							 ukupnoTrajanje=(int) (ukupnoTrajanje+pr.getTrajanje());
							}
							}
					
								if(radnoVreme- ukupnoTrajanje>=1) {
				

									listaLekaraDTO.add(new LekarDTO(l));
						
					}
				} ukupnoTrajanje=0;
	
			}
				
			}
	
		
			
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}

	
	@PostMapping(value = "/nadjiZauzetePreglede/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<Integer>> nadjiZauzetePreglede (@PathVariable Long id, @RequestBody String datum ) {
	
		Lekar lekar = lekarService.findOne(id);
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		List<Integer> sati = new ArrayList<Integer>();

		List<Pregled> pregledi  =  new ArrayList<Pregled>();
		pregledi=pregledRepository.findAll();
		Integer pocetak=0;
		Integer kraj=0;
		Integer razlika=0;
		Integer i=0;
		
		for(Pregled pr: pregledi) {
			System.out.println(pr.getDatum());
			System.out.println(datum);
			
			String[] datumi = datum.split("\"");
		
			System.out.println(datumi[1]);
			
			if(pr.getLekar().getId().equals(id) && pr.getDatum().equals(datumi[1])) {
				System.out.println("usaoooooooooooooooooooooooo");
				pocetak=Integer.parseInt(pr.getVreme());
				sati.add(pocetak);
				kraj=pocetak+pr.getTrajanje();
				razlika=kraj-pocetak;
				if(razlika>1) {
					for( i=1; i<razlika; i++) {
						sati.add(pocetak+i);
					}
				}
				
			
				}
			}
		System.out.println(sati);
		
		return new ResponseEntity<>(sati, HttpStatus.OK);
		
		
	}
	
	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<LekarDTO> getLekar(@PathVariable Long id) {
	
		Lekar lekar = lekarService.findOne(id);
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		LekarDTO lekarDTO = new LekarDTO(lekar);

		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/get1/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<LekarDTO> getLekar1(@PathVariable Long id) {
	
		Lekar lekar = lekarService.findOne(id);
		String tipPregleda = lekar.getTipPregleda().getNaziv();
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		LekarDTO lekarDTO = new LekarDTO(lekar);

		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
		
	}
	
	
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izmeniPacijenta(@RequestBody LekarDTO lekarDTO) {
		
		Lekar lekar = (Lekar) lekarService.findOne(lekarDTO.getId());
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		
		Lekar izmenjenLekar = lekarService.izmeniLekara(lekar, lekarDTO);

		LekarDTO newLekarDTO = new LekarDTO(izmenjenLekar);

		return new ResponseEntity<>(newLekarDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeniLozinku")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izmeniLozinku(@RequestBody LekarDTO lekarDTO) {
		
		Lekar lekar = (Lekar) lekarService.findOne(lekarDTO.getId());
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		
		Lekar izmenjenLekar = lekarService.izmeniLozinku(lekar, lekarDTO);

		LekarDTO newLekarDTO = new LekarDTO(izmenjenLekar);

		return new ResponseEntity<>(newLekarDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<LekarDTO> dodajLekara(@RequestBody LekarDTO lekarDTO) {
		
		LekarDTO lekardto = new LekarDTO();
		try {
			lekardto = lekarService.dodajLekara(lekarDTO);
			if (lekardto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(lekardto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj/{idKlinike}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> getIzlistaj(@PathVariable Long idKlinike) {
		
		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
		for (Lekar l : listaLekara) {
				if(l.getKlinika().getId().equals(idKlinike)) {
					listaLekaraDTO.add(new LekarDTO(l));
				}

		}
		
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistajPoIdAdmina/{idAdmina}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> getIzlistajPoIdAdmina(@PathVariable Long idAdmina) {
		
		
		AdministratorKlinike ak = adminKlinikeRepository.findById(idAdmina).orElse(null);
		
		
		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
		for (Lekar l : listaLekara) {
				if(l.getKlinika().getId().equals(ak.getKlinika().getId())) {
					listaLekaraDTO.add(new LekarDTO(l));
				}

		}
		
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistajOdmor/{idLekara}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izlistajOdmor(@PathVariable Long idLekara) {
	System.out.println("heloooo");
		List<Lekar> listaLekara = lekarService.findAll();
		Collection<ZahtevZaOdmor> listaOdmora = new ArrayList<ZahtevZaOdmor>();
		List<ZahtevZaOdmorDTO> listaOdmoraDTO = new ArrayList<ZahtevZaOdmorDTO>();
		for (Lekar l : listaLekara) {
				if(l.getId().equals(idLekara)) {
					listaOdmora = l.getZahtevZaOdmor();
				}
		}
		for (ZahtevZaOdmor zahtevZaOdmor : listaOdmora) {
			try{
				if(zahtevZaOdmor.getOdobren()==true)
					listaOdmoraDTO.add(new ZahtevZaOdmorDTO(zahtevZaOdmor));
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new ResponseEntity<>(listaOdmoraDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistajPreglede/{idLekara}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izlistajPreglede(@PathVariable Long idLekara) {
		List<Lekar> listaLekara = lekarService.findAll();
		Collection<Pregled> listaPregleda = new ArrayList<Pregled>();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		for (Lekar l : listaLekara) {
				if(l.getId().equals(idLekara)) {
					listaPregleda = l.getPregled();
				}
		}
		for (Pregled p : listaPregleda) {
			try{
				if(p.getIdPacijenta()!=null)
					listaPregledaDTO.add(new PregledDTO(p));
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/preuzmiInfo/{email}")
	public ResponseEntity<Boolean> getIzlistajInfo(@PathVariable String email) {
		
		List<Lekar> listaLekara = lekarService.findAll();
		Boolean flag =false;
		for (Lekar l : listaLekara) {
				if(l.getEmail().equals(email)) {
					flag = l.getPromenjenaLozinka();
				}

		}
		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	@PostMapping(value = "/dodajUoperaciju/{vreme}/{datum}/{idZahteva}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajUoperaciju(@RequestBody LekarDTO lekarDTO, @PathVariable String vreme, @PathVariable String datum, @PathVariable Long idZahteva) throws MailException, InterruptedException {
		
		Boolean flag = false;
		
		ZahtevZaPregled zahtevZaPregled = zahtevZaPregledRepository.findById(idZahteva).orElse(null);
		
		String errormessage = "";
		
		 String[] datumm = zahtevZaPregled.getDatum().split("T");
		 
		Integer vremeInt = Integer.parseInt(vreme);
		
		 List<Pregled> pregledi = pregledService.findAll();
		
		//ako je zakazan pre radnog vremena lekara ili posle
		if(vremeInt < lekarDTO.getPocetak() || vremeInt > lekarDTO.getKraj())
		{
			flag = true;
			System.out.println("USAO 3");
		}
		
		//ako je zakazan unutar radnog vremena ali traje duze od radnog vremena
		if(vremeInt >= lekarDTO.getPocetak() && vremeInt <= lekarDTO.getKraj() && (vremeInt + zahtevZaPregled.getTrajanje()) >= lekarDTO.getKraj())
		{
			flag = true;
			System.out.println("USAO 4");
		}
		
		//ako hocu da rezervisem datum za koji vec imam preglede
		for (Pregled p : pregledi) {
		    
			String[] datumPregleda2 = p.getDatum().split("T");
			
			 if (datumPregleda2[0].equals(datum) && p.getLekar().getId() == lekarDTO.getId()) {
			
			 				
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
		
		
		
	    if(flag == false) {
	    	
	    	Lekar lekar = lekarRepository.findById(lekarDTO.getId()).orElse(null);
	    	
	    
	    	
	    	 String messagePacijent = "Dodati ste u operaciju od strane administratora";
			 mailService.sendNotificaitionAsync(lekar, messagePacijent);

	    	
	    	return new ResponseEntity<>(HttpStatus.OK);									
	    }else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		
		
	}
	
	@PostMapping(value = "/obrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<Lekar>> obrisi(@PathVariable Long id) {

		Lekar lekar = lekarService.findOne(id);
		List<Lekar> lekarDTO = new ArrayList<>();
		lekarService.remove(id);
		lekarDTO = lekarService.findAll();
		return new ResponseEntity<>(lekarDTO,HttpStatus.OK);
		
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping(value = "/izbrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> deletePregled(@PathVariable Long id) {

		Lekar lekar = lekarService.findOne(id);
		
		List<LekarDTO> lekarDTO = new ArrayList<>();
		
		if (lekarDTO != null) {
			
			int flag = 0;
			List<Pregled> pregledi = pregledService.findAll();

			for (Pregled p : pregledi){
				if (p.getLekar().getId() == id) {
					flag = 1;
					break;
				}
			}
			
		
			
			//lekara mozemo obrisati samo ako nema zakazane preglede
			if(flag == 0) {
				lekarService.remove(id);
				
				List<Lekar> lk = lekarService.findAll();

				for (Lekar l : lk) {
					if (l.getKlinika().getId() == lekar.getKlinika().getId()) {
						lekarDTO.add(new LekarDTO(l));
					}
				}
				return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
			}
			
		
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	 @PostMapping(value = "/pretraga/{id}",consumes = "application/json")
   public ResponseEntity<?> pretragaLekara(@RequestBody PretragaLekaraDTO pretragaLekaraDTO, @PathVariable Long id){


	    	
	    	String ime = null;
	    	String prezime =  null;

	    		

	    	if(pretragaLekaraDTO.getIme() != null) {
	    		if(!pretragaLekaraDTO.getIme().isEmpty()) {
	    		
	    			ime = pretragaLekaraDTO.getIme();

	    		}
	    	}
	    	
	    	if(pretragaLekaraDTO.getPrezime() != null) {
	    		if(!pretragaLekaraDTO.getPrezime().equals("")){
	    			prezime = pretragaLekaraDTO.getPrezime();	    		
	    		}
	    	}

	      	if(pretragaLekaraDTO.getOcena() != null) {
	    		if(!pretragaLekaraDTO.getOcena().equals("")){
	    		    		
	    		}
	    	}
	    	

	    	List<Lekar> lekari = lekarService.pronadjiLekara( ime,prezime);

			List<LekarDTO> lekariDTO = new ArrayList<>();
			
			for (Lekar l : lekari) {
				lekariDTO.add(new LekarDTO(l));
			}

	    	return new ResponseEntity<>(lekariDTO, HttpStatus.OK);


	    }
	
	@PreAuthorize("hasAuthority('PACIJENT')")
	 @PostMapping(value = "/pretragaP/{id}",consumes = "application/json")
  public ResponseEntity<?> pretragaLekaraP(@RequestBody PretragaLekaraDTO pretragaLekaraDTO, @PathVariable Long id){


	    	
	    	String ime = null;
	    	String prezime =  null;
	    	Double ocena = null;
	    		

	    	if(pretragaLekaraDTO.getIme() != null) {
	    		if(!pretragaLekaraDTO.getIme().isEmpty()) {
	    		
	    			ime = pretragaLekaraDTO.getIme();

	    		}
	    	}
	    	
	    	if(pretragaLekaraDTO.getPrezime() != null) {
	    		if(!pretragaLekaraDTO.getPrezime().equals("")){
	    			prezime = pretragaLekaraDTO.getPrezime();	    		
	    		}
	    	}

	      	if(pretragaLekaraDTO.getOcena() != null) {
	    		if(!pretragaLekaraDTO.getOcena().equals("")){
	    			ocena = pretragaLekaraDTO.getOcena();	    		
	    		}
	    	}
	    	

	    	List<Lekar> lekari = lekarService.pronadjiLekare( ime,prezime,ocena);

			List<LekarDTO> lekariDTO = new ArrayList<>();
			
			for (Lekar l : lekari) {
				lekariDTO.add(new LekarDTO(l));
			}

	    	return new ResponseEntity<>(lekariDTO, HttpStatus.OK);


	    }

	@PostMapping(value = "/promeniSvojuLozinku/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> promeniLozinku(@PathVariable Long id, @RequestBody PromenaLozinkeDTO promenaLozinkeDTO){
		
		Lekar admin = lekarService.findOne(id);
		
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(),
						promenaLozinkeDTO.getStaraLozinka()));
		
		Lekar adminKC = (Lekar) authentication.getPrincipal();
		if (adminKC == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		boolean promena = lekarService.promeniLozinku(admin, promenaLozinkeDTO);
		
		if (promena == true) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	} 

	  
	 
}
