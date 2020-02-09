package main.model;

import java.util.ArrayList;
/***********************************************************************
 * Module:  Lekar.java
 * Author:  23nik
 * Purpose: Defines the Class Lekar
 ***********************************************************************/
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor 
//@EqualsAndHashCode
@Builder

public class Lekar implements UserDetails{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
   private double ocena;
	
	@Column(name = "pocetak", nullable = false)
	private Integer pocetak;
	
	@Column(name = "kraj", nullable = false)
	private Integer kraj;
	
	@Column(name = "brojRecenzija", nullable = false)
   private int brojRecenzija;

	@Column(name = "promenjenaLozinka", nullable = false)
	private Boolean promenjenaLozinka;
   
	 @OneToMany(mappedBy = "lekar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Izvestaj> izvestaj;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
	 public Klinika klinika;
	 
	 @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	 private TipPregleda tipPregleda;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "radniKalendar_id", referencedColumnName = "id")
	  public RadniKalendar radniKalendar;
	 
	 @OneToMany(mappedBy = "lekar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	 public java.util.Collection<Pregled> pregled = new ArrayList<Pregled>();
	 
	 @OneToMany(mappedBy = "lekar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	 public java.util.Collection<Operacija> operacija;
	 
	 @OneToMany(mappedBy = "lekar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
     public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor = new ArrayList<ZahtevZaOdmor>();
	 
	 @OneToMany(mappedBy = "lekar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
     public java.util.Collection<Recept> recept;
	 
		
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name = "lekar_authority",
	 	joinColumns = @JoinColumn(name = "lekar_id", referencedColumnName = "id"),
	 	inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	 private List<Authority> authorities;










@Override

public Collection<? extends GrantedAuthority> getAuthorities() {

	return this.authorities;

}





@Override

public String getPassword() {

	return lozinka;

}



@Override

public String getUsername() {

	return email;

}



@JsonIgnore

@Override

public boolean isAccountNonExpired() {

	return true;

}



@JsonIgnore

@Override

public boolean isAccountNonLocked() {

	return true;

}



@JsonIgnore

@Override

public boolean isCredentialsNonExpired() {

	return true;

}



@Override

public boolean isEnabled() {

	return true;

}





public Lekar(Long id, String ime, String prezime, String email, String lozinka, String adresa, String grad,
		String drzava, String telefon, String jmbg, double ocena, Integer pocetak, Integer kraj, int brojRecenzija,
		Boolean promenjenaLozinka, Collection<Izvestaj> izvestaj, Klinika klinika, TipPregleda tipPregleda,
		RadniKalendar radniKalendar, Collection<Pregled> pregled, Collection<Operacija> operacija,
		Collection<ZahtevZaOdmor> zahtevZaOdmor, Collection<Recept> recept, List<Authority> authorities) {
	super();
	this.id = id;
	this.ime = ime;
	this.prezime = prezime;
	this.email = email;
	this.lozinka = lozinka;
	this.adresa = adresa;
	this.grad = grad;
	this.drzava = drzava;
	this.telefon = telefon;
	this.jmbg = jmbg;
	this.ocena = ocena;
	this.pocetak = pocetak;
	this.kraj = kraj;
	this.brojRecenzija = brojRecenzija;
	this.promenjenaLozinka = promenjenaLozinka;
	this.izvestaj = izvestaj;
	this.klinika = klinika;
	this.tipPregleda = tipPregleda;
	this.radniKalendar = radniKalendar;
	this.pregled = pregled;
	this.operacija = operacija;
	this.zahtevZaOdmor = zahtevZaOdmor;
	this.recept = recept;
	this.authorities = authorities;
}


    
  

}