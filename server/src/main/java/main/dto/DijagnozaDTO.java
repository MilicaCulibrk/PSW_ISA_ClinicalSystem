package main.dto;

import main.model.Dijagnoza;

public class DijagnozaDTO {
	
	private Long id;
	private String sifra;
	private String naziv;
	
	public DijagnozaDTO(String sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}
	public DijagnozaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DijagnozaDTO(Dijagnoza d) {
		// TODO Auto-generated constructor stub
		this.sifra = d.getSifra();
		this.naziv = d.getNaziv();
		this.id = d.getId();
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
