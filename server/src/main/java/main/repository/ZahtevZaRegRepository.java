package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ZahtevZaRegistraciju;


public interface ZahtevZaRegRepository extends JpaRepository<ZahtevZaRegistraciju, Long>{

	
}