package main.dto;

import main.model.Lek;

public class LekDTO {
	
	private Long id;
	private String sifra;
	private String naziv;
	
	public LekDTO(String sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}
	public LekDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LekDTO(Lek l) {
		// TODO Auto-generated constructor stub
		this.sifra = l.getSifra();
		this.naziv = l.getNaziv();
		this.id = l.getId();
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
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	
	
}
