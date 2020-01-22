package main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.model.Pacijent;
//import main.repository.PacijentRepository;
import main.repository.PacijentRepository;
import main.repository.ZdravstveniKartonRepository;

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
	
	public Pacijent izmeniPacijenta(Pacijent pacijent, PacijentDTO pacijentDTO) {
		  
			pacijent.setIme(pacijentDTO.getIme());
			pacijent.setPrezime(pacijentDTO.getPrezime());
			pacijent.setAdresa(pacijentDTO.getAdresa());
			pacijent.setTelefon(pacijentDTO.getTelefon());
			pacijent.setGrad(pacijentDTO.getGrad());
			pacijent.setDrzava(pacijentDTO.getDrzava());


			pacijent.setZdravstveniKarton(zdravstveniKartonRepository.getOne(pacijentDTO.getIdZdravstveniKarton()));

			pacijentRepository.save(pacijent);
			
			return pacijent;
	}

	public List<Pacijent> findAll() {
		// TODO Auto-generated method stub
		return pacijentRepository.findAll();
	}


}
