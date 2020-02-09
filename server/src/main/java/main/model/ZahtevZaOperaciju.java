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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

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

	

	public ZahtevZaOperaciju(boolean odobren, long terminPregleda, long trajanje, long cena, Operacija operacija) {
		super();
		this.odobren = odobren;
		this.terminPregleda = terminPregleda;
		this.trajanje = trajanje;
		this.cena = cena;
		this.operacija = operacija;
	}




}