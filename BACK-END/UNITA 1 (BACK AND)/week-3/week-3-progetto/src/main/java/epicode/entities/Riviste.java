package epicode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Riviste extends Catalogo {

    @Enumerated
    @Column(name = "periodicita")
    private Periodicita periodicita;

    public Riviste(){

    }

    public Riviste (String titolo, LocalDate date, int nPagine, Periodicita periodicita) {

        super(titolo, date, nPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
