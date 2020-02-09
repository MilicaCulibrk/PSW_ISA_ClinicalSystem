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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 

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
		
		@Column(name = "prihvacenOdPacijenta", nullable= true)
		private Boolean prihvacenOdPacijenta;
		
		public Boolean getPrihvacenOdPacijenta() {
			return prihvacenOdPacijenta;
		}

		public void setPrihvacenOdPacijenta(Boolean prihvacenOdPacijenta) {
			this.prihvacenOdPacijenta = prihvacenOdPacijenta;
		}

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


}