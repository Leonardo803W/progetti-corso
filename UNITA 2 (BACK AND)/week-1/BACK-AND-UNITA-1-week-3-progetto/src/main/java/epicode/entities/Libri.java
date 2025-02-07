package epicode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libri extends Catalogo {

    @Column(name = "autore")
    private String autore;

    @Column(name = "genere")
    private String genere;

    public Libri(){

    }

    public Libri (String titolo, LocalDate date, int nPagine, String autore, String genere) {

        super(titolo, date, nPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
