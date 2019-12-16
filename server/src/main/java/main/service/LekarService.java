package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.LekarDTO;
import main.dto.PacijentDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.Lekar;
import main.repository.LekarRepository;

@Service
public class LekarService {
	
	@Autowired
	private LekarRepository lekarRepository;
	
	public Lekar findOne(Long id) {
		return lekarRepository.findById(id).orElseGet(null);
	}
	
	public Lekar findOne(String mail) {
		return lekarRepository.findByEmail(mail);
	}
	
	
	public Lekar izmeniLekara(Lekar lekar, LekarDTO lekarDTO) {
		  
		lekar.setIme(lekarDTO.getIme());
		lekar.setPrezime(lekarDTO.getPrezime());
		lekar.setAdresa(lekarDTO.getAdresa());
		lekar.setTelefon(lekarDTO.getTelefon());
		lekar.setGrad(lekarDTO.getGrad());
		lekar.setDrzava(lekarDTO.getDrzava());
		lekarRepository.save(lekar);
		
		return lekar;
}
	
	

}
