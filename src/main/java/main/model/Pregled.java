package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pregled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "datumVreme", nullable = false)
   private long datumVreme;
	
	@Column(name = "trajanje", nullable = false)
   private long trajanje;
	
	@Column(name = "cena", nullable = false)
   private double cena;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
   public Pacijent pacijent;

public Pregled() {
	super();
	// TODO Auto-generated constructor stub
}

public Pregled(Long id, long datumVreme, long trajanje, double cena, Pacijent pacijent) {
	super();
	this.id = id;
	this.datumVreme = datumVreme;
	this.trajanje = trajanje;
	this.cena = cena;
	this.pacijent = pacijent;
}
   
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
     public Klinika klinika;
     
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lekar_id", referencedColumnName = "id")
	public Lekar lekar;
     
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipPregleda_id", referencedColumnName = "id")
   public TipPregleda tipPregleda;
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sala_id", referencedColumnName = "id")
   public Sala sala;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(long datumVreme) {
		this.datumVreme = datumVreme;
	}

	public long getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(long trajanje) {
		this.trajanje = trajanje;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(TipPregleda tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Pregled [id=" + id + ", datumVreme=" + datumVreme + ", trajanje=" + trajanje + ", cena=" + cena
				+ ", pacijent=" + pacijent + ", klinika=" + klinika + ", lekar=" + lekar + ", tipPregleda="
				+ tipPregleda + ", sala=" + sala + "]";
	}
   
    
  
}