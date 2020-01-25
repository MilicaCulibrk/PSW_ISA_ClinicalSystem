package main.model;

/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  23nik
 * Purpose: Defines the Class MedicinskaSestra
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

@Entity
public class MedicinskaSestra implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	
	public MedicinskaSestra(Long id, String ime, String prezime, int ocena, String email, String lozinka, String adresa,
			String grad, String drzava, String telefon, String jmbg, RadniKalendar radniKalendar, Klinika klinika,
			Collection<ZahtevZaOdmor> zahtevZaOdmor) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.ocena = ocena;
		this.email = email;
		this.lozinka = lozinka;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.telefon = telefon;
		this.jmbg = jmbg;
		this.radniKalendar = radniKalendar;
		this.klinika = klinika;
		this.zahtevZaOdmor = zahtevZaOdmor;
	}
	public MedicinskaSestra() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	@Column(name = "promenjenaLozinka", nullable = false)
	private Boolean promenjenaLozinka;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "radniKalendar_id", referencedColumnName = "id")
   public RadniKalendar radniKalendar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
   public Klinika klinika;
	
	 @OneToMany(mappedBy = "medicinskaSestra", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor;

	 @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
		@JoinTable(name = "sestra_authority",
				joinColumns = @JoinColumn(name = "sestra_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
		private List<Authority> authorities;
	 
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
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
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
	public RadniKalendar getRadniKalendar() {
		return radniKalendar;
	}
	public void setRadniKalendar(RadniKalendar radniKalendar) {
		this.radniKalendar = radniKalendar;
	}
	public Klinika getKlinika() {
		return klinika;
	}
	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}
	public java.util.Collection<ZahtevZaOdmor> getZahtevZaOdmor() {
		return zahtevZaOdmor;
	}
	public void setZahtevZaOdmor(java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor) {
		this.zahtevZaOdmor = zahtevZaOdmor;
	}
	@Override
	public String toString() {
		return "MedicinskaSestra [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", ocena=" + ocena + ", email="
				+ email + ", lozinka=" + lozinka + ", adresa=" + adresa + ", grad=" + grad + ", drzava=" + drzava
				+ ", telefon=" + telefon + ", jmbg=" + jmbg + ", radniKalendar=" + radniKalendar + ", klinika="
				+ klinika + ", zahtevZaOdmor=" + zahtevZaOdmor + "]";
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