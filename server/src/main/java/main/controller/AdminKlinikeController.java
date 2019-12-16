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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.AdminKlinikeDTO;
import main.dto.KlinikaDTO;
import main.dto.LekarDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Lekar;
import main.service.AdminKlinikeService;


@CrossOrigin
@RestController
@RequestMapping(value = "/adminKlinike")
public class AdminKlinikeController {
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
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
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<AdminKlinikeDTO> getAdmina(@PathVariable Long id) {
		
		AdministratorKlinike ak = adminKlinikeService.findOne(id);
		
		if (ak == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		AdminKlinikeDTO akDTO = new AdminKlinikeDTO(ak);

		return new ResponseEntity<>(akDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<AdminKlinikeDTO> izmeni(@RequestBody AdminKlinikeDTO adminKlinikeDTO){
		
		try {
			adminKlinikeService.izmeniAdminaKlinike(adminKlinikeDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(adminKlinikeDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<AdminKlinikeDTO>> getIzlistaj() {
		
		List<AdministratorKlinike> listaAdmina = adminKlinikeService.findAll();
		List<AdminKlinikeDTO> adminKlinikeDTO = new ArrayList<AdminKlinikeDTO>();
		for (AdministratorKlinike k : listaAdmina) {
			adminKlinikeDTO.add(new AdminKlinikeDTO(k));
		}
		
		return new ResponseEntity<>(adminKlinikeDTO, HttpStatus.OK);
	}

}
