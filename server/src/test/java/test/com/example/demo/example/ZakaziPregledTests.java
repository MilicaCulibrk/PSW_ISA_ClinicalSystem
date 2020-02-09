package test.com.example.demo.example;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.EqualsAndHashCode;
import main.model.Lekar;
import main.model.Pregled;
@EqualsAndHashCode
public class ZakaziPregledTests  extends PregledServiceTest{
	
	Long IDpregled = (long) 1;
	Long IDpacijent = (long) 1;
	Long IDlekar = (long) 1;

	@Test
	public void trebaZakazatiPregled_kadaSeMetodaPozove() {
		
		Pregled pregled = getPregled();
		service.zakaziPregled(IDpacijent, pregled);
		
		Mockito.verify(pregledRepository, Mockito.times(1)).save(any(Pregled.class));
	}
	
	@Test
	public void proveraTacnostiArgumenta_kadaSeMetodaPozove() {
		
		Pregled actual = getPregled();
		Pregled expected  = new Pregled();
		expected.setId(IDpregled);
		service.zakaziPregled(IDpacijent, actual);

 		Assertions.assertEquals(expected, actual);	
 	}
	
	private Lekar getLekar() {
		Lekar lekar= new Lekar();
		lekar.setId(IDlekar);

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
}
