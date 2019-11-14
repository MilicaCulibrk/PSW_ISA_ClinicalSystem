package main;

/***********************************************************************
 * Module:  Klinika.java
 * Author:  23nik
 * Purpose: Defines the Class Klinika
 ***********************************************************************/

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
		//this.medicinskaSestra = medicinskaSestra;
		//this.administratorKlinike = administratorKlinike;
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
   
   
  /*public java.util.Collection<MedicinskaSestra> medicinskaSestra;
   public java.util.Collection<AdministratorKlinike> administratorKlinike;
   *  public java.util.Collection<Lekar> lekar;
   public KlinickiCentar klinickiCentar;
   public java.util.Collection<Cenovnik> cenovnik;
   public java.util.Collection<Pregled> pregled;
   public java.util.Collection<Sala> sala;*/
   
   
   

}