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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

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



public Izvestaj(Long id,  String opis) {
	super();
	this.id = id;
	this.opis = opis;
}



   
   
}