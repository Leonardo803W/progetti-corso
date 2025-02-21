CREATE TABLE catalogo(
	id SERIAL PRIMARY KEY,
	titolo VARCHAR(50) NOT NULL,
	annopubblicazione DATE NOT NULL,
	numeropagine INTEGER NOT NULL
);

CREATE TABLE libri(
	libro_id INT,
	CONSTRAINT fk_libro FOREIGN KEY (libro_id) REFERENCES catalogo(id),
	autore VARCHAR(50) NOT NULL,
	genere VARCHAR(50) NOT NULL
);

CREATE TYPE periodicita AS ENUM ('SETTIMANALE', 'MENSILE', 'SEMESTRALE');

CREATE TABLE riviste(
	rivista_id INT,
	CONSTRAINT fk_riviste FOREIGN KEY (rivista_id) REFERENCES catalogo(id),
	periodicita periodicita
);

CREATE TABLE utente(
	nome VARCHAR(50) NOT NULL,
	cognome VARCHAR(50) NOT NULL,
	datadinascita DATE NOT NULL,
	numerotessera SERIAL PRIMARY KEY
);

CREATE TABLE prestito(
	utente_id INT,
	CONSTRAINT fk_utente FOREIGN KEY (utente_id) REFERENCES utente(numerotessera),
	elementoinprestito_id INT,
	CONSTRAINT fk_elementoinprestito FOREIGN KEY (elementoinprestito_id) REFERENCES catalogo(id),
	datainizioprestito DATE NOT NULL,
	datarestituzioneprevista DATE NOT NULL,
	datarestituzioneeffettiva DATE NOT NULL
);