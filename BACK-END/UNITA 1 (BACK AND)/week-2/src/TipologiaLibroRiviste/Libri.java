package TipologiaLibroRiviste;

import ClassePadre.Libro;

public class Libri extends Libro {

    private static String autore;
    private static String genere;

    public Libri(String kay, String title, int anno, int pagine, String autoreLibro, String genereLibro)
    {
        super(kay, title, anno, pagine);
        this.autore = autoreLibro;
        this.genere = genereLibro;
    }

    public static void setAutore(String autoreLibro)
    {
        autore = autoreLibro;
    }

    public String getAutore()
    {
        return this.autore;
    }

    public static void setGenere(String genereLibro)
    {
        genere = genereLibro;
    }

    public String getGenere()
    {
        return this.genere;
    }

    @Override
    public String toString()
    {
        return " Codice libro: " + getCodice() + ", Titolo: " + getTitolo() + ", Anno di publicazione: "
                + getAnnoPublicazione() + ", Numero di pagine: " + getNumeroPagine() + ", Autore: "
                + autore + ", Genere: " + genere;
    }
}
