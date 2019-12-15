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
import main.dto.MedicinskaSestraDTO;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.service.MedicinskaSestraService;

@CrossOrigin
@RestController
@RequestMapping(value = "/medicinska_sestra")
public class MedicinskaSestraContoller {
	
	@Autowired
	MedicinskaSestraService mss = new MedicinskaSestraService();
	

	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
	public ResponseEntity<MedicinskaSestraDTO> getMedicinkaSestra(@PathVariable Long id) {
		
		MedicinskaSestra ms = mss.findOne(id);
		
		if (ms == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		MedicinskaSestraDTO msDTO = new MedicinskaSestraDTO(ms);

		return new ResponseEntity<>(msDTO, HttpStatus.OK);
	}
	
	 
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
	public ResponseEntity<MedicinskaSestraDTO> izmeni(@RequestBody MedicinskaSestraDTO msdto){
		
		try {
			mss.izmeniMedicinskuSestru(msdto);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(msdto, HttpStatus.OK);
	}
}
