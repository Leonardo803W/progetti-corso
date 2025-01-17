package ClassePadre;

public abstract class Libro {

    private final String codice;
    private static String titolo;
    private static int annoPublicazione;
    private static int numeroPagine;

    public Libro(String kay, String title, int anno, int pagine)
    {
        this.codice = kay;
        this.titolo = title;
        this.annoPublicazione = anno;
        this.numeroPagine = pagine;
    }

    public String getCodice()
    {
        return this.codice;
    }

    public static void setTitolo(String title)
    {
        titolo = title;
    }

    public String getTitolo()
    {
        return this.titolo;
    }

    public static void setAnnoPublicazione(int year)
    {
        annoPublicazione = year;
    }

    public int getAnnoPublicazione()
    {
        return this.annoPublicazione;
    }

    public static void setNumeroPagine(int pagine)
    {
       numeroPagine = pagine;
    }

    public int getNumeroPagine()
    {
        return this.numeroPagine;
    }

    public String toString()
    {
        return " Codice: " + codice + ", Titolo: " + titolo + ", Anno di publicazione: " + annoPublicazione + ", Numero di pagine: " + numeroPagine;
    }
}
