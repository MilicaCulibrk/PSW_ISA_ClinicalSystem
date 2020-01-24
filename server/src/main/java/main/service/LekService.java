package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.KlinikaDTO;
import main.dto.LekDTO;
import main.model.Klinika;
import main.model.Lek;
import main.repository.LekRepository;

@Service
public class LekService {
	@Autowired
	private LekRepository lekRepository;

	public List<Lek> findAll() {
		// TODO Auto-generated method stub
		return lekRepository.findAll();
	}

	public LekDTO dodajLek(LekDTO lekDTO) {
		// TODO Auto-generated method stub
		Lek lek = new Lek();
		
		lek.setNaziv(lekDTO.getNaziv());
		lek.setSifra(lekDTO.getSifra());
		
		for (Lek l : lekRepository.findAll()) {
			if (lek.getSifra().equals(l.getSifra())) {
				return null;
			}
		}
		lekRepository.save(lek);
		
		LekDTO lekdto=new LekDTO(lek);
		return lekdto;
	}

	public Lek findOne(Long id) {
		// TODO Auto-generated method stub
		return lekRepository.findById(id).orElseGet(null);
	}

	public void remove(Long id) {
		// TODO Auto-generated method stub
		lekRepository.deleteById(id);

	}
}
