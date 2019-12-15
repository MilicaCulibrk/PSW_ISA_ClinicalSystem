package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.PacijentDTO;
import main.dto.ZahtevZaRegDTO;
import main.model.ZahtevZaRegistraciju;
import main.service.ZahtevZaRegService;


@RestController
@RequestMapping(value = "/zahtevZaReg")
public class ZahtevZaRegController {
	
	@Autowired
	private ZahtevZaRegService zahtevZaRegService;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<ZahtevZaRegDTO>> getSviZahtevi() {
		
		List<ZahtevZaRegistraciju> zahtevi = zahtevZaRegService.findAll();

		List<ZahtevZaRegDTO> zahteviDTO = new ArrayList<>();
		for (ZahtevZaRegistraciju zzr : zahtevi) {
			zahteviDTO.add(new ZahtevZaRegDTO(zzr));
		}
		
		return new ResponseEntity<>(zahteviDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPacijenta/{zahtevId}")
	public ResponseEntity<PacijentDTO> getPacijent(@PathVariable Long zahtevId) {
		
		ZahtevZaRegistraciju zahtev =  zahtevZaRegService.findOne((long) zahtevId);
		
		if(zahtev.equals(null)) {
			System.out.println("neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		}
		PacijentDTO pacijentDTO = new PacijentDTO();
		pacijentDTO.setIme(zahtev.getIme());
		pacijentDTO.setPrezime(zahtev.getPrezime());
		pacijentDTO.setEmail(zahtev.getEmail());
		pacijentDTO.setTelefon(zahtev.getTelefon());
		pacijentDTO.setAdresa(zahtev.getAdresa());
		pacijentDTO.setGrad(zahtev.getGrad());
		pacijentDTO.setDrzava(zahtev.getDrzava());
		pacijentDTO.setJmbg(zahtev.getJmbg());
		pacijentDTO.setLozinka(zahtev.getLozinka());

		ZahtevZaRegDTO zahtevdto = new ZahtevZaRegDTO(zahtev);
	
		return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
	}
	
	
	
}