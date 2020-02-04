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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.dto.PretragaKlinikeDTO;
import main.dto.PretragaSaleDTO;
import main.dto.SalaDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Sala;
import main.service.KlinikaService;



@CrossOrigin
@RestController
@RequestMapping(value = "/klinika")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;
	
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	@PostMapping(value = "/dodajKlinikuUBazu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> dodajKliniku(@RequestBody KlinikaDTO klinikaDTO) {
		
		KlinikaDTO klinikadto = new KlinikaDTO();
		try {
			klinikadto = klinikaService.dodajKliniku(klinikaDTO);
			if (klinikadto==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(klinikadto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pronadji")
	public ResponseEntity<KlinikaDTO> getPostojecaKlinika() {
		
		Klinika klinika = klinikaService.findOne((long) 1);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/pronadjiKliniku/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<KlinikaDTO> getPronadjiKliniku(@PathVariable Long id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pronadjiKliniku1/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KlinikaDTO> getPronadjiKliniku1(@PathVariable Long id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<KlinikaDTO>> getIzlistaj() {
		
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/izlistajK")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getIzlistajK() {
		
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> izmeni(@RequestBody KlinikaDTO klinikaDTO){
		
		try {
			klinikaService.izmeniKliniku(klinikaDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('PACIJENT')")
	 @PostMapping(value = "/pretraga/{id}",consumes = "application/json")
    public ResponseEntity<?> pretragaKlinike(@RequestBody PretragaKlinikeDTO pretragaKlinikeDTO, @PathVariable Long id){


	    	
	    	String datum = null;
	    	String tipPregleda =  null;
	    	

	    	
	    	if(pretragaKlinikeDTO.getDatum() != null) {
	    		if(!pretragaKlinikeDTO.getDatum().equals("")){
	    			datum = pretragaKlinikeDTO.getDatum();	    		
	    		}
	    	}
	    	
	    	if(pretragaKlinikeDTO.getTipPregleda() != null) {
	    		if(!pretragaKlinikeDTO.getTipPregleda().equals("")){
	    			tipPregleda = pretragaKlinikeDTO.getTipPregleda();	    		
	    		}
	    	}

	    	//AdministratorKlinike admin =  adminKlinikeService.findOne(id);

	    	List<Klinika> klinike = klinikaService.pronadjiKlinike( datum, tipPregleda);

			List<KlinikaDTO> klinikeDTO = new ArrayList<>();
			for (Klinika k : klinike) {
				klinikeDTO.add(new KlinikaDTO(k));
			}

	    	return new ResponseEntity<>(klinikeDTO, HttpStatus.OK);


	    }
	
}
