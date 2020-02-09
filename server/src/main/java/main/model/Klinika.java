package main.model;

/***********************************************************************
 * Module:  Klinika.java
 * Author:  23nik
 * Purpose: Defines the Class Klinika
 ***********************************************************************/
import java.util.Collection;
import java.util.HashSet;

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

import lombok.Builder;
import lombok.EqualsAndHashCode;
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


}