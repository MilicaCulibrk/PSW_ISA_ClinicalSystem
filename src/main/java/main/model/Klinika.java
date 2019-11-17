package main.model;

/***********************************************************************
 * Module:  Klinika.java
 * Author:  23nik
 * Purpose: Defines the Class Klinika
 ***********************************************************************/

import java.util.*;

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

@Entity
public class Klinika {
	
	public Klinika() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Klinika(Long id, String naziv, String adresa, String email, String grad, String telefon, String opis,
			int ocena, int brojRecenzija, Collection<MedicinskaSestra> medicinskaSestra,
			Collection<AdministratorKlinike> administratorKlinike, Collection<Pacijent> pacijent) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.grad = grad;
		this.telefon = telefon;
		this.opis = opis;
		this.ocena = ocena;
		this.brojRecenzija = brojRecenzija;
		this.medicinskaSestra = medicinskaSestra;
		this.administratorKlinike = administratorKlinike;
		this.pacijent = pacijent;
	}

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
	
	@Column(name = "telefon", nullable = false)
   private String telefon;
	
	@Column(name = "opis", nullable = false)
   private String opis;
	
	@Column(name = "ocena", nullable = false)
   private int ocena;
	
	@Column(name = "brojRecenzija", nullable = false)
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
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Pregled> pregled;
   
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Sala> sala;

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

public int getOcena() {
	return ocena;
}

public void setOcena(int ocena) {
	this.ocena = ocena;
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

public java.util.Collection<Pregled> getPregled() {
	return pregled;
}

public void setPregled(java.util.Collection<Pregled> pregled) {
	this.pregled = pregled;
}

public java.util.Collection<Sala> getSala() {
	return sala;
}

public void setSala(java.util.Collection<Sala> sala) {
	this.sala = sala;
}

@Override
public String toString() {
	return "Klinika [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", email=" + email + ", grad=" + grad
			+ ", telefon=" + telefon + ", opis=" + opis + ", ocena=" + ocena + ", brojRecenzija=" + brojRecenzija
			+ ", pacijent=" + pacijent + ", klinickiCentar=" + klinickiCentar + ", cenovnik=" + cenovnik
			+ ", medicinskaSestra=" + medicinskaSestra + ", administratorKlinike=" + administratorKlinike + ", lekar="
			+ lekar + ", pregled=" + pregled + ", sala=" + sala + "]";
}
   
   
   

}