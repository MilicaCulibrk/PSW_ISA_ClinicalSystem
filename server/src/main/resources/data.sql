INSERT INTO public.klinika(
	id, adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
	VALUES (nextval('klinika_id_seq'), 'Jovana Obrenovica 83A', '5', 'klinika@klinika.com', 'Podgorica', 'Crna Gora',  'Bolnica', 3.5, 'Vrlo lepo', '+381/61-5534209');	

INSERT INTO public.administrator_klinike(
	id, adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES (nextval('administrator_klinike_id_seq'),'Marsala Tita 58','Srbija', 'an@gmail.com', 'Novi Sad', 'Ana', '012123', 'ana',  'Nikolasevic', '+381/61-5534209');
	
INSERT INTO public.administrator_klinickog_centra(
	id, adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES (nextval('administrator_klinickog_centra_id_seq'),'Marsala Tita 58','Srbija', 'mc@gmail.com', 'Novi Sad', 'Milica', '012123', 'milica',  'Culibrk', '+381/61-5534209');
	
INSERT INTO public.pacijent(
	id, adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES (nextval('pacijent_id_seq'),'Marsala Tita 58','Srbija', 'ss@gmail.com', 'Novi Sad', 'Stasa', '012123', 'stasa',  'Skoric', '+381/61-5534209');
	
INSERT INTO public.medicinska_sestra(
	id, adresa, drzava,  email, grad, ime, jmbg, lozinka, ocena, prezime, telefon)
	VALUES (nextval('pacijent_id_seq'),'Marsala Tita 58','Srbija', 'mm@gmail.com', 'Novi Sad', 'Masa', '012123', 'masa', 5, 'Matovic', '+381/61-5534209');
	
INSERT INTO public.lekar(
	id, adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon)
	VALUES (nextval('pacijent_id_seq'),'Marsala Tita 58',  '5', 'Srbija', 'pb@gmail.com', 'Novi Sad', 'Peca', '012123', 'peca', 5, 'Basic', '+381/61-5534209');



