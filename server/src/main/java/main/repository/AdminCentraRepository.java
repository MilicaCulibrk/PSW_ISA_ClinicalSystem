package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.AdministratorKlinickogCentra;

public interface AdminCentraRepository extends JpaRepository<AdministratorKlinickogCentra, Long> {
	AdministratorKlinickogCentra findByEmail( String mail );
}