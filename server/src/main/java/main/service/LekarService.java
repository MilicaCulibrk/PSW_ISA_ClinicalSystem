package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.LekarDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.repository.LekarRepository;

@Service
public class LekarService {
	
	@Autowired
	private LekarRepository lekarRepository;
	
	public Lekar findOne(Long id) {
		return lekarRepository.findById(id).orElseGet(null);
	}
	
	public void izmeniLekar(LekarDTO lekarDTO) {
		Lekar lekar = lekarRepository.findById(lekarDTO.getId()).orElse(null);
		
		if(lekar == null) {
			throw new ValidationException("Lekar sa zadatim id-jem ne postoji");
		}
		try {
			lekar = lekarRepository.getOne(lekarDTO.getId());
			lekar.setIme(lekarDTO.getIme());
			lekar.setPrezime(lekarDTO.getPrezime());
			lekar.setAdresa(lekarDTO.getAdresa());
			lekar.setTelefon(lekarDTO.getTelefon());
			lekar.setGrad(lekarDTO.getGrad());
			lekar.setDrzava(lekarDTO.getDrzava());
			lekarRepository.save(lekar);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Lekar sa tim id-ijem ne postoji");
		}
	}
	
	

}
