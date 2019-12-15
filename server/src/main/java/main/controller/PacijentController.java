package main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.dto.PacijentDTO;
import main.model.Klinika;
import main.model.Pacijent;
import main.service.PacijentService;


@CrossOrigin
@RestController
@RequestMapping(value = "/pacijent")
public class PacijentController {

	@Autowired
	private PacijentService pacijentService;
	

	
	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
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
		
		Pacijent izmenjenPacijent = pacijentService.izmeniPacijenta(pacijent, pacijentDTO);

		PacijentDTO newPacijentDTO = new PacijentDTO(izmenjenPacijent);

		return new ResponseEntity<>(newPacijentDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<List<PacijentDTO>> getIzlistaj() {
		
		List<Pacijent> listaPacijenata = pacijentService.findAll();
		List<PacijentDTO> listaPacijenataDTO = new ArrayList<PacijentDTO>();
		for (Pacijent k : listaPacijenata) {
			listaPacijenataDTO.add(new PacijentDTO(k));
		}
		
		return new ResponseEntity<>(listaPacijenataDTO, HttpStatus.OK);
	}
}

