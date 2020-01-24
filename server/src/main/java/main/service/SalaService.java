package main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.SalaDTO;
import main.model.AdministratorKlinike;
import main.model.Sala;
import main.repository.AdminKlinikeRepository;
import main.repository.KlinikaRepository;
import main.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	
	
	@Autowired
	private KlinikaService klinikaService;
	
	
	public List<Sala> findAll() {
		return salaRepository.findAll();
	}
	

	public Sala findOne(Long id) {
		return salaRepository.findById(id).orElseGet(null);
	}
	
	public SalaDTO dodajSaluKlinike(SalaDTO salaKlinikeDTO, Long id) {
		Sala sala = new Sala();
		
		sala.setNaziv(salaKlinikeDTO.getNaziv());
		sala.setBroj(salaKlinikeDTO.getBroj());
		
		AdministratorKlinike admin = adminKlinikeRepository.findById(id).orElse(null);
		sala.setKlinika(admin.getKlinika());
		
		
		salaRepository.save(sala);
		
		SalaDTO salaDTO = new SalaDTO(sala);
		return salaDTO;
	}
	
	public void izmeniSalu(SalaDTO salaDTO) {
		
		Sala sala = salaRepository.findById(salaDTO.getId()).orElse(null);
		
		if(sala == null) {
			throw new ValidationException("Sala sa zadatim id-jem ne postoji");
		}
		try {
			sala = salaRepository.getOne(salaDTO.getId());
			sala.setNaziv(salaDTO.getNaziv());
			sala.setBroj(salaDTO.getBroj());
			salaRepository.save(sala);
		
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Sala sa tim idijem nepostoji");
		}
	}
	
	public void remove(Long id) {
		salaRepository.deleteById(id);
	}
	
}
