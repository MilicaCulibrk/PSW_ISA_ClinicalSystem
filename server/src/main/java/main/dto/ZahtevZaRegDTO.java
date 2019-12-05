package main.dto;

import main.model.ZahtevZaRegistraciju;

public class ZahtevZaRegDTO {

	private Long id;
    private String status;
	
    public ZahtevZaRegDTO(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
    
    public ZahtevZaRegDTO(ZahtevZaRegistraciju zahtev) {
		this.id = zahtev.getId();
		this.status = zahtev.getStatus();
	}
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
