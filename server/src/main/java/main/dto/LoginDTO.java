package main.dto;

import main.model.Pacijent;

public class LoginDTO {

	private String email;
	private String lozinka;
	
	public LoginDTO() {

	}
	
	public LoginDTO(String email, String lozinka) {
		super();
		this.email = email;
		this.lozinka = lozinka;
	}

	public LoginDTO(Pacijent pacijent) {
		super();
		this.email = pacijent.getEmail();
		this.lozinka = pacijent.getLozinka();
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
	public void setLozinka(String sifra) {
		this.lozinka = sifra;
	}
}