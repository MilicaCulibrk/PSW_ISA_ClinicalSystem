package test.com.example.demo.example;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;

import main.dto.KlinikaDTO;
import main.dto.LekarDTO;
import main.dto.PregledDTO;
import main.dto.SalaDTO;
import main.dto.TipPregledaDTO;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.Sala;
import main.model.TipPregleda;

public class DodajPregledTests extends PregledServiceTest{
	
	Long IDlekar = (long) 1;
	Long IDsala = (long) 1;
	Long IDtipPregleda = (long) 1;
	Long IDpregled = (long) 1;
	Long IDpacijentdto = (long) 1;
	Long IDsaladto = (long) 1;
	Long IDpregleddto = (long) 1;
	Long IDlekardto = (long) 1;
	Long IDklinikadto = (long) 1;

	@Test
	public void trebaPozvatiLekaraRep_kadaSeMetodaPozove() {
		Mockito.doReturn(getLekar()).when(lekarRepository).findById(Mockito.eq(IDlekar));
		Mockito.doReturn(getSala()).when(salaKlinikeRepository).getOne(any(Long.class));
		Mockito.doReturn(getTipPregleda()).when(tipPregledaRepository).getOne(any(Long.class));
		Mockito.doReturn(getSalaList()).when(salaKlinikeRepository).findAll();

		PregledDTO pregledDTO = pregledDTO();
		
		service.dodajPregled(pregledDTO);
		
		Mockito.verify(lekarRepository, Mockito.times(1)).findById(Mockito.eq(IDlekar));
	}
	
	@Test
	public void trebaPozvatiSalaRep_kadaSeMetodaPozove() {
		Mockito.doReturn(getLekar()).when(lekarRepository).findById(any(Long.class));
		Mockito.doReturn(getSala()).when(salaKlinikeRepository).getOne(Mockito.eq(IDsala));
		Mockito.doReturn(getTipPregleda()).when(tipPregledaRepository).getOne(any(Long.class));
		Mockito.doReturn(getSalaList()).when(salaKlinikeRepository).findAll();
		
		PregledDTO pregledDTO = pregledDTO();
		
		service.dodajPregled(pregledDTO);
		
		Mockito.verify(salaKlinikeRepository, Mockito.times(1)).getOne(Mockito.eq(IDsala));
		Mockito.verify(salaKlinikeRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	public void trebaPozvatiTipPregledaRep_kadaSeMetodaPozove() {
		Mockito.doReturn(getLekar()).when(lekarRepository).findById(any(Long.class));
		Mockito.doReturn(getSala()).when(salaKlinikeRepository).getOne(any(Long.class));
		Mockito.doReturn(getTipPregleda()).when(tipPregledaRepository).getOne(Mockito.eq(IDtipPregleda));
		Mockito.doReturn(getSalaList()).when(salaKlinikeRepository).findAll();	
		
		PregledDTO pregledDTO = pregledDTO();
		
		service.dodajPregled(pregledDTO);
		
		Mockito.verify(tipPregledaRepository, Mockito.times(1)).getOne(Mockito.eq(IDtipPregleda));
	}
	
	@Test
	public void trebaSacuvatiPregled_kadaSeMetodaPozove() {
		Mockito.doReturn(getLekar()).when(lekarRepository).findById(any(Long.class));
		Mockito.doReturn(getSala()).when(salaKlinikeRepository).getOne(any(Long.class));
		Mockito.doReturn(getTipPregleda()).when(tipPregledaRepository).getOne(any(Long.class));
		Mockito.doReturn(getSalaList()).when(salaKlinikeRepository).findAll();	
		
		PregledDTO pregledDTO = pregledDTO();
		
		service.dodajPregled(pregledDTO);
		
		Mockito.verify(pregledRepository, Mockito.times(1)).save(any(Pregled.class));
	}
	
	
	private Optional<Lekar> getLekar() {
		Lekar lekar = new Lekar();
		lekar.setAdresa("Radnicka");
		lekar.setDrzava("Srbija");
		lekar.setGrad("NS");
		lekar.setIme("Ana");
		lekar.setPrezime("Nik");
		lekar.setEmail("bla@gmail.com");
		lekar.setJmbg("123");
		lekar.setId(IDlekar);
		Klinika klinika = new Klinika();
		klinika.setId((long)1);
		lekar.setKlinika(klinika);
		lekar.setBrojRecenzija(0);
		return Optional.of(lekar);
	}
	
	private Sala getSala() {
		Sala sala = new Sala();
		sala.setId(IDsala);
		Pregled pregled = new Pregled();
		pregled.setId(IDpregled);
		Collection<Pregled> pregledi = new ArrayList<Pregled>();
		pregledi.add(pregled);
		sala.setPregledi(pregledi);
		return sala;
	}
	
	private TipPregleda getTipPregleda() {
		TipPregleda tp = new TipPregleda();
		tp.setId(IDtipPregleda);
		tp.setNaziv("naziv");
		return tp;
	}
	
	private PregledDTO pregledDTO() {
		PregledDTO pregleddto = new PregledDTO();
		pregleddto.setId(IDpregleddto);
		pregleddto.setCena("");
		pregleddto.setDatum("");
		pregleddto.setVreme("");
		TipPregledaDTO tpdto = new TipPregledaDTO();
		tpdto.setId(IDtipPregleda);
		pregleddto.setTipPregleda(tpdto);
		pregleddto.setIdPacijenta(IDpacijentdto);
		pregleddto.setTrajanjePregleda(1);
		LekarDTO lekar = new LekarDTO();
		lekar.setId(IDlekar);
		pregleddto.setLekar(lekar);
		SalaDTO saladto = new SalaDTO();
		saladto.setId((long)1);
		saladto.setNaziv("nes");
		saladto.setBroj(2);
		KlinikaDTO klinikadto = new KlinikaDTO();
		klinikadto.setId(IDklinikadto);
		saladto.setKlinika(klinikadto);
		pregleddto.setSala(saladto);
		return pregleddto;
	}
	
	private List<Sala> getSalaList() {
		ArrayList<Sala> result = new ArrayList<Sala>();
		
		result.add(getSala());
		
		return result;
	}
}
