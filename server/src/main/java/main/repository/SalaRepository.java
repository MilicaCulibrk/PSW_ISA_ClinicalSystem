package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Sala;

public interface SalaRepository extends JpaRepository<Sala,Long> {

}
