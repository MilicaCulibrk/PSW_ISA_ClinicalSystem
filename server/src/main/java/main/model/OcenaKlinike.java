package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OcenaKlinike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Pacijent pacijent;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Klinika klinika;
	
	@Column(name = "ocena",nullable = false)
	private Integer ocena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	
	public OcenaKlinike(Long id, Pacijent pacijent, Klinika klinika, Integer ocena) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.klinika = klinika;
		this.ocena = ocena;
	}

	public OcenaKlinike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
