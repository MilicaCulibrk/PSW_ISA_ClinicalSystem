package main.service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.AdminKlinikeDTO;
import main.dto.KlinikaDTO;
import main.model.AdministratorKlinike;
import main.model.Klinika;
import main.model.Lekar;
import main.model.Pregled;
import main.model.Sala;
import main.model.ZahtevZaOdmor;
import main.repository.KlinikaRepository;
import main.repository.LekarRepository;
import main.repository.PregledRepository;
import main.repository.ZahtevZaOdmorRepository;

@Service
public class KlinikaService {
	//@Autowired
	private final KlinikaRepository klinikaRepository;
	
	//@Autowired
	private final LekarRepository	lekarRepository;
	
	//@Autowired
	private final PregledRepository	pregledRepository;
	
	
	//@Autowired
	private final ZahtevZaOdmorRepository	zahtevZaOdmorRepository;
	
	
	
	public KlinikaService(KlinikaRepository klinikaRepository, LekarRepository lekarRepository,
			PregledRepository pregledRepository, ZahtevZaOdmorRepository zahtevZaOdmorRepository) {
		super();
		this.klinikaRepository = klinikaRepository;
		this.lekarRepository = lekarRepository;
		this.pregledRepository = pregledRepository;
		this.zahtevZaOdmorRepository = zahtevZaOdmorRepository;
	}

	public KlinikaDTO dodajKliniku(KlinikaDTO klinikaDTO) {
		Klinika klinika = new Klinika();
		
		klinika.setNaziv(klinikaDTO.getNaziv());
		klinika.setOpis(klinikaDTO.getOpis());
		klinika.setAdresa(klinikaDTO.getAdresa());
		klinika.setGrad(klinikaDTO.getGrad());
		klinika.setDrzava(klinikaDTO.getDrzava());
		klinika.setTelefon(klinikaDTO.getTelefon());
		klinika.setEmail(klinikaDTO.getEmail());
		
		for (Klinika k : klinikaRepository.findAll()) {
			if (klinika.getEmail().equals(k.getEmail())) {
				return null;
			}
		}
		klinikaRepository.save(klinika);
		
		KlinikaDTO klinikadto=new KlinikaDTO(klinika);
		return klinikadto;
	}
	
	public Klinika findOne(Long id) {
		System.out.println("izvolte "+id);
		return klinikaRepository.findById(id).orElseGet(null);
	}


	public List<Klinika> findAll() {
		// TODO Auto-generated method stub
		return klinikaRepository.findAll();
	}
	
	public void izmeniKliniku(KlinikaDTO klinikaDTO) {
		Klinika klinika = klinikaRepository.findById(klinikaDTO.getId()).orElse(null);
		
		if(klinika == null) {
			throw new ValidationException("Admin sa zadatim id-jem ne postoji");
		}
		try {
			klinika = klinikaRepository.getOne(klinikaDTO.getId());
			klinika.setNaziv(klinikaDTO.getNaziv());
			klinika.setOpis(klinikaDTO.getOpis());
			klinika.setAdresa(klinikaDTO.getAdresa());
			klinika.setTelefon(klinikaDTO.getTelefon());
			klinika.setGrad(klinikaDTO.getGrad());
			klinika.setDrzava(klinikaDTO.getDrzava());
			klinikaRepository.save(klinika);
		} catch (EntityNotFoundException e) {
			throw new ValidationException("Admin sa tim id-ijem ne postoji");
		}
	}
	public List<Klinika> pronadjiKlinike( String datum, String tipPregleda) throws ParseException {
		
		//lista klinika koju vracam
		List<Klinika> ret= new ArrayList<Klinika>();
		
		List<Klinika> klinike = new ArrayList<Klinika>();
		klinike=klinikaRepository.findAll();
		
		String datumm=datum;
		
		String[] datum1=datum.split("'");
		
		SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
			Date dtIn = inFormat.parse(datum1[0]);
		
			List<Lekar> lekari  =  new ArrayList<Lekar>();
			lekari=lekarRepository.findAll();
			
			List<Pregled> pregledi  =  new ArrayList<Pregled>();
			pregledi=pregledRepository.findAll();

			List<ZahtevZaOdmor> zahtevi  =  new ArrayList<ZahtevZaOdmor>();
			
					
					int radnoVreme=0;
					int ukupnoTrajanje=0;
					
				for(Lekar l: lekari) {
					
					if(l.getTipPregleda().getNaziv().equals(tipPregleda)) {
						
							radnoVreme = l.getKraj() - l.getPocetak();
							zahtevi= (List<ZahtevZaOdmor>) l.zahtevZaOdmor;
							
							
							if(!zahtevi.isEmpty()) {
							
								
								
							for(ZahtevZaOdmor z: zahtevi) {
						
								String[] pocetak=z.getStartDate().split("'");
								SimpleDateFormat inFormat1 = new SimpleDateFormat("yyyy-MM-dd");
								Date p = inFormat1.parse(pocetak[0]);
									
								
								String[] kraj=z.getEndDate().split("'");
								SimpleDateFormat inFormat2 = new SimpleDateFormat("yyyy-MM-dd");
								Date k = inFormat2.parse(kraj[0]);
									

								if( dtIn.after(k) || dtIn.before(p))  {
									
									System.out.println("ne nalazi se izmedju");
									
									
									for(Pregled pr: pregledi) {
										
										if(pr.getLekar().getId().equals(l.getId()) && pr.getDatum().equals(datumm)) {
										
											System.out.println("pogresio za bojanu");
										 ukupnoTrajanje=(int) (ukupnoTrajanje+pr.getTrajanje());
										}
										}
								
									System.out.println(ukupnoTrajanje);
									System.out.println(radnoVreme);
									
									
											if(radnoVreme - ukupnoTrajanje>=1) {
							
												for(Klinika kl: klinike) {
											
													if(l.getKlinika().getId().equals(kl.getId()) && !ret.contains(kl)) {
														ret.add(kl);
														}
													}
												}
											ukupnoTrajanje=0;
							} else
								System.out.println("nalazi se izmedju");
						}
				} 
				
				else {
							
					
								
								System.out.println("usao u else");
									for(Pregled pr: pregledi) {
										
										if(pr.getLekar().getId().equals(l.getId()) && pr.getDatum().equals(datumm)) {
											System.out.println("usao u dobro za pecu i dimija");
										 ukupnoTrajanje=(int) (ukupnoTrajanje+pr.getTrajanje());
										}
										}
								
											if(radnoVreme- ukupnoTrajanje>=1) {
							
												for(Klinika kl: klinike) {
											
													if(l.getKlinika().getId().equals(kl.getId()) && !ret.contains(kl))
														ret.add(kl);
									
									
								}
							} ukupnoTrajanje=0;
				
						}
					}
				}
				
				
		return ret;
		
		}
}
