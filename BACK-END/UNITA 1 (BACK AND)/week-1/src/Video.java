public class Video extends ElementoMultimediale implements Riproducibile {

    private int volume;
    private int luminosita;

    public Video (String title, int duration, int vol, int lum)
    {
        super(title, duration);
        this.volume = vol;
        this.luminosita = lum;
    }

    public void alazaVolumeVideo()
    {
        volume++;
    }

    public void abbassaVolumeVideo()
    {
        if(volume > 0)
        {
            volume--;
        }
    }

    public void aumentaluminositaVideo()
    {
        luminosita++;
    }

    public void abbassaluminositaVideo()
    {
        if(luminosita > 0)
        {
            luminosita--;
        }
    }

    @Override
    public void play()
    {
        for (int i = 0; i < durata; i++)
        {
            System.out.println(titolo + "!" + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    @Override
    public void esegui()
    {
        play();
    }
}
