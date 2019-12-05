package main.model;

import java.util.Collection;

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

import main.dto.PacijentDTO;

@Entity
public class Pacijent {
	
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
   
	@OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Pregled> pregled;
 
	@OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Operacija> operacija;
   
   @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   @JoinColumn(name = "zdrastveniKarton_id", referencedColumnName = "id")
   public ZdravstveniKarton zdravstveniKarton;
 
   
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "pacijent_klinika", joinColumns = @JoinColumn(name = "pacijent_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "klinika_id", referencedColumnName = "id"))
   public java.util.Collection<Klinika> klinika;

   @OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Izvestaj> izvestaj;

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
		String drzava, String telefon, String jmbg, Collection<Pregled> pregled, Collection<Operacija> operacija,
		ZdravstveniKarton zdravstveniKarton, Collection<Klinika> klinika, Collection<Izvestaj> izvestaj) {

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
	this.pregled = pregled;
	this.operacija = operacija;
	this.zdravstveniKarton = zdravstveniKarton;
	this.klinika = klinika;
	this.izvestaj = izvestaj;
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

public java.util.Collection<Pregled> getPregled() {
	return pregled;
}

public void setPregled(java.util.Collection<Pregled> pregled) {
	this.pregled = pregled;
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

@Override
public String toString() {
	return "Pacijent [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", lozinka=" + lozinka
			+ ", adresa=" + adresa + ", grad=" + grad + ", drzava=" + drzava + ", telefon=" + telefon + ", jmbg=" + jmbg
			+ ", pregled=" + pregled + ", operacija=" + operacija + ", zdravstveniKarton=" + zdravstveniKarton
			+ ", klinika=" + klinika + ", izvestaj=" + izvestaj + "]";
} 
   
   
    
   

}