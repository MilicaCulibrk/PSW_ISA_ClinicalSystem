package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.SalaDTO;
import main.model.AdministratorKlinike;
import main.model.Sala;
import main.service.AdminKlinikeService;
import main.service.SalaService;

@RestController
@RequestMapping(value = "sala")
public class SalaController {
	
	@Autowired
	private SalaService salaKlinikeService;

	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@GetMapping(value = "/getSale/{id}")
	public ResponseEntity<List<SalaDTO>> getSveSale(@PathVariable String id) {

		List<Sala> sale = salaKlinikeService.findAll();

		Long idLong = Long.parseLong(id);
		AdministratorKlinike adm = adminKlinikeService.findOne(idLong);

		List<SalaDTO> salaDTO = new ArrayList<>();
		for (Sala s : sale) {
			if (s.getKlinika().getId() == adm.getKlinika().getId()) {
				salaDTO.add(new SalaDTO(s));
			}
		}

		return new ResponseEntity<>(salaDTO, HttpStatus.OK);
	}

}
