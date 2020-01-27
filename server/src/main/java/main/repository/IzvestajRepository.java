package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Izvestaj;

public interface IzvestajRepository extends JpaRepository<Izvestaj, Long>{

}
