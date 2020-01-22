package main.service;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.AdminKlinikeDTO;
import main.dto.KlinikaDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.repository.KlinikaRepository;

@Service
public class KlinikaService {
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	public KlinikaDTO dodajKliniku(KlinikaDTO klinikaDTO) {
		Klinika klinika = new Klinika();
		
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setGrad(klinikaDTO.getGrad());
		klinika.setDrzava(klinikaDTO.getDrzava());
		klinika.setTelefon(klinikaDTO.getTelefon());
		klinika.setEmail(klinikaDTO.getEmail());
		
		for (Klinika k : klinikaRepository.findAll()) {
			if (klinika.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		klinikaRepository.save(klinika);
		
		KlinikaDTO klinikadto=new KlinikaDTO(klinika);
		return klinikadto;
	}
	
	public Klinika findOne(Long id) {
		System.out.println("izvolte "+id);
		return klinikaRepository.findById(id).orElseGet(null);
	}


	public List<Klinika> findAll() {
		// TODO Auto-generated method stub
		return klinikaRepository.findAll();
	}
	
	public void izmeniKliniku(KlinikaDTO klinikaDTO) {
		Klinika klinika = klinikaRepository.findById(klinikaDTO.getId()).orElse(null);
		
		if(klinika == null) {
			throw new ValidationException("Admin sa zadatim id-jem ne postoji");
		}
		try {
			klinika = klinikaRepository.getOne(klinikaDTO.getId());
			klinika.setNaziv(klinikaDTO.getNaziv());
			klinika.setOpis(klinikaDTO.getOpis());
			klinika.setAdresa(klinikaDTO.getAdresa());
			klinika.setTelefon(klinikaDTO.getTelefon());
			klinika.setGrad(klinikaDTO.getGrad());
			klinika.setDrzava(klinikaDTO.getDrzava());
			klinikaRepository.save(klinika);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}
}
