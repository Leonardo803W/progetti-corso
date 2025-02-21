import ArchivioDati.Archivio;
import ArchivioDati.ArchivioException;
import TipologiaLibroRiviste.Libri;
import TipologiaLibroRiviste.Periodicita;
import TipologiaLibroRiviste.Riviste;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws ArchivioException {

        Libri libro1 = new Libri("001", "Signore degli anelli", 2024, 150, "Anstar", "Fantasy");
        Libri libro2 = new Libri("002", "Signore degli anelli", 2024, 600, "Anstar", "Fantasy");
        Riviste rivista1 = new Riviste("003", "Tutti pazzi per Mary", 2020, 300, Periodicita.SETTIMANALE);
        Riviste rivista2 = new Riviste("004", "Tutti pazzi per Mary", 2020, 300, Periodicita.MENSILE);
        Riviste rivista3 = new Riviste("005", "Le dodici fatiche di Ercole", 2022, 700, Periodicita.SEMESTRALE);
        Riviste rivista4 = new Riviste("007", "Le dodici fatiche di Ercole", 2022, 150, Periodicita.SEMESTRALE);

        Archivio archivio1 = new Archivio();

        archivio1.addBook(libro1);
        archivio1.addBook(libro2);
        archivio1.addBook(libro1);
        archivio1.addBook(rivista1);
        archivio1.addBook(rivista2);
        archivio1.addBook(rivista3);
        archivio1.addBook(rivista4);

        //archivio1.findBookByCode("002");
        //archivio1.findBookByCode("006");

        //archivio1.findBookByAuthor("Anstar");
        //archivio1.findBookByAuthor("bob");

        //archivio1.findBookByYear(2024);
        //archivio1.findBookByYear(2025);

        //archivio1.removeBookByCode("007");
        //archivio1.removeBookByCode("010");

        //archivio1.setBookRiviste("001");
        //archivio1.findBookByCode("001");

        //archivio1.setBookRiviste("003");
        //archivio1.findBookByCode("003");

        archivio1.prinList();
    }
}