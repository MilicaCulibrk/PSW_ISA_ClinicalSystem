package main.dto;

import main.model.Dijagnoza;
import main.model.Izvestaj;
import main.model.Lek;

public class IzvestajDTO {
	
	private Long id;
	private String lek;
	private String dijagnoza;
	private String opis;
	private Long idPacijenta;
	private Long idLekara;
	public IzvestajDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IzvestajDTO(Izvestaj i) {
		super();
		this.id = i.getId();
		this.lek = i.getLek().getSifra();
		this.dijagnoza = i.getDijagnoza().getSifra();
		this.opis = i.getOpis();
	}
	

	public Long getIdPacijenta() {
		return idPacijenta;
	}
	public void setIdPacijenta(Long idPacijenta) {
		this.idPacijenta = idPacijenta;
	}
	public Long getIdLekara() {
		return idLekara;
	}
	public void setIdLekara(Long idLekara) {
		this.idLekara = idLekara;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getLek() {
		return lek;
	}
	public void setLek(String lek) {
		this.lek = lek;
	}
	public String getDijagnoza() {
		return dijagnoza;
	}
	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

}
