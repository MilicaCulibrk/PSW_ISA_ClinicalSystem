package main.dto;

public class PretragaTipaPregledaDTO {
	
	String naziv;
	String oznaka;
	String cena;
	
	public PretragaTipaPregledaDTO(String ime, String prezime, String jmbg) {
		super();
		this.naziv = ime;
		this.oznaka = prezime;
		this.cena = jmbg;
	}
	public PretragaTipaPregledaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String ime) {
		this.naziv = ime;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String prezime) {
		this.oznaka = prezime;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String jmbg) {
		this.cena = jmbg;
	}
	


}
