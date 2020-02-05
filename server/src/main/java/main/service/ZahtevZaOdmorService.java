package main.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.ZahtevZaOdmorDTO;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pregled;
import main.model.ZahtevZaOdmor;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.MedicinskaSestraRepository;
import main.repository.PregledRepository;
import main.repository.ZahtevZaOdmorRepository;

@Service
public class ZahtevZaOdmorService {

	@Autowired
	private ZahtevZaOdmorRepository zahtevZaOdmorRepository;
	
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private MedicinskaSestraRepository medicinskaSestraRepository;
	
	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;
	@Autowired
	private PregledRepository pregledRepository;

	public ZahtevZaOdmorDTO zatrazi(ZahtevZaOdmorDTO zahtevZaOdmorDTO) throws ParseException {
		// TODO Auto-generated method stub
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		zzo.setStartDate(zahtevZaOdmorDTO.getStart());
		zzo.setEndDate(zahtevZaOdmorDTO.getEnd());
		List<Lekar> lekari = lekarRepository.findAll();
		List<MedicinskaSestra> ms = medicinskaSestraRepository.findAll();
		List<AdministratorKlinike> admini = adminKlinikeRepository.findAll();
		Collection<Pregled> pregledi = pregledRepository.findAll();
		Long idKlinike = null;
		for (MedicinskaSestra medicinskaSestra : ms) {
			if(medicinskaSestra.getId().equals(zahtevZaOdmorDTO.getMedicinskaSestra())) {
				zzo.setMedicinskaSestra(medicinskaSestra);
				idKlinike = medicinskaSestra.getKlinika().getId();
			}
		}
		
		for (Lekar l : lekari) {
			if(l.getId().equals(zahtevZaOdmorDTO.getLekar())) {
				pregledi = l.getPregled();
				zzo.setLekar(l);
				idKlinike = l.getKlinika().getId();
			}
		}
		
		for (AdministratorKlinike ak : admini) {
			if(ak.getKlinika().getId().equals(idKlinike)) {
				ak.getZahtevZaOdmor().add(zzo);
			}
		}
		
		zzo.setOdobren(null);
		
		String[] startS=zahtevZaOdmorDTO.getStart().split("'");
		String[] endS=zahtevZaOdmorDTO.getEnd().split("'");

		SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date start = inFormat.parse(startS[0]);
		Date end = inFormat.parse(endS[0]);	

		for (Pregled pregled : pregledi) {
			Date pregledDatum = inFormat.parse(pregled.getDatum());
			if(pregledDatum.after(start)&& pregledDatum.before(end)) {
				return null;
			}
		}
		zahtevZaOdmorRepository.save(zzo);
		ZahtevZaOdmorDTO zahtevZaOdmorDTO1 =new ZahtevZaOdmorDTO(zzo);
		return zahtevZaOdmorDTO1;
	}

	public List<ZahtevZaOdmor> findAll() {
		// TODO Auto-generated method stub
		return zahtevZaOdmorRepository.findAll();
	}

	public ZahtevZaOdmor odobri(ZahtevZaOdmorDTO zahtevZaOdmorDTO) {
		// TODO Auto-generated method stub
		Collection<ZahtevZaOdmor> lista = findAll();
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		for (ZahtevZaOdmor zahtevZaOdmor : lista) {
			if(zahtevZaOdmor.getId().equals(zahtevZaOdmorDTO.getId())) {
				zahtevZaOdmor.setOdobren(true);
				zahtevZaOdmorRepository.save(zahtevZaOdmor);
				zzo = zahtevZaOdmor;
			}
		}
		List<Lekar> lekari = lekarRepository.findAll();
		List<MedicinskaSestra> ms = medicinskaSestraRepository.findAll();
		for (MedicinskaSestra medicinskaSestra : ms) {
			if(medicinskaSestra.getId().equals(zahtevZaOdmorDTO.getMedicinskaSestra())) {
				medicinskaSestra.getZahtevZaOdmor().add(zzo);
			}
		}
		
		for (Lekar l : lekari) {
			if(l.getId().equals(zahtevZaOdmorDTO.getLekar())) {
				l.getZahtevZaOdmor().add(zzo);
			}
		}
		return zzo;
	}

	public ZahtevZaOdmor odbij(ZahtevZaOdmorDTO zahtevZaOdmorDTO) {
		// TODO Auto-generated method stub
		Collection<ZahtevZaOdmor> lista = findAll();
		for (ZahtevZaOdmor zahtevZaOdmor : lista) {
			if(zahtevZaOdmor.getId().equals(zahtevZaOdmorDTO.getId())) {
				zahtevZaOdmor.setOdobren(false);
				zahtevZaOdmorRepository.save(zahtevZaOdmor);
				return zahtevZaOdmor;
			}
		}
		return null;
	}



}
