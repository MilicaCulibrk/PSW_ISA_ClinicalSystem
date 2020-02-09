package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

public class Dijagnoza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sifra", nullable = false)
	   private String sifra;
	
	@Column(name = "naziv", nullable = false)
   private String naziv;


	public Dijagnoza(String sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}

	
}
