package main.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.PregledDTO;
import main.model.Pregled;
import main.service.PregledService;

@CrossOrigin
@RestController
@RequestMapping(value = "/pregled")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;
	
	//dodaj predefinisani pregled kao administrator klinike sa ogranicenjima
	@PostMapping(value = "/dodajPregled", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<PregledDTO> dodajPregled(@RequestBody PregledDTO pregledDTO) {

		PregledDTO pregleddto = new PregledDTO();
		boolean flag = false;
		
		 int pocetakRV = pregledDTO.getLekar().getPocetak();
		 int krajRV = pregledDTO.getLekar().getKraj();
		 
		 String pocetakPstr = pregledDTO.getVreme();
		 double pocetakP = Double.parseDouble(pocetakPstr);
		 
		 Double trajanjeP = pregledDTO.getTrajanjePregleda();
		 System.out.println(trajanjeP);
		 Double krajP = pocetakP + trajanjeP;
		 
		 //ako postoji predefinisan pregled sa istom salom i datumom proverimo da li se vreme poklapa, jer ne sme
		 List<Pregled> pregledi = pregledService.findAll();
			for(Pregled pregled : pregledi) {
				
				
				String vremeStr = pregled.getVreme();
				double pocetakPregleda =  Double.parseDouble(vremeStr);
				double trajanjePregleda = pregledDTO.getTrajanjePregleda()*60;
				double krajPregleda = pocetakPregleda + trajanjePregleda;
				
				
				if(pregledDTO.getDatum().equals(pregled.getDatum()) && pregled.getIdPacijenta() == null && pregled.getSala().getId() == pregledDTO.getSala().getId()) {
				
					//pregled ne sme da pocne u terminu drugog pregleda
					if(pocetakP >= pocetakPregleda && pocetakP <= krajPregleda) {
						flag = true;
					}
					
					//termin ne sme da pocne pre pocetka drugog pregleda a zavrsi se posle pocetka drugog pregleda
					else if(pocetakP <= pocetakPregleda && krajP >= pocetakPregleda) {
						flag = true;
					}
					
				//ako postoji pregled sa istim datumom i razlicitom salom ali istim lekarom
				}else if(pregledDTO.getDatum().equals(pregled.getDatum()) && pregled.getIdPacijenta() == null && pregled.getSala().getId() != pregledDTO.getSala().getId() && pregled.getLekar().getId() == pregledDTO.getLekar().getId()) {
						
				    //ako pregled pocinje u terminu drugog pregleda
					if(pocetakP >= pocetakPregleda && pocetakP <= krajPregleda) {
						flag = true;
					}
					
					//termin ne sme da pocne pre pocetka drugog pregleda a zavrsi se posle pocetka drugog pregleda
					else if(pocetakP <= pocetakPregleda && krajP >= pocetakPregleda) {
						flag = true;
					}
					
					//termin ne sme pocinjati pre radnog vremena lekara i zavrsavati se posle radnog vremena lekara
					else if(pocetakP < pocetakRV || pocetakP > krajRV) {
						flag = true;
					}
					
					//termin ne sme pocinjati posle radnog vremena lekara, a zavrsavati se posle radnog vremena lekara
					else if(pocetakP > pocetakRV && krajP > krajRV) {
						flag = true;
					}
					
				}
			}
			
			if(!flag) {
				pregleddto = pregledService.dodajPregled(pregledDTO);
			}
		 
			if(flag) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);			
			}			
	
			return new ResponseEntity<>(pregleddto, HttpStatus.OK);
	}
			
}
