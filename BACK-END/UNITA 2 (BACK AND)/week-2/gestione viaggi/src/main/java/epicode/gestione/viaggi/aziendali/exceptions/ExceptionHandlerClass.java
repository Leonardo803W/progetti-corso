package epicode.gestione.viaggi.aziendali.exceptions;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice è utilizzata per definire una classe che fornisce un comportamento globale per tutti i controller dell'applicazione. Essa consente di gestire le eccezioni, le validazioni e le configurazioni comuni in un unico posto
//@ExceptionHandler viene utilizzata per specificare un metodo che gestisce le eccezioni lanciate da un controller

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Error> entityNotFound(EntityNotFoundException ex) {

        Error error = new Error();
        error.setMessage("Entity not found");
        error.setDetails(ex.getMessage());
        error.setStatus("404");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EntityExistsException.class)
    protected ResponseEntity<Error> alreadyExistsException(EntityExistsException ex) {

        Error error = new Error();
        error.setMessage("Entity already exists");
        error.setDetails(ex.getMessage());
        error.setStatus("409");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConsraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();

            //System.out.println(fieldName);
            if (fieldName.contains(".")) {
                fieldName = fieldName.substring(fieldName.lastIndexOf('.') + 1);
            }
            errors.put(fieldName, violation.getMessage());
        }


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
