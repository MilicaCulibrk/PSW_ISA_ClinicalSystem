package main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class KlinickiCentar {
	
	public KlinickiCentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "klinickiCentar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra;
   
	@OneToMany(mappedBy = "klinickiCentar", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	   public java.util.Collection<AdministratorKlinickogCentra> klinika;

	public KlinickiCentar(Long id, Collection<AdministratorKlinickogCentra> administratorKlinickogCentra,
			Collection<AdministratorKlinickogCentra> klinika) {
		super();
		this.id = id;
		this.administratorKlinickogCentra = administratorKlinickogCentra;
		this.klinika = klinika;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Collection<AdministratorKlinickogCentra> getAdministratorKlinickogCentra() {
		return administratorKlinickogCentra;
	}

	public void setAdministratorKlinickogCentra(
			java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra) {
		this.administratorKlinickogCentra = administratorKlinickogCentra;
	}

	public java.util.Collection<AdministratorKlinickogCentra> getKlinika() {
		return klinika;
	}

	public void setKlinika(java.util.Collection<AdministratorKlinickogCentra> klinika) {
		this.klinika = klinika;
	}

	@Override
	public String toString() {
		return "KlinickiCentar [id=" + id + ", administratorKlinickogCentra=" + administratorKlinickogCentra
				+ ", klinika=" + klinika + "]";
	}
	   
   
  

}