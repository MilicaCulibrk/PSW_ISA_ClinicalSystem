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

import main.dto.IzvestajDTO;
import main.model.Izvestaj;
import main.repository.IzvestajRepository;
import main.service.IzvestajService;
import main.service.MedicinskaSestraService;

@CrossOrigin
@RestController
@RequestMapping(value = "/izvestaj")
public class IzvestajController {
	@Autowired
	private IzvestajService izvestajService;
	@Autowired
	private IzvestajRepository izvestajRepository;
	
	@Autowired
	private MedicinskaSestraService medicinskaSestraService;
	
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
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAnyAuthority('LEKAR, MEDICINSKA_SESTRA')")
	public ResponseEntity<List<IzvestajDTO>> getIzlistaj() {
		
		List<Izvestaj> listaIzvestaj = izvestajService.findAll();
		List<IzvestajDTO> listaIzvestajDTO = new ArrayList<IzvestajDTO>();
		for (Izvestaj i : listaIzvestaj) {
				if(!i.getOverenRecept()) {
					listaIzvestajDTO.add(new IzvestajDTO(i));
				}

		}
		
		return new ResponseEntity<>(listaIzvestajDTO, HttpStatus.OK);
	}
	/*
	@PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
	@PutMapping(value = "/overi", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IzvestajDTO>> getOveri(Long idPacijenta) {
		System.out.println("uslo u kontroler");
		Izvestaj iz = izvestajService.findOne(idPacijenta);
		iz.setOverenRecept(false);
		List<Izvestaj> listaIzvestaj = izvestajService.findAll();
		List<IzvestajDTO> listaIzvestajDTO = new ArrayList<IzvestajDTO>();
		for (Izvestaj i : listaIzvestaj) {
				if(!i.getOverenRecept()) {
					listaIzvestajDTO.add(new IzvestajDTO(i));
				}

		}
		
		return new ResponseEntity<>(listaIzvestajDTO, HttpStatus.OK);
	}*/
	
	@PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
	@PutMapping(value = "/overi", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IzvestajDTO>> overi(@RequestBody IzvestajDTO izvestajDTO) {
		System.out.println(izvestajDTO.getIdMedicinskeSestre());
		Izvestaj iz = izvestajService.findOne(izvestajDTO.getId());
		iz.setOverenRecept(true);
		iz.setMedicinskaSestra(medicinskaSestraService.findOne(izvestajDTO.getIdMedicinskeSestre()));
		izvestajRepository.save(iz);
		List<Izvestaj> listaIzvestaj = izvestajService.findAll();
		List<IzvestajDTO> listaIzvestajDTO = new ArrayList<IzvestajDTO>();
		for (Izvestaj i : listaIzvestaj) {
				if(!i.getOverenRecept()) {
					listaIzvestajDTO.add(new IzvestajDTO(i));
				}

		}
		
		return new ResponseEntity<>(listaIzvestajDTO, HttpStatus.OK);
	}
}
