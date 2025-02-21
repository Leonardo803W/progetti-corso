package epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
public class Prestito {

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    @Column(name = "datainizioprestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "datarestituzioneprevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "datarestituzioneeffettiva")
    private LocalDate restituzioneEffettiva;

    public Prestito(){

    }

    public Prestito (Utente utente, Catalogo catalogo, LocalDate dataPre, LocalDate dataResti, LocalDate resti) {

        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataPre;
        this.dataRestituzionePrevista = dataResti;
        this.restituzioneEffettiva = resti;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzioneEffettiva;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzioneEffettiva = restituzionePrevista;
    }
}
