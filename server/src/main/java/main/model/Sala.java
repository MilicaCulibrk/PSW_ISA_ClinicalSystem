package main.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor 

public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv", nullable = false)
   private String naziv;
   
	@Column(name = "broj", nullable = false)
	private Integer broj;

	 @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
     public java.util.Collection<Pregled> pregledi = new ArrayList<Pregled>();

		@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		private Klinika klinika;



}