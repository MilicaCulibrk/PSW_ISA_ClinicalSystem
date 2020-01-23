package main.dto;

import main.model.Sala;

public class SalaDTO {
	private Long id;
	private String naziv;
	private String broj;
	private KlinikaDTO klinika;
	
	public SalaDTO() {
		
	}
	
	public SalaDTO(Sala salaKlinike) {
		this.id = salaKlinike.getId();
		this.naziv = salaKlinike.getNaziv();
		this.broj = salaKlinike.getBroj();
		klinika = new KlinikaDTO(salaKlinike.getKlinika());
	}
	
	public SalaDTO(Long id, String naziv, String broj) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.broj = broj;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}

	public KlinikaDTO getKlinika() {
		return klinika;
	}

	public void setKlinika(KlinikaDTO klinika) {
		this.klinika = klinika;
	}
	
	

}
