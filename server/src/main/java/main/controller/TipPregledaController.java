package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.TipPregledaDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.TipPregleda;
import main.service.AdminKlinikeService;
import main.service.LekarService;
import main.service.TipPregledaService;

@RestController
@RequestMapping(value = "tipPregleda")
public class TipPregledaController {
	
	@Autowired
	private TipPregledaService tipPregledaService;
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@Autowired
	private LekarService lekarService;
	
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
	
	

}
