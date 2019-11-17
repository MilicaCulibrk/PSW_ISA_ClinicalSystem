package main.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ZahtevZaRegistraciju {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	   @OneToMany(mappedBy = "zahtevZaRegistraciju")
   public java.util.Collection<NeautentifikovaniKorisnik> neautentifikovaniKorisnik;

	public ZahtevZaRegistraciju() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZahtevZaRegistraciju(Long id, Collection<NeautentifikovaniKorisnik> neautentifikovaniKorisnik) {
		super();
		this.id = id;
		this.neautentifikovaniKorisnik = neautentifikovaniKorisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Collection<NeautentifikovaniKorisnik> getNeautentifikovaniKorisnik() {
		return neautentifikovaniKorisnik;
	}

	public void setNeautentifikovaniKorisnik(java.util.Collection<NeautentifikovaniKorisnik> neautentifikovaniKorisnik) {
		this.neautentifikovaniKorisnik = neautentifikovaniKorisnik;
	}

	@Override
	public String toString() {
		return "ZahtevZaRegistraciju [id=" + id + ", neautentifikovaniKorisnik=" + neautentifikovaniKorisnik + "]";
	}
   
   

}