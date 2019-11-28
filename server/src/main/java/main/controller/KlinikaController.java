package main.controller;
import org.springframework.http.MediaType;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.KlinikaDTO;
import main.model.Klinika;
import main.service.KlinikaService;


@RestController
@RequestMapping(value = "klinika")
@CrossOrigin(origins = "http://localhost:8081")
public class KlinikaController {
	@Autowired
	private KlinikaService klinikaService;
	
	@PostMapping(value = "/dodajKlinikuUBazu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> dodajKliniku(@RequestBody KlinikaDTO klinikaDTO) {
		
		KlinikaDTO klinikadto = new KlinikaDTO();
		try {
			klinikadto = klinikaService.dodajKliniku(klinikaDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(klinikadto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/postojecaKlinika")
	public ResponseEntity<KlinikaDTO> getPostojecaKlinika() {
		
		Klinika klinika = klinikaService.findOne((long) 1);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
}
