package main.dto;

import main.model.AdministratorKlinike;

public class AdminKlinikeDTO {
	private Long id;

	private String ime;
	
   private String prezime;
	
   private String email;
	
   private String lozinka;
	
   private String adresa;
	
   private String grad;
	
   private String drzava;
	
   private String telefon;
	
   private String jmbg;

   private Long idKlinike;
   
public AdminKlinikeDTO(Long id, String ime, String prezime, String email, String lozinka, String adresa, String grad,
		String drzava, String telefon, String jmbg, Long idKlinike) {
	super();
	this.id = id;
	this.ime = ime;
	this.prezime = prezime;
	this.email = email;
	this.lozinka = lozinka;
	this.adresa = adresa;
	this.grad = grad;
	this.drzava = drzava;
	this.telefon = telefon;
	this.jmbg = jmbg;
	this.idKlinike = idKlinike;
}

public AdminKlinikeDTO(AdministratorKlinike admin) {
	super();
	this.id = admin.getId();
	this.ime = admin.getIme();
	this.prezime = admin.getPrezime();
	this.email = admin.getEmail();
	this.lozinka = admin.getLozinka();
	this.adresa = admin.getAdresa();
	this.grad = admin.getGrad();
	this.drzava = admin.getDrzava();
	this.telefon = admin.getTelefon();
	this.jmbg = admin.getJmbg();
	this.idKlinike = admin.klinika.getId();
}

public AdminKlinikeDTO() {
	super();
}

public Long getIdKlinike() {
	return idKlinike;
}

public void setIdKlinike(Long idKlinike) {
	this.idKlinike = idKlinike;
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
