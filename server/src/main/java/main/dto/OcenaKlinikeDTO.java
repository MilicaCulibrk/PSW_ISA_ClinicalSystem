package main.dto;

import main.model.OcenaKlinike;

public class OcenaKlinikeDTO {
	private Long id;
	private Integer ocena;
	private KlinikaDTO klinika;
	private Long klinikaId;
	private PacijentDTO pacijent;
	
	
	
	

	public Long getKlinikaId() {
		return klinikaId;
	}
	public void setKlinikaId(Long klinikaId) {
		this.klinikaId = klinikaId;
	}
	public PacijentDTO getPacijent() {
		return pacijent;
	}
	public void setPacijent(PacijentDTO pacijent) {
		this.pacijent = pacijent;
	}
	public KlinikaDTO getKlinika() {
		return klinika;
	}
	public void setKlinika(KlinikaDTO klinika) {
		this.klinika = klinika;
	}
	public OcenaKlinikeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OcenaKlinikeDTO(Long id, Integer ocena) {
		super();
		this.id = id;
		this.ocena = ocena;
	}
	public OcenaKlinikeDTO(OcenaKlinike ocena) {
		// TODO Auto-generated constructor stub
		this.id = ocena.getId();
		this.ocena = ocena.getOcena();
		this.klinikaId = ocena.getKlinika().getId();
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
	
}
