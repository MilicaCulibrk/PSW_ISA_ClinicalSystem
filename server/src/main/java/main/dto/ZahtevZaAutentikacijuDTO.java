package main.dto;
public class ZahtevZaAutentikacijuDTO {



	private String email;

    private String lozinka;

    private Boolean promenjenaLozinka;

    public ZahtevZaAutentikacijuDTO() {

   

    }

    

    public ZahtevZaAutentikacijuDTO(String email, String lozinka) {

        this.email = email;

        this.lozinka = lozinka;
    }



	public Boolean getPromenjenaLozinka() {
		return promenjenaLozinka;
	}



	public void setPromenjenaLozinka(Boolean promenjenaLozinka) {
		this.promenjenaLozinka = promenjenaLozinka;
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

    
    

    

}

