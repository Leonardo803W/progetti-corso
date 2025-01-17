package ArchivioDati;

import ClassePadre.Libro;
import TipologiaLibroRiviste.Riviste;
import TipologiaLibroRiviste.Libri;
import TipologiaLibroRiviste.Periodicita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivio {

    private List<Libro> archivio = new ArrayList<>();

    Scanner myScanner = new Scanner(System.in);

    // Metodo per aggiungere un libro.

    public void addBook(Libro libro)
    {
        for (Libro existingBook : archivio)
        {
            if (libro.getCodice().equals(existingBook.getCodice()))
            {
                System.out.println("Spiacenti già presente nell'archivio.");
                return;
            }
        }
        archivio.add(libro);
        System.out.println("Aggiunto con successo.");
    }

    // Metodo di ricerca per codice identificativo.

    public void findBookByCode(String codice) throws ArchivioException
    {
        for (Libro libro : archivio)
        {
            if (codice.equals(libro.getCodice()))
            {
                System.out.println("Aggiunto con successo.");
                return;
            }
        }
        throw new ArchivioException("Spiacenti non trovato");
    }

    // Metodo di rimozione di un libro dato un codice identificativo.

    public void removeBookByCode(String codice) throws ArchivioException
    {
        for (Libro libro : archivio)
        {
            if (codice.equals(libro.getCodice()))
            {
                archivio.remove(libro);
                System.out.println("Rimosso con successo.");
                return;
            }
        }
        throw new ArchivioException("Spiacenti non trovato");
    }

    // Metodo di ricerca per anno di pubblicazione.

    public void findBookByYear(int anno) throws ArchivioException
    {
        boolean found = false;

        for (Libro libro : archivio)
        {
            if (anno == libro.getAnnoPublicazione())
            {
                System.out.println(libro);
                found = true;
            }
        }
        if (!found)
        {
            throw new ArchivioException("Spiacenti non trovato per l'anno specificato.");
        }
    }

    // Metodo di ricerca per autore.

    public void findBookByAuthor(String autore) throws ArchivioException
    {
        boolean found = false;
        for (Libro libro : archivio)
        {
            if (libro instanceof Libri)
            {
                if (autore.equals(((Libri) libro).getAutore()))
                {
                    System.out.println(libro);
                    found = true;
                }
            }
        }
        if (!found)
        {
            throw new ArchivioException("Spiacenti non trovato per l'autore specificato.");
        }
    }

    // Metodo di reimpostazioni dati di un libro o rivista dato un codice identificativo

    public void setBookRiviste(String codice) throws ArchivioException
    {

        for (Libro libro : archivio)
        {
            //verifico l'unicita dell'elemento corrente.

            if (codice.equals(libro.getCodice()))
            {
                //verifico di che classe e l'elemento corrente per evitare di dare modo di modificare proprieta
                //che sono insesistenti rispetto ad un'altra classe.

                if (libro instanceof Libri)
                {
                    System.out.println("Scegliere le impostazioni del libro o rivista che si vuole modificare: ");
                    System.out.println("1) titolo, 2) anno di publicazione, 3) numero di pagine, 4) autore, 5) genere.");
                }

                if (libro instanceof Riviste)
                {
                    System.out.println("Scegliere le impostazioni del libro o rivista che si vuole modificare: ");
                    System.out.println("1) titolo, 2) anno di publicazione, 3) numero di pagine, 6) periodicita.");
                }

                int scelta = Integer.parseInt(myScanner.nextLine());

                //in base all'operazione desiderata si va a modificare qualunque proprieta
                //ad eccezzione del codice identificativo.

                do {

                    switch (scelta)
                    {
                        case 1:
                            System.out.print("Nuovo titolo: ");
                            String title = myScanner.nextLine();
                            Libri.setTitolo(title);
                            System.out.println("Titolo modificato con successo.");
                            break;

                        case 2:
                            System.out.print("Nuovo anno di publicazione: ");
                            int annoPublicazione = myScanner.nextInt();
                            Libri.setAnnoPublicazione(annoPublicazione);
                            String b = myScanner.nextLine();
                            System.out.println("Anno di publicazione modificato con successo.");

                            break;

                        case 3:
                            System.out.print("Quante pagine? ");
                            int numeroPagine = myScanner.nextInt();
                            Libri.setNumeroPagine(numeroPagine);
                            String c = myScanner.nextLine();
                            System.out.println("Numero di agine modificato con successo.");

                            break;

                        case 4:
                            System.out.print("Nuovo autore: ");
                            String autore = myScanner.nextLine();
                            Libri.setAutore(autore);
                            System.out.println("Autore modificato con successo.");
                            break;

                        case 5:
                            System.out.print("Nuovo genere: ");
                            String genere = myScanner.nextLine();
                            Libri.setGenere(genere);
                            System.out.println("Titolo modificato con successo.");
                            break;

                        case 6:
                            System.out.print("Nuovo periodicita: ");
                            String periodicita = myScanner.nextLine();
                            Riviste.setPeriodicita(Periodicita.valueOf(periodicita.toUpperCase()));
                            System.out.println("Titolo modificato con successo.");
                            break;
                    }

                    System.out.println("1) titolo, 2) anno di publicazione, 3) numero di pagine, 4) autore, 5) genere, 6) periodicita. Per uscire premere 0.");
                    scelta = Integer.parseInt(myScanner.nextLine());

                }while (scelta != 0);

            }
        }
        throw new ArchivioException("Spiacenti non trovato");
    }

    //Metodo per stampare le informazioni contenute nell'archivio.

    public void prinList ()
    {
        String[] elementoPiuPagine;
        int book = 0;
        int riviste = 0;
        int pagineMomentanea = 0;
        Libro elementoConPiuPagine = null;
        int totalePagine = 0;
        int totaleElementi = 0;

        for (Libro elemento : archivio)
        {
            if (elemento instanceof Libri)
            {
                book++;
            }

            if (elemento instanceof Riviste)
            {
                riviste++;
            }

            if (pagineMomentanea < elemento.getNumeroPagine())
            {
                elementoConPiuPagine = elemento;
            }

            totalePagine = totalePagine + elemento.getNumeroPagine();
            totaleElementi++;
        }

        if (totaleElementi > 0)
        {
            totalePagine = totalePagine / totaleElementi;
        }

        System.out.println("Nell'archivio i sono " + book + " libri a disposizione.");
        System.out.println("Nell'archivio i sono " + riviste + " libri a disposizione.");
        System.out.println("Elemento con più pagine " + elementoConPiuPagine.toString());
        System.out.println("La media delle pagine sono: " + totalePagine);
    }
}
