package test.com.example.demo.example;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;
import main.repository.ZahtevZaPregledRepository;
import main.service.ZahtevZaPregledService;
import test.com.example.demo.TestBase;

public class ZahtevZaPregledServiceTest extends TestBase<ZahtevZaPregledService> {
	//@Autowired
	protected final PregledRepository pregledRepository = Mockito.mock(PregledRepository.class);
	protected final ZahtevZaPregledRepository zahteZaPregledRepository = Mockito.mock(ZahtevZaPregledRepository.class);

	//@Autowired
	protected final LekarRepository lekarRepository = Mockito.mock(LekarRepository.class);
	
	//@Autowired
	protected final SalaRepository salaKlinikeRepository = Mockito.mock(SalaRepository.class);
	
	//@Autowired
	protected final TipPregledaRepository tipPregledaRepository = Mockito.mock(TipPregledaRepository.class);

	protected final ZahtevZaPregledRepository zahtevZaPregledRepository = Mockito.mock(ZahtevZaPregledRepository.class);
	protected final AdminKlinikeRepository adminKlinikeRepository= Mockito.mock(AdminKlinikeRepository.class);
	
	@Override
	@BeforeEach

	protected void init() {
		service = new ZahtevZaPregledService(lekarRepository, salaKlinikeRepository, tipPregledaRepository, zahteZaPregledRepository, 
				pregledRepository, adminKlinikeRepository);
	}
}
