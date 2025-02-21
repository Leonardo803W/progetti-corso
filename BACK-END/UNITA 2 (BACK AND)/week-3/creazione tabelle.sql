CREATE TYPE statoRuolo AS ENUM ('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI');

CREATE TABLE utenti (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    ruolo statoRuolo NOT NULL
);

CREATE TABLE eventi (
    id SERIAL PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    descrizione TEXT NOT NULL,
    data TIMESTAMP NOT NULL,
    luogo VARCHAR(100) NOT NULL,
    posti_disponibili INT NOT NULL,
    organizzatore_id INT REFERENCES utenti(id)
);

CREATE TABLE prenotazioni (
    id SERIAL PRIMARY KEY,
    utente_id INT REFERENCES utenti(id),
    evento_id INT REFERENCES eventi(id)
);