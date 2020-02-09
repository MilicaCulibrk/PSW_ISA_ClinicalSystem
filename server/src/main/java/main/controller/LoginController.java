package main.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.dto.LekarDTO;
import main.dto.PacijentDTO;
import main.dto.ZahtevZaAutentikacijuDTO;
import main.model.AdministratorKlinickogCentra;
import main.model.AdministratorKlinike;
import main.model.Authority;
import main.model.Lekar;
import main.model.MedicinskaSestra;
import main.model.Pacijent;
import main.model.TokenState;
import main.security.TokenUtils;
import main.service.CustomUserDetailsService;
import main.service.PacijentService;
import main.service.ZahtevZaRegService;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
	
	  @Autowired

	    private TokenUtils tokenUtils;

	    @Autowired

	    private AuthenticationManager authenticationManager;

	    @Autowired
		private ZahtevZaRegService zahtevZaRegService;

	    @Autowired

	    private CustomUserDetailsService userDetailsService;
	    
	    @Autowired
		private PacijentService pacijentService;

	
	
		@RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity<?>  createAuthenticationToken(@RequestBody ZahtevZaAutentikacijuDTO authenticationDTO,

	                                   HttpServletResponse response) throws AuthenticationException {

	        final Authentication authentication = authenticationManager

	                .authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(),

	                        authenticationDTO.getLozinka()));



	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        Object nekiKorisnik = authentication.getPrincipal();
	        System.out.println(nekiKorisnik);


	        if (nekiKorisnik instanceof Pacijent) {
	        	
	        	Pacijent pacijent = (Pacijent) nekiKorisnik;

	        	Collection<?> roles = pacijent.getAuthorities();
	            
	        	String jwt = tokenUtils.generateTokenP(pacijent, (Authority) roles.iterator().next());

	            int expiresIn = tokenUtils.getExpiredIn();

	            return ResponseEntity.ok(new TokenState(jwt, expiresIn));



	        } else if (nekiKorisnik instanceof  Lekar) {

	            Lekar lekar = (Lekar) nekiKorisnik;

	        	Collection<?> roles = lekar.getAuthorities();

	            String jwt = tokenUtils.generateTokenL(lekar, (Authority) roles.iterator().next());

	            int expiresIn = tokenUtils.getExpiredIn();

	            return ResponseEntity.ok(new TokenState(jwt, expiresIn));



	        } else if (nekiKorisnik instanceof MedicinskaSestra) {

	            MedicinskaSestra medicinskaSestra = (MedicinskaSestra) nekiKorisnik;

	        	Collection<?> roles = medicinskaSestra.getAuthorities();

	            String jwt = tokenUtils.generateTokenM(medicinskaSestra, (Authority) roles.iterator().next());

	            int expiresIn = tokenUtils.getExpiredIn();

	            return ResponseEntity.ok(new TokenState(jwt, expiresIn));



	        } else if (nekiKorisnik instanceof AdministratorKlinike) {

	            AdministratorKlinike administratorKlinike = (AdministratorKlinike) nekiKorisnik;


	        	Collection<?> roles = administratorKlinike.getAuthorities();
	        	for (Object object : roles) {
	        		System.out.println(object);
				}
	            String jwt = tokenUtils.generateTokenAK(administratorKlinike,  (Authority) roles.iterator().next());

	            int expiresIn = tokenUtils.getExpiredIn();

	            return ResponseEntity.ok(new TokenState(jwt, expiresIn));



	        } else if (nekiKorisnik instanceof AdministratorKlinickogCentra) {

	            AdministratorKlinickogCentra administratorKlinickogCentra = (AdministratorKlinickogCentra) nekiKorisnik;

	            Collection<?> roles = administratorKlinickogCentra.getAuthorities();

	            String jwt = tokenUtils.generateTokenAC(administratorKlinickogCentra,   (Authority) roles.iterator().next());

	            int expiresIn = tokenUtils.getExpiredIn();

	            return ResponseEntity.ok(new TokenState(jwt, expiresIn));



	        } else {

	        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	        }

	    }
		
		@PostMapping(value = "/posalji")
		public void posalji(@RequestBody PacijentDTO korisnik) {
			
			zahtevZaRegService.posaljiZahtevAdminuKC(korisnik);
		}
}
