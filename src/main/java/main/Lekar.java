package main;

/***********************************************************************
 * Module:  Lekar.java
 * Author:  23nik
 * Purpose: Defines the Class Lekar
 ***********************************************************************/

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class Lekar {
	
	@Column(name = "ime", nullable = false)
   private String ime;
	
	@Column(name = "prezime", nullable = false)
   private String prezime;
	
	@Column(name = "email", nullable = false)
   private String email;
	
	@Column(name = "lozinka", nullable = false)
   private String lozinka;
	
	@Column(name = "adresa", nullable = false)
   private String adresa;
	
	@Column(name = "grad", nullable = false)
   private String grad;
	
	@Column(name = "drzava", nullable = false)
   private String drzava;
	
	@Column(name = "telefon", nullable = false)
   private String telefon;
	
	@Column(name = "jmpg", nullable = false)
   private String jmbg;
	
	@Column(name = "ocena", nullable = false)
   private int ocena;
	
	@Column(name = "brojRecenzija", nullable = false)
   private int brojRecenzija;
   
   public java.util.Collection<Pregled> pregled;
   public java.util.Collection<Operacija> operacija;
   public Klinika klinika;
   public RadniKalendar radniKalendar;
   public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor;
   
   
  

}