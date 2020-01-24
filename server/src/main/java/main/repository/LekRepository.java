package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Lek;

public interface LekRepository extends JpaRepository<Lek, Long>{

}
