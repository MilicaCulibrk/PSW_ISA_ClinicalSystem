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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv", nullable = false)
   private int naziv;
   
	 @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Pregled> pregled;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
   public Klinika klinika;
	
	
	 @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
  public java.util.Collection<Operacija> operacija;


	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sala(Long id, int naziv, Collection<Pregled> pregled, Klinika klinika, Collection<Operacija> operacija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pregled = pregled;
		this.klinika = klinika;
		this.operacija = operacija;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNaziv() {
		return naziv;
	}


	public void setNaziv(int naziv) {
		this.naziv = naziv;
	}


	public java.util.Collection<Pregled> getPregled() {
		return pregled;
	}


	public void setPregled(java.util.Collection<Pregled> pregled) {
		this.pregled = pregled;
	}


	public Klinika getKlinika() {
		return klinika;
	}


	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}


	public java.util.Collection<Operacija> getOperacija() {
		return operacija;
	}


	public void setOperacija(java.util.Collection<Operacija> operacija) {
		this.operacija = operacija;
	}


	@Override
	public String toString() {
		return "Sala [id=" + id + ", naziv=" + naziv + ", pregled=" + pregled + ", klinika=" + klinika + ", operacija="
				+ operacija + "]";
	}


 

	
  

}