package main.dto;

import javax.persistence.Column;

import main.model.MedicinskaSestra;

public class MedicinskaSestraDTO {
	private Long id;
	private String ime;
	
   private String prezime;
	
   private int ocena;
	
   private String email;
	
   private String lozinka;
	
   private String adresa;
	
   private String grad;
	
   private String drzava;
	
   private String telefon;
	
   private String jmbg;
   private Boolean promenjenaLozinka;

public MedicinskaSestraDTO(String ime, String prezime, int ocena, String email, String lozinka, String adresa,
		String grad, String drzava, String telefon, String jmbg) {
	super();
	this.ime = ime;
	this.prezime = prezime;
	this.ocena = ocena;
	this.email = email;
	this.lozinka = lozinka;
	this.adresa = adresa;
	this.grad = grad;
	this.drzava = drzava;
	this.telefon = telefon;
	this.jmbg = jmbg;
}

public MedicinskaSestraDTO(MedicinskaSestra ms) {
	super();
	this.id = ms.getId();
	this.ime = ms.getIme();
	this.prezime = ms.getPrezime();
	this.ocena = ms.getOcena();
	this.email = ms.getEmail();
	this.lozinka = ms.getLozinka();
	this.adresa = ms.getAdresa();
	this.grad = ms.getGrad();
	this.drzava = ms.getDrzava();
	this.telefon = ms.getTelefon();
	this.jmbg = ms.getJmbg();
	this.promenjenaLozinka = ms.getPromenjenaLozinka();

}



public MedicinskaSestraDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public Boolean getPromenjenaLozinka() {
	return promenjenaLozinka;
}



public void setPromenjenaLozinka(Boolean promenjenaLozinka) {
	this.promenjenaLozinka = promenjenaLozinka;
}
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

public int getOcena() {
	return ocena;
}

public void setOcena(int ocena) {
	this.ocena = ocena;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getDrzava() {
	return drzava;
}

public void setDrzava(String drzava) {
	this.drzava = drzava;
}

public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}

public String getJmbg() {
	return jmbg;
}

public void setJmbg(String jmbg) {
	this.jmbg = jmbg;
}
   
   
}
