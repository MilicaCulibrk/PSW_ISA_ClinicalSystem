package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.ZahtevZaPregled;
import main.repository.ZahtevZaPregledRepository;

@Service
public class ZahtevZaPregledService {
	
	@Autowired
	private ZahtevZaPregledRepository zahtevZaPregled;
	
	public List<ZahtevZaPregled> findAll() {
		return zahtevZaPregled.findAll();
	}
	
	public ZahtevZaPregled findOne(Long id) {
		return zahtevZaPregled.findById(id).orElseGet(null);
	}

}
