package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ZahtevZaOperaciju {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "odobren", nullable = false)
   private boolean odobren;
	
	@Column(name = "terminPregleda", nullable = false)
   private long terminPregleda;
	
	@Column(name = "trajanje", nullable = false)
   private long trajanje;
	
	@Column(name = "cena", nullable = false)
   private long cena;
   
	 @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	   @JoinColumn(name = "operacija_id", referencedColumnName = "id")
   public Operacija operacija;

	public ZahtevZaOperaciju() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ZahtevZaOperaciju(boolean odobren, long terminPregleda, long trajanje, long cena, Operacija operacija) {
		super();
		this.odobren = odobren;
		this.terminPregleda = terminPregleda;
		this.trajanje = trajanje;
		this.cena = cena;
		this.operacija = operacija;
	}



	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}

	public long getTerminPregleda() {
		return terminPregleda;
	}

	public void setTerminPregleda(long terminPregleda) {
		this.terminPregleda = terminPregleda;
	}

	public long getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(long trajanje) {
		this.trajanje = trajanje;
	}

	public long getCena() {
		return cena;
	}

	public void setCena(long cena) {
		this.cena = cena;
	}

	public Operacija getOperacija() {
		return operacija;
	}

	public void setOperacija(Operacija operacija) {
		this.operacija = operacija;
	}

	@Override
	public String toString() {
		return "ZahtevZaOperaciju [odobren=" + odobren + ", terminPregleda=" + terminPregleda + ", trajanje=" + trajanje
				+ ", cena=" + cena + ", operacija=" + operacija + "]";
	}



}