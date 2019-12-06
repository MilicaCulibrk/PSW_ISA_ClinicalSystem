package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Lekar;
import main.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent,Long>{
	Pacijent findByEmail( String mail );
}
