package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pregled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "datum", nullable = false)
    private String datum;
	
	@Column(name = "vreme", nullable = false)
    private String vreme;
	
	
	@Column(name = "trajanje", nullable = false)
    private Integer trajanje;
	
	@Column(name = "cena", nullable = false)
    private String cena;
	
	@Column(name = "zavrsen", nullable = false)
    private boolean zavrsen;
	
	@Column(name = "vrsta_pregleda", nullable = false)
    private String vrstaPregleda;
   
	@Column(name = "id_pacijenta", nullable = true, unique = false)
	private Long idPacijenta;
   
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "lekar_id")
	private Lekar lekar;
    
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tip_pregleda_id")
	private TipPregleda tipPregleda;
	

	public Pregled() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	
	
	
	public Integer getTrajanje() {
		return trajanje;
	}


	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
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
	
	
	public Lekar getLekar() {
		return lekar;
	}
	
	
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	
	
	public Sala getSala() {
		return sala;
	}
	
	
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}
	
	
	public void setTipPregleda(TipPregleda tipPregleda) {
		this.tipPregleda = tipPregleda;
	}


	public String getVreme() {
		return vreme;
	}


	public void setVreme(String vreme) {
		this.vreme = vreme;
	}


	public String getVrstaPregleda() {
		return vrstaPregleda;
	}


	public void setVrstaPregleda(String vrstaPregleda) {
		this.vrstaPregleda = vrstaPregleda;
	}


	public boolean isZavrsen() {
		return zavrsen;
	}


	public void setZavrsen(boolean zavrsen) {
		this.zavrsen = zavrsen;
	}
	  
}