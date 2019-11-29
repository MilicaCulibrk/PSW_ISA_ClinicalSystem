package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Lekar;

public interface LekarRepository extends JpaRepository<Lekar,Long> {
	Lekar findByEmail( String mail );
}