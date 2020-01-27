package main.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Izvestaj {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
/*	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "lek_id", referencedColumnName = "id")
  public Lek lek;
  */
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "dijagnoza_id", referencedColumnName = "id")
  public Dijagnoza dijagnoza;
	 @Column(name = "overenRecept", nullable = false)	 
   private Boolean overenRecept;
	@Column(name = "opis", nullable = false)
   private String opis;
   
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
   public Pacijent pacijent;
   
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "lekar_id", referencedColumnName = "id")
   public Lekar lekar;

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ms_id", referencedColumnName = "id")
   public MedicinskaSestra medicinskaSestra;
	 
   @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zdravstveniKarton_id", referencedColumnName = "id")
   public ZdravstveniKarton zdravstveniKarton;
   
   @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
   public java.util.Collection<Lek> lekovi = new ArrayList<Lek>();
   
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


public MedicinskaSestra getMedicinskaSestra() {
	return medicinskaSestra;
}

public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
	this.medicinskaSestra = medicinskaSestra;
}

public Boolean getOverenRecept() {
	return overenRecept;
}

public void setOverenRecept(Boolean overenRecept) {
	this.overenRecept = overenRecept;
}

/*
public Lek getLek() {
	return lek;
}

public void setLek(Lek lek) {
	this.lek = lek;
}
*/
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

public java.util.Collection<Lek> getLekovi() {
	return lekovi;
}

public void setLekovi(java.util.Collection<Lek> lekovi) {
	this.lekovi = lekovi;
}
   
   
}