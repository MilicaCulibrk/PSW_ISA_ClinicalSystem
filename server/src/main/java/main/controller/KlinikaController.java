package main.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import main.dto.KlinikaDTO;
import main.dto.PretragaKlinikeDTO;
import main.dto.PrihodiDTO;
import main.model.Klinika;
import main.model.Pregled;
import main.service.KlinikaService;
import main.service.PregledService;



@CrossOrigin
@RestController
@RequestMapping(value = "/klinika")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;
	
	@Autowired
	private PregledService pregledService;
	
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	@PostMapping(value = "/dodajKlinikuUBazu", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> dodajKliniku(@RequestBody KlinikaDTO klinikaDTO) {
		
		KlinikaDTO klinikadto = new KlinikaDTO();
		try {
			klinikadto = klinikaService.dodajKliniku(klinikaDTO);
			if (klinikadto==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(klinikadto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pronadji")
	public ResponseEntity<KlinikaDTO> getPostojecaKlinika() {
		
		Klinika klinika = klinikaService.findOne((long) 1);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/pronadjiKliniku/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<KlinikaDTO> getPronadjiKliniku(@PathVariable Long id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pronadjiKliniku1/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<KlinikaDTO> getPronadjiKliniku1(@PathVariable Long id) {
		
		Klinika klinika = klinikaService.findOne(id);
		
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika);
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj")
	@PreAuthorize("hasAuthority('ADMIN_CENTRA')")
	public ResponseEntity<List<KlinikaDTO>> getIzlistaj() {
		
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/izlistajK")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getIzlistajK() {
		
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/izlistajKl")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<KlinikaDTO>> getIzlistajKl() {
		
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	@PutMapping(value = "/izmeni", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> izmeni(@RequestBody KlinikaDTO klinikaDTO){
		
		try {
			klinikaService.izmeniKliniku(klinikaDTO);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('PACIJENT')")
	 @PostMapping(value = "/pretraga/{id}",consumes = "application/json")
    public ResponseEntity<?> pretragaKlinike(@RequestBody PretragaKlinikeDTO pretragaKlinikeDTO, @PathVariable Long id) throws ParseException {


	    	
	    	String datum = null;
	    	String tipPregleda =  null;
	    	

	    	
	    	if(pretragaKlinikeDTO.getDatum() != null) {
	    		if(!pretragaKlinikeDTO.getDatum().equals("")){
	    			datum = pretragaKlinikeDTO.getDatum();	    		
	    		}
	    	}
	    	
	    	if(pretragaKlinikeDTO.getTipPregleda() != null) {
	    		if(!pretragaKlinikeDTO.getTipPregleda().equals("")){
	    			tipPregleda = pretragaKlinikeDTO.getTipPregleda();	    		
	    		}
	    	}

	    	List<Klinika> klinike = klinikaService.pronadjiKlinike( datum, tipPregleda);

			List<KlinikaDTO> klinikeDTO = new ArrayList<>();
			for (Klinika k : klinike) {
				klinikeDTO.add(new KlinikaDTO(k));
			}

	    	return new ResponseEntity<>(klinikeDTO, HttpStatus.OK);


	    }
	
	@PutMapping(value = "/azuriraj")
	@PreAuthorize("hasAnyAuthority('PACIJENT')")
	public ResponseEntity<List<KlinikaDTO>> getAzuriraj(@RequestBody String sortBy) {
		
		List<Klinika> listaKlinika = klinikaService.sortiraj(sortBy);
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		for (Klinika k : listaKlinika) {
			listaKlinikaDTO.add(new KlinikaDTO(k));
		}
		
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/prihodi/{idKlinike}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<Double> zatrazi(@PathVariable Long idKlinike,  @RequestBody PrihodiDTO prihodiDTO) throws ParseException {
		
		try {
			String[] startS=prihodiDTO.getStart().split("'");
			String[] endS=prihodiDTO.getEnd().split("'");

			SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date start = inFormat.parse(startS[0]);
			Date end = inFormat.parse(endS[0]);	
			
			List <Pregled> pregledi = pregledService.findAll();
			Double ukupnaCena = 0.0;
			
			for(Pregled p : pregledi) {
				Date pregledDatum = inFormat.parse(p.getDatum());
				if(p.getLekar().getKlinika().getId() == idKlinike && pregledDatum.after(start) && pregledDatum.before(end)) {
					ukupnaCena += Double.parseDouble(p.getCena());
				}
			}
				return new ResponseEntity<>(ukupnaCena, HttpStatus.OK);
			}catch (ValidationException e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		
	}
}
