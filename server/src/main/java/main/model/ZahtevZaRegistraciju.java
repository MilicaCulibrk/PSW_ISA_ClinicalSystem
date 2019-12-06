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

@Entity
public class ZahtevZaRegistraciju {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "status", nullable = false)
	    private String status;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
	    private Pacijent pacijent;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "admin_id", nullable = false)
	    private AdministratorKlinickogCentra adminKC;
	    
	    public ZahtevZaRegistraciju() {
	        this.status = "NA_CEKANJU";
	    }
	    
	    public ZahtevZaRegistraciju(Long id, Pacijent pacijent) {
	        this.id = id;
	        this.pacijent = pacijent;
	        this.status = "NA_CEKANJU";
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Pacijent getPacijent() {
			return pacijent;
		}

		public void setPacijent(Pacijent pacijent) {
			this.pacijent = pacijent;
		}

		public AdministratorKlinickogCentra getAdminKC() {
			return adminKC;
		}

		public void setAdminKC(AdministratorKlinickogCentra adminKC) {
			this.adminKC = adminKC;
		}

	    

}