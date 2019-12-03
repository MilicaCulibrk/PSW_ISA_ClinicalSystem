package main.controller;

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

import main.dto.MedicinskaSestraDTO;
import main.model.MedicinskaSestra;
import main.service.MedicinskaSestraService;

@RestController
@RequestMapping(value = "medicinskaSestra")
@CrossOrigin(origins = "http://localhost:8080")
public class MedicinskaSestraContoller {
	
	@Autowired
	MedicinskaSestraService mss = new MedicinskaSestraService();
	
	@GetMapping(value = "/get")
	public ResponseEntity<MedicinskaSestraDTO> getMedicinkaSestra() {
		
		MedicinskaSestra ms = mss.findOne((long) 2);
		
		MedicinskaSestraDTO msdto = new MedicinskaSestraDTO(ms);
		
		return new ResponseEntity<>(msdto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedicinskaSestraDTO> izmeni(@RequestBody MedicinskaSestraDTO msdto){
		
		try {
			mss.izmeniMedicinskuSestru(msdto);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(msdto, HttpStatus.OK);
	}
}
