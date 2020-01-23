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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.AdminKlinikeDTO;
import main.dto.KlinikaDTO;
import main.dto.LekarDTO;
import main.dto.LekarDTO;
import main.model.Klinika;
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
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<LekarDTO> dodajLekara(@RequestBody LekarDTO lekarDTO) {
		
		LekarDTO lekardto = new LekarDTO();
		try {
			lekardto = lekarService.dodajLekara(lekarDTO);
			if (lekardto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(lekardto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj/{idKlinike}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> getIzlistaj(@PathVariable Long idKlinike) {
		
		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
		for (Lekar l : listaLekara) {
				if(l.getKlinika().getId().equals(idKlinike)) {
					listaLekaraDTO.add(new LekarDTO(l));
				}

		}
		
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/obrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<Lekar>> obrisi(@PathVariable Long id) {

		Lekar lekar = lekarService.findOne(id);
		List<Lekar> lekarDTO = new ArrayList<>();
		lekarService.remove(id);
		lekarDTO = lekarService.findAll();
		return new ResponseEntity<>(lekarDTO,HttpStatus.OK);
		
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
