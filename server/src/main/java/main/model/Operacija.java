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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

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



   
   
  

}