package test.com.example.demo.example;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.SalaRepository;
import main.repository.TipPregledaRepository;
import main.service.PregledService;
import test.com.example.demo.TestBase;

public class PregledServiceTest extends TestBase<PregledService> {
	
	//@Autowired
	protected final PregledRepository pregledRepository = Mockito.mock(PregledRepository.class);

	//@Autowired
	protected final LekarRepository lekarRepository = Mockito.mock(LekarRepository.class);
	
	//@Autowired
	protected final SalaRepository salaKlinikeRepository = Mockito.mock(SalaRepository.class);
	
	//@Autowired
	protected final TipPregledaRepository tipPregledaRepository = Mockito.mock(TipPregledaRepository.class);

	
	@Override
	@BeforeEach

	protected void init() {
		service = new PregledService(pregledRepository, lekarRepository, salaKlinikeRepository, tipPregledaRepository);
	}
}
