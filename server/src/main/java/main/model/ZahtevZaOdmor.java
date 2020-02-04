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

@Entity
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
	
	public ZahtevZaOdmor() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	

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





	public Boolean getOdobren() {
		return odobren;
	}






	public void setOdobren(Boolean odobren) {
		this.odobren = odobren;
	}






	public String getStartDate() {
		return startDate;
	}






	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}






	public String getEndDate() {
		return endDate;
	}






	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}






	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public MedicinskaSestra getMedicinskaSestra() {
		return medicinskaSestra;
	}


	public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}


	public Lekar getLekar() {
		return lekar;
	}


	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}


	@Override
	public String toString() {
		return "ZahtevZaOdmor [id=" + id + ", medicinskaSestra=" + medicinskaSestra + ", lekar=" + lekar + "]";
	}
   
   

}