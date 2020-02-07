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
		private ZahtevZaRegRepository zahtevZaRegRepository;
		
		@Autowired
		private ZdravstveniKartonRepository zdravstveniKartonRepository;
		
		@Autowired
		private AdminKCService adminKCService;
		

		@Autowired
		private AuthorityRepository authorityRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;




	
	public PacijentDTO register(PacijentDTO pacijentDTO, Long zahtevId) {
		
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
		
		pacijent.setZdravstveniKarton(null);
		
		for (ZahtevZaRegistraciju zzr : zahtevZaRegRepository.findAll()) {
			if(zzr.getId().equals(zahtevId)) {
				zzr.setStatus("PRIHVACEN");
				zahtevZaRegRepository.save(zzr);
			}
		}
		
		this.pacijentRepository.save(pacijent);
		
		PacijentDTO pacdto = new PacijentDTO(pacijent);
		return pacdto;
	}





	public void odbijen(Long zahtevId) {
		// TODO Auto-generated method stub
		for (ZahtevZaRegistraciju zzr : zahtevZaRegRepository.findAll()) {
			if(zzr.getId().equals(zahtevId)) {
				zzr.setStatus("ODBIJEN");
				zahtevZaRegRepository.save(zzr);
			}
		}
	}





	public boolean napraviZK(PacijentDTO korisnik) {
		// TODO Auto-generated method stub
		System.out.println("ovoa saljemo kada pravimo zk" + korisnik.getId());
		Pacijent pacijent = new Pacijent();
		ZdravstveniKarton zk = new ZdravstveniKarton();
		zk.setAlergije("");
		zk.setDioptrija("");
		zk.setTezina("");
		zk.setVisina("");

		for (Pacijent p : pacijentRepository.findAll()) {
			if(p.getEmail().equals(korisnik.getEmail())) {
				System.out.println("ovo je zk " + p.getZdravstveniKarton());
				if(p.getZdravstveniKarton()==null) {
					pacijent = p;
					zk.setPacijent(p);
					zdravstveniKartonRepository.save(zk);
					p.setZdravstveniKarton(zk);
					pacijentRepository.save(p);
				}else {
					return false;
				}
			}
		}
		PacijentDTO pacijentDTO = new PacijentDTO(pacijent);
		return true;
	}
	

}
