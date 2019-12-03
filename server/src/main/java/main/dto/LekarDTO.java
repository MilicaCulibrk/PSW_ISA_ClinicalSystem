package main.dto;

import main.model.AdministratorKlinike;
import main.model.Lekar;

public class LekarDTO {

	private Long id;
	
	   private String ime;
	   
	   private String prezime;
		
	   private String lozinka;
		
	   private String jmbg;
		
	   private String adresa;
		
	   private String email;
		
	   private String grad;
	   
	   private String drzava;
		
	   private String telefon;

	

	
 
	
	public LekarDTO(Long id, String ime, String prezime, String lozinka, String jmbg, String adresa, String email,
			String grad, String drzava, String telefon) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.lozinka = lozinka;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.email = email;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
	}


	public LekarDTO(Lekar lekar) {
		super();
		this.id = lekar.getId();
		this.ime = lekar.getIme();
		this.prezime = lekar.getPrezime();
		this.email = lekar.getEmail();
		this.lozinka = lekar.getLozinka();
		this.adresa = lekar.getAdresa();
		this.grad = lekar.getGrad();
		this.drzava = lekar.getDrzava();
		this.telefon = lekar.getTelefon();
		this.jmbg = lekar.getJmbg();
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






	public String getLozinka() {
		return lozinka;
	}






	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}






	public String getJmbg() {
		return jmbg;
	}






	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
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

	
	   
	   
	
}
