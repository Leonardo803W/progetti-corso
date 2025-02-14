package epicode.gestione.viaggi.aziendali.viaggi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioDettaglioResponse {

    private Long id;
    private String destinazione;
    private LocalDate dataViaggio;
    private StatoViaggio statoViaggio;
    private int dipendenteId;
}