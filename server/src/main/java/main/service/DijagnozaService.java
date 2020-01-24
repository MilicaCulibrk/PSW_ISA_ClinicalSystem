package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.DijagnozaDTO;
import main.dto.LekDTO;
import main.model.Dijagnoza;
import main.model.Lek;
import main.repository.DijagnozaRepository;

@Service
public class DijagnozaService {
	@Autowired
	private DijagnozaRepository dijagnozaRepository;

	public List<Dijagnoza> findAll() {
		// TODO Auto-generated method stub
		return dijagnozaRepository.findAll();
	}

	public DijagnozaDTO dodajDijagnozu(DijagnozaDTO dijagnozaDTO) {
		// TODO Auto-generated method stub
		Dijagnoza dijagnoza = new Dijagnoza();
		
		dijagnoza.setNaziv(dijagnozaDTO.getNaziv());
		dijagnoza.setSifra(dijagnozaDTO.getSifra());
		
		for (Dijagnoza l : dijagnozaRepository.findAll()) {
			if (dijagnoza.getSifra().equals(l.getSifra())) {
				return null;
			}
		}
		dijagnozaRepository.save(dijagnoza);
		
		DijagnozaDTO dijagnozadto=new DijagnozaDTO(dijagnoza);
		return dijagnozadto;
	}
}
