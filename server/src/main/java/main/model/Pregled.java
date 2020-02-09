package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
@EqualsAndHashCode
public class Pregled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EqualsAndHashCode.Exclude private Long id;
	
	@Column(name = "datum", nullable = false)
    private String datum;
	
	@Column(name = "vreme", nullable = false)
    private String vreme;
	
	
	@Column(name = "trajanje", nullable = false)
    private Integer trajanje;
	
	@Column(name = "cena", nullable = false)
    private String cena;
	
	@Column(name = "zavrsen", nullable = false)
    private boolean zavrsen;
	
	@Column(name = "vrsta_pregleda", nullable = false)
    private String vrstaPregleda;
   
	@Column(name = "id_pacijenta", nullable = true, unique = false)
	private Long idPacijenta;
   
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "lekar_id")
	private Lekar lekar;
    
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tip_pregleda_id")
	private TipPregleda tipPregleda;
	


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pregled p = (Pregled) obj;
		if(this.id ==  p.id ) {
			return true;
		}
		else {
			return false;
		}

	}
}