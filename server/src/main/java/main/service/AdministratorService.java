package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.SendEmailTLS;
import main.dto.AdministratorDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.repository.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	
	public AdministratorDTO dodajAdministratora(AdministratorDTO administratorDTO) {
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
		for (AdministratorKlinike k : administratorRepository.findAll()) {
			if (klinika.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		administratorRepository.save(klinika);
		SendEmailTLS.main(administratorDTO.getEmail());
		AdministratorDTO administratordto =new AdministratorDTO(klinika);
		return administratordto;
	}
}
