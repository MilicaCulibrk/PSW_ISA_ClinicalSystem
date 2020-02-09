package main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

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




   
   
   
}