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
public class OcenaLekara {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Pacijent pacijent;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Lekar lekar;
	
	@Column(name = "ocena")
	private Integer ocena;

	
	
	public OcenaLekara(Long id, Pacijent pacijent, Lekar lekar, Integer ocena) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.ocena = ocena;
	}

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

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public OcenaLekara() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
