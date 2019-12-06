package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import main.dto.RegistracijaDTO;
import main.service.RegistracijaService;

@RestController
@RequestMapping(value = "registracija")
@CrossOrigin(origins = "http://localhost:8080")
public class RegistracijaController {
	
	@Autowired
	private RegistracijaService registracijaService;
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void Register(@RequestBody RegistracijaDTO korisnik) {
		
		registracijaService.register(korisnik);
	}



}
