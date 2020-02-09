package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.dto.LekarDTO;
import main.dto.MedicinskaSestraDTO;
import main.dto.PromenaLozinkeDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.Authority;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.repository.AuthorityRepository;
import main.repository.KlinikaRepository;
import main.repository.MedicinskaSestraRepository;

@Service
public class MedicinskaSestraService {
	@Autowired
	private MedicinskaSestraRepository msr;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private KlinikaRepository klinikaRepository;
	

	@Autowired
	private MedicinskaSestraRepository mssRepository;
	
	public MedicinskaSestra findOne(Long id) {
		return msr.findById(id).orElseGet(null);
	}
	
	public MedicinskaSestra findOneEmail(String email) {
		return msr.findByEmail(email);
	}
	
	public void izmeniMedicinskuSestru(MedicinskaSestraDTO msdto) {
		MedicinskaSestra ms = msr.findById(msdto.getId()).orElse(null);
		
		if(ms == null) {
			throw new ValidationException("Admin sa zadatim id-jem ne postoji");
		}
		try {
			ms = msr.getOne(msdto.getId());
			ms.setIme(msdto.getIme());
			ms.setPrezime(msdto.getPrezime());
			ms.setAdresa(msdto.getAdresa());
			ms.setTelefon(msdto.getTelefon());
			ms.setGrad(msdto.getGrad());
			ms.setDrzava(msdto.getDrzava());
			ms.setPromenjenaLozinka(true);
			//ms.setLozinka(passwordEncoder.encode(msdto.getLozinka()));			
			msr.save(ms);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}

	public void izmeniLozinku(MedicinskaSestraDTO msdto) {
		MedicinskaSestra ms = msr.findById(msdto.getId()).orElse(null);

		ms.setPromenjenaLozinka(true);
		ms.setLozinka(passwordEncoder.encode(msdto.getLozinka()));
		msr.save(ms);
		
	}

	public MedicinskaSestraDTO dodajLekara(MedicinskaSestraDTO msDTO) {
		// TODO Auto-generated method stub
		MedicinskaSestra l = new MedicinskaSestra();
		
		Authority auth = this.authorityRepository.findByUloga("MEDICINSKA_SESTRA");
		List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    l.setAuthorities(auths);
	
		l.setIme(msDTO.getIme());
		l.setPrezime(msDTO.getPrezime());
		l.setAdresa(msDTO.getAdresa());
		l.setGrad(msDTO.getGrad());
		l.setDrzava(msDTO.getDrzava());
		l.setTelefon(msDTO.getTelefon());
		l.setEmail(msDTO.getEmail());
		l.setJmbg(msDTO.getJmbg());
		l.setLozinka(passwordEncoder.encode(msDTO.getLozinka()));
		l.setKlinika(klinikaRepository.getOne(msDTO.getIdKlinike()));
		l.setPromenjenaLozinka(false);
		msDTO.setPromenjenaLozinka(false);
		for (MedicinskaSestra ms : msr.findAll()) {
			if (l.getEmail().equals(ms.getEmail())) {
				return null;
			}
		}
		msr.save(l);
		//SendEmailTLS.main(lekarDTO.getEmail());
		MedicinskaSestraDTO msdto =new MedicinskaSestraDTO(l);
		return msdto;
	}


	public List<MedicinskaSestra> findAll() {
		// TODO Auto-generated method stub
		return msr.findAll();
	}


	public void remove(Long id) {
		msr.deleteById(id);
		
	}

	public boolean promeniLozinku(MedicinskaSestra admin, PromenaLozinkeDTO lozinka) {

		if (lozinka.getNovaLozinka().equals(lozinka.getPonovljenaLozinka())) {
			admin.setLozinka(passwordEncoder.encode(lozinka.getNovaLozinka()));
			mssRepository.save(admin);
			return true;
		}
		return false;
	}

}
