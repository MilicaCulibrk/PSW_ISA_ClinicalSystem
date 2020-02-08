package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Lekar;
import main.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent,Long>{
	Pacijent findByEmail( String mail );
	
	List<Pacijent> findAllByOrderByImeAsc();

	List<Pacijent> findAllByOrderByIdAsc();

	List<Pacijent> findAllByOrderByPrezimeAsc();

	List<Pacijent> findAllByOrderByJmbgAsc();

	List<Pacijent> findAllByOrderByEmailAsc();
	
}
