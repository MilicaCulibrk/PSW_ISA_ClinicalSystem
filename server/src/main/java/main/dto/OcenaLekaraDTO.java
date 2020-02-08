package main.dto;

import main.model.OcenaLekara;

public class OcenaLekaraDTO {
	
	private Long id;
	private Integer ocena;
	private Long lekarId;
	private PacijentDTO pacijent;
	
	
	
	
	public Long getLekarId() {
		return lekarId;
	}
	public void setLekarId(Long lekarId) {
		this.lekarId = lekarId;
	}
	public PacijentDTO getPacijent() {
		return pacijent;
	}
	public void setPacijent(PacijentDTO pacijent) {
		this.pacijent = pacijent;
	}
	public OcenaLekaraDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	public OcenaLekaraDTO(OcenaLekara ocena) {
		super();
		this.id = ocena.getId();
		this.ocena = ocena.getOcena();
		this.lekarId = ocena.getLekar().getId();
	}

}
