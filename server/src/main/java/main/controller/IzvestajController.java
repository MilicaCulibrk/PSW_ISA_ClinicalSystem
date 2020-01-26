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

import main.dto.IzvestajDTO;
import main.dto.LekarDTO;
import main.model.Izvestaj;
import main.model.Lekar;
import main.service.IzvestajService;

@CrossOrigin
@RestController
@RequestMapping(value = "/izvestaj")
public class IzvestajController {
	@Autowired
	private IzvestajService izvestajService;
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvestajDTO> dodajIzvestaj(@RequestBody IzvestajDTO izvestajDTO) {
		
		IzvestajDTO izvestajdto = new IzvestajDTO();
		try {
			izvestajdto = izvestajService.dodajIzvestaj(izvestajDTO);
			if (izvestajdto==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(izvestajdto, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/izlistaj/{idPacijenta}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<List<IzvestajDTO>> getIzlistaj(@PathVariable Long idPacijenta) {
		
		List<Izvestaj> listaIzvestaj = izvestajService.findAll();
		List<IzvestajDTO> listaIzvestajDTO = new ArrayList<IzvestajDTO>();
		for (Izvestaj i : listaIzvestaj) {
				if(i.getPacijent().getId().equals(idPacijenta)) {
					listaIzvestajDTO.add(new IzvestajDTO(i));
				}

		}
		
		return new ResponseEntity<>(listaIzvestajDTO, HttpStatus.OK);
	}
}
