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
public class Izvestaj {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "lek_id", referencedColumnName = "id")
  public Lek lek;
  
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "dijagnoza_id", referencedColumnName = "id")
  public Dijagnoza dijagnoza;
	 
	@Column(name = "opis", nullable = false)
   private String opis;
   
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
   public Pacijent pacijent;
   
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "lekar_id", referencedColumnName = "id")
   public Lekar lekar;
   
   @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zdravstveniKarton_id", referencedColumnName = "id")
   public ZdravstveniKarton zdravstveniKarton;
   
   
   /** @pdGenerated default parent getter */
   public Pacijent getPacijent() {
      return pacijent;
   }

public Izvestaj() {
	super();
	// TODO Auto-generated constructor stub
}

public Izvestaj(Long id,  String opis) {
	super();
	this.id = id;
	this.opis = opis;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public Lek getLek() {
	return lek;
}

public void setLek(Lek lek) {
	this.lek = lek;
}

public Dijagnoza getDijagnoza() {
	return dijagnoza;
}

public void setDijagnoza(Dijagnoza dijagnoza) {
	this.dijagnoza = dijagnoza;
}

public String getOpis() {
	return opis;
}

public void setOpis(String opis) {
	this.opis = opis;
}

public Lekar getLekar() {
	return lekar;
}


public void setLekar(Lekar lekar) {
	this.lekar = lekar;
}

public ZdravstveniKarton getZdravstveniKarton() {
	return zdravstveniKarton;
}

public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
	this.zdravstveniKarton = zdravstveniKarton;
}

public void setPacijent(Pacijent pacijent) {
	this.pacijent = pacijent;
}

@Override
public String toString() {
	return "Izvestaj [id=" + id + ",  opis=" + opis + ", pacijent=" + pacijent
			+ ", lekar=" + lekar + ", zdravstveniKarton=" + zdravstveniKarton + "]";
}
   
   
}