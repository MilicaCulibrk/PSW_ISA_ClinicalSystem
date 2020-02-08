package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.Pacijent;
import main.model.Pregled;
import main.model.Sala;
//import main.repository.PacijentRepository;
import main.repository.PacijentRepository;
import main.repository.ZdravstveniKartonRepository;
import org.springframework.data.domain.Sort;
@Service
public class PacijentService {

	@Autowired
	private PacijentRepository pacijentRepository;

	@Autowired
	private ZdravstveniKartonRepository zdravstveniKartonRepository;
	
	public Pacijent findOne(Long id) {
		return pacijentRepository.findById(id).orElseGet(null);
	}
	
	public Pacijent findOne(String mail) {
		return pacijentRepository.findByEmail(mail);
	}
	
	public Pacijent izmeniPacijenta( PacijentDTO pacijentDTO) {
					
			Pacijent pacijent = pacijentRepository.findById(pacijentDTO.getId()).orElse(null);
			
			if(pacijent == null) {
				throw new ValidationException("Pacijent sa zadatim id-jem ne postoji");
			}
			try {
				pacijent.setIme(pacijentDTO.getIme());
				pacijent.setPrezime(pacijentDTO.getPrezime());
				pacijent.setAdresa(pacijentDTO.getAdresa());
				pacijent.setTelefon(pacijentDTO.getTelefon());
				pacijent.setGrad(pacijentDTO.getGrad());
				pacijent.setDrzava(pacijentDTO.getDrzava());
				//pacijent.setZdravstveniKarton(zdravstveniKartonRepository.getOne(pacijentDTO.getIdZdravstveniKarton()));
				pacijentRepository.save(pacijent);

			} catch (EntityNotFoundException e) {
				throw new ValidationException("Pacijent sa tim id-ijem ne postoji");
			}
			return pacijent;
	}

	public List<Pacijent> findAll() {
		return pacijentRepository.findAll();
	}

	public List<Pacijent> sortiraj(String sortBy) {
		if(sortBy.equals("id"))
			return pacijentRepository.findAllByOrderByIdAsc();
		else if(sortBy.equals("ime"))
			return pacijentRepository.findAllByOrderByImeAsc();
		else if(sortBy.equals("prezime"))
			return pacijentRepository.findAllByOrderByPrezimeAsc();
		else if(sortBy.equals("JMBG"))
			return pacijentRepository.findAllByOrderByJmbgAsc();
		else if(sortBy.equals("email"))
			return pacijentRepository.findAllByOrderByEmailAsc();
		return pacijentRepository.findAll();
	}
	
	public List<Pacijent> pronadjiPacijente( String ime, String prezime, String jmbg){
		
		//lista pacijenata koju vracam
		List<Pacijent> ret = new ArrayList<Pacijent>();
		
		List<Pacijent> sviPacijenti = pacijentRepository.findAll();
		
	
		if(ime == null && prezime == null && jmbg == null) {
			ret = sviPacijenti;
		}else if(ime == null && prezime == null && jmbg != null){
			for(Pacijent p : sviPacijenti) {
				if(p.getJmbg().contains(jmbg)) {
					ret.add(p);
				}
			}
		}else if(ime == null && prezime != null && jmbg == null){
			for(Pacijent p : sviPacijenti) {
				if(p.getPrezime().contains(prezime)) {
					ret.add(p);
				}
			}
		}else if(ime != null && prezime == null && jmbg == null){
			for(Pacijent p : sviPacijenti) {
				if(p.getIme().contains(ime)) {
					ret.add(p);
				}
			}
		}else if(ime != null && prezime != null && jmbg == null){
			for(Pacijent p : sviPacijenti) {
				if(p.getIme().contains(ime) && p.getPrezime().contains(prezime)) {
					ret.add(p);
				}
			}
		}else if(ime != null && prezime == null && jmbg != null){
			for(Pacijent p : sviPacijenti) {
				if(p.getIme().contains(ime) && p.getJmbg().contains(jmbg)) {
					ret.add(p);
				}
			}
		}else if(ime == null && prezime != null && jmbg != null){
			for(Pacijent p : sviPacijenti) {
				if(p.getPrezime().contains(prezime) && p.getJmbg().contains(jmbg)) {
					ret.add(p);
				}
			}
		}else if(ime != null && prezime != null && jmbg != null){
			for(Pacijent p : sviPacijenti) {
				if(p.getPrezime().contains(prezime) && p.getJmbg().contains(jmbg)  && p.getIme().contains(ime)) {
					ret.add(p);
				}
			}
		}
		
	
		return ret;
		}
	

}
