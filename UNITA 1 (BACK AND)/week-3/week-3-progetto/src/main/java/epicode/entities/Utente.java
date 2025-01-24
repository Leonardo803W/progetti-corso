package epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "datadinascita")
    private LocalDate dataNascita;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroTessera;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestito> prestito = new ArrayList<>();

    public Utente(){

    }

    public Utente (String nome, String cognome, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public List<Prestito> getPrestito() {
        return prestito;
    }

    public void setPrestito(List<Prestito> prestito) {
        this.prestito = prestito;
    }
}
