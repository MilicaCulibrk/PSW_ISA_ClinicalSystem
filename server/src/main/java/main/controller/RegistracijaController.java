package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.SendEmailTLS;
import main.dto.PacijentDTO;
import main.service.MailService;
import main.service.RegistracijaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/registracija")

public class RegistracijaController {
	
	@Autowired
	private RegistracijaService registracijaService;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping(value = "/register/{zahtevId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void Register(@PathVariable Long zahtevId, @RequestBody PacijentDTO korisnik) {
		
		
		registracijaService.register(korisnik, zahtevId);
		String message = "Cestitamo,"
                + "\n\n Upravo ste registrovani kao pacijent na sajt Klinickog centra!";
		try {
			mailService.sendNotificaitionAsync(korisnik, message);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@PostMapping(value = "/napraviZK", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PacijentDTO> Register( @RequestBody PacijentDTO korisnik) {
		if (registracijaService.napraviZK(korisnik)) {
			String message = "Cestitamo,"
	                + "\n\n Upravo ste registrovani kao pacijent na sajt Klinickog centra!";
			try {
				mailService.sendNotificaitionAsync(korisnik, message);
			} catch (MailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<>(korisnik, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

		}
		


	}


	@PostMapping(value = "/odbijen/{zahtevId}/{text}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void Odbijen(@PathVariable Long zahtevId, @PathVariable String text, @RequestBody PacijentDTO pacijent) {
		registracijaService.odbijen(zahtevId);
		String message = text;
		try {
			mailService.sendNotificaitionAsync(pacijent, message);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
