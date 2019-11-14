package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class AdministratorKlinickogCentra {
	
	public AdministratorKlinickogCentra() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	@Column(name = "ime", nullable = false)
   private String ime;

	@Column(name = "prezime", nullable = false)
   private String prezime;

	@Column(name = "email", nullable = false)
   private String email;
 
	@Column(name = "lozinka", nullable = false)
   private String lozinka;

	@Column(name = "adresa", nullable = false)
   private String adresa;

	@Column(name = "grad", nullable = false)
   private String grad;

	@Column(name = "drzava", nullable = false)
   private String drzava;
  
	@Column(name = "telefon", nullable = false)
   private String telefon;
  
	@Column(name = "jmbg", nullable = false)
   private String jmbg;
   
 
   public KlinickiCentar klinickiCentar;
   
   
   public KlinickiCentar getKlinickiCentar() {
      return klinickiCentar;
   }
  
   public void setKlinickiCentar(KlinickiCentar newKlinickiCentar) {
      if (this.klinickiCentar == null || !this.klinickiCentar.equals(newKlinickiCentar))
      {
         if (this.klinickiCentar != null)
         {
            KlinickiCentar oldKlinickiCentar = this.klinickiCentar;
            this.klinickiCentar = null;
            oldKlinickiCentar.removeAdministratorKlinickogCentra(this);
         }
         if (newKlinickiCentar != null)
         {
            this.klinickiCentar = newKlinickiCentar;
            this.klinickiCentar.addAdministratorKlinickogCentra(this);
         }
      }
   }

}