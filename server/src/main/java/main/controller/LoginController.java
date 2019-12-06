package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LoginDTO;
import main.dto.LoginResponseDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pacijent;
import main.service.LoginService;

@RestController
@RequestMapping(value = "prijava")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginDTO user) {

	//	Pacijent pacijent = loginService.findPacijent(user.getEmail());
		MedicinskaSestra medicinskaSestra = loginService.findMedicinskaSestra(user.getEmail());
		Lekar lekar = loginService.findLekar(user.getEmail());
		AdministratorKlinike adminKlinike = loginService.findAdminKlinike(user.getEmail());
		AdministratorKlinickogCentra adminCentra = loginService.findAdminCentra(user.getEmail());

		LoginResponseDTO responseUser = new LoginResponseDTO();
		responseUser.setMail(user.getEmail());

		if ( medicinskaSestra == null && lekar==null && adminKlinike == null && adminCentra == null) {
			System.out.println("Email je nepostojeci");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	/*	if (pacijent != null) {
			if (user.getLozinka().equals(pacijent.getLozinka())) {
				responseUser.setIme(pacijent.getIme());
				responseUser.setPrezime(pacijent.getPrezime());
				responseUser.setUloga("PACIJENT");
			}
		} else*/ if (medicinskaSestra != null) {
			if (user.getLozinka().equals(medicinskaSestra.getLozinka())) {
				responseUser.setIme(medicinskaSestra.getIme());
				responseUser.setPrezime(medicinskaSestra.getPrezime());
				responseUser.setUloga("MEDICINSKA_SESTRA");
			}
		} else if (lekar != null) {
			if (user.getLozinka().equals(lekar.getLozinka())) {
				responseUser.setIme(lekar.getIme());
				responseUser.setPrezime(lekar.getPrezime());
				responseUser.setUloga("LEKAR");
			}
		} else if (adminKlinike != null) {
			if (user.getLozinka().equals(adminKlinike.getLozinka())) {
				responseUser.setIme(adminKlinike.getIme());
				responseUser.setPrezime(adminKlinike.getPrezime());
				responseUser.setUloga("ADMIN_KLINIKE");
			} 
		} else if (adminCentra != null) {
			if (user.getLozinka().equals(adminCentra.getLozinka())) {
				responseUser.setIme("Admin");
				responseUser.setPrezime("Admirovic");
				responseUser.setUloga("ADMIN_CENTRA");
			}
		} else {
			System.out.println("Sifra nije ispravna!");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		System.out.println("Uspesno ste se logovali!");
		return new ResponseEntity<>(responseUser, HttpStatus.OK);
	}

}
