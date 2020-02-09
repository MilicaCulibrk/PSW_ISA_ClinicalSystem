package main.model;

import java.util.ArrayList;
/***********************************************************************
 * Module:  Klinika.java
 * Author:  23nik
 * Purpose: Defines the Class Klinika
 ***********************************************************************/
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Setter
@Getter
@NoArgsConstructor 
public class Klinika {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv", nullable = false)
   private String naziv;
	
	@Column(name = "adresa", nullable = false)
   private String adresa;
	
	@Column(name = "email", nullable = false)
   private String email;
	
	@Column(name = "grad", nullable = false)
   private String grad;
	
	@Column(name = "drzava", nullable = false)
	   private String drzava;
	
	@Column(name = "telefon", nullable = false)
   private String telefon;
	
	@Column(name = "opis", nullable = false)
   private String opis;
	
	@Column(name = "ocena", nullable = true)
   private double ocena;
	
	@Column(name = "brojRecenzija", nullable = true)
   private int brojRecenzija;
   
   
   



@ManyToMany(mappedBy = "klinika")
   public java.util.Collection<Pacijent> pacijent;
   
   
   @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinickiCentar_id", referencedColumnName = "id")
   public KlinickiCentar klinickiCentar;
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Cenovnik> cenovnik;
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<MedicinskaSestra> medicinskaSestra;
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<AdministratorKlinike> administratorKlinike;
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Lekar> lekar;
   
    @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private Collection<TipPregleda> tipPregleda = new HashSet<TipPregleda>();


   @OneToMany(mappedBy = "klinika",  cascade = CascadeType.ALL)
   public   List<OcenaKlinike> ocenaKlinike = new ArrayList<OcenaKlinike>();
   	 


	
	public Klinika(Long id, String naziv, String adresa, String email, String grad, String drzava, String telefon,
			String opis, Double ocena, int brojRecenzija, Collection<Pacijent> pacijent, KlinickiCentar klinickiCentar,
			Collection<Cenovnik> cenovnik, Collection<MedicinskaSestra> medicinskaSestra,
			Collection<AdministratorKlinike> administratorKlinike, Collection<Lekar> lekar, Collection<Pregled> pregled,
			Collection<TipPregleda> tipPregleda) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.opis = opis;
		this.ocena = ocena;
		this.brojRecenzija = brojRecenzija;
		this.pacijent = pacijent;
		this.klinickiCentar = klinickiCentar;
		this.cenovnik = cenovnik;
		this.medicinskaSestra = medicinskaSestra;
		this.administratorKlinike = administratorKlinike;
		this.lekar = lekar;
	
		this.tipPregleda = tipPregleda;
	}
	
	public void setOcena(java.util.Collection<OcenaKlinike> ocenaKlinike) {
		
		int suma=0;
		int duzina=0;
		
		
		ocenaKlinike.remove(ocenaKlinike.size());
			// System.out.println(ocenaKlinike.size());
		
		for(OcenaKlinike o: ocenaKlinike) {
			duzina=duzina+1;
			suma= suma+ o.getOcena();
			//System.out.println(o.getOcena());
			

		}
		this.ocena=(double) (suma/duzina);
	}
	
	
/*	
	public String getDrzava() {
		return drzava;
	}
	
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
	public double getOcena() {
		return ocena;
	}




	public int getBrojRecenzija() {
		return brojRecenzija;
	}
	
	public void setBrojRecenzija(int brojRecenzija) {
		this.brojRecenzija = brojRecenzija;
	}
	
	public java.util.Collection<Pacijent> getPacijent() {
		return pacijent;
	}
	
	public void setPacijent(java.util.Collection<Pacijent> pacijent) {
		this.pacijent = pacijent;
	}
	

	



	public List<OcenaKlinike> getOcenaKlinike() {
		return ocenaKlinike;
	}

	public void setOcenaKlinike(List<OcenaKlinike> ocenaKlinike) {
		this.ocenaKlinike = ocenaKlinike;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public KlinickiCentar getKlinickiCentar() {
		return klinickiCentar;
	}
	
	public void setKlinickiCentar(KlinickiCentar klinickiCentar) {
		this.klinickiCentar = klinickiCentar;
	}
	
	public java.util.Collection<Cenovnik> getCenovnik() {
		return cenovnik;
	}
	
	public void setCenovnik(java.util.Collection<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	public java.util.Collection<MedicinskaSestra> getMedicinskaSestra() {
		return medicinskaSestra;
	}
	
	public void setMedicinskaSestra(java.util.Collection<MedicinskaSestra> medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}
	
	public java.util.Collection<AdministratorKlinike> getAdministratorKlinike() {
		return administratorKlinike;
	}
	
	public void setAdministratorKlinike(java.util.Collection<AdministratorKlinike> administratorKlinike) {
		this.administratorKlinike = administratorKlinike;
	}
	
	public java.util.Collection<Lekar> getLekar() {
		return lekar;
	}
	
	public void setLekar(java.util.Collection<Lekar> lekar) {
		this.lekar = lekar;
	}
	

	
	
	public Collection<TipPregleda> getTipPregleda() {
		return tipPregleda;
	}
	
	public void setTipPregleda(Collection<TipPregleda> tipPregleda) {
		this.tipPregleda = tipPregleda;
	}*/
}