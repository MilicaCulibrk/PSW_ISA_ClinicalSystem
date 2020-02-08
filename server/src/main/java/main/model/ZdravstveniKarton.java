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

@Entity
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

	public ZdravstveniKarton() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDioptrija() {
		return dioptrija;
	}

	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}

	public String getAlergije() {
		return alergije;
	}

	public void setAlergije(String alergije) {
		this.alergije = alergije;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public java.util.Collection<Izvestaj> getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(java.util.Collection<Izvestaj> izvestaj) {
		this.izvestaj = izvestaj;
	}

	public java.util.Collection<SifarnikLekova> getSifarnikLekova() {
		return sifarnikLekova;
	}

	public void setSifarnikLekova(java.util.Collection<SifarnikLekova> sifarnikLekova) {
		this.sifarnikLekova = sifarnikLekova;
	}

	public java.util.Collection<SifranikDijagnoza> getSifranikDijagnoza() {
		return sifranikDijagnoza;
	}

	public void setSifranikDijagnoza(java.util.Collection<SifranikDijagnoza> sifranikDijagnoza) {
		this.sifranikDijagnoza = sifranikDijagnoza;
	}
   
   
   
   
}