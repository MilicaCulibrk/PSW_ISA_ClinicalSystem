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

import main.dto.AdminKCDTO;
import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.service.AdminKCService;
import main.service.AdminKlinikeService;

@RestController
@RequestMapping(value = "adminKC")
@CrossOrigin(origins = "http://localhost:8080")
public class AdminKCController {

	@Autowired
	private AdminKCService adminKCService;
	
	
	@GetMapping(value = "/get")
	public ResponseEntity<AdminKCDTO> getAdmina() {
		
		AdministratorKlinickogCentra adminKC = adminKCService.findOne((long) 1);
		
		AdminKCDTO adminKCDTO = new AdminKCDTO(adminKC);
		
		return new ResponseEntity<>(adminKCDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminKCDTO> izmeni(@RequestBody AdminKCDTO adminKCDTO){
		
		try {
			adminKCService.izmeniAdminaKlinike(adminKCDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(adminKCDTO, HttpStatus.OK);
	}
}
