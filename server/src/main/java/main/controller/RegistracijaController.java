package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.SendEmailTLS;
import main.dto.PacijentDTO;
import main.service.RegistracijaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/registracija")

public class RegistracijaController {
	
	@Autowired
	private RegistracijaService registracijaService;
	

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void Register(@RequestBody PacijentDTO korisnik) {
		
		//registracijaService.posaljiZahtevAdminuKC(korisnik);
		registracijaService.register(korisnik);
	    SendEmailTLS.main(korisnik.getEmail(),  "Cestitamo,"
                + "\n\n Upravo ste registrovani kao pacijent na sajt Klinickog centra!");
	}


	@PostMapping(value = "/odbijen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void Odbijen(@RequestBody String email, @RequestBody String text) {
	    SendEmailTLS.main(email, "Nazalost,"
                + "\n\n vas zahtev je odbijen!" + "\n\nRazlog odbijanja: ");
	}

}
