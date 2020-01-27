package main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.KlinikaDTO;
import main.dto.PacijentDTO;
import main.dto.ZdravstveniKartonDTO;
import main.model.Klinika;
import main.model.Pacijent;
import main.model.ZdravstveniKarton;
import main.repository.ZdravstveniKartonRepository;

@Service
public class ZdravstveniKartonService {
	@Autowired
	private ZdravstveniKartonRepository zdravstveniKartonRepository;
	
	public ZdravstveniKartonDTO dodajZdravstveniKarton(ZdravstveniKartonDTO zdravstveniKartonDTO) {
		ZdravstveniKarton zdravstveniKarton = new ZdravstveniKarton();
		
		zdravstveniKarton.setId(zdravstveniKartonDTO.getId());
		zdravstveniKarton.setDioptrija(zdravstveniKartonDTO.getDioptrija());
		zdravstveniKarton.setAlergije(zdravstveniKartonDTO.getAlergije());
		zdravstveniKarton.setVisina(zdravstveniKartonDTO.getVisina());
		zdravstveniKarton.setTezina(zdravstveniKartonDTO.getTezina());
		
		zdravstveniKartonRepository.save(zdravstveniKarton);
		
		ZdravstveniKartonDTO zdravstveniKartondto=new ZdravstveniKartonDTO(zdravstveniKarton);
		return zdravstveniKartondto;
	}
	
	public ZdravstveniKarton findOne(Long id) {
		return zdravstveniKartonRepository.findById(id).orElseGet(null);
	}
	public List<ZdravstveniKarton> findAll() {
		// TODO Auto-generated method stub
		return zdravstveniKartonRepository.findAll();
	}
	
	public void izmeniZdravstveniKarton(ZdravstveniKartonDTO zdravstveniKartonDTO) {

		ZdravstveniKarton zdravstveniKarton = zdravstveniKartonRepository.findById(zdravstveniKartonDTO.getId()).orElse(null);
		
		if(zdravstveniKarton == null) {
			throw new ValidationException("Zdravstveni karton sa zadatim id-jem ne postoji");
		}
		try {
			zdravstveniKarton = zdravstveniKartonRepository.getOne(zdravstveniKartonDTO.getId());
			zdravstveniKarton.setId(zdravstveniKartonDTO.getId());
			zdravstveniKarton.setDioptrija(zdravstveniKartonDTO.getDioptrija());
			zdravstveniKarton.setAlergije(zdravstveniKartonDTO.getAlergije());
			zdravstveniKarton.setVisina(zdravstveniKartonDTO.getVisina());
			zdravstveniKarton.setTezina(zdravstveniKartonDTO.getTezina());
			zdravstveniKartonRepository.save(zdravstveniKarton);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Zdravstveni Karton sa tim id-ijem ne postoji");
		}
	}
	
	
}
