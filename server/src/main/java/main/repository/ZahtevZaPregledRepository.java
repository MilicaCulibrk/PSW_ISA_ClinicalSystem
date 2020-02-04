package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ZahtevZaPregled;

public interface ZahtevZaPregledRepository extends JpaRepository<ZahtevZaPregled, Long>{
	
	List<ZahtevZaPregled> findByLekarId(Long id);

}
