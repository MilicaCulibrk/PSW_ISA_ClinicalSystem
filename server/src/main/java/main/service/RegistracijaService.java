package main.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.dto.RegistracijaDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.Pacijent;
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



	
	public void register(PacijentDTO pacijentDTO) {
		
		Pacijent pacijent = new Pacijent();
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
