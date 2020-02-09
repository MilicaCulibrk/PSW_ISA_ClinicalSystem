
INSERT INTO public.klinika(adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
VALUES ('Radnicka', '5', 'domzdravlja@klinika.com', 'Novi Sad', 'Srbija',  'Dom zdravlja', 3, 'lep', '+381/61-3322111');

INSERT INTO public.klinika(adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
VALUES ('Gogoljeva', '4', 'infektivnabolnica@klinika.com', 'Novi Sad', 'Srbija',  'Infektivna bolnica', 2, 'Vrlo lepo', '+381/61-5534444');

INSERT INTO public.klinika(adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
VALUES ('Dunavska', '3', 'nsklinika@klinika.com', 'Novi Sad', 'Srbija',  'NS Klinika', 5, 'Odlicno', '+381/61-5522244');



INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('3.0', 'nema', ' 1.70m', '70kg');

INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('nema', 'polen', ' 2.10m', '99kg');

INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('1.0', 'astma', ' 1.82m', '70kg');

INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('-1.0', 'nema', ' 1.65m', '65kg');

INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('-2.0', 'nema', ' 1.75m', '72kg');

INSERT INTO public.zdravstveni_karton(dioptrija, alergije, visina, tezina)
VALUES ('-3.0', 'nema', ' 1.74m', '71kg');



INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id, aktiviran_nalog)
VALUES ('Marsala Tita 58', 'Srbija', 'ss@gmail.com', 'Novi Sad', 'Stasa', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Skoric', '+381/61-5535509', 1, false);

INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id, aktiviran_nalog)
VALUES ('Alekse Santica 2', 'Srbija', 'ms@gmail.com', 'Novi Sad', 'Milos', '512123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Skoric', '+381/61-5511209', 2, false);

INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id, aktiviran_nalog)
VALUES ('Kolo Srpskih Sestara 23', 'Srbija', 'am@gmail.com', 'Novi Sad', 'Amanda', '230999', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Mirkovic', '+381/61-3334209', 3, false);

INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id,aktiviran_nalog)
VALUES ('Cara Dusana 21', 'Srbija', 'op@gmail.com', 'Novi Sad', 'Olga', '231914', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Petrovic', '+381/61-1134209', 4, false);

INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id, aktiviran_nalog)
VALUES ('Cara Lazara 23', 'Srbija', 'tp@gmail.com', 'Novi Sad', 'Teodora', '530914', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Petrovic', '+381/61-1134779', 5, false);

INSERT INTO public.pacijent(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, zdrastveni_karton_id, aktiviran_nalog)
VALUES ('Cara Lazara 64', 'Srbija', 'lp@gmail.com', 'Novi Sad', 'Lidija', '538814', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Petrovic', '+381/61-8834779', 6, false);



INSERT INTO public.administrator_klinickog_centra(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, promenjena_lozinka)
VALUES ('Marsala Tita 58','Srbija', 'mc@gmail.com', 'Novi Sad', 'Milica', '012333', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Culibrk', '+381/61-5534209', false);



INSERT INTO public.zahtev_za_registraciju(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, status, admin_id)
VALUES ('Marsala Tita 58', 'Srbija', 'it@gmail.com', 'Novi Sad', 'Isidora', '23091997', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Tepic', '+381/61-5534209', 'NA_CEKANJU', 1);

INSERT INTO public.zahtev_za_registraciju(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, status, admin_id)
VALUES ('Marsala Tita 57', 'Srbija', 'mg@gmail.com', 'Novi Sad', 'Milana', '23091997', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Galin', '+381/61-5534209', 'NA_CEKANJU', 1);



INSERT INTO public.medicinska_sestra( adresa, drzava,  email, grad, ime, jmbg, lozinka, ocena, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Vojvodjanska 2','Srbija', 'mm@gmail.com', 'Novi Sad', 'Masa', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Matovic', '+381/61-5534209', 1, false);

INSERT INTO public.medicinska_sestra( adresa, drzava,  email, grad, ime, jmbg, lozinka, ocena, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Gogoljeva 1','Srbija', 'km@gmail.com', 'Novi Sad', 'Kristina', '052123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 4, 'Matovic', '+381/61-553309', 2, false);

INSERT INTO public.medicinska_sestra( adresa, drzava,  email, grad, ime, jmbg, lozinka, ocena, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Marsala Tita 58','Srbija', 'am@gmail.com', 'Novi Sad', 'Ana', '412123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 3, 'Matovic', '+381/61-5514209', 3, false);



INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (5, 'Sala', 1);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (3, 'Sala', 1);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (10, 'Sala', 1);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (5, 'Sala zdravlje', 2);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (3, 'Sala infektivna', 2);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (10, 'Sok soba', 2);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (5, 'Soba', 3);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (3, 'Sala relaks', 3);

INSERT INTO public.sala(
broj, naziv, klinika_id)
VALUES (10, 'Soba', 3);



INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Bubrezi', 'bbr', ' 1500', 1);

INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Pluca', 'plc', ' 3500', 1);

INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Srce', 'src', ' 2000', 1);

INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Pluca', 'plc', ' 3500', 2);

INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Srce', 'src', ' 2000', 2);

INSERT INTO public.tip_pregleda(naziv, oznaka, cena, klinika_id)
VALUES ('Pluca', 'plc', ' 3000', 3);



INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'pb@gmail.com', 'Novi Sad', 'Peca', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Basic', '+381/61-5534209', 1, 1, 9, 16, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'bb@gmail.com', 'Novi Sad', 'Bojana', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 4, 'Basic', '+381/61-5534209', 2, 1, 8, 14, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'db@gmail.com', 'Novi Sad', 'Dimitrije', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 3, 'Basic', '+381/61-5534209', 3, 1, 14, 21, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'mb@gmail.com', 'Novi Sad', 'Miodrag', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 1, 'Basic', '+381/61-5534209', 4, 2, 8, 14, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'sb@gmail.com', 'Novi Sad', 'Sanja', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 2, 'Basic', '+381/61-5534209', 5, 2, 9, 15, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'jb@gmail.com', 'Novi Sad', 'Jelena', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Basic', '+381/61-5534209', 6, 3, 10, 20, false);

INSERT INTO public.lekar( adresa, broj_recenzija, drzava,  email, grad, ime, jmpg, lozinka, ocena, prezime, telefon, tip_pregleda_id, klinika_id, pocetak, kraj, promenjena_lozinka)
VALUES ('Marsala Tita 58',  '5', 'Srbija', 'kb@gmail.com', 'Novi Sad', 'Koki', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 5, 'Basic', '+381/61-5534209', 1, 1, 10, 15, false);



INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id, zavrsen, vrsta_pregleda)
VALUES ('1500', '2020-05-20T00:00:00.000Z', null, 1, '11', 1, 1, 1, 'false', 'pregled');

INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id, zavrsen, vrsta_pregleda)
VALUES ('3500', '2020-06-20T00:00:00.000Z', null, 2, '12', 2, 2, 2, 'false', 'pregled');

INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id, zavrsen, vrsta_pregleda)
VALUES ('1500', '2020-05-22T00:00:00.000Z', null, 1, '11', 4, 4, 4, 'false', 'pregled');

INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id, zavrsen, vrsta_pregleda)
VALUES ('3500', '2020-04-20T00:00:00.000Z', null, 2, '12', 5, 5, 5, 'false', 'pregled');

INSERT INTO public.pregled(cena, datum, id_pacijenta, trajanje, vreme, lekar_id, sala_id, tip_pregleda_id, zavrsen, vrsta_pregleda)
VALUES ('3000', '2020-04-21T00:00:00.000Z', null, 2, '12', 6, 7, 6, 'false', 'pregled');



INSERT INTO public.administrator_klinike(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Marsala Tita 58','Srbija', 'an@gmail.com', 'Novi Sad', 'Ana', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Nikolasevic', '+381/61-5534209', 1, false);

INSERT INTO public.administrator_klinike(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Marsala Tita 58','Srbija', 'zn@gmail.com', 'Novi Sad', 'Zoran', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Nikolasevic', '+381/61-5534209', 2, false);

INSERT INTO public.administrator_klinike(adresa, drzava,  email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id, promenjena_lozinka)
VALUES ('Marsala Tita 58','Srbija', 'gn@gmail.com', 'Novi Sad', 'Gorana', '012123', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',  'Nikolasevic', '+381/61-5534209', 3, false);


INSERT INTO public.sala_pregledi(sala_id, pregledi_id)
VALUES (1,1);

INSERT INTO public.sala_pregledi(sala_id, pregledi_id)
VALUES (2,2);

INSERT INTO public.sala_pregledi(sala_id, pregledi_id)
VALUES (4,3);

INSERT INTO public.sala_pregledi(sala_id, pregledi_id)
VALUES (5,4);

INSERT INTO public.sala_pregledi(sala_id, pregledi_id)
VALUES (7,5);



INSERT INTO public.lek(sifra, naziv)
VALUES ('Kl130','Diklofenak');

INSERT INTO public.lek(sifra, naziv)
VALUES ('AS212','Aspirin');

INSERT INTO public.lek(sifra, naziv)
VALUES ('BF140','Brufen');

INSERT INTO public.lek(sifra, naziv)
VALUES ('DF200','Defrinol');

INSERT INTO public.dijagnoza(sifra, naziv)
VALUES ('K4544','Povisen pritisak');

INSERT INTO public.dijagnoza(sifra, naziv)
VALUES ('R3376','Gusenje');

INSERT INTO public.dijagnoza(sifra, naziv)
VALUES ('D3234','Povisena temperatura');

INSERT INTO public.dijagnoza(sifra, naziv)
VALUES ('S1125','Stomacni problemi');

INSERT INTO public.zahtev_za_pregled(cena, datum, id_pacijenta, prihvacen_od_pacijenta, status, trajanje, vreme, vrsta_pregleda, lekar_id, lekar1_id, lekar2_id, sala_id, tip_pregleda_id)
VALUES ('1500', '2020-05-22T00:00:00.000Z', '1', 'false', 'odobren', 1, 13, 'pregled', 1, null, null, 1, 1);


INSERT INTO public.authority (uloga) VALUES ('PACIJENT');
INSERT INTO public.authority (uloga) VALUES ('LEKAR');
INSERT INTO public.authority (uloga) VALUES ('MEDICINSKA_SESTRA');
INSERT INTO public.authority (uloga) VALUES ('ADMIN_CENTRA');
INSERT INTO public.authority (uloga) VALUES ('ADMIN_KLINIKE');


INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (1, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (2, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (3, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (4, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (5, 1);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (6, 1);


INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (1, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (2, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (3, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (4, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (5, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (6, 2);
INSERT INTO public.lekar_authority (lekar_id, authority_id) VALUES (7, 2);


INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (1, 3);
INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (2, 3);
INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (3, 3);


INSERT INTO public.adminkc_authority (adminkc_id, authority_id) VALUES (1, 4);


INSERT INTO public.admink_authority (admink_id, authority_id) VALUES (1,5);
INSERT INTO public.admink_authority (admink_id, authority_id) VALUES (2,5);
INSERT INTO public.admink_authority (admink_id, authority_id) VALUES (3,5);