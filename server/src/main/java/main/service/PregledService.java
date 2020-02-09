package main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PregledDTO;
import main.dto.ZahtevZaPregledDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
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
	
	//@Autowired
	private final PregledRepository pregledRepository;
	
	//@Autowired
	private final ZahtevZaPregledRepository zahtevZaPregledRepository;
	
	
	//@Autowired
	private final LekarRepository lekarRepository;
	
	//@Autowired
	private final SalaRepository salaKlinikeRepository;
	
	//@Autowired
	private final TipPregledaRepository tipPregledaRepository;
	
	//@Autowired
	private final AdminKlinikeRepository adminKlinikeRepository;
	
	


	public PregledService(PregledRepository pregledRepository, ZahtevZaPregledRepository zahtevZaPregledRepository,
			LekarRepository lekarRepository, SalaRepository salaKlinikeRepository,
			TipPregledaRepository tipPregledaRepository, AdminKlinikeRepository adminKlinikeRepository) {
		super();
		this.pregledRepository = pregledRepository;
		this.zahtevZaPregledRepository = zahtevZaPregledRepository;
		this.lekarRepository = lekarRepository;
		this.salaKlinikeRepository = salaKlinikeRepository;
		this.tipPregledaRepository = tipPregledaRepository;
		this.adminKlinikeRepository = adminKlinikeRepository;
	}

	public Pregled findOne(Long id) {
		return pregledRepository.findById(id).orElseGet(null);
	}
	
	//pacijent bira unapred definisani pregeld i zakazuje ga
	public Pregled zakaziPregled(Long idPacijent, Pregled pregled) {
		  
		pregled.setIdPacijenta(idPacijent);
		pregled.getLekar().getPregled().add(pregled);

		pregledRepository.save(pregled);
		
		return pregled;
}

	//dodaj predefinisani pregled kao administrator klinike sa ogranicenjima
	public void dodajPregled(PregledDTO pregledDTO) {
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
		pregledRepository.save(pregled);
		for (Sala s : salaKlinikeRepository.findAll()) {
			if(s.getId().equals(pregledDTO.getSala().getId())){
				s.getPregledi().add(pregled);
				salaKlinikeRepository.save(s);
			}
				
		}
	}
	
	public List<Pregled> findAll() {
		return pregledRepository.findAll();
	}
	
	  //lekar u toku trenuntog pregleda zakazuje naredni
	  //pacijent bira argumente za pregled i salje se adminu da odobri
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
		zahtevZaPregled.setVrstaPregleda(zahtevZaPregledDTO.getVrstaPregleda());
		zahtevZaPregled.setStatus("na_cekanju");
		zahtevZaPregled.setPrihvacenOdPacijenta(false);


		
		zahtevZaPregledRepository.save(zahtevZaPregled);
		
		Collection<ZahtevZaPregled> zahtevi = new ArrayList<ZahtevZaPregled>();
		zahtevi=admin.getZahtevZaPregled();

		zahtevi.add(zahtevZaPregled);
		adminKlinikeRepository.save(admin);
		
}
	public List<Pregled> sortirajPreglede(String sortBy) {
		if(sortBy.equals("Tip Pregleda"))
			return pregledRepository.findAllByOrderByTipPregledaAsc();
		else if(sortBy.equals("Datum"))
			return pregledRepository.findAllByOrderByDatumAsc();
		return pregledRepository.findAll();
	}

	public List<Pregled> sortirajOperacije(String sortBy) {
		if(sortBy.equals("Tip Pregleda"))
			return pregledRepository.findAllByOrderByTipPregledaAsc();
		else if(sortBy.equals("Datum"))
			return pregledRepository.findAllByOrderByDatumAsc();
		return pregledRepository.findAll();
	}


}
