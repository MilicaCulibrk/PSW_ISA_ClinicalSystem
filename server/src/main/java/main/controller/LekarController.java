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

import main.dto.LekarDTO;
import main.dto.LekarDTO;
import main.model.Lekar;
import main.model.Lekar;
import main.service.LekarService;

@CrossOrigin
@RestController
@RequestMapping(value = "/lekar")
public class LekarController {

	@Autowired
	private LekarService lekarService;


	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<LekarDTO> getLekar(@PathVariable Long id) {
	
		Lekar lekar = lekarService.findOne(id);
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		LekarDTO lekarDTO = new LekarDTO(lekar);

		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izmeniPacijenta(@RequestBody LekarDTO lekarDTO) {
		
		Lekar lekar = (Lekar) lekarService.findOne(lekarDTO.getId());
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Lekar izmenjenLekar = lekarService.izmeniLekara(lekar, lekarDTO);

		LekarDTO newLekarDTO = new LekarDTO(izmenjenLekar);

		return new ResponseEntity<>(newLekarDTO, HttpStatus.OK);
	}
	
}
