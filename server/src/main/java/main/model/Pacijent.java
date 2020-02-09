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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.dto.PacijentDTO;

@Entity
@Getter @Setter @NoArgsConstructor 

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
/*
  

   

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
*/

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