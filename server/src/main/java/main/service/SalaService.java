package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.SalaDTO;
import main.model.AdministratorKlinike;
import main.model.Pregled;
import main.model.Sala;
import main.repository.AdminKlinikeRepository;
import main.repository.KlinikaRepository;
import main.repository.PregledRepository;
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
	private PregledRepository pregledRepository;
	
	
	
	
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
	
	public List<Sala> pronadjiSale(Long klinika_id, String naziv, Integer broj, String datum, String vreme){
		System.out.println("heeejj -> " + datum +" ii  "+ vreme);
		//lista slobodnoh sala koju vracam
		List<Sala> ret= new ArrayList<Sala>();
		
		List<Pregled> pregledi = new ArrayList<Pregled>();
		pregledi = pregledRepository.findAll();
		
		
		if(vreme == null && datum == null) {
				if(naziv == null) {
						if(broj == null) {
						//vrati sve iz te klinike
							ret = salaRepository.pronadjiSalePoIdKlinike(klinika_id);
					    }else {
						//samo po broju
					    	ret = salaRepository.pronadjiSaluPoBrojuiIDKlinike(broj, klinika_id);
					    }
				}else {
					if(broj == null) {
						// samo po nazivu
						ret = salaRepository.pronadjiSaluPoNazivuiIDKlinike(naziv, klinika_id);
					}else {
						//po nazivu i po broji
						ret = salaRepository.pronadjiSaluPoNazivuiBrojuiIdKlinike(naziv,broj, klinika_id);
					}
				}
		}else {
			
		
			Integer vremePocetak =  Integer.parseInt(vreme);
		
			
			if(naziv == null) {
				if(broj == null) {
				
					//samo po datumu i vremenu
					List<Sala> sale =  salaRepository.pronadjiSalePoIdKlinike(klinika_id);
					
					for(Sala s : sale) {
						boolean imaSlobodanPregled = true;
						
					
						for(Pregled p: pregledi) {
							System.out.println(p.getDatum() + "pregeld i novi datum "+datum);
							if(s.getId() == p.getSala().getId() && p.getDatum().equals(datum)) {
							
								
								double pregledPocetak =  Double.parseDouble(p.getVreme());
								
			
								//pregled ne sme da pocne u terminu drugog pregleda
									if(vremePocetak >= pregledPocetak && vremePocetak <= (pregledPocetak + p.getTrajanje())) {
										imaSlobodanPregled=false;
										break;
								}
							}
						}
						//dodaj salu ako postoji slobodan termin za pregled
						if(imaSlobodanPregled) {
							ret.add(s);
						}
						
					}
				}else {
				
					//po datumu i broju
					List<Sala> sale = salaRepository.pronadjiSaluPoBrojuiIDKlinike(broj, klinika_id);
					
					for(Sala s : sale) {
						boolean imaSlobodanPregled = true;
			
						
					
						for(Pregled p: pregledi) {
							if(s.getId() == p.getSala().getId() &&  p.getDatum().equals(datum)) {
								
								
						
								double pregledPocetak =  Double.parseDouble(p.getVreme());
			
								//pregled ne sme da pocne u terminu drugog pregleda
									if(vremePocetak >= pregledPocetak && vremePocetak <= (pregledPocetak + p.getTrajanje())) {
										imaSlobodanPregled=false;
										break;
								}
							}
						}
						if(imaSlobodanPregled) {
							ret.add(s);
						}
			
					}
				}
		}else {

			if(broj == null) {
				// po nazivu i datumu
				List<Sala> sale = salaRepository.pronadjiSaluPoNazivuiIDKlinike(naziv, klinika_id);
				for(Sala s : sale) {
					boolean imaSlobodanPregled = true;
					

					
					for(Pregled p: pregledi) {
						if(s.getId() == p.getSala().getId() &&p.getDatum().equals(datum) ) {
							if(p.getTrajanje() == null)
								continue;
							
							double pregledPocetak =  Double.parseDouble(p.getVreme());
		
							//pregled ne sme da pocne u terminu drugog pregleda
								if(vremePocetak >= pregledPocetak && vremePocetak <= (pregledPocetak + p.getTrajanje())) {
									imaSlobodanPregled=false;
									break;
							}
						}
					}
					if(imaSlobodanPregled) {
						ret.add(s);
					}
			}
		}else {
			//po po nazivu,datumu i broju
			List<Sala> sale = salaRepository.pronadjiSaluPoNazivuiBrojuiIdKlinike(naziv,broj, klinika_id);
			for(Sala s : sale) {
				boolean imaSlobodanPregled = true;
			

								
				for(Pregled p: pregledi) {
					if(s.getId() == p.getSala().getId() && p.getDatum().equals(datum)) {
						if(p.getTrajanje() == null)
							continue;
						
						double pregledPocetak =  Double.parseDouble(p.getVreme());
	
						//pregled ne sme da pocne u terminu drugog pregleda
							if(vremePocetak >= pregledPocetak && vremePocetak <= (pregledPocetak + p.getTrajanje())) {
								imaSlobodanPregled=false;
								break;
						}
					}
				}
				if(imaSlobodanPregled) {
					ret.add(s);
				}
			}
		}

		}
		
		}
		return ret;
		}
}
