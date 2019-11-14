package main;

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
   
   
   
   /*  public Klinika klinika;
   public Lekar lekar;
   public TipPregleda tipPregleda;
   public Sala sala;*/
   
   
  
}