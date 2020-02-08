package main.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import main.dto.PacijentDTO;

@Entity
public class Pacijent implements UserDetails{
	
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
	
	@Column(name = "jmbg", nullable = false)
   private String jmbg;
	
	@Column(name = "aktiviran_nalog", nullable = false)
	private boolean aktiviranNalog;
   

	@OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Operacija> operacija;
	
	
   
   @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   @JoinColumn(name = "zdrastveniKarton_id", referencedColumnName = "id")
   private ZdravstveniKarton zdravstveniKarton;
 
   
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "pacijent_klinika", joinColumns = @JoinColumn(name = "pacijent_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "klinika_id", referencedColumnName = "id"))
   public java.util.Collection<Klinika> klinika;

   @OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Izvestaj> izvestaj = new ArrayList<Izvestaj>();
   
   @OneToMany(mappedBy = "pacijent",  cascade = CascadeType.ALL)
   public  Set<OcenaLekara> ocenaLekara = new HashSet<OcenaLekara>();
   
   @OneToMany(mappedBy = "pacijent",  cascade = CascadeType.ALL)
   public  Set<OcenaKlinike> ocenaKlinike = new HashSet<OcenaKlinike>();
   
   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   @JoinTable(name = "pacijent_authority",
           joinColumns = @JoinColumn(name = "pacijent_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
   private List<Authority> authorities;


  

   

public Set<OcenaLekara> getOcenaLekara() {
	return ocenaLekara;
}

public void setOcenaLekara(Set<OcenaLekara> ocenaLekara) {
	this.ocenaLekara = ocenaLekara;
}

public Set<OcenaKlinike> getOcenaKlinike() {
	return ocenaKlinike;
}

public void setOcenaKlinike(Set<OcenaKlinike> ocenaKlinike) {
	this.ocenaKlinike = ocenaKlinike;
}

public Pacijent() {
	super();
	// TODO Auto-generated constructor stub
}

public Pacijent(PacijentDTO pacijentDTO) {
	
	this.id = pacijentDTO.getId();
	this.ime = pacijentDTO.getIme();
	this.prezime = pacijentDTO.getPrezime();
	this.email = pacijentDTO.getEmail();
	this.lozinka = pacijentDTO.getLozinka();
	this.adresa = pacijentDTO.getAdresa();
	this.grad = pacijentDTO.getGrad();
	this.drzava = pacijentDTO.getDrzava();
	this.telefon = pacijentDTO.getTelefon();
	this.jmbg = pacijentDTO.getJmbg();

}

public Pacijent(Long id, String ime, String prezime, String email, String lozinka, String adresa, String grad,
		String drzava, String telefon, String jmbg) {

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
	this.aktiviranNalog = false;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}


public boolean isAktiviranNalog() {
	return aktiviranNalog;
}

public void setAktiviranNalog(boolean aktiviranNalog) {
	this.aktiviranNalog = aktiviranNalog;
} 

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getDrzava() {
	return drzava;
}

public void setDrzava(String drzava) {
	this.drzava = drzava;
}

public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}

public String getJmbg() {
	return jmbg;
}

public void setJmbg(String jmbg) {
	this.jmbg = jmbg;
}





public java.util.Collection<Operacija> getOperacija() {
	return operacija;
}

public void setOperacija(java.util.Collection<Operacija> operacija) {
	this.operacija = operacija;
}

public ZdravstveniKarton getZdravstveniKarton() {
	return zdravstveniKarton;
}

public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
	this.zdravstveniKarton = zdravstveniKarton;
}

public java.util.Collection<Klinika> getKlinika() {
	return klinika;
}

public void setKlinika(java.util.Collection<Klinika> klinika) {
	this.klinika = klinika;
}

public java.util.Collection<Izvestaj> getIzvestaj() {
	return izvestaj;
}

public void setIzvestaj(java.util.Collection<Izvestaj> izvestaj) {
	this.izvestaj = izvestaj;
}

public void setAuthorities(List<Authority> authorities) {

    this.authorities = authorities;

}



@Override

public Collection<? extends GrantedAuthority> getAuthorities() {

    return this.authorities;

}


@Override
public String getPassword() {
	 return this.lozinka;
}

@Override
public String getUsername() {
	 return this.email;
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
   
   
    
   

}