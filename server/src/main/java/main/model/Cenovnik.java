package main.model;

import javax.persistence.Column;
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

public class Cenovnik {
	
	public Cenovnik(Long id, float cena, Klinika klinika) {
		super();
		this.id = id;
		this.cena = cena;
		this.klinika = klinika;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cena", nullable = false)
   private float cena;
   
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klinika_id", referencedColumnName = "id")
   public Klinika klinika;



	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", cena=" + cena + ", klinika=" + klinika + "]";
	}
   
    
   

}