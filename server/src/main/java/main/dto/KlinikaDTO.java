package main.dto;
import javax.persistence.Column;

import main.model.Klinika;

public class KlinikaDTO {
	private Long id;
	
   private String naziv;
	
   private String adresa;
	
   private String email;
	
   private String grad;
   
   private String drzava;
	
   private String telefon;
	
   private String opis;
	
   private int ocena;
	
   private int brojRecenzija;
   
   

public KlinikaDTO(Klinika klinika) {
	super();
	this.id = klinika.getId();
	this.naziv = klinika.getNaziv();
	this.adresa = klinika.getAdresa();
	this.email = klinika.getEmail();
	this.grad = klinika.getGrad();
	this.drzava = klinika.getDrzava();
	this.telefon = klinika.getTelefon();
	this.opis = klinika.getOpis();
	this.ocena = klinika.getOcena();
	this.brojRecenzija = klinika.getBrojRecenzija();
}



public KlinikaDTO(Long id, String naziv, String adresa, String email, String grad, String drzava, String telefon, String opis,
		int ocena, int brojRecenzija) {
	super();
	this.id = id;
	this.naziv = naziv;
	this.adresa = adresa;
	this.email = email;
	this.grad = grad;
	this.drzava = drzava;
	this.telefon = telefon;
	this.opis = opis;
	this.ocena = ocena;
	this.brojRecenzija = brojRecenzija;
}



public KlinikaDTO() {
	super();
}



public String getDrzava() {
	return drzava;
}



public void setDrzava(String drzava) {
	this.drzava = drzava;
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

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}

public String getOpis() {
	return opis;
}

public void setOpis(String opis) {
	this.opis = opis;
}

public int getOcena() {
	return ocena;
}

public void setOcena(int ocena) {
	this.ocena = ocena;
}

public int getBrojRecenzija() {
	return brojRecenzija;
}

public void setBrojRecenzija(int brojRecenzija) {
	this.brojRecenzija = brojRecenzija;
}
   
   
}
