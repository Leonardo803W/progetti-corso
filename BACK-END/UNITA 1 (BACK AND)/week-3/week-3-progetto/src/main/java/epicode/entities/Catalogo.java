package epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int codiceISBN;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "annopubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "numeropagine")
    private int numeroPagine;

    public Catalogo(){

    }

    public Catalogo (String titolo, LocalDate date, int nPagine) {

        this.titolo = titolo;
        this.annoPubblicazione = date;
        this.numeroPagine = nPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
