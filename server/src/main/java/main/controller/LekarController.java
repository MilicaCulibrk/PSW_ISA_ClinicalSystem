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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import main.dto.ZahtevZaOdmorDTO;
import main.dto.PregledDTO;
import main.dto.PretragaKlinikeDTO;
import main.dto.PretragaLekaraDTO;
import main.dto.TipPregledaDTO;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.ZahtevZaOdmor;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.ZahtevZaOdmorRepository;
import main.service.LekarService;
import main.service.PregledService;
import main.service.ZahtevZaOdmorService;

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
	private PregledRepository	pregledRepository;
	
	
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
	
	/*@GetMapping(value = "/izlistajOdmor/{idLekara}")
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
	}*/
	
	@GetMapping(value = "/izlistajOdmor/{idLekara}")
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
	

	@PreAuthorize("hasAuthority('PACIJENT')")
	 @PostMapping(value = "/pretraga/{id}",consumes = "application/json")
   public ResponseEntity<?> pretragaLekara(@RequestBody PretragaLekaraDTO pretragaLekaraDTO, @PathVariable Long id){


	    	
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

	  
	 
}
