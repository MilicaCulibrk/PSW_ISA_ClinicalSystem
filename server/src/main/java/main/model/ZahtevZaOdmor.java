package main.model;

import java.util.Date;

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

public class ZahtevZaOdmor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "startDate", nullable = false)
	private String startDate;
	
	@Column(name = "endDate", nullable = false)
	private String endDate;
	
	@Column(name = "odobren", nullable = true)
	private Boolean odobren;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicinskaSestra_id", referencedColumnName = "id")
   public MedicinskaSestra medicinskaSestra;
   

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lekar_id", referencedColumnName = "id")
   public Lekar lekar;
	

	public ZahtevZaOdmor(Long id, String startDate, String endDate, MedicinskaSestra medicinskaSestra) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.medicinskaSestra = medicinskaSestra;
	}

	public ZahtevZaOdmor(Long id, String startDate, String endDate,Lekar lekar) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lekar = lekar;
	}



   

}