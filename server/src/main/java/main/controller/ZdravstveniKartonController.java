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

import main.dto.ZdravstveniKartonDTO;
import main.model.ZdravstveniKarton;
import main.service.ZdravstveniKartonService;


@CrossOrigin
@RestController
@RequestMapping(value = "/zdravstveniKarton")

public class ZdravstveniKartonController {
	@Autowired
	private ZdravstveniKartonService zdravstveniKartonService;
	
	@GetMapping(value = "/get")

	@PreAuthorize("hasAuthority('LEKAR')")

	public ResponseEntity<ZdravstveniKartonDTO> getZdravstveniKarton() {
		
		ZdravstveniKarton zdravstveniKarton = zdravstveniKartonService.findOne((long) 1);
		
		ZdravstveniKartonDTO zdravstveniKartonDTO = new ZdravstveniKartonDTO(zdravstveniKarton);
		
		
		return new ResponseEntity<>(zdravstveniKartonDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/pronadjiZdravstveniKarton/{id}")

	public ResponseEntity<ZdravstveniKartonDTO> getPronadjiZdravstveniKarton(@PathVariable Long id) {
		
		ZdravstveniKarton zdravstveniKarton = zdravstveniKartonService.findOne(id);
		
		ZdravstveniKartonDTO zdravstveniKartonDTO = new ZdravstveniKartonDTO(zdravstveniKarton);
		
		return new ResponseEntity<>(zdravstveniKartonDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

	@PreAuthorize("hasAuthority('LEKAR')")

	public ResponseEntity<ZdravstveniKartonDTO> izmeni(@RequestBody ZdravstveniKartonDTO zdravstveniKartonDTO){
		
		try {
			zdravstveniKartonService.izmeniZdravstveniKarton(zdravstveniKartonDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(zdravstveniKartonDTO, HttpStatus.OK);
	}
}
