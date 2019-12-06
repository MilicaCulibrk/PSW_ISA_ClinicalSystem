package main.dto;

import main.model.Pacijent;

public class RegistracijaDTO {
	
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
	
	   public RegistracijaDTO(Long id, String ime, String prezime, String email, String lozinka, String adresa,
			String grad, String drzava, String telefon, String jmbg) {
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

	}
	   
		public RegistracijaDTO(Pacijent pacijent) {
			super();
			this.id = pacijent.getId();
			this.ime = pacijent.getIme();
			this.prezime = pacijent.getPrezime();
			this.email = pacijent.getEmail();
			this.lozinka = pacijent.getLozinka();
			this.adresa = pacijent.getAdresa();
			this.grad = pacijent.getGrad();
			this.drzava = pacijent.getDrzava();
			this.telefon = pacijent.getTelefon();
			this.jmbg = pacijent.getJmbg();
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
