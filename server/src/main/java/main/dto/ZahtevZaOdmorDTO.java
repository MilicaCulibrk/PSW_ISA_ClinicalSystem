package main.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.ZahtevZaOdmor;

public class ZahtevZaOdmorDTO {

	private Long id;

	private String start;

	private String end;

   public Long medicinskaSestra;

   public Long lekar;

   
   

public ZahtevZaOdmorDTO(ZahtevZaOdmor zzo) {
	super();
	this.id = zzo.getId();
	this.start = zzo.getStartDate();
	this.end = zzo.getEndDate();
	try {
		this.medicinskaSestra = zzo.getMedicinskaSestra().getId();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	try {
		this.lekar = zzo.getLekar().getId();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}

public ZahtevZaOdmorDTO() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}




public String getStart() {
	return start;
}

public void setStart(String start) {
	this.start = start;
}

public String getEnd() {
	return end;
}

public void setEnd(String end) {
	this.end = end;
}

public Long getMedicinskaSestra() {
	return medicinskaSestra;
}

public void setMedicinskaSestra(Long medicinskaSestra) {
	this.medicinskaSestra = medicinskaSestra;
}

public Long getLekar() {
	return lekar;
}

public void setLekar(Long lekar) {
	this.lekar = lekar;
}


   
   
}
