package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.AdministratorKlinike;

public interface AdminKlinikeRepository extends JpaRepository<AdministratorKlinike, Long> {
	AdministratorKlinike findByEmail( String mail );
}