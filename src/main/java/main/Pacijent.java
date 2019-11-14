package main;

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

public Pacijent(Long id, String ime, String prezime, String email, String lozinka, String adresa, String grad,
		String drzava, String telefon, String jmbg, Collection<Pregled> pregled, Collection<Operacija> operacija,
		ZdravstveniKarton zdravstveniKarton, Collection<Klinika> klinika, Collection<Izvestaj> izvestaj) {
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
	this.pregled = pregled;
	this.operacija = operacija;
	this.zdravstveniKarton = zdravstveniKarton;
	this.klinika = klinika;
	this.izvestaj = izvestaj;
} 
   
   
   
   

}