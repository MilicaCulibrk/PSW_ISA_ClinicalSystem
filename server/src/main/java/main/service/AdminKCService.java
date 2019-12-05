package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.AdministratorKlinickogCentra;
import main.repository.AdminKCRepository;

@Service
public class AdminKCService {
	
	@Autowired
	private AdminKCRepository adminKCRepository;
	
	public AdministratorKlinickogCentra findOne(Long id) {
		return adminKCRepository.findById(id).orElseGet(null);
	}

}
