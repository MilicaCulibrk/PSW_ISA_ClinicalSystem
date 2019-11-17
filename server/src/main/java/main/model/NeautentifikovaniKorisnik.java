package main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class NeautentifikovaniKorisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   public NeautentifikovaniKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

   public NeautentifikovaniKorisnik(ZahtevZaRegistraciju zahtevZaRegistraciju) {
	super();
	this.zahtevZaRegistraciju = zahtevZaRegistraciju;
}
   
   @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "zahtevZaRegistraciju_id", referencedColumnName = "id")
	public ZahtevZaRegistraciju zahtevZaRegistraciju;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public ZahtevZaRegistraciju getZahtevZaRegistraciju() {
	return zahtevZaRegistraciju;
}

public void setZahtevZaRegistraciju(ZahtevZaRegistraciju zahtevZaRegistraciju) {
	this.zahtevZaRegistraciju = zahtevZaRegistraciju;
}

@Override
public String toString() {
	return "NeautentifikovaniKorisnik [id=" + id + ", zahtevZaRegistraciju=" + zahtevZaRegistraciju + "]";
}
   
   
  
   
  

}