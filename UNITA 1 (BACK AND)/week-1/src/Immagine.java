public class Immagine extends ElementoMultimediale {

    private int luminosita;

    public Immagine(String title, int duration, int lum)
    {
        super(title, duration);
        this.luminosita = lum;
    }

    public void aumentaluminositaImmagine()
    {
        luminosita++;
    }

    public void abbassaLuminositaImmagine()
    {
        if(luminosita > 0)
        {
            luminosita--;
        }
    }

    @Override
    public void esegui()
    {
        show();
    }

    public void show()
    {
        System.out.println(titolo + "!" + "*".repeat(luminosita));
    }
}
