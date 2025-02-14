package epicode.gestione.viaggi.aziendali.viaggi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioRequest {

    @NotBlank(message = "Il campo destinazione non puo essere vuoto")
    private String destinazione;

    @NotNull(message = "La data del viaggio non puo essere null")
    private LocalDate dataViaggio;

    private StatoViaggio statoViaggio;
    private int dipendenteId;
}