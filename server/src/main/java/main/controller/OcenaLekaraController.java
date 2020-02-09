package main.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.OcenaKlinikeDTO;
import main.dto.OcenaLekaraDTO;
import main.service.OcenaLekaraService;

@CrossOrigin
@RestController
@RequestMapping(value = "/ocenaLekara")
public class OcenaLekaraController {
	@Autowired
	private OcenaLekaraService ocenaService;

	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<OcenaLekaraDTO> dodajOcenu(@RequestBody OcenaLekaraDTO ocenaDTO) {
		
		OcenaLekaraDTO ocenadto = new OcenaLekaraDTO();
		try {
			ocenadto = ocenaService.dodajOcenu(ocenaDTO);
			if (ocenadto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(ocenadto, HttpStatus.OK);
	}
	
	
}
