package main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class ZdravstveniKarton {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dioptrija", nullable = true)
   private String dioptrija;
	
	@Column(name = "alergije", nullable = true)
   private String alergije;
	
	@Column(name = "visina", nullable = true)
   private String visina;
	
	@Column(name = "tezina", nullable = true)
   private String tezina;
   
	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	   @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
	public Pacijent pacijent;

	
	 @OneToMany(mappedBy = "zdravstveniKarton", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	public java.util.Collection<Izvestaj> izvestaj;   
	
	 
	 @OneToMany(mappedBy = "zdravstveniKarton", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)

   public java.util.Collection<SifarnikLekova> sifarnikLekova;
   
	 @OneToMany(mappedBy = "zdravstveniKarton", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)

   public java.util.Collection<SifranikDijagnoza> sifranikDijagnoza;


	public ZdravstveniKarton(Long id, String dioptrija, String alergije, String visina, String tezina,
			Pacijent pacijent, Collection<Izvestaj> izvestaj, Collection<SifarnikLekova> sifarnikLekova,
			Collection<SifranikDijagnoza> sifranikDijagnoza) {
		super();
		this.id = id;
		this.dioptrija = dioptrija;
		this.alergije = alergije;
		this.visina = visina;
		this.tezina = tezina;
		this.pacijent = pacijent;
		this.izvestaj = izvestaj;
		this.sifarnikLekova = sifarnikLekova;
		this.sifranikDijagnoza = sifranikDijagnoza;
	}

	@Override
	public String toString() {
		return "ZdravstveniKarton [id=" + id + ", dioptrija=" + dioptrija + ", alergije=" + alergije + ", visina="
				+ visina + ", tezina=" + tezina + ", pacijent=" + pacijent + ", izvestaj=" + izvestaj
				+ ", sifarnikLekova=" + sifarnikLekova + ", sifranikDijagnoza=" + sifranikDijagnoza + "]";
	}



   
   
   
}