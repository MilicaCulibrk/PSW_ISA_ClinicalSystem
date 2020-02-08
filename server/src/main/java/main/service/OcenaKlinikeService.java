package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.OcenaKlinikeDTO;
import main.model.Klinika;
import main.model.OcenaKlinike;
import main.model.OcenaLekara;
import main.repository.KlinikaRepository;
import main.repository.OcenaKlinikeRepository;
import main.repository.OcenaLekaraRepository;

@Service
public class OcenaKlinikeService {

	@Autowired
	private OcenaKlinikeRepository ocenaKlinikeRepository;
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	public List<OcenaKlinike> findAll() {
		return ocenaKlinikeRepository.findAll();
	}
	

	public OcenaKlinike findOne(Long id) {
		return ocenaKlinikeRepository.findById(id).orElseGet(null);
	}


	public OcenaKlinikeDTO dodajOcenu(OcenaKlinikeDTO ocenaDTO) {
		// TODO Auto-generated method stub
		OcenaKlinike ocena = new OcenaKlinike();
		ocena.setOcena(ocenaDTO.getOcena());
		
		
		for (Klinika i : klinikaRepository.findAll()) {
			if(i.getId().equals(ocenaDTO.getKlinikaId())) {
				

				ocena.setKlinika(i);
				ocenaKlinikeRepository.save(ocena);
				
				//i.getOcenaKlinike().add(ocena);
				System.out.println(i.getOcenaKlinike().size());
				//System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
				i.setOcena(i.getOcenaKlinike());
				//System.out.println(i.getOcenaKlinike().size());

				klinikaRepository.save(i);
				
			}
		}
		OcenaKlinikeDTO ocenadto = new OcenaKlinikeDTO(ocena);
		return ocenadto;
	}
	

}
