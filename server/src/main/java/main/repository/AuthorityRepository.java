package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
		Authority findByUloga(String uloga);
	}
