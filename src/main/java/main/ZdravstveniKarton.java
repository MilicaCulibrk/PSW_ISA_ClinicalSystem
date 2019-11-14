package main;

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
public class ZdravstveniKarton {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dioptrija", nullable = false)
   private String dioptrija;
	
	@Column(name = "alergije", nullable = false)
   private String alergije;
	
	@Column(name = "visina", nullable = false)
   private String visina;
	
	@Column(name = "tezina", nullable = false)
   private String tezina;
   
	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	   @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
	public Pacijent pacijent;

	public ZdravstveniKarton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZdravstveniKarton(Long id, String dioptrija, String alergije, String visina, String tezina,
			Pacijent pacijent) {
		super();
		this.id = id;
		this.dioptrija = dioptrija;
		this.alergije = alergije;
		this.visina = visina;
		this.tezina = tezina;
		this.pacijent = pacijent;
	}
	   
   /*public java.util.Collection<SifarnikLekova> sifarnikLekova;
   public java.util.Collection<SifranikDijagnoza> sifranikDijagnoza;
   public java.util.Collection<Izvestaj> izvestaj;*/
   
   
   
}