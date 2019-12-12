package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ZdravstveniKarton;

public interface ZdravstveniKartonRepository  extends JpaRepository<ZdravstveniKarton,Long> {
	

}
