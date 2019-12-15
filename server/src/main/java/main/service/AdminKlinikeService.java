package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.SendEmailTLS;
import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinike;
import main.repository.AdminKlinikeRepository;
import main.repository.KlinikaRepository;

@Service
public class AdminKlinikeService {
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	public AdministratorKlinike findOne(Long id) {
		return adminKlinikeRepository.findById(id).orElseGet(null);
	}
	
	
	public AdminKlinikeDTO dodajAdministratora(AdminKlinikeDTO administratorDTO) {
		AdministratorKlinike ak = new AdministratorKlinike();
		
		ak.setIme(administratorDTO.getIme());
		ak.setPrezime(administratorDTO.getPrezime());
		ak.setAdresa(administratorDTO.getAdresa());
		ak.setGrad(administratorDTO.getGrad());
		ak.setDrzava(administratorDTO.getDrzava());
		ak.setTelefon(administratorDTO.getTelefon());
		ak.setEmail(administratorDTO.getEmail());
		ak.setJmbg(administratorDTO.getJmbg());
		ak.setLozinka(administratorDTO.getLozinka());
		//ak.setKlinika(klinikaRepository.getOne(administratorDTO.getIdKlinike()));
		for (AdministratorKlinike k : adminKlinikeRepository.findAll()) {
			if (ak.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		adminKlinikeRepository.save(ak);
		//SendEmailTLS.main(administratorDTO.getEmail());
		AdminKlinikeDTO administratordto =new AdminKlinikeDTO(ak);
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
