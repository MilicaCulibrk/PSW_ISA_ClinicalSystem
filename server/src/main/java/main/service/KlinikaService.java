package main.service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.AdminKlinikeDTO;
import main.dto.KlinikaDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.Sala;
import main.repository.KlinikaRepository;
import main.repository.LekarRepository;

@Service
public class KlinikaService {
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Autowired
	private LekarRepository	lekarRepository;
	
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
	public List<Klinika> pronadjiKlinike( String datum, String tipPregleda){
		
		//lista klinika koju vracam
		List<Klinika> ret= new ArrayList<Klinika>();
		
		List<Klinika> klinike = new ArrayList<Klinika>();
		klinike=klinikaRepository.findAll();
		
	
				if(datum == null && tipPregleda == null) {
						//vrati sve klinike
							ret = klinikaRepository.findAll();
					}
				else {
					List<Lekar> lekari  =  new ArrayList<Lekar>();
					lekari=lekarRepository.findAll();
						for(Lekar l: lekari) {
							if(l.getTipPregleda().getNaziv().equals(tipPregleda)) {
								for(Klinika k: klinike) {
									if(l.getKlinika().getId().equals(k.getId())){
										ret.add(k);
									}
								}
							}
						}
					}
			
		return ret;
		
		}
}
