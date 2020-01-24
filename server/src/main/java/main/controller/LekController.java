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

import main.dto.KlinikaDTO;
import main.dto.LekDTO;
import main.model.Lek;
import main.model.Lekar;
import main.service.LekService;

@CrossOrigin
@RestController
@RequestMapping(value = "/lek")
public class LekController {
	@Autowired
	private LekService lekService;
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<LekDTO>> getIzlistaj() {
		
		List<Lek> listaLekova = lekService.findAll();
		List<LekDTO> listaLekovaDTO = new ArrayList<LekDTO>();
		for (Lek k : listaLekova) {
			listaLekovaDTO.add(new LekDTO(k));
		}
		
		return new ResponseEntity<>(listaLekovaDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LekDTO> dodajLek(@RequestBody LekDTO lekDTO) {
		
		LekDTO lekdto = new LekDTO();
		try {
			lekdto = lekService.dodajLek(lekDTO);
			if (lekdto==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(lekdto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/obrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<Lek>> obrisi(@PathVariable Long id) {

		Lek lek = lekService.findOne(id);
		List<Lek> lekDTO = new ArrayList<>();
		lekService.remove(id);
		lekDTO = lekService.findAll();
		return new ResponseEntity<>(lekDTO,HttpStatus.OK);
		
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
