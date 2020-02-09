package main.controller;

import java.util.ArrayList;
import java.util.List;


import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.dto.PacijentDTO;
import main.dto.PretragaPacijentaDTO;
import main.dto.PromenaLozinkeDTO;
import main.dto.SalaDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Pacijent;
import main.model.Sala;
import main.service.PacijentService;


@CrossOrigin
@RestController
@RequestMapping(value = "/pacijent")
public class PacijentController {

	@Autowired
	private PacijentService pacijentService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping(value = "/getEmail/{email}")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<PacijentDTO> getPacijentEmail(@PathVariable String email) {
		System.out.println(email);
		Pacijent pacijent = pacijentService.findByEmail(email);

		if (pacijent == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		PacijentDTO pacijentDTO = new PacijentDTO(pacijent);

		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
	}

	
	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAnyAuthority('PACIJENT, LEKAR')")
	public ResponseEntity<PacijentDTO> getPostojeciPacijent(@PathVariable Long id) {

		


		Pacijent pacijent = pacijentService.findOne(id);

		if (pacijent == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		PacijentDTO pacijentDTO = new PacijentDTO(pacijent);

		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> izmeniPacijenta(@RequestBody PacijentDTO pacijentDTO) {
		
		Pacijent pacijent = (Pacijent) pacijentService.findOne(pacijentDTO.getId());
		
		if (pacijent == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Pacijent izmenjenPacijent = pacijentService.izmeniPacijenta( pacijentDTO);

		PacijentDTO newPacijentDTO = new PacijentDTO(izmenjenPacijent);

		return new ResponseEntity<>(newPacijentDTO, HttpStatus.OK);
		
		
		/*try {
			pacijentService.izmeniPacijenta(pacijentDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);*/
	}
	
	
	
	
	
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAnyAuthority('LEKAR, MEDICINSKA_SESTRA')")
	public ResponseEntity<List<PacijentDTO>> getIzlistaj() {
		
		List<Pacijent> listaPacijenata = pacijentService.findAll();
		List<PacijentDTO> listaPacijenataDTO = new ArrayList<PacijentDTO>();
		for (Pacijent k : listaPacijenata) {
			listaPacijenataDTO.add(new PacijentDTO(k));
		}
		
		return new ResponseEntity<>(listaPacijenataDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/azuriraj")
	@PreAuthorize("hasAnyAuthority('LEKAR, MEDICINSKA_SESTRA')")
	public ResponseEntity<List<PacijentDTO>> getAzuriraj(@RequestBody String sortBy) {
		
		List<Pacijent> listaPacijenata = pacijentService.sortiraj(sortBy);
		List<PacijentDTO> listaPacijenataDTO = new ArrayList<PacijentDTO>();
		for (Pacijent k : listaPacijenata) {
			listaPacijenataDTO.add(new PacijentDTO(k));
		}
		
		return new ResponseEntity<>(listaPacijenataDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@PostMapping(value = "/pretraga/{id}",consumes = "application/json")
    public ResponseEntity<?> pretragaPacijenta(@RequestBody PretragaPacijentaDTO pretragaPacijentaDTO, @PathVariable Long id){


	    	String ime = null;
	    	String prezime = null;
	    	String jmbg =  null;
	    	

	    	if(pretragaPacijentaDTO.getIme() != null) {
	    		if(!pretragaPacijentaDTO.getIme().isEmpty()) {
	    		
	    			ime = pretragaPacijentaDTO.getIme();
	    		}
	    	}
	    	
	    	if(pretragaPacijentaDTO.getPrezime() != null) {
	    		if(!pretragaPacijentaDTO.getPrezime().equals("")){
	    			prezime = pretragaPacijentaDTO.getPrezime();	    		
	    		}
	    	}
	    	
	    	if(pretragaPacijentaDTO.getJmbg() != null) {
	    		if(!pretragaPacijentaDTO.getJmbg().equals("")){
	    			jmbg = pretragaPacijentaDTO.getJmbg();	    		
	    		}
	    	}

	    	Pacijent pacijent =  pacijentService.findOne(id);

	    	//pacijenti koje vracam
	    	List<Pacijent> pacijenti = pacijentService.pronadjiPacijente(ime, prezime, jmbg);

			List<PacijentDTO> pacijentDTO = new ArrayList<>();
			for (Pacijent p : pacijenti) {
				pacijentDTO.add(new PacijentDTO(p));
			}

	    	return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);


	    }
	
	@PostMapping(value = "/promeniSvojuLozinku/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<?> promeniLozinku(@PathVariable Long id, @RequestBody PromenaLozinkeDTO promenaLozinkeDTO){
		
		Pacijent admin = pacijentService.findOne(id);
		
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(),
						promenaLozinkeDTO.getStaraLozinka()));
		
		Pacijent adminKC = (Pacijent) authentication.getPrincipal();
		if (adminKC == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		boolean promena = pacijentService.promeniLozinku(admin, promenaLozinkeDTO);
		
		if (promena == true) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	} 
	

	
}

