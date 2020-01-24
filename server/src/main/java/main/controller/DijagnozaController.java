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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.DijagnozaDTO;
import main.dto.LekDTO;
import main.model.Dijagnoza;
import main.service.DijagnozaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/dijagnoza")
public class DijagnozaController {
	@Autowired
	private DijagnozaService dijagnozaService;
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<DijagnozaDTO>> getIzlistaj() {
		
		List<Dijagnoza> listaDijagnoza = dijagnozaService.findAll();
		List<DijagnozaDTO> listaDijagnozaDTO = new ArrayList<DijagnozaDTO>();
		for (Dijagnoza k : listaDijagnoza) {
			listaDijagnozaDTO.add(new DijagnozaDTO(k));
		}
		
		return new ResponseEntity<>(listaDijagnozaDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DijagnozaDTO> dodajDijagnozu(@RequestBody DijagnozaDTO dijagnozaDTO) {
		
		DijagnozaDTO dijagnozadto = new DijagnozaDTO();
		try {
			dijagnozadto = dijagnozaService.dodajDijagnozu(dijagnozaDTO);
			if (dijagnozadto==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(dijagnozadto, HttpStatus.OK);
	}
}
