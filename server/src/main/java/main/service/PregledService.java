package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.dto.PregledDTO;
import main.model.Pacijent;
import main.model.Pregled;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;

@Service
public class PregledService {
	
	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private SalaRepository salaKlinikeRepository;
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	public Pregled findOne(Long id) {
		return pregledRepository.findById(id).orElseGet(null);
	}
	
	public Pregled zakaziPregled(Long idPacijent, Pregled pregled) {
		  
		pregled.setIdPacijenta(idPacijent);
		

		pregledRepository.save(pregled);
		
		return pregled;
}

	
	public PregledDTO dodajPregled(PregledDTO pregledDTO) {
		Pregled pregled = new Pregled();
		
		
		pregled.setDatum(pregledDTO.getDatum());
		pregled.setVreme(pregledDTO.getVreme());
		pregled.setCena(pregledDTO.getCena());
		pregled.setLekar(lekarRepository.findById(pregledDTO.getLekar().getId()).orElse(null));
		pregled.setSala(salaKlinikeRepository.getOne(pregledDTO.getSala().getId()));
		pregled.setTipPregleda(tipPregledaRepository.getOne(pregledDTO.getTipPregleda().getId()));
		pregled.setTrajanje(pregledDTO.getTrajanjePregleda());
		pregled.setIdPacijenta(null);
		pregled.setZavrsen(false);
		System.out.println(pregledDTO.getTrajanjePregleda());
		pregledRepository.save(pregled);
		
		PregledDTO pregleddto = new PregledDTO(pregled);
		return pregleddto;
	}
	
	public List<Pregled> findAll() {
		return pregledRepository.findAll();
	}


}
