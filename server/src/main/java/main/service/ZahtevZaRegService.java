package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PacijentDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.Lekar;
import main.model.Pacijent;
import main.model.ZahtevZaRegistraciju;
import main.repository.ZahtevZaRegRepository;

@Service
public class ZahtevZaRegService {
	
	@Autowired
	private ZahtevZaRegRepository zahtevZaRegRepository;
	
	@Autowired
	private AdminKCService adminKCService;
	
	public List<ZahtevZaRegistraciju> findAll() {
		return zahtevZaRegRepository.findAll();
	}
	
	public ZahtevZaRegistraciju findOne(Long id) {
		System.out.println(id + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return zahtevZaRegRepository.findById(id).orElseGet(null);
		
	
	}
	
	public void posaljiZahtevAdminuKC(PacijentDTO pacijentDTO){
		ZahtevZaRegistraciju zahtev = new ZahtevZaRegistraciju();
		Pacijent pacijent = new Pacijent(pacijentDTO);
		zahtev.setIme(pacijent.getIme());
		zahtev.setPrezime(pacijent.getPrezime());
		zahtev.setAdresa(pacijent.getAdresa());
		zahtev.setDrzava(pacijent.getDrzava());
		zahtev.setGrad(pacijent.getGrad());
		zahtev.setEmail(pacijent.getEmail());
		zahtev.setJmbg(pacijent.getJmbg());
		zahtev.setLozinka(pacijent.getLozinka());
		zahtev.setTelefon(pacijent.getTelefon());
		
		AdministratorKlinickogCentra administratorKlinickogCentra = adminKCService.findOne(Long.valueOf(1));
		
		zahtev.setAdminKC(administratorKlinickogCentra);
        zahtevZaRegRepository.save(zahtev);
        administratorKlinickogCentra.getZahtevi().add(zahtev);
	}

}
