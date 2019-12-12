package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.AdminKCDTO;
import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.repository.AdminKCRepository;

@Service
public class AdminKCService {
	
	@Autowired
	private AdminKCRepository adminKCRepository;
	
	public AdministratorKlinickogCentra findOne(Long id) {
		return adminKCRepository.findById(id).orElseGet(null);
	}

	public void izmeniAdminaKlinike(AdminKCDTO adminKCDTO) {
		AdministratorKlinickogCentra adminKlinike = adminKCRepository.findById(adminKCDTO.getId()).orElse(null);
		
		if(adminKlinike == null) {
			throw new ValidationException("Admin sa zadatim id-jem ne postoji");
		}
		try {
			adminKlinike = adminKCRepository.getOne(adminKCDTO.getId());
			adminKlinike.setIme(adminKCDTO.getIme());
			adminKlinike.setPrezime(adminKCDTO.getPrezime());
			adminKlinike.setAdresa(adminKCDTO.getAdresa());
			adminKlinike.setTelefon(adminKCDTO.getTelefon());
			adminKlinike.setGrad(adminKCDTO.getGrad());
			adminKlinike.setDrzava(adminKCDTO.getDrzava());
			adminKCRepository.save(adminKlinike);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}
}
