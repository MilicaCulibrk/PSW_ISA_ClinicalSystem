package main.dto;

import main.model.Pregled;

public class PregledDTO {
	
	private Long id;
	private String datum;
	private String vreme;
	private Integer trajanjePregleda;
	private SalaDTO sala;
	private TipPregledaDTO tipPregleda;
	private LekarDTO lekar;
	private String cena;
	private Long idPacijenta;
	private Boolean zavrsen;
	private String vrstaPregleda;

	
	public PregledDTO() {

	}
	
	public PregledDTO(Pregled pregled) {
		this.id = pregled.getId();
		this.datum = pregled.getDatum();
		this.vreme = pregled.getVreme();
		this.sala = new SalaDTO(pregled.getSala());
		this.tipPregleda = new TipPregledaDTO(pregled.getTipPregleda());
		this.lekar = new LekarDTO(pregled.getLekar());
		this.cena = pregled.getCena();
		this.idPacijenta = pregled.getIdPacijenta();
		this.trajanjePregleda = pregled.getTrajanje();
		this.zavrsen = pregled.isZavrsen();
		this.vrstaPregleda = pregled.getVrstaPregleda();
	}

	public PregledDTO(Long id, String datum, String vreme, Integer trajanjePregleda, SalaDTO sala, TipPregledaDTO tipPregleda,

			LekarDTO lekar, String cena, Long idPacijenta, Boolean zavrsen) {
		super();
		this.id = id;
		this.datum = datum;
		this.vreme = vreme;
		this.sala = sala;
		this.tipPregleda = tipPregleda;
		this.lekar = lekar;
		this.cena = cena;
		this.idPacijenta = idPacijenta;
	    this.zavrsen = zavrsen;
		this.trajanjePregleda = trajanjePregleda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public SalaDTO getSala() {
		return sala;
	}

	public void setSala(SalaDTO sala) {
		this.sala = sala;
	}

	public TipPregledaDTO getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(TipPregledaDTO tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public LekarDTO getLekar() {
		return lekar;
	}

	public void setLekar(LekarDTO lekar) {
		this.lekar = lekar;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public Long getIdPacijenta() {
		return idPacijenta;
	}

	public void setIdPacijenta(Long idPacijenta) {
		this.idPacijenta = idPacijenta;
	}


	public void setTrajanjePregleda(Integer trajanjePregleda) {
		this.trajanjePregleda = trajanjePregleda;
	}

	public Integer getTrajanjePregleda() {
		return trajanjePregleda;
	}

	public Boolean getZavrsen() {
		return zavrsen;
	}

	public void setZavrsen(Boolean zavrsen) {
		this.zavrsen = zavrsen;
	}

	public String getVrstaPregleda() {
		return vrstaPregleda;
	}

	public void setVrstaPregleda(String vrstaPregleda) {
		this.vrstaPregleda = vrstaPregleda;
	}

	
	
}