package main.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import main.dto.PregledDTO;
import main.dto.PretragaSaleDTO;
import main.dto.SalaDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.Pregled;
import main.model.Sala;
import main.service.AdminKlinikeService;
import main.service.PregledService;
import main.service.SalaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaKlinikeService;

	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@Autowired
	private PregledService pregledService;
	
	@GetMapping(value = "/getSale/{id}")
	public ResponseEntity<List<SalaDTO>> getSveSale(@PathVariable String id) {

		List<Sala> sale = salaKlinikeService.findAll();

		Long idLong = Long.parseLong(id);
		AdministratorKlinike adm = adminKlinikeService.findOne(idLong);

		List<SalaDTO> salaDTO = new ArrayList<>();
		for (Sala s : sale) {
			if (s.getKlinika().getId() == adm.getKlinika().getId()) {
				SalaDTO sdto = new SalaDTO(s);
				salaDTO.add(sdto);
				
			}
		}

		return new ResponseEntity<>(salaDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/dodaj/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<SalaDTO> dodajSaluKlinike(@RequestBody SalaDTO salaDTO, @PathVariable String id) {
		
		SalaDTO salaDto = new SalaDTO();
		
		Long idLong = Long.parseLong(id);
		AdministratorKlinike adm = adminKlinikeService.findOne(idLong);
	
		
		List<Sala> sale = salaKlinikeService.findAll();
		for (Sala s : sale) {
			if (s.getNaziv().equals(salaDTO.getNaziv())  && (s.getKlinika().getId() == adm.getKlinika().getId())) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (s.getBroj().equals(salaDTO.getBroj())  && (s.getKlinika().getId() == adm.getKlinika().getId())) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		try {
			salaDto = salaKlinikeService.dodajSaluKlinike(salaDTO, idLong);
		} catch (ValidationException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(salaDto, HttpStatus.OK);
	}
	
	
	
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	@PutMapping(value = "/izmeniSalu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> izmeniSalu(@RequestBody SalaDTO salaDTO) {
	
	

	
			int flag = 0;
			List<Pregled> pregledi = pregledService.findAll();

			for (Pregled p : pregledi){
				if (p.getSala().getId() == salaDTO.getId()) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
			
				salaKlinikeService.izmeniSalu(salaDTO);
				return new ResponseEntity<>(salaDTO, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}


		
	}
	
	@DeleteMapping(value = "/izbrisi/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<List<SalaDTO>> deleteSalu(@PathVariable Long id) {

		Sala salaKlinike = salaKlinikeService.findOne(id);
		List<SalaDTO> salaDTO = new ArrayList<>();
		if (salaKlinike != null) {
			
			int flag = 0;
			List<Pregled> pregledi = pregledService.findAll();

			for (Pregled p : pregledi){
				if (p.getSala().getId() == id) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				salaKlinikeService.remove(id);
				List<Sala> sk = salaKlinikeService.findAll();

				for (Sala sala : sk) {
					if (sala.getKlinika().getId() == salaKlinike.getKlinika().getId()) {
						salaDTO.add(new SalaDTO(sala));
					}
				}
				return new ResponseEntity<>(salaDTO, HttpStatus.OK);
			}
			
		
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	 @PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	 @PostMapping(value = "/pretraga/{id}",consumes = "application/json")
     public ResponseEntity<?> pretragaSale(@RequestBody PretragaSaleDTO pretragaSaleDTO, @PathVariable Long id){

System.out.println("helou ima li koga");
	    	String naziv = null;
	    	Integer broj = null;
	    	String datum = null;
	    	String vreme =  null;
	    	

	    	if(pretragaSaleDTO.getNaziv() != null) {
	    		if(!pretragaSaleDTO.getNaziv().isEmpty()) {
	    		
	    			naziv = pretragaSaleDTO.getNaziv();
	    		}
	    	}

	    	if(pretragaSaleDTO.getBroj() != null) {
	    		if(!(pretragaSaleDTO.getBroj() < 0)) {
	    			broj = pretragaSaleDTO.getBroj();
	    		}
	    	}
	    	
	    	if(pretragaSaleDTO.getDatum() != null) {
	    		if(!pretragaSaleDTO.getDatum().equals("")){
	    			datum = pretragaSaleDTO.getDatum();	    		
	    		}
	    	}
	    	
	    	if(pretragaSaleDTO.getVreme() != null) {
	    		if(!pretragaSaleDTO.getVreme().equals("")){
	    			vreme = pretragaSaleDTO.getVreme();	    		
	    		}
	    	}

	    	AdministratorKlinike admin =  adminKlinikeService.findOne(id);

	    	//slobodne sale koje vracam
	    	List<Sala> sale = salaKlinikeService.pronadjiSale(admin.getKlinika().getId(), naziv, broj, datum, vreme);

			List<SalaDTO> saleDTO = new ArrayList<>();
			for (Sala s : sale) {
				saleDTO.add(new SalaDTO(s));
			}

	    	return new ResponseEntity<>(saleDTO, HttpStatus.OK);


	    }
	 
		@GetMapping(value = "/izlistajZauzece/{idSale}")
		@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
		public ResponseEntity<?> izlistajZauzece(@PathVariable Long idSale) {
			List<Sala> listaSala = salaKlinikeService.findAll();
			Collection<Pregled> listaPregleda = new ArrayList<Pregled>();
			List<PregledDTO> listaPregledaDTO = new ArrayList<PregledDTO>();
			for (Sala s : listaSala) {
					if(s.getId().equals(idSale)) {
						listaPregleda = s.getPregledi();
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

}
