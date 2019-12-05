package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Lekar;
import main.model.ZahtevZaRegistraciju;
import main.repository.ZahtevZaRegRepository;

@Service
public class ZahtevZaRegService {
	
	@Autowired
	private ZahtevZaRegRepository zahtevZaRegRepository;
	
	public List<ZahtevZaRegistraciju> findAll() {
		return zahtevZaRegRepository.findAll();
	}
	
	public ZahtevZaRegistraciju findOne(Long id) {
		System.out.println(id + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return zahtevZaRegRepository.findById(id).orElseGet(null);
		
	
	}
	


}
