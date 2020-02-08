package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.OcenaKlinike;

@Repository
public interface OcenaKlinikeRepository extends JpaRepository<OcenaKlinike,Long> {

}
