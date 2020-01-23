package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.TipPregleda;
import main.repository.TipPregledaRepository;

@Service
public class TipPregledaService {
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	public TipPregleda findOne(Long id) {
		return tipPregledaRepository.findById(id).orElse(null);
	}
	
	public List<TipPregleda> findAll() {
		return tipPregledaRepository.findAll();
	}

}
