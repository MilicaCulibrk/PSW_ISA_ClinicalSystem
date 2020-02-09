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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
public class ZahtevZaRegistraciju {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "status", nullable = false)
	    private String status;

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

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "admin_id", nullable = false)
	    private AdministratorKlinickogCentra adminKC;
	    
	    public ZahtevZaRegistraciju() {
	        this.status = "NA_CEKANJU";
	    }
	    
	    public ZahtevZaRegistraciju(Long id, String ime, String prezime, String email, String lozinka, String adresa, String grad,
	    		String drzava, String telefon, String jmbg) {
	        this.id = id;
	        this.ime = ime;
	    	this.prezime = prezime;
	    	this.email = email;
	    	this.lozinka = lozinka;
	    	this.adresa = adresa;
	    	this.grad = grad;
	    	this.drzava = drzava;
	    	this.telefon = telefon;
	    	this.jmbg = jmbg;
	    	this.status = "NA_CEKANJU";
	    }


	    

}