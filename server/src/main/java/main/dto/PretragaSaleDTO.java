package main.dto;

public class PretragaSaleDTO {
	
	String naziv;
	Integer broj;
	String datum;
	String vreme;
	
	public PretragaSaleDTO(String naziv, Integer broj, String datum, String vreme) {
		super();
		this.naziv = naziv;
		this.broj = broj;
		this.datum = datum;
		this.vreme = datum;
	}
	public PretragaSaleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getBroj() {
		return broj;
	}
	public void setBroj(Integer broj) {
		this.broj = broj;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	
	


}
