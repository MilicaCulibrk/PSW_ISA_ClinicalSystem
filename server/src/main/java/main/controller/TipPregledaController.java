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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.TipPregledaDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.Pregled;
import main.model.TipPregleda;
import main.service.AdminKlinikeService;
import main.service.LekarService;
import main.service.PregledService;
import main.service.TipPregledaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/tipPregleda")
public class TipPregledaController {
	
	@Autowired
	private TipPregledaService tipPregledaService;
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@Autowired
	private LekarService lekarService;
	

	@Autowired
	private PregledService pregledService;
	
	
	@GetMapping(value = "/TipoviLekara/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<LekarDTO>> getTipoviLekara(@PathVariable String id) {
		
		List<Lekar> lekari = lekarService.findAll();

		Long idLong = Long.parseLong(id);
		TipPregleda tipPregleda = tipPregledaService.findOne(idLong);
		List<LekarDTO> lekarDTO = new ArrayList<>();
		
		
		for (Lekar l : lekari) {
		    if(l.getTipPregleda().getId() == tipPregleda.getId()) {
			lekarDTO.add(new LekarDTO(l));
		    }
		}

		return new ResponseEntity<>(lekarDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/TipoviKlinike/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<TipPregledaDTO>> getTipovi(@PathVariable String id) {
		
		List<TipPregleda> tipoviPregleda = tipPregledaService.findAll();

		Long idLong = Long.parseLong(id);
		AdministratorKlinike adm = adminKlinikeService.findOne(idLong);
		List<TipPregledaDTO> tipoviDTO = new ArrayList<>();
		
		
		for (TipPregleda tip : tipoviPregleda) {
		    if(tip.getKlinika().getId() == adm.getKlinika().getId()) {
			tipoviDTO.add(new TipPregledaDTO(tip));
		    }
		}

		return new ResponseEntity<>(tipoviDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/nadjiTip/{id}")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<TipPregledaDTO> nadjiTip(@PathVariable String id) {
		
		Long idLong = Long.parseLong(id);
		Lekar lekar = lekarService.findOne(idLong);
		
		TipPregleda tipPregleda = lekar.getTipPregleda();
		
		TipPregledaDTO tipPregledaDTO = new TipPregledaDTO(tipPregleda);
		
		

		return new ResponseEntity<>(tipPregledaDTO, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/TipoviKlinike1")
	@PreAuthorize("hasAuthority('PACIJENT')")
	public ResponseEntity<List<TipPregledaDTO>> getTipovi1() {
		
		List<TipPregleda> tipoviPregleda = tipPregledaService.findAll();

		List<TipPregledaDTO> tipoviDTO = new ArrayList<>();
		
		
		for (TipPregleda tip : tipoviPregleda) {
			tipoviDTO.add(new TipPregledaDTO(tip));
		    }
		

		return new ResponseEntity<>(tipoviDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/dodaj/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<TipPregledaDTO> dodajTipPregleda(@RequestBody TipPregledaDTO tipPregledaDTO,@PathVariable String id) {
		
		TipPregledaDTO tipDTO = new TipPregledaDTO();
		Long idLong = Long.parseLong(id);
		AdministratorKlinike adm = adminKlinikeService.findOne(idLong);
		
		//ako je ista oznaka ili naziv a u toj je klinici ne mozes ga dodati
		List<TipPregleda> tipovi = tipPregledaService.findAll();
		for(TipPregleda tip : tipovi) {
			if(tip.getOznaka().equals(tipPregledaDTO.getOznaka()) && tip.getKlinika().getId() == adm.getKlinika().getId()) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(tip.getNaziv().equals(tipPregledaDTO.getNaziv()) && tip.getKlinika().getId() == adm.getKlinika().getId()) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		try {
			tipDTO = tipPregledaService.dodajTipPregleda(tipPregledaDTO,idLong);
		}catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(tipDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmeniTipPregleda", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<TipPregledaDTO> izmeniPodatkeTipaPregleda(@RequestBody TipPregledaDTO tipPregledaDTO){
		
		int flag = 0;
		List<Pregled> pregledi = pregledService.findAll();

		for (Pregled p : pregledi){
			if (p.getTipPregleda().getId() == tipPregledaDTO.getId()) {
				flag = 1;
				break;
			}
		}
		
		
		if(flag == 0) {
			
			tipPregledaService.izmeniTipPregleda(tipPregledaDTO);
			return new ResponseEntity<>(tipPregledaDTO, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping(value = "/izbrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<TipPregledaDTO>> deletePregled(@PathVariable Long id) {

		TipPregleda tipPregleda = tipPregledaService.findOne(id);
		List<TipPregledaDTO> tipPregledaDTO = new ArrayList<>();
		
		if (tipPregleda != null) {
			
			int flag = 0;
			List<Pregled> pregledi = pregledService.findAll();

			for (Pregled p : pregledi){
				if (p.getTipPregleda().getId() == id) {
					flag = 1;
					break;
				}
			}
			
			List<Lekar> lekari = lekarService.findAll();

			for (Lekar l : lekari){
				if (l.getTipPregleda().getId() == id) {
					flag = 1;
					break;
				}
			}
			
			//tip pregleda mozemo da obrisemo samo ako on nije vezan za neki pregled ili ako nije vezan za lekara
			if(flag == 0) {
				tipPregledaService.remove(id);
				
				List<TipPregleda> pr = tipPregledaService.findAll();

				for (TipPregleda prg : pr) {
					if (prg.getKlinika().getId() == tipPregleda.getKlinika().getId()) {
						tipPregledaDTO.add(new TipPregledaDTO(prg));
					}
				}
				return new ResponseEntity<>(tipPregledaDTO, HttpStatus.OK);
			}
			
		
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

}
