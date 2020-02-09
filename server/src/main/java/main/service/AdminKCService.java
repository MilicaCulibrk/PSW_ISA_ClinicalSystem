package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.dto.AdminKCDTO;
import main.dto.PromenaLozinkeDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Authority;
import main.repository.AdminKCRepository;
import main.repository.AuthorityRepository;

@Service
public class AdminKCService {
	
	@Autowired
	private AdminKCRepository adminKCRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Autowired
	private AuthorityRepository authorityRepository;
	
	
	public AdministratorKlinickogCentra findOne(Long id) {
		return adminKCRepository.findById(id).orElseGet(null);
	}
	public List<AdministratorKlinickogCentra> findAll() {
		// TODO Auto-generated method stub
		return adminKCRepository.findAll();
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
			adminKlinike.setPromenjenaLozinka(true);
			//adminKlinike.setLozinka(passwordEncoder.encode(adminKCDTO.getLozinka()));
			adminKCRepository.save(adminKlinike);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}
	
	public AdminKCDTO dodajAdministratoraKC(AdminKCDTO adminKCDTO) {
		AdministratorKlinickogCentra ak = new AdministratorKlinickogCentra();
		
		Authority auth = this.authorityRepository.findByUloga("ADMIN_CENTRA");
		List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    ak.setAuthorities(auths);
		
		ak.setIme(adminKCDTO.getIme());
		ak.setPrezime(adminKCDTO.getPrezime());
		ak.setAdresa(adminKCDTO.getAdresa());
		ak.setGrad(adminKCDTO.getGrad());
		ak.setDrzava(adminKCDTO.getDrzava());
		ak.setTelefon(adminKCDTO.getTelefon());
		ak.setEmail(adminKCDTO.getEmail());
		ak.setJmbg(adminKCDTO.getJmbg());
		ak.setLozinka(passwordEncoder.encode(adminKCDTO.getLozinka()));
		ak.setPromenjenaLozinka(false);
		for (AdministratorKlinickogCentra k : adminKCRepository.findAll()) {
			if (ak.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		adminKCRepository.save(ak);
		//SendEmailTLS.main(administratorDTO.getEmail());
		AdminKCDTO administratordto =new AdminKCDTO(ak);
		//klinikaRepository.getOne(administratorDTO.getIdKlinike()).administratorKlinike.add(ak);

		return administratordto;
	}
	public void izmeniLozinku(AdminKCDTO adminKCDTO) {
		// TODO Auto-generated method stub
		AdministratorKlinickogCentra adminKlinike = adminKCRepository.findById(adminKCDTO.getId()).orElse(null);

		adminKlinike.setPromenjenaLozinka(true);
		adminKlinike.setLozinka(passwordEncoder.encode(adminKCDTO.getLozinka()));
		adminKCRepository.save(adminKlinike);
		
	}
	
	public boolean promeniLozinku(AdministratorKlinickogCentra admin, PromenaLozinkeDTO lozinka) {

		if (lozinka.getNovaLozinka().equals(lozinka.getPonovljenaLozinka())) {
			admin.setLozinka(passwordEncoder.encode(lozinka.getNovaLozinka()));
			adminKCRepository.save(admin);
			return true;
		}
		return false;
	}
}



