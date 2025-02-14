package epicode.gestione.viaggi.aziendali.exceptions;

import lombok.Data;

//questa classe serve per una risposta di errore da inserire in un ErrorHandler
//data serve per poter personalizzare eventualmente il messaggio con i set, oltre ad avere disposizione tutti gli altri metodi

@Data
public class Error {

    private String message;
    private String details;
    private String status;
}