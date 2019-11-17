package main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RadniKalendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @OneToMany(mappedBy = "radniKalendar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Lekar> lekar;


		@OneToMany(mappedBy = "radniKalendar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL) 
	   public java.util.Collection<MedicinskaSestra> medicinskaSestra;
	 
	public RadniKalendar(Long id, Collection<Lekar> lekar, Collection<MedicinskaSestra> medicinskaSestra) {
		super();
		this.id = id;
		this.lekar = lekar;
		this.medicinskaSestra = medicinskaSestra;
	}



	public RadniKalendar() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public java.util.Collection<Lekar> getLekar() {
		return lekar;
	}



	public void setLekar(java.util.Collection<Lekar> lekar) {
		this.lekar = lekar;
	}



	public java.util.Collection<MedicinskaSestra> getMedicinskaSestra() {
		return medicinskaSestra;
	}



	public void setMedicinskaSestra(java.util.Collection<MedicinskaSestra> medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}



	@Override
	public String toString() {
		return "RadniKalendar [id=" + id + ", lekar=" + lekar + ", medicinskaSestra=" + medicinskaSestra + "]";
	}



   
   
   
}