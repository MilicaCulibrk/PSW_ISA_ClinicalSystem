package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.model.Authority;
import main.model.Pacijent;
import main.model.ZdravstveniKarton;
import main.repository.AuthorityRepository;
import main.repository.PacijentRepository;
import main.repository.ZdravstveniKartonRepository;


@Service
public class RegistracijaService {
	
	 @Autowired
	 private PacijentService pacijentService;
	 

		@Autowired
		private PacijentRepository pacijentRepository;
		
		@Autowired
		private ZdravstveniKartonRepository zdravstveniKartonRepository;
		
		@Autowired
		private AdminKCService adminKCService;
		

		@Autowired
		private AuthorityRepository authorityRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;




	
	public void register(PacijentDTO pacijentDTO) {
		
		Pacijent pacijent = new Pacijent();

		
		Authority auth = this.authorityRepository.findByUloga("PACIJENT");
		List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
		
		pacijent.setAdresa(pacijentDTO.getAdresa());
	    pacijent.setAuthorities(auths);
		pacijent.setTelefon(pacijentDTO.getTelefon());
		pacijent.setDrzava(pacijentDTO.getDrzava());
		pacijent.setGrad(pacijentDTO.getGrad());
		pacijent.setIme(pacijentDTO.getIme());
		pacijent.setEmail(pacijentDTO.getEmail());
		pacijent.setPrezime(pacijentDTO.getPrezime());
		pacijent.setJmbg(pacijentDTO.getJmbg());
		pacijent.setLozinka(passwordEncoder.encode(pacijentDTO.getLozinka()));
		
		this.pacijentRepository.save(pacijent);
		

		Pacijent pacijentPostoji = pacijentRepository.findByEmail(pacijentDTO.getEmail());
		ZdravstveniKarton zk = new ZdravstveniKarton();
		
	    if (pacijentPostoji != null) {
			throw new ValidationException("Postoji korisnik sa datim Mailom");
		} else {
			try {
				zk.setAlergije("");
				zk.setDioptrija("");
				zk.setTezina("");
				zk.setVisina("");
				zdravstveniKartonRepository.save(zk);
				pacijent.setEmail(pacijentDTO.getEmail());
				pacijent.setLozinka(pacijentDTO.getLozinka());
				pacijent.setIme(pacijentDTO.getIme());
				pacijent.setPrezime(pacijentDTO.getPrezime());
				pacijent.setAdresa(pacijentDTO.getAdresa());
				pacijent.setGrad(pacijentDTO.getGrad());
				pacijent.setDrzava(pacijentDTO.getDrzava());
				pacijent.setTelefon(pacijentDTO.getTelefon());
				pacijent.setJmbg(pacijentDTO.getJmbg());
				pacijent.setZdravstveniKarton(zk);
				pacijentRepository.save(pacijent);
				zk.setPacijent(pacijent);
			} catch (EntityNotFoundException e) {
				throw new ValidationException("Doslo je do greske");
			}
		}

	}
	

}
