package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.AdministratorKlinike;

public interface AdministratorRepository extends JpaRepository<AdministratorKlinike,Long>{

}
