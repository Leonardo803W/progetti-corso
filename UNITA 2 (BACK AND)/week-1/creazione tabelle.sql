CREATE TABLE edificio (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL,
    citta VARCHAR(100) NOT NULL
);

CREATE TABLE postazione (
    id SERIAL PRIMARY KEY,
    codice VARCHAR(100) NOT NULL,
    descrizione VARCHAR(100) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    numero_massimo_occupanti INT NOT NULL,
    edificio_id INT,
    FOREIGN KEY (edificio_id) REFERENCES edificio(id)
);

CREATE TABLE utente (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    nome_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE prenotazione (
    id SERIAL PRIMARY KEY,
    postazione_id INT,
    utente_id INT,
    data DATE NOT NULL,
    FOREIGN KEY (postazione_id) REFERENCES postazione(id),
    FOREIGN KEY (utente_id) REFERENCES utente(id)
);