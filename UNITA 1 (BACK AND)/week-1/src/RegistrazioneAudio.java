public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {

    private int volume;

    public RegistrazioneAudio (String title, int duration, int vol) {

        super(title, duration);
        this.volume = vol;
    }

    public void alazaVolumeRegistrazione()
    {
        volume++;
    }

    public void abbassaVolumeRegistrazione()
    {
        if(volume > 0)
        {
            volume--;
        }
    }

    @Override
    public void play()
    {
        for (int i = 0; i < durata; i++)
        {
            System.out.println(titolo + "!" + "!".repeat(volume));
        }
    }

    @Override
    public  void esegui()
    {
        play();
    }
}
