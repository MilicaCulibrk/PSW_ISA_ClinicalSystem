package main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

public class Recept {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicinskaSestra_id", referencedColumnName = "id")
   public MedicinskaSestra medicinskaSestra;
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lekar_id", referencedColumnName = "id")
   public Lekar lekar;



	public Recept(Long id, MedicinskaSestra medicinskaSestra, Lekar lekar) {
		super();
		this.id = id;
		this.medicinskaSestra = medicinskaSestra;
		this.lekar = lekar;
	}

	
}