package main.model;

import java.util.Arrays;

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
public class Operacija {
	
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
	  @JoinColumn(name = "sala_id", referencedColumnName = "id")
	  public Sala sala;
   
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "lekar_id", referencedColumnName = "id")
	public Lekar[] lekar;
	
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
   public Pacijent pacijent;

   @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   @JoinColumn(name = "zahtevZaOperaciju_id", referencedColumnName = "id")
   public ZahtevZaOperaciju zahtevZaOperaciju;




public Operacija(Long id, long datumVreme, long trajanje, double cena, Sala sala, Lekar[] lekar, Pacijent pacijent,
		ZahtevZaOperaciju zahtevZaOperaciju) {
	super();
	this.id = id;
	this.datumVreme = datumVreme;
	this.trajanje = trajanje;
	this.cena = cena;
	this.sala = sala;
	this.lekar = lekar;
	this.pacijent = pacijent;
	this.zahtevZaOperaciju = zahtevZaOperaciju;
}


public Operacija() {
	super();
	// TODO Auto-generated constructor stub
}


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


public Sala getSala() {
	return sala;
}


public void setSala(Sala sala) {
	this.sala = sala;
}


public Lekar[] getLekar() {
	return lekar;
}


public void setLekar(Lekar[] lekar) {
	this.lekar = lekar;
}


public Pacijent getPacijent() {
	return pacijent;
}


public void setPacijent(Pacijent pacijent) {
	this.pacijent = pacijent;
}



public ZahtevZaOperaciju getZahtevZaOperaciju() {
	return zahtevZaOperaciju;
}


public void setZahtevZaOperaciju(ZahtevZaOperaciju zahtevZaOperaciju) {
	this.zahtevZaOperaciju = zahtevZaOperaciju;
}


@Override
public String toString() {
	return "Operacija [id=" + id + ", datumVreme=" + datumVreme + ", trajanje=" + trajanje + ", cena=" + cena
			+ ", sala=" + sala + ", lekar=" + Arrays.toString(lekar) + ", pacijent=" + pacijent + ", zahtevZaOperaciju="
			+ zahtevZaOperaciju + "]";
}



   

   
   
  

}