package main.repository;
import main.model.Klinika;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlinikaRepository extends JpaRepository<Klinika,Long> {

}
