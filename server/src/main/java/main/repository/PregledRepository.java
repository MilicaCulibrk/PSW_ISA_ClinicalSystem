package main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.model.Pregled;

public interface PregledRepository extends JpaRepository<Pregled,Long>{
	
	    
}
