package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.model.Sala;
import main.model.ZahtevZaPregled;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {

	//po id klinike
	@Query("select s from Sala s where s.klinika.id = ?1")
	List<Sala> pronadjiSalePoIdKlinike(Long klinika_id);
	
	
	//po borju
	@Query("select s from Sala s where s.klinika.id = ?2 and s.broj=?1")
	List<Sala> pronadjiSaluPoBrojuiIDKlinike(Integer broj,Long id);
	
	//po nazivu
	@Query("select s from Sala s where s.klinika.id = ?2 and lower(s.naziv) like lower(?1)")
	List<Sala> pronadjiSaluPoNazivuiIDKlinike(String naziv,Long id);
	
	
	
	//po nazivu i broju
    @Query("select s from Sala s where s.id = ?3 and lower(s.naziv)=lower(?1) and  s.broj=?2")
    List<Sala> pronadjiSaluPoNazivuiBrojuiIdKlinike(String naziv,Integer broj,Long id);
	
	
	

		
	
}
