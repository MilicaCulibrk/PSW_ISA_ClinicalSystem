package main.model;

import java.util.ArrayList;
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

@Entity
public class AdministratorKlinike implements UserDetails{
	
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
	@Column(name = "promenjenaLozinka", nullable = false)
	private Boolean promenjenaLozinka;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
   public Klinika klinika;
	
	 @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
     public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor = new ArrayList<ZahtevZaOdmor>();

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "admink_authority",
			joinColumns = @JoinColumn(name = "admink_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;


	public AdministratorKlinike() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdministratorKlinike(Long id, String ime, String prezime, String email, String lozinka, String adresa,
			String grad, String drzava, String telefon, String jmbg, Klinika klinika) {
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
		this.klinika = klinika;
	}

	public java.util.Collection<ZahtevZaOdmor> getZahtevZaOdmor() {
		return zahtevZaOdmor;
	}


	public void setZahtevZaOdmor(java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor) {
		this.zahtevZaOdmor = zahtevZaOdmor;
	}


	public Boolean getPromenjenaLozinka() {
		return promenjenaLozinka;
	}

	public void setPromenjenaLozinka(Boolean promenjenaLozinka) {
		this.promenjenaLozinka = promenjenaLozinka;
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


	public Klinika getKlinika() {
		return klinika;
	}


	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}


	@Override
	public String toString() {
		return "AdministratorKlinike [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email
				+ ", lozinka=" + lozinka + ", adresa=" + adresa + ", grad=" + grad + ", drzava=" + drzava + ", telefon="
				+ telefon + ", jmbg=" + jmbg + ", klinika=" + klinika + "]";
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
   
    

}