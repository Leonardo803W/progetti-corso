package epicode.gestione.viaggi.aziendali.general_responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//tale classe serve per far ricevere al client il numero dell'id che si trova nella risposta json e non quello del databese

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateResponse {

    private Long id;
}