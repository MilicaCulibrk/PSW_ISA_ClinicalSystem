package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pacijent;
import main.repository.AdminKCRepository;
import main.repository.AdminKlinikeRepository;
import main.repository.LekarRepository;
import main.repository.MedicinskaSestraRepository;
import main.repository.PacijentRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
    private PacijentRepository pacijentRepository;

    @Autowired
    private LekarRepository lekarRepository;

    @Autowired
    private MedicinskaSestraRepository medicinskaSestraRepository;

    @Autowired
    private AdminKCRepository adminKCRepository;

    @Autowired
    private AdminKlinikeRepository adminKlinikeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Funkcija koja na osnovu email-a iz baze vraca objekat koji mi treba
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	  
    	  Pacijent pacijent = pacijentRepository.findByEmail(email);
          Lekar lekar = lekarRepository.findByEmail(email);
          MedicinskaSestra medicinskaSestra = medicinskaSestraRepository.findByEmail(email);
          AdministratorKlinickogCentra administratorKlinickogCentra = adminKCRepository.findByEmail(email);
          AdministratorKlinike administratorKlinike = adminKlinikeRepository.findByEmail(email);
          
          if (pacijent != null) {
             return pacijent;
          } else if (lekar != null) {
        	  return lekar;
          } else if (medicinskaSestra != null) {
              return medicinskaSestra;
          } else if (administratorKlinickogCentra != null) {
              return administratorKlinickogCentra;
          } else if (administratorKlinike != null) {
              return administratorKlinike;
          } else {
             throw new UsernameNotFoundException(String.format("Korisnik sa email adresom: '%s' nije pronadjen.", email));
          }
	}
    
    
   
}
