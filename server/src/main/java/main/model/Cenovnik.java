package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cenovnik {
	
	public Cenovnik(Long id, float cena, Klinika klinika) {
		super();
		this.id = id;
		this.cena = cena;
		this.klinika = klinika;
	}


	public Cenovnik() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cena", nullable = false)
   private float cena;
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
   public Klinika klinika;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public float getCena() {
		return cena;
	}


	public void setCena(float cena) {
		this.cena = cena;
	}


	public Klinika getKlinika() {
		return klinika;
	}


	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}


	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", cena=" + cena + ", klinika=" + klinika + "]";
	}
   
    
   

}