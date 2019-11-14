package main;

/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  23nik
 * Purpose: Defines the Class MedicinskaSestra
 ***********************************************************************/

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class MedicinskaSestra {
	
	@Column(name = "ime", nullable = false)
   private String ime;
	
	@Column(name = "prezime", nullable = false)
   private String prezime;
	
	@Column(name = "ocena", nullable = false)
   private int ocena;
	
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
	
	@Column(name = "jmbg", nullable = false)
   private String jmbg;
   
   public RadniKalendar radniKalendar;
   public Klinika klinika;
   public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor;
   
   
   

}