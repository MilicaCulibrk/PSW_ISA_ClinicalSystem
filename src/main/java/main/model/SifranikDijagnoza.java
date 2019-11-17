package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SifranikDijagnoza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public SifranikDijagnoza(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "SifranikDijagnoza [id=" + id + "]";
	}
   
	
	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	   @JoinColumn(name = "zdravstveniKarton_id", referencedColumnName = "id")
	public ZdravstveniKarton zdravstveniKarton;

	public ZdravstveniKarton getZdravstveniKarton() {
		return zdravstveniKarton;
	}

	public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
		this.zdravstveniKarton = zdravstveniKarton;
	}
	
	
	
}