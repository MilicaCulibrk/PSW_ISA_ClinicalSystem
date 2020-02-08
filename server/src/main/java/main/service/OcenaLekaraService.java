package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.OcenaKlinikeDTO;
import main.dto.OcenaLekaraDTO;
import main.model.Klinika;
import main.model.Lekar;
import main.model.OcenaKlinike;
import main.model.OcenaLekara;
import main.repository.LekarRepository;
import main.repository.OcenaLekaraRepository;

@Service
public class OcenaLekaraService {

	@Autowired
	private OcenaLekaraRepository ocenaLekaraRepository;
	@Autowired
	private LekarRepository lekarRepository;	
	
	public List<OcenaLekara> findAll() {
		return ocenaLekaraRepository.findAll();
	}
	

	public OcenaLekara findOne(Long id) {
		return ocenaLekaraRepository.findById(id).orElseGet(null);
	}


	public OcenaLekaraDTO dodajOcenu(OcenaLekaraDTO ocenaDTO) {
		// TODO Auto-generated method stub
		OcenaLekara ocena = new OcenaLekara();
		ocena.setOcena(ocenaDTO.getOcena());
		for (Lekar i : lekarRepository.findAll()) {
			if(i.getId().equals(ocenaDTO.getLekarId())) {
				ocena.setLekar(i);
				ocenaLekaraRepository.save(ocena);

				//i.getOcenaLekara().add(ocena);
				i.setOcena(i.getOcenaLekara());
				lekarRepository.save(i);
			}
		}
		OcenaLekaraDTO ocenadto = new OcenaLekaraDTO(ocena);
		return ocenadto;
		}
	
}
