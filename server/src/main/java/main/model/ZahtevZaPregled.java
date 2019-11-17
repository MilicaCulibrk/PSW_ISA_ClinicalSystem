package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ZahtevZaPregled {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "odobren", nullable = false)
	    private boolean odobren;
		
		@Column(name = "terminPregleda", nullable = false)
	    private long terminPregleda;
		
		@Column(name = "trajanje", nullable = false)
	    private long trajanje;
		
		@Column(name = "cena", nullable = false)
	    private long cena;
   
 
	   @OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
	   public Pacijent pacijent;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Pacijent getPacijent() {
		return pacijent;
	}


	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}


	public ZahtevZaPregled() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ZahtevZaPregled(Long id, boolean odobren, long terminPregleda, long trajanje, long cena, Pacijent pacijent) {
		super();
		this.id = id;
		this.odobren = odobren;
		this.terminPregleda = terminPregleda;
		this.trajanje = trajanje;
		this.cena = cena;
		this.pacijent = pacijent;
	}
	   
	   /*@OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "sala_id", referencedColumnName = "id")
	   public Sala sala;
	 
	   @OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "lekar_id", referencedColumnName = "id")
	   public Lekar lekar;
	  
       @OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "tipPregleda_id", referencedColumnName = "id")
	   public TipPregleda tipPregleda; */
	   
	   

}