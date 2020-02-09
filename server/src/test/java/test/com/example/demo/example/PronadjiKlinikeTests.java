package test.com.example.demo.example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.TipPregleda;
import main.model.ZahtevZaOdmor;

public class PronadjiKlinikeTests extends KlinikaServiceTest{
	Long IDlekar = (long) 1;
	Long IDklinika = (long) 1;
	Long IDtp = (long) 1;
	Long IDpregled = (long) 1;
	Long IDzzo = (long) 1;
	Long IDsaladto = (long) 1;
	Long IDpregleddto = (long) 1;
	Long IDlekardto = (long) 1;
	Long IDklinikadto = (long) 1;
	
	@Test
	public void trebaPozvatiLekarRep_kadaSeMetodaPozove() throws ParseException {
		Mockito.doReturn(getLekari()).when(lekarRepository).findAll();
		Mockito.doReturn(getKlinike()).when(klinikaRepository).findAll();
		Mockito.doReturn(getPregledi()).when(pregledRepository).findAll();
		
		service.pronadjiKlinike("2020-02-02T00:00:00", "kardio");

		Mockito.verify(lekarRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	public void trebaPozvatiKlinikaRep_kadaSeMetodaPozove() throws ParseException {
		Mockito.doReturn(getLekari()).when(lekarRepository).findAll();
		Mockito.doReturn(getKlinike()).when(klinikaRepository).findAll();
		Mockito.doReturn(getPregledi()).when(pregledRepository).findAll();
		
		service.pronadjiKlinike("2020-02-02T00:00:00", "kardio");

		Mockito.verify(klinikaRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	public void trebaPozvatiPregledRep_kadaSeMetodaPozove() throws ParseException {
		Mockito.doReturn(getLekari()).when(lekarRepository).findAll();
		Mockito.doReturn(getKlinike()).when(klinikaRepository).findAll();
		Mockito.doReturn(getPregledi()).when(pregledRepository).findAll();
		
		service.pronadjiKlinike("2020-02-02T00:00:00", "kardio");

		Mockito.verify(pregledRepository, Mockito.times(1)).findAll();
	}
	
	
	private Klinika getKlinika() {
		Klinika klinika = new Klinika();
		klinika.setId(IDklinika);
		return klinika;
	}
	
	private Lekar getLekar() {
		Lekar lekar= new Lekar();
		lekar.setId(IDlekar);
		lekar.setTipPregleda(getTipPregleda());
		lekar.setKraj(1);
		lekar.setPocetak(1);
		lekar.setKlinika(getKlinika());
		return lekar;
	}
	
	private Pregled getPregled() {
		Pregled pregled = new Pregled();
		pregled.setId(IDpregled);
		pregled.setLekar(getLekar());
		pregled.setDatum("");
		pregled.setTrajanje(1);
		return pregled;
	}
	
	private TipPregleda getTipPregleda() {
		TipPregleda tp = new TipPregleda();
		tp.setId(IDtp);
		tp.setNaziv("");
		return tp;
	}
	
	private ZahtevZaOdmor getZahtevZaOdmor() {
		ZahtevZaOdmor zzo = new ZahtevZaOdmor();
		zzo.setId(IDzzo);
		zzo.setStartDate("");
		zzo.setEndDate("");
		return zzo;
	}
	
	private ArrayList<Klinika> getKlinike(){
		ArrayList<Klinika> klinike = new ArrayList<Klinika>();
		klinike.add(getKlinika());
		return klinike;
	}
	private ArrayList<Lekar> getLekari(){
		ArrayList<Lekar> lekari = new ArrayList<Lekar>();
		lekari.add(getLekar());
		return lekari;
	}
	private ArrayList<Pregled> getPregledi(){
		ArrayList<Pregled> pregledi = new ArrayList<Pregled>();
		pregledi.add(getPregled());
		return pregledi;
	}
	private ArrayList<ZahtevZaOdmor> getZahteviZaOdmor(){
		ArrayList<ZahtevZaOdmor> zahtevi = new ArrayList<ZahtevZaOdmor>();
		zahtevi.add(getZahtevZaOdmor());
		return zahtevi;
	}
}
