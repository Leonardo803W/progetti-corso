CREATE TYPE stato AS ENUM ('in_programma', 'completato');

CREATE TABLE viaggio (
    id SERIAL PRIMARY KEY,
    destinazione VARCHAR(50) NOT NULL,
    data_viaggio DATA NOT NULL,
	stato_viaggio stato NOT NULL,
	dipendente_id INT,
	FOREIGN KEY (dipendente_id) REFERENCES dipendente(id)
);

CREATE TABLE dipendente (
    id SERIAL PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
);