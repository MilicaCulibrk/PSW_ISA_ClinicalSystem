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

import main.dto.LekarDTO;
import main.model.Lekar;
import main.service.LekarService;

@RestController
@RequestMapping(value = "lekar")
@CrossOrigin(origins = "http://localhost:8080")
public class LekarController {

	@Autowired
	private LekarService lekarService;

	@GetMapping(value = "/get")
	public ResponseEntity<LekarDTO> getLekar() {
		
	    Lekar lekar = lekarService.findOne((long) 3);
		
		LekarDTO lekarDTO = new LekarDTO(lekar);
			
		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LekarDTO> izmeni(@RequestBody LekarDTO lekarDTO){
		
		try {
			lekarService.izmeniLekar(lekarDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	
}
