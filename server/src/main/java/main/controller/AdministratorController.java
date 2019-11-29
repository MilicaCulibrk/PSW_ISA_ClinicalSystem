package main.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.AdministratorDTO;
import main.service.AdministratorService;

@RestController
@RequestMapping(value = "administrator")
@CrossOrigin(origins = "http://localhost:8081")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	
	@PostMapping(value = "/dodajAdministratoraUBazu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdministratorDTO> dodajAdministratora(@RequestBody AdministratorDTO administratorDTO) {
		
		AdministratorDTO administratordto = new AdministratorDTO();
		try {
			administratordto = administratorService.dodajAdministratora(administratorDTO);
			if (administratordto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(administratordto, HttpStatus.OK);
	}

}
