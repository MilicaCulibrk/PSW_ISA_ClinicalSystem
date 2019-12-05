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
import main.repository.PacijentRepository;
//import main.repository.PacijentRepository;
import main.repository.ZahtevZaRegRepository;

@Service
public class RegistracijaService {
	
	 @Autowired
	 private PacijentService pacijentService;
	 

		@Autowired
		private PacijentRepository pacijentRepository;
		
		@Autowired
		private AdminKCService adminKCService;



	
	public void register(PacijentDTO pacijentDTO) {
		
		Pacijent pacijent = new Pacijent();
		Pacijent pacijentPostoji = pacijentRepository.findByEmail(pacijentDTO.getEmail());

		
	    if (pacijentPostoji != null) {
			throw new ValidationException("Postoji korisnik sa datim Mailom");
		} else {
			try {
				pacijent.setEmail(pacijentDTO.getEmail());
				pacijent.setLozinka(pacijentDTO.getLozinka());
				pacijent.setIme(pacijentDTO.getIme());
				pacijent.setPrezime(pacijentDTO.getPrezime());
				pacijent.setAdresa(pacijentDTO.getAdresa());
				pacijent.setGrad(pacijentDTO.getGrad());
				pacijent.setDrzava(pacijentDTO.getDrzava());
				pacijent.setTelefon(pacijentDTO.getTelefon());
				pacijent.setJmbg(pacijentDTO.getJmbg());
				pacijentRepository.save(pacijent);
			} catch (EntityNotFoundException e) {
				throw new ValidationException("Doslo je do greske");
			}
		}

	} 
	

	

}
