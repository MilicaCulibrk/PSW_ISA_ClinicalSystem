package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.dto.AdminKlinikeDTO;
import main.model.AdministratorKlinike;
import main.model.Authority;
import main.repository.AdminKlinikeRepository;
import main.repository.AuthorityRepository;
import main.repository.KlinikaRepository;

@Service
public class AdminKlinikeService {
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	public AdministratorKlinike findOne(Long id) {
		return adminKlinikeRepository.findById(id).orElseGet(null);
	}
	

	@Autowired
	private AuthorityRepository authorityRepository;
	
	
	public AdminKlinikeDTO dodajAdministratora(AdminKlinikeDTO administratorDTO) {
		AdministratorKlinike ak = new AdministratorKlinike();
		
		Authority auth = this.authorityRepository.findByUloga("ADMIN_KLINIKE");
		List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    ak.setAuthorities(auths);
		
		ak.setIme(administratorDTO.getIme());
		ak.setPrezime(administratorDTO.getPrezime());
		ak.setAdresa(administratorDTO.getAdresa());
		ak.setGrad(administratorDTO.getGrad());
		ak.setDrzava(administratorDTO.getDrzava());
		ak.setTelefon(administratorDTO.getTelefon());
		ak.setEmail(administratorDTO.getEmail());
		ak.setJmbg(administratorDTO.getJmbg());
		ak.setLozinka(passwordEncoder.encode(administratorDTO.getLozinka()));
		ak.setPromenjenaLozinka(false);
		ak.setKlinika(klinikaRepository.getOne(administratorDTO.getIdKlinike()));
		for (AdministratorKlinike k : adminKlinikeRepository.findAll()) {
			if (ak.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		adminKlinikeRepository.save(ak);
		//SendEmailTLS.main(administratorDTO.getEmail());
		AdminKlinikeDTO administratordto =new AdminKlinikeDTO(ak);
		//klinikaRepository.getOne(administratorDTO.getIdKlinike()).administratorKlinike.add(ak);

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
			adminKlinike.setPromenjenaLozinka(true);
			adminKlinike.setLozinka(passwordEncoder.encode(adminKlinikeDTO.getLozinka()));
			adminKlinikeRepository.save(adminKlinike);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}


	public List<AdministratorKlinike> findAll() {
		// TODO Auto-generated method stub
		return adminKlinikeRepository.findAll();
	}

	public void izmeniLozinku(AdminKlinikeDTO adminKlinikeDTO) {
		// TODO Auto-generated method stub
		AdministratorKlinike adminKlinike = adminKlinikeRepository.findById(adminKlinikeDTO.getId()).orElse(null);
		adminKlinike.setPromenjenaLozinka(true);
		adminKlinike.setLozinka(passwordEncoder.encode(adminKlinikeDTO.getLozinka()));
		adminKlinikeRepository.save(adminKlinike);

	}
}
