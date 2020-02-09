package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.MedicinskaSestra;

public interface MedicinskaSestraRepository extends JpaRepository<MedicinskaSestra,Long> {
	MedicinskaSestra findByEmail( String mail );

}