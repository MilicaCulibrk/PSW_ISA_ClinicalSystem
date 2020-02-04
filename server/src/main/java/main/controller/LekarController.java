package main.controller;

import java.util.ArrayList;
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
import main.dto.PretragaKlinikeDTO;
import main.dto.PretragaLekaraDTO;
import main.dto.TipPregledaDTO;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.TipPregleda;
import main.service.LekarService;
import main.service.PregledService;

@CrossOrigin
@RestController
@RequestMapping(value = "/lekar")
public class LekarController {

	@Autowired
	private LekarService lekarService;
	
	@Autowired
	private PregledService pregledService;


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
	public ResponseEntity<List<LekarDTO>> getIzlistajLekarePoTP(@RequestBody PretragaKlinikeDTO pretragaKlinikaDTO, @PathVariable Long idKlinike) {      
		
		
		System.out.println(pretragaKlinikaDTO.getTipPregleda());

   		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
	
		for (Lekar l : listaLekara) {
			if(l.getKlinika().getId().equals(idKlinike) && l.getTipPregleda().getNaziv().equals(pretragaKlinikaDTO.getTipPregleda())) {
				
				listaLekaraDTO.add(new LekarDTO(l));
			}
	
		}
		
			
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
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
	    		if(!pretragaLekaraDTO.getIme().equals("")){
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
