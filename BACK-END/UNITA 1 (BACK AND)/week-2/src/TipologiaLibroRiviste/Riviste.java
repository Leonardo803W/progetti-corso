package TipologiaLibroRiviste;

import ClassePadre.Libro;

public class Riviste extends Libro
{
    private static Periodicita periodicita;

    public Riviste(String kay, String title, int anno, int pagine, Periodicita periodicitaRivista)
    {
        super(kay, title, anno, pagine);
        this.periodicita = Periodicita.valueOf(String.valueOf(periodicitaRivista));
    }

    public static void setPeriodicita(Periodicita periodicitaRivista)
    {
        periodicita = Periodicita.valueOf(String.valueOf(periodicitaRivista));
    }

    public Periodicita getPeriodicita()
    {
        return this.periodicita;
    }

    @Override
    public String toString()
    {
        return " Codice rivista: " + getCodice() + ", Titolo: " + getTitolo() + ", Anno di publicazione: "
                + getAnnoPublicazione() + ", Numero di pagine: " + getNumeroPagine() + ", Peridiocita della rivista: "
                + periodicita;
    }
}
