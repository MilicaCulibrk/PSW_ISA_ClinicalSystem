package main.controller;


import java.text.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.joda.time.DateTime;
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

import main.dto.ZahtevZaOdmorDTO;
import main.model.Lekar;
import main.model.ZahtevZaOdmor;
import main.service.LekarService;
import main.service.ZahtevZaOdmorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/zahtevZaOdmor")
public class ZahtevZaOdmorController {
	
	@Autowired
	private ZahtevZaOdmorService zahtevZaOdmorService;
	
	@Autowired
	private LekarService lekarService;
	
	@PostMapping(value = "/zatrazi", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyAuthority('LEKAR,MEDICINSKA_SESTRA')")
	public ResponseEntity<ZahtevZaOdmorDTO> zatrazi(@RequestBody ZahtevZaOdmorDTO zahtevZaOdmorDTO) throws ParseException {
		
		ZahtevZaOdmorDTO zzodto = new ZahtevZaOdmorDTO();
		try {
			zzodto = zahtevZaOdmorService.zatrazi(zahtevZaOdmorDTO);
			if (zzodto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(zzodto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/odobri", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> odobri(@RequestBody ZahtevZaOdmorDTO zahtevZaOdmorDTO) {
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		try {
			zzo = zahtevZaOdmorService.odobri(zahtevZaOdmorDTO);
			if (zzo ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PutMapping(value = "/odbij", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> odbij(@RequestBody ZahtevZaOdmorDTO zahtevZaOdmorDTO) {
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		try {
			zzo = zahtevZaOdmorService.odbij(zahtevZaOdmorDTO);
			if (zzo ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping(value = "/nadjiDatume/{id}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<List<String>> nadjiDatumeGodisnjeg(@PathVariable Long id) {
		
		Lekar lekar = lekarService.findOne(id);
		
		List<ZahtevZaOdmor> zahteviZaOdmor = (List<ZahtevZaOdmor>) lekar.getZahtevZaOdmor();
		
		List<String> datumi = new ArrayList<String>();
		
		
		for(ZahtevZaOdmor zzo : zahteviZaOdmor) {
			if(zzo.getOdobren() == true) {
				datumi.add(zzo.getStartDate());
				datumi.add(zzo.getEndDate());
			}
		}
		
		return new ResponseEntity<>(datumi, HttpStatus.OK);
	}
}
