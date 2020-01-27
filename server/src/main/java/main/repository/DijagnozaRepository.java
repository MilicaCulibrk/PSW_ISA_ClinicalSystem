package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Dijagnoza;

public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Long>{
	Dijagnoza findBySifra(String sifra);
}
