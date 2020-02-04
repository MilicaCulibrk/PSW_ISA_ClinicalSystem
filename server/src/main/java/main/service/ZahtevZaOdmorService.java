package main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.LekarDTO;
import main.dto.ZahtevZaOdmorDTO;
import main.model.AdministratorKlinike;
import main.model.Authority;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.ZahtevZaOdmor;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.MedicinskaSestraRepository;
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

	public ZahtevZaOdmorDTO zatrazi(ZahtevZaOdmorDTO zahtevZaOdmorDTO) {
		// TODO Auto-generated method stub
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		zzo.setStartDate(zahtevZaOdmorDTO.getStart());
		zzo.setEndDate(zahtevZaOdmorDTO.getEnd());
		List<Lekar> lekari = lekarRepository.findAll();
		List<MedicinskaSestra> ms = medicinskaSestraRepository.findAll();
		List<AdministratorKlinike> admini = adminKlinikeRepository.findAll();

		Long idKlinike = null;
		for (MedicinskaSestra medicinskaSestra : ms) {
			if(medicinskaSestra.getId().equals(zahtevZaOdmorDTO.getMedicinskaSestra())) {
				zzo.setMedicinskaSestra(medicinskaSestra);
				idKlinike = medicinskaSestra.getKlinika().getId();
			}
		}
		
		for (Lekar l : lekari) {
			if(l.getId().equals(zahtevZaOdmorDTO.getLekar())) {
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
