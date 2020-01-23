INSERT INTO public.klinika(adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
VALUES ('Jovana Obrenovica 83A', '5', 'klinika@klinika.com', 'Podgorica', 'Crna Gora',  'Bolnica', 3.5, 'Vrlo lepo', '+381/61-5534209');	

INSERT INTO public.administrator_klinickog_centra(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Marsala Tita 58','Srbija', 'mc@gmail.com', 'Novi Sad', 'Milica', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Culibrk', '+381/61-5534209');
	
INSERT INTO public.pacijent(adresa, aktiviran_nalog, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Marsala Tita 58', 'false', 'Srbija', 'ss@gmail.com', 'Novi Sad', 'stasa', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Skoric', '+381/61-5534209');
	
INSERT INTO public.pacijent(adresa, aktiviran_nalog, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Marsala Tita 58', 'false', 'Srbija', 'ms@gmail.com', 'Novi Sad', 'Milos', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Skoric', '+381/61-5534209');
	

INSERT INTO public.medicinska_sestra( adresa, drzava,  email, grad, ime, jmbg, lozinka, ocena, prezime, telefon)
	VALUES ('Marsala Tita 58','Srbija', 'mm@gmail.com', 'Novi Sad', 'Masa', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Matovic', '+381/61-5534209');
	
INSERT INTO public.sala(
	broj, naziv, klinika_id)
	VALUES (5, 'Sala5', 1);
	
INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
	VALUES ('Pregled bubrega', 'bbr', ' 3000', 1);
	
INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
	VALUES ('Kardio', 'krd', ' 3000', 1);
	
INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj)
	VALUES ('Marsala Tita 58',  '5', 'Srbija', 'pb@gmail.com', 'Novi Sad', 'Peca', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Basic', '+381/61-5534209', 1, 1, 10, 13);
	
INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj)
	VALUES ('Marsala Tita 58',  '5', 'Srbija', 'bb@gmail.com', 'Novi Sad', 'Bojana', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Basic', '+381/61-5534209', 2, 1, 9, 10);
	
INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id)
	VALUES ('5000', '22/01/2019', null, 1, '13', 1, 1, 1);
	
INSERT INTO public.administrator_klinike(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id)
	VALUES ('Marsala Tita 58','Srbija', 'an@gmail.com', 'Novi Sad', 'Ana', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Nikolasevic', '+381/61-5534209', 1);
	
	



INSERT INTO public.authority (uloga) VALUES ('PACIJENT');
INSERT INTO public.authority (uloga) VALUES ('LEKAR');
INSERT INTO public.authority (uloga) VALUES ('MEDICINSKA_SESTRA');
INSERT INTO public.authority (uloga) VALUES ('ADMIN_CENTRA');
INSERT INTO public.authority (uloga) VALUES ('ADMIN_KLINIKE');


INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (1, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (2, 1);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (1, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (2, 2);
INSERT INTO public.admink_authority (admink_id, authority_id) VALUES (1,5);
INSERT INTO public.adminkc_authority (adminkc_id, authority_id) VALUES (1, 4);
INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (1, 3);

