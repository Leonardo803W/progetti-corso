import java.util.Scanner;

public class PlayerMultimediale {

    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];
    private Scanner mYscanner = new Scanner(System.in);

    public void caricaElementi() {

        for (int i = 0; i < elementi.length; i++)
        {
            System.out.println("Premere invio.");
            mYscanner.nextLine();

            System.out.println("Inserire il tipo di elemento (audio/video/immgaine): ");
            String tipo = mYscanner.nextLine();

            System.out.println("\n" + "Inserire il titolo: ");
            String titolo = mYscanner.nextLine();

            if("audio".equals(tipo))
            {
                System.out.println("\n" + "Inserire la durata (in secondi): ");
                int durata = mYscanner.nextInt();

                System.out.println("\n" + "Inserire la volume (da 0 fino a 100): ");
                int volume = mYscanner.nextInt();

                elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
            }
            else if ("video".equals(tipo))
            {
                System.out.println("\n" + "Inserire la durata (in secondi): ");
                int durata = mYscanner.nextInt();

                System.out.println("\n" + "Inserire la volume (da 0 fino a 100): ");
                int volume = mYscanner.nextInt();

                System.out.println("\n" + "Inserire la luminosita (da 1 fino a 100): ");
                int luminosita = mYscanner.nextInt();

                elementi[i] = new Video(titolo, durata, volume, luminosita);
            }
            else if ("immagine".equals(tipo))
            {
                System.out.println("\n" + "Inserire la luminosita (da 1 fino a 100): ");
                int luminosita = mYscanner.nextInt();

                elementi[i] = new Immagine(titolo, 0, luminosita);
            }
            else
            {
                System.out.println("\n" + "Tipo non riconosciuto. riprova.");
                i--;
                //in tal modo evito di andare avanti e lasciare un buco vuoto nell'array
            }
        }
    }

    public void avvia () {

        int scelta;

        do {

            System.out.println("\n" + "Scelga un elemento da eseguire (da 1 fino a 5) o 0 per uscire: ");
            scelta = mYscanner.nextInt();

            if (scelta > 0 && scelta <= 5)
            {
                elementi[scelta - 1].esegui();

                // Se l'elemento è riproducibile, offro ulteriori opzioni
                if (elementi[scelta] instanceof Riproducibile) {
                    boolean continua = true;

                    while (continua) {
                        System.out.println("\n" + "Vuoi modificare le impostazioni? (1: Alza volume video, 2: Abbassa volume video, 3: Aumenta luminosità video, 4: Diminuisci luminosità video)," +
                                "(5: Alza volume registrazione, 6: Abbassa volume registrazione, 7: / 0: Torna indietro)");
                        int sceltaImpostazione = mYscanner.nextInt();


                        if (sceltaImpostazione == 1 && elementi[scelta - 1] instanceof Video) {
                            ((Video) elementi[scelta - 1]).alazaVolumeVideo();
                            System.out.println("\n" + "Volume alzato.");
                        }
                        else if (sceltaImpostazione == 2 && elementi[scelta - 1] instanceof Video)
                        {
                            ((Video) elementi[scelta - 1]).abbassaVolumeVideo();
                            System.out.println("\n" + "Volume abbassato.");
                        }
                        else if (sceltaImpostazione == 3 && elementi[scelta - 1] instanceof Video)
                        {
                            ((Video) elementi[scelta - 1]).aumentaluminositaVideo();
                            System.out.println("\n" + "Luminosità aumentata.");
                        }
                        else if (sceltaImpostazione == 4 && elementi[scelta - 1] instanceof Video)
                        {
                            ((Video) elementi[scelta - 1]).abbassaluminositaVideo();
                            System.out.println("\n" + "Luminosità diminuita.");
                        }
                        else if (sceltaImpostazione == 5 && elementi[scelta - 1] instanceof RegistrazioneAudio)
                        {
                            ((RegistrazioneAudio) elementi[scelta - 1]).alazaVolumeRegistrazione();
                            System.out.println("\n" + "Volume alzato.");
                        }
                        else if (sceltaImpostazione == 6 && elementi[scelta - 1] instanceof RegistrazioneAudio)
                        {
                            ((RegistrazioneAudio) elementi[scelta - 1]).abbassaVolumeRegistrazione();
                            System.out.println("\n" + "Volume abbassato.");
                        }
                        else if (sceltaImpostazione == 0)
                        {
                            continua = false; // Torna indietro
                        }
                        else
                        {
                            System.out.println("\n" + "Scelta non valida, si prega di riprovare.");
                        }
                    }
                }
            }
            else
            {
                System.out.println("\n" + "Scelta non valida, si prega di riprovare.");
            }
        }while (scelta != 0) ;

            System.out.println("\n" + "Grazie per il suo tempo, buona giornata :)");

    }
}
