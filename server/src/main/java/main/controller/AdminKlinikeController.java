package main.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinike;
import main.service.AdminKlinikeService;


@CrossOrigin
@RestController
@RequestMapping(value = "/adminKlinike")
public class AdminKlinikeController {
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminKlinikeDTO> dodajAdministratora(@RequestBody AdminKlinikeDTO administratorDTO) {
		
		AdminKlinikeDTO administratordto = new AdminKlinikeDTO();
		try {
			administratordto = adminKlinikeService.dodajAdministratora(administratorDTO);
			if (administratordto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(administratordto, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<AdminKlinikeDTO> getAdmina(@PathVariable String id) {
		
		Long idLong = Long.parseLong(id);
		AdministratorKlinike adminKlinike = adminKlinikeService.findOne((long) 1);
		
		AdminKlinikeDTO adminKlinikeDTO = new AdminKlinikeDTO(adminKlinike);
		
		return new ResponseEntity<>(adminKlinikeDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminKlinikeDTO> izmeni(@RequestBody AdminKlinikeDTO adminKlinikeDTO){
		
		try {
			adminKlinikeService.izmeniAdminaKlinike(adminKlinikeDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(adminKlinikeDTO, HttpStatus.OK);
	}

}
