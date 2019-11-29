INSERT INTO public.klinika(
	id, adresa, broj_recenzija, email, grad, drzava, naziv, ocena, opis, telefon)
	VALUES (nextval('klinika_id_seq'), 'Jovana Obrenovica 83A', '5', 'klinika@klinika', 'Pljevlja', 'Crna Gora',  'Sveti vid', 3.5, 'Vrlo lepo', '+381/61-5534209');