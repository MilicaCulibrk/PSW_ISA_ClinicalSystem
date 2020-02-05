package main.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.PregledDTO;
import main.dto.ZahtevZaOdmorDTO;
import main.model.Lekar;
import main.model.Pregled;
import main.model.ZahtevZaOdmor;
import main.service.LekarService;
import main.service.PregledService;
import main.service.ZahtevZaOdmorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/lekar")
public class LekarController {

	@Autowired
	private LekarService lekarService;
	
	@Autowired
	private PregledService pregledService;



	@GetMapping(value = "/get/{id}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<LekarDTO> getLekar(@PathVariable Long id) {
	
		Lekar lekar = lekarService.findOne(id);
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		LekarDTO lekarDTO = new LekarDTO(lekar);

		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/izmeni")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izmeniPacijenta(@RequestBody LekarDTO lekarDTO) {
		
		Lekar lekar = (Lekar) lekarService.findOne(lekarDTO.getId());
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		
		Lekar izmenjenLekar = lekarService.izmeniLekara(lekar, lekarDTO);

		LekarDTO newLekarDTO = new LekarDTO(izmenjenLekar);

		return new ResponseEntity<>(newLekarDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeniLozinku")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izmeniLozinku(@RequestBody LekarDTO lekarDTO) {
		
		Lekar lekar = (Lekar) lekarService.findOne(lekarDTO.getId());
		
		if (lekar == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		
		Lekar izmenjenLekar = lekarService.izmeniLozinku(lekar, lekarDTO);

		LekarDTO newLekarDTO = new LekarDTO(izmenjenLekar);

		return new ResponseEntity<>(newLekarDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<LekarDTO> dodajLekara(@RequestBody LekarDTO lekarDTO) {
		
		LekarDTO lekardto = new LekarDTO();
		try {
			lekardto = lekarService.dodajLekara(lekarDTO);
			if (lekardto ==null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(lekardto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/izlistaj/{idKlinike}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> getIzlistaj(@PathVariable Long idKlinike) {
		
		List<Lekar> listaLekara = lekarService.findAll();
		List<LekarDTO> listaLekaraDTO = new ArrayList<LekarDTO>();
		for (Lekar l : listaLekara) {
				if(l.getKlinika().getId().equals(idKlinike)) {
					listaLekaraDTO.add(new LekarDTO(l));
				}

		}
		
		return new ResponseEntity<>(listaLekaraDTO, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/izlistajOdmor/{idLekara}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izlistajOdmor(@PathVariable Long idLekara) {
	System.out.println("heloooo");
		List<Lekar> listaLekara = lekarService.findAll();
		Collection<ZahtevZaOdmor> listaOdmora = new ArrayList<ZahtevZaOdmor>();
		List<ZahtevZaOdmorDTO> listaOdmoraDTO = new ArrayList<ZahtevZaOdmorDTO>();
		for (Lekar l : listaLekara) {
				if(l.getId().equals(idLekara)) {
					listaOdmora = l.getZahtevZaOdmor();
				}
		}
		for (ZahtevZaOdmor zahtevZaOdmor : listaOdmora) {
			try{
				if(zahtevZaOdmor.getOdobren()==true)
					listaOdmoraDTO.add(new ZahtevZaOdmorDTO(zahtevZaOdmor));
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new ResponseEntity<>(listaOdmoraDTO, HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/izlistajOdmor/{idLekara}")
	@PreAuthorize("hasAuthority('LEKAR')")
	public ResponseEntity<?> izlistajPreglede(@PathVariable Long idLekara) {
		List<Lekar> listaLekara = lekarService.findAll();
		Collection<Pregled> listaPregleda = new ArrayList<Pregled>();
		List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
		for (Lekar l : listaLekara) {
				if(l.getId().equals(idLekara)) {
					listaPregleda = l.getPregled();
				}
		}
		for (Pregled p : listaPregleda) {
			try{
				if(p.getIdPacijenta()!=null)
					listaPregledaDTO.add(new PregledDTO(p));
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new ResponseEntity<>(listaPregledaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/preuzmiInfo/{email}")
	public ResponseEntity<Boolean> getIzlistajInfo(@PathVariable String email) {
		
		List<Lekar> listaLekara = lekarService.findAll();
		Boolean flag =false;
		for (Lekar l : listaLekara) {
				if(l.getEmail().equals(email)) {
					flag = l.getPromenjenaLozinka();
				}

		}
		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	
	@PostMapping(value = "/obrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<Lekar>> obrisi(@PathVariable Long id) {

		Lekar lekar = lekarService.findOne(id);
		List<Lekar> lekarDTO = new ArrayList<>();
		lekarService.remove(id);
		lekarDTO = lekarService.findAll();
		return new ResponseEntity<>(lekarDTO,HttpStatus.OK);
		
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping(value = "/izbrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> deletePregled(@PathVariable Long id) {

		Lekar lekar = lekarService.findOne(id);
		
		List<LekarDTO> lekarDTO = new ArrayList<>();
		
		if (lekarDTO != null) {
			
			int flag = 0;
			List<Pregled> pregledi = pregledService.findAll();

			for (Pregled p : pregledi){
				if (p.getLekar().getId() == id) {
					flag = 1;
					break;
				}
			}
			
		
			
			//lekara mozemo obrisati samo ako nema zakazane preglede
			if(flag == 0) {
				lekarService.remove(id);
				
				List<Lekar> lk = lekarService.findAll();

				for (Lekar l : lk) {
					if (l.getKlinika().getId() == lekar.getKlinika().getId()) {
						lekarDTO.add(new LekarDTO(l));
					}
				}
				return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
			}
			
		
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
