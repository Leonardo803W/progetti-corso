CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL,
    titolo VARCHAR(50) NOT NULL,
    contenuto VARCHAR(50) NOT NULL,
	tempo_di_lettura INTEGER NOT NULL,
	autore_id INT,
	FOREIGN KEY (autore_id) REFERENCES autore(id)
);

CREATE TABLE autore (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_di_nascita DATE NOT NULL
);