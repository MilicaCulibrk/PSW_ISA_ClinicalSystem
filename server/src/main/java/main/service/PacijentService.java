package main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.Pacijent;
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
		if(sortBy.equals("Id"))
			return pacijentRepository.findAllByOrderByIdAsc();
		else if(sortBy.equals("Ime"))
			return pacijentRepository.findAllByOrderByImeAsc();
		else if(sortBy.equals("Prezime"))
			return pacijentRepository.findAllByOrderByPrezimeAsc();
		else if(sortBy.equals("JMBG"))
			return pacijentRepository.findAllByOrderByJmbgAsc();
		else if(sortBy.equals("Email"))
			return pacijentRepository.findAllByOrderByEmailAsc();
		return pacijentRepository.findAll();
	}
	

}
