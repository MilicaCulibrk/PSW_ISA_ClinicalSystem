package main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.dto.PacijentDTO;
import main.model.Klinika;
import main.model.Pacijent;
import main.service.PacijentService;

@RestController
@RequestMapping(value = "pacijent")
@CrossOrigin(origins = "http://localhost:8080")

public class PacijentController {

	@Autowired
	private PacijentService pacijentService;
	
	@GetMapping(value = "/get")
	public ResponseEntity<PacijentDTO> getPacijenta() {
		
		Pacijent pacijent = pacijentService.findOne((long) 3);
		
		PacijentDTO pacijentDTO = new PacijentDTO(pacijent);
		
		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PacijentDTO> izmeni(@RequestBody PacijentDTO pacijentDTO){
		
		try {
			pacijentService.izmeniPacijenta(pacijentDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/izlistaj")
	public ResponseEntity<List<PacijentDTO>> getIzlistaj() {
		
		List<Pacijent> listaPacijenata = pacijentService.findAll();
		List<PacijentDTO> listaPacijenataDTO = new ArrayList<PacijentDTO>();
		for (Pacijent k : listaPacijenata) {
			listaPacijenataDTO.add(new PacijentDTO(k));
		}
		
		return new ResponseEntity<>(listaPacijenataDTO, HttpStatus.OK);
	}
}
