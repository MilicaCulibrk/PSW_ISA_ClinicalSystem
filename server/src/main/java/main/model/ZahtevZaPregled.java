package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ZahtevZaPregled {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "datum")
		private String datum;
		
		@Column(name = "vreme")
		private String vreme;
		
		@Column(name = "trajanje")
		private Integer trajanje;
		
		@Column(name = "vrstaPregleda")
		private String vrstaPregleda;
		

		@Column(name = "cena")
		private String cena;
		
		@Column(name = "id_pacijenta")
		private Long idPacijenta;
		
		@Column(name = "status")
		private String status;
		
		@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinColumn(name = "sala_id")
		private Sala sala;
		
		@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinColumn(name = "tip_pregleda_id")
		private TipPregleda tipPregleda;
		
		@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinColumn(name = "lekar_id")
		private Lekar lekar;
		
		@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinColumn(name = "lekar1_id")
		private Lekar lekar1;
		
		@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		@JoinColumn(name = "lekar2_id")
		private Lekar lekar2;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Integer getTrajanje() {
			return trajanje;
		}

		public void setTrajanje(Integer trajanje) {
			this.trajanje = trajanje;
		}

		public String getVrstaPregleda() {
			return vrstaPregleda;
		}

		public void setVrstaPregleda(String vrstaPregleda) {
			this.vrstaPregleda = vrstaPregleda;
		}

		public String getCena() {
			return cena;
		}

		public void setCena(String cena) {
			this.cena = cena;
		}

		public Long getIdPacijenta() {
			return idPacijenta;
		}

		public void setIdPacijenta(Long idPacijenta) {
			this.idPacijenta = idPacijenta;
		}

		public Lekar getLekar() {
			return lekar;
		}

		public void setLekar(Lekar lekar) {
			this.lekar = lekar;
		}

		public Lekar getLekar1() {
			return lekar1;
		}

		public void setLekar1(Lekar lekar1) {
			this.lekar1 = lekar1;
		}

		public Lekar getLekar2() {
			return lekar2;
		}

		public void setLekar2(Lekar lekar2) {
			this.lekar2 = lekar2;
		}

		public Sala getSala() {
			return sala;
		}

		public void setSala(Sala sala) {
			this.sala = sala;
		}

		public TipPregleda getTipPregleda() {
			return tipPregleda;
		}

		public void setTipPregleda(TipPregleda tipPregleda) {
			this.tipPregleda = tipPregleda;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
 


	   

}