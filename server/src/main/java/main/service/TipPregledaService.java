package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.TipPregledaDTO;
import main.model.AdministratorKlinike;
import main.model.TipPregleda;
import main.model.TipPregleda;
import main.repository.AdminKlinikeRepository;
import main.repository.TipPregledaRepository;

@Service
public class TipPregledaService {
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	

	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	
	public TipPregleda findOne(Long id) {
		return tipPregledaRepository.findById(id).orElse(null);
	}
	
	public List<TipPregleda> findAll() {
		return tipPregledaRepository.findAll();
	}
	
	public TipPregledaDTO dodajTipPregleda(TipPregledaDTO tipPregledaDTO,Long id) {
		
		TipPregleda tipPregleda = new TipPregleda();
		
		AdministratorKlinike admin = adminKlinikeRepository.findById(id).orElse(null);
		
		tipPregleda.setNaziv(tipPregledaDTO.getNaziv());
		tipPregleda.setOznaka(tipPregledaDTO.getOznaka());
		tipPregleda.setCena(tipPregledaDTO.getCena());
		tipPregleda.setKlinika(admin.getKlinika());
		tipPregledaRepository.save(tipPregleda);
		
		TipPregledaDTO tipDTO=new TipPregledaDTO(tipPregleda);
		return tipDTO;
	}
	
	public void izmeniTipPregleda(TipPregledaDTO tipPregledaDTO) {
		TipPregleda tipPregleda = tipPregledaRepository.findById(tipPregledaDTO.getId()).orElse(null);
		
		if(tipPregleda == null) {
			throw new ValidationException("Tip pregleda sa zadatim id-jem nepostoji");
		}
		try {
			tipPregleda = tipPregledaRepository.getOne(tipPregledaDTO.getId());
			tipPregleda.setNaziv(tipPregledaDTO.getNaziv());
			tipPregleda.setOznaka(tipPregledaDTO.getOznaka());
			tipPregleda.setCena(tipPregledaDTO.getCena());
			tipPregledaRepository.save(tipPregleda);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Tip pregleda sa tim idijem nepostoji");
		}
	}
	

	public void remove(Long id) {
		tipPregledaRepository.deleteById(id);
	}
	
public List<TipPregleda> pronadjiPreglede( String naziv, String oznaka, String cena){
		
		//lista pregleda koju vracam
		List<TipPregleda> ret = new ArrayList<TipPregleda>();
		
		List<TipPregleda> sviPregledi = tipPregledaRepository.findAll();
		
	
		if(naziv == null && oznaka == null && cena == null) {
			ret = sviPregledi;
		}else if(naziv == null && oznaka == null && cena != null){
			for(TipPregleda p : sviPregledi) {
				if(p.getCena().contains(cena)) {
					ret.add(p);
				}
			}
		}else if(naziv == null && oznaka != null && cena == null){
			for(TipPregleda p : sviPregledi) {
				if(p.getOznaka().contains(oznaka)) {
					ret.add(p);
				}
			}
		}else if(naziv != null && oznaka == null && cena == null){
			for(TipPregleda p : sviPregledi) {
				if(p.getNaziv().contains(naziv)) {
					ret.add(p);
				}
			}
		}else if(naziv != null && oznaka != null && cena == null){
			for(TipPregleda p : sviPregledi) {
				if(p.getNaziv().contains(naziv) && p.getOznaka().contains(oznaka)) {
					ret.add(p);
				}
			}
		}else if(naziv != null && oznaka == null && cena != null){
			for(TipPregleda p : sviPregledi) {
				if(p.getNaziv().contains(naziv) && p.getCena().contains(cena)) {
					ret.add(p);
				}
			}
		}else if(naziv == null && oznaka != null && cena != null){
			for(TipPregleda p : sviPregledi) {
				if(p.getOznaka().contains(oznaka) && p.getCena().contains(cena)) {
					ret.add(p);
				}
			}
		}else if(naziv != null && oznaka != null && cena != null){
			for(TipPregleda p : sviPregledi) {
				if(p.getOznaka().contains(oznaka) && p.getCena().contains(cena)  && p.getNaziv().contains(naziv)) {
					ret.add(p);
				}
			}
		}
		
	
		return ret;
		}
	

}
