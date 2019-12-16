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

@CrossOrigin
@RestController
@RequestMapping(value = "/adminKlinickogCentra")

public class AdminKCController {

	@Autowired
	private AdminKCService adminKCService;
	
	
	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<AdminKCDTO> getAdmina(@PathVariable Long id) {
		
		AdministratorKlinickogCentra ak = adminKCService.findOne(id);
		
		if (ak == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		AdminKCDTO akDTO = new AdminKCDTO(ak);

		return new ResponseEntity<>(akDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<AdminKCDTO> izmeni(@RequestBody AdminKCDTO adminKCDTO){
		
		try {
			adminKCService.izmeniAdminaKlinike(adminKCDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(adminKCDTO, HttpStatus.OK);
	}
}
