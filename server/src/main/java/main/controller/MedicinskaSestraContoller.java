package main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.MedicinskaSestraDTO;
import main.dto.SalaDTO;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pregled;
import main.model.Sala;
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
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<MedicinskaSestraDTO> dodajLekara(@RequestBody MedicinskaSestraDTO msDTO) {
		
		MedicinskaSestraDTO msdto = new MedicinskaSestraDTO();
		try {
			msdto = mss.dodajLekara(msDTO);
			if (msdto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(msdto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj/{idKlinike}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<MedicinskaSestraDTO>> getIzlistaj(@PathVariable Long idKlinike) {
		
		List<MedicinskaSestra> listaMedicinskaSestra = mss.findAll();
		List<MedicinskaSestraDTO> listaMedicinskaSestraDTO = new ArrayList<MedicinskaSestraDTO>();
		for (MedicinskaSestra l : listaMedicinskaSestra) {
				if(l.getKlinika().getId().equals(idKlinike)) {
					listaMedicinskaSestraDTO.add(new MedicinskaSestraDTO(l));
				}

		}
		
		return new ResponseEntity<>(listaMedicinskaSestraDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/izbrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<MedicinskaSestraDTO>> deleteMedicinskuSestru(@PathVariable Long id) {

		MedicinskaSestra ms = mss.findOne(id);
		List<MedicinskaSestraDTO> medicinskaSestraDTO = new ArrayList<MedicinskaSestraDTO>();
		if (ms != null) {
			mss.remove(id);
			List<MedicinskaSestra> sk = mss.findAll();

			for (MedicinskaSestra medicinskaSestra : sk) {
				if (medicinskaSestra.getKlinika().getId() == ms.getKlinika().getId()) {
					medicinskaSestraDTO.add(new MedicinskaSestraDTO(medicinskaSestra));
				}
			}
			return new ResponseEntity<>(medicinskaSestraDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
