package epicode.gestione.viaggi.aziendali.dipendenti;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//questa classe servira per il metodo findAll in service

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendenteResponse {

    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;

}