package test.com.example.demo.example;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import main.repository.KlinikaRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.ZahtevZaOdmorRepository;
import main.service.KlinikaService;
import test.com.example.demo.TestBase;

public class KlinikaServiceTest extends TestBase<KlinikaService>{
	//@Autowired
	protected final KlinikaRepository klinikaRepository = Mockito.mock(KlinikaRepository.class);
	
	//@Autowired
	protected final LekarRepository lekarRepository = Mockito.mock(LekarRepository.class);
	
	//@Autowired
	protected final PregledRepository	pregledRepository = Mockito.mock(PregledRepository.class);
	
	
	//@Autowired
	protected final ZahtevZaOdmorRepository zahtevZaOdmorRepository = Mockito.mock(ZahtevZaOdmorRepository.class);
	
	@Override
	@BeforeEach	
	protected void init() {
		service = new KlinikaService(klinikaRepository, lekarRepository, pregledRepository, zahtevZaOdmorRepository);
	}
}
