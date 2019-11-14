package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
   public Pacijent pacijent;
   
	 /*  public Lekar lekar;
   public ZdravstveniKarton zdravstveniKarton;*/
   
   
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
   
  
}