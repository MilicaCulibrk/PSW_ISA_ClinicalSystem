package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pacijent;
import main.repository.AdminCentraRepository;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.MedicinskaSestraRepository;
import main.repository.PacijentRepository;

@Service
public class LoginService {
	
	@Autowired
	private PacijentRepository pacijentRepository;

	@Autowired
	private MedicinskaSestraRepository medicinskaSestraRepository;
	
	@Autowired
	private LekarRepository lekarRepository;

	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;

	@Autowired
	private AdminCentraRepository adminCentraRepository;

	public Pacijent findPacijent(String mail) {
		return pacijentRepository.findByEmail(mail);
	}

	public MedicinskaSestra findMedicinskaSestra(String mail) {
		return medicinskaSestraRepository.findByEmail(mail);
	}
	
	public Lekar findLekar(String mail) {
		return lekarRepository.findByEmail(mail);
	}

	public AdministratorKlinike findAdminKlinike(String mail) {
		return adminKlinikeRepository.findByEmail(mail);
	}

	public AdministratorKlinickogCentra findAdminCentra(String mail) {
		return adminCentraRepository.findByEmail(mail);
	}

	
	

}
