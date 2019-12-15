package main.dto;

import javax.persistence.Column;

import main.model.ZdravstveniKarton;

public class ZdravstveniKartonDTO {
	
	private Long id;
	
    private String dioptrija;
	
    private String alergije;
	
    private String visina;
	
    private String tezina;

	public ZdravstveniKartonDTO(Long id, String dioptrija, String alergije, String visina, String tezina) {
		super();
		this.id = id;
		this.dioptrija = dioptrija;
		this.alergije = alergije;
		this.visina = visina;
		this.tezina = tezina;
	}
	public ZdravstveniKartonDTO(ZdravstveniKarton zdravstveniKarton) {
		super();
		this.id = zdravstveniKarton.getId();
		this.dioptrija =zdravstveniKarton.getDioptrija();
		this.alergije = zdravstveniKarton.getAlergije();
		this.visina = zdravstveniKarton.getVisina();
		this.tezina = zdravstveniKarton.getTezina();
	}

	public ZdravstveniKartonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDioptrija() {
		return dioptrija;
	}

	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}

	public String getAlergije() {
		return alergije;
	}

	public void setAlergije(String alergije) {
		this.alergije = alergije;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}
    
    
}

