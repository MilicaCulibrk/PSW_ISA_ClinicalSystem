package main.repository;
import main.model.Klinika;
import main.model.Pacijent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KlinikaRepository extends JpaRepository<Klinika,Long> {

	Klinika findByEmail(String email);
	
	List<Klinika> findAllByOrderByNazivAsc();

	List<Klinika> findAllByOrderByAdresaAsc();

	List<Klinika> findAllByOrderByOcenaAsc();

	
	
}
