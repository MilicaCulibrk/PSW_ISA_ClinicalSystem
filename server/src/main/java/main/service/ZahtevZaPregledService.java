package main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.ZahtevZaOdmorDTO;
import main.dto.ZahtevZaPregledDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pregled;
import main.model.Sala;
import main.model.ZahtevZaOdmor;
import main.model.ZahtevZaPregled;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;
import main.repository.ZahtevZaPregledRepository;

@Service
public class ZahtevZaPregledService {
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private SalaRepository salaKlinikeRepository;
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregled;
	
	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	public List<ZahtevZaPregled> findAll() {
		return zahtevZaPregled.findAll();
	}
	
	public ZahtevZaPregled findOne(Long id) {
		return zahtevZaPregled.findById(id).orElseGet(null);
	}


	public void remove(Long id) {
		zahtevZaPregled.deleteById(id);
	}
	

	
public List<ZahtevZaPregled> izlistaj(Long id) {
		
		List<ZahtevZaPregled> listaZahteva = new ArrayList<ZahtevZaPregled>();

		List<ZahtevZaPregled> zahtevi = zahtevZaPregled.findAll();
		for(ZahtevZaPregled z: zahtevi) {
			if(z.getIdPacijenta().equals(id) && z.getStatus().equals("odobren") && z.getPrihvacenOdPacijenta().equals(false)) {
				System.out.println(z.getPrihvacenOdPacijenta());
				listaZahteva.add(z);
				
			}
		}
		
		
		return listaZahteva ;
	}

public void odobri(ZahtevZaPregledDTO zahtevZaPregledDTO) {
	// TODO Auto-generated method stub
	Pregled p=new Pregled();
	
			p.setCena(zahtevZaPregledDTO.getCena());
			p.setDatum(zahtevZaPregledDTO.getDatum());
			p.setIdPacijenta(zahtevZaPregledDTO.getIdPacijenta());
			p.setLekar(lekarRepository.findById(zahtevZaPregledDTO.getLekar().getId()).orElse(null));
			p.setSala(salaKlinikeRepository.getOne(zahtevZaPregledDTO.getSala().getId()));
			p.setTipPregleda(tipPregledaRepository.getOne(zahtevZaPregledDTO.getTipPregleda().getId()));
			p.setTrajanje(zahtevZaPregledDTO.getTrajanje());
			p.setVreme(zahtevZaPregledDTO.getVreme());
			p.setVrstaPregleda(zahtevZaPregledDTO.getVrstaPregleda());
			p.setZavrsen(false);
			
			pregledRepository.save(p);
			
			for (Sala s : salaKlinikeRepository.findAll()) {
				if(s.getId().equals(zahtevZaPregledDTO.getSala().getId())){
					s.getPregledi().add(p);
					salaKlinikeRepository.save(s);
				}
					
			}
			List<ZahtevZaPregled> zahtevi = zahtevZaPregled.findAll();
			for(ZahtevZaPregled z: zahtevi) {
				if(z.getId().equals(zahtevZaPregledDTO.getId())) {
					z.setPrihvacenOdPacijenta(true);
					zahtevZaPregled.save(z);
				}
			}
			
			
}


}
