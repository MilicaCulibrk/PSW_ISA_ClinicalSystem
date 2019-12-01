package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.SendEmailTLS;
import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinike;
import main.repository.AdminKlinikeRepository;

@Service
public class AdminKlinikeService {
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	public AdministratorKlinike findOne(Long id) {
		return adminKlinikeRepository.findById(id).orElseGet(null);
	}
	
	
	public AdminKlinikeDTO dodajAdministratora(AdminKlinikeDTO administratorDTO) {
		AdministratorKlinike klinika = new AdministratorKlinike();
		
		klinika.setIme(administratorDTO.getIme());
		klinika.setPrezime(administratorDTO.getPrezime());
		klinika.setAdresa(administratorDTO.getAdresa());
		klinika.setGrad(administratorDTO.getGrad());
		klinika.setDrzava(administratorDTO.getDrzava());
		klinika.setTelefon(administratorDTO.getTelefon());
		klinika.setEmail(administratorDTO.getEmail());
		klinika.setJmbg(administratorDTO.getJmbg());
		klinika.setLozinka(administratorDTO.getLozinka());
		for (AdministratorKlinike k : adminKlinikeRepository.findAll()) {
			if (klinika.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		adminKlinikeRepository.save(klinika);
		SendEmailTLS.main(administratorDTO.getEmail());
		AdminKlinikeDTO administratordto =new AdminKlinikeDTO(klinika);
		return administratordto;
	}
	
	public void izmeniAdminaKlinike(AdminKlinikeDTO adminKlinikeDTO) {
		AdministratorKlinike adminKlinike = adminKlinikeRepository.findById(adminKlinikeDTO.getId()).orElse(null);
		
		if(adminKlinike == null) {
			throw new ValidationException("Admin sa zadatim id-jem ne postoji");
		}
		try {
			adminKlinike = adminKlinikeRepository.getOne(adminKlinikeDTO.getId());
			adminKlinike.setIme(adminKlinikeDTO.getIme());
			adminKlinike.setPrezime(adminKlinikeDTO.getPrezime());
			adminKlinike.setAdresa(adminKlinikeDTO.getAdresa());
			adminKlinike.setTelefon(adminKlinikeDTO.getTelefon());
			adminKlinike.setGrad(adminKlinikeDTO.getGrad());
			adminKlinike.setDrzava(adminKlinikeDTO.getDrzava());
			adminKlinikeRepository.save(adminKlinike);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}
}
