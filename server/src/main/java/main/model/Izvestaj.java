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
	
	@Column(name = "datumVreme", nullable = false)
   private int datumVreme;
	
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

public Izvestaj(Long id, int datumVreme, String opis, Pacijent pacijent) {
	super();
	this.id = id;
	this.datumVreme = datumVreme;
	this.opis = opis;
	this.pacijent = pacijent;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getDatumVreme() {
	return datumVreme;
}

public void setDatumVreme(int datumVreme) {
	this.datumVreme = datumVreme;
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
	return "Izvestaj [id=" + id + ", datumVreme=" + datumVreme + ", opis=" + opis + ", pacijent=" + pacijent
			+ ", lekar=" + lekar + ", zdravstveniKarton=" + zdravstveniKarton + "]";
}
   
   
}