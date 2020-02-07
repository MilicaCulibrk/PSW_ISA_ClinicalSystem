package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PregledDTO;
import main.dto.ZahtevZaPregledDTO;
import main.model.AdministratorKlinike;
import main.model.Pregled;
import main.model.Sala;
import main.model.ZahtevZaPregled;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;
import main.repository.ZahtevZaPregledRepository;

@Service
public class PregledService {
	
	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private SalaRepository salaKlinikeRepository;
	
	@Autowired
	private TipPregledaRepository tipPregledaRepository;
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	
	public Pregled findOne(Long id) {
		return pregledRepository.findById(id).orElseGet(null);
	}
	
	public Pregled zakaziPregled(Long idPacijent, Pregled pregled) {
		  
		pregled.setIdPacijenta(idPacijent);
		pregled.getLekar().getPregled().add(pregled);

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
		pregled.setVrstaPregleda("pregled");
		System.out.println(pregledDTO.getTrajanjePregleda());
		pregledRepository.save(pregled);
		for (Sala s : salaKlinikeRepository.findAll()) {
			if(s.getId().equals(pregledDTO.getSala().getId())){
				s.getPregledi().add(pregled);
				salaKlinikeRepository.save(s);
			}
				
		}
		PregledDTO pregleddto = new PregledDTO(pregled);
		return pregleddto;
	}
	
	public List<Pregled> findAll() {
		return pregledRepository.findAll();
	}
	
	public void dodajZahtev(ZahtevZaPregledDTO zahtevZaPregledDTO, AdministratorKlinike admin) {

	
		ZahtevZaPregled zahtevZaPregled = new ZahtevZaPregled();

		zahtevZaPregled.setLekar(lekarRepository.findById(zahtevZaPregledDTO.getLekar().getId()).orElse(null));
		zahtevZaPregled.setIdPacijenta(zahtevZaPregledDTO.getIdPacijenta());
		zahtevZaPregled.setCena(zahtevZaPregledDTO.getCena());
		zahtevZaPregled.setDatum(zahtevZaPregledDTO.getDatum());
		zahtevZaPregled.setVreme(zahtevZaPregledDTO.getVreme());
		zahtevZaPregled.setTrajanje(zahtevZaPregledDTO.getTrajanje());
		zahtevZaPregled.setVrstaPregleda(zahtevZaPregledDTO.getVrstaPregleda());
		zahtevZaPregled.setTipPregleda(tipPregledaRepository.findById(zahtevZaPregledDTO.getTipPregleda().getId()).orElse(null));
		zahtevZaPregled.setVrstaPregleda("pregled");

		
		zahtevZaPregledRepository.save(zahtevZaPregled);
		
		admin.getZahtevZaPregled().add(zahtevZaPregled);
		adminKlinikeRepository.save(admin);
		
}


}
