package main.dto;

import java.util.ArrayList;
import java.util.Collection;

import main.model.Dijagnoza;
import main.model.Izvestaj;
import main.model.Lek;

public class IzvestajDTO {
	
	private Long id;
	private Collection<String> lekovi = new ArrayList<String>();
	private String dijagnoza;
	private String opis;
	private Long idPacijenta;
	private Long idLekara;
	private Long idMedicinskeSestre;
	public IzvestajDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IzvestajDTO(Izvestaj i) {
		super();
		this.id = i.getId();
		for (Lek l : i.getLekovi()) {
			this.lekovi.add(l.getSifra());
		}
		this.dijagnoza = i.getDijagnoza().getSifra();
		this.opis = i.getOpis();
		this.idLekara = i.getLekar().getId();
		this.idPacijenta = i.getPacijent().getId();
		//this.idMedicinskeSestre = i.getMedicinskaSestra().getId();
	}
	

	public Long getIdMedicinskeSestre() {
		return idMedicinskeSestre;
	}
	public void setIdMedicinskeSestre(Long idMedicinskeSestre) {
		this.idMedicinskeSestre = idMedicinskeSestre;
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



	public Collection<String> getLekovi() {
		return lekovi;
	}
	public void setLekovi(Collection<String> lekovi) {
		this.lekovi = lekovi;
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
