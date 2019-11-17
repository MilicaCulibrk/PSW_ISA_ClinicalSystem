package main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recept {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicinskaSestra_id", referencedColumnName = "id")
   public MedicinskaSestra medicinskaSestra;
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lekar_id", referencedColumnName = "id")
   public Lekar lekar;

	public Recept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recept(Long id, MedicinskaSestra medicinskaSestra, Lekar lekar) {
		super();
		this.id = id;
		this.medicinskaSestra = medicinskaSestra;
		this.lekar = lekar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicinskaSestra getMedicinskaSestra() {
		return medicinskaSestra;
	}

	public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	@Override
	public String toString() {
		return "Recept [id=" + id + ", medicinskaSestra=" + medicinskaSestra + ", lekar=" + lekar + "]";
	}

	
	
}