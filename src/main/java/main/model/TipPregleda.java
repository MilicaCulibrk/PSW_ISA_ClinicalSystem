package main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TipPregleda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv", nullable = false)
   private String naziv;
   
	
	 @OneToMany(mappedBy = "tipPregleda", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Pregled> pregled;


	public TipPregleda() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipPregleda(Long id, String naziv, Collection<Pregled> pregled) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pregled = pregled;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public java.util.Collection<Pregled> getPregled() {
		return pregled;
	}


	public void setPregled(java.util.Collection<Pregled> pregled) {
		this.pregled = pregled;
	}


	@Override
	public String toString() {
		return "TipPregleda [id=" + id + ", naziv=" + naziv + ", pregled=" + pregled + "]";
	}
   
   
  
}