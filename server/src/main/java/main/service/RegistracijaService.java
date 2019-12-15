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


import main.repository.AuthorityRepository;

import main.model.ZahtevZaRegistraciju;
import main.model.ZdravstveniKarton;
import main.repository.PacijentRepository;
//import main.repository.PacijentRepository;
import main.repository.ZahtevZaRegRepository;
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
		
		ZdravstveniKarton zk = new ZdravstveniKarton();
		zk.setAlergije("ambrozija");
		zk.setDioptrija("-1.5");
		zk.setTezina("70");
		zk.setVisina("180");
		zdravstveniKartonRepository.save(zk);
		pacijent.setZdravstveniKarton(zk);
		zk.setPacijent(pacijent);
		
		this.pacijentRepository.save(pacijent);
		


	}
	

}
