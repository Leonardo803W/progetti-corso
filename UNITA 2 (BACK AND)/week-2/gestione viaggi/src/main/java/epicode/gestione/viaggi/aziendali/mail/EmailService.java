package epicode.gestione.viaggi.aziendali.mail;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    //Autowired cerca automaticamente una istanza gia pre-configurata della variabile di tipo JavaMailSender
    //un'interfaccia fornita da Spring che estende le funzionalità di invio email, supporta l'invio di messaggi email sia semplici che MIME (Multipurpose Internet Mail Extensions)

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject) throws MessagingException {

        sendEmail(to, subject, "Mail di spam");
    }

    public void sendEmail(String to, String subject, String body) throws  MessagingException {

        if (body == null)
        {
            body = "mail di default";
        }

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        mailSender.send(message);
        System.out.println("Email inviata con successo a " + to);
    }
}
