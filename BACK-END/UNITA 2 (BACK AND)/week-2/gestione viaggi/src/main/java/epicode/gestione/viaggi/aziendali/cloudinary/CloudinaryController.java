package epicode.gestione.viaggi.aziendali.cloudinary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

//RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
//RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class CloudinaryController {
    private final Cloudinary cloudinary;

    //Il metodo post metodi avranno alla base dell'url questo: http://localhost:8080/api/images
    //questa classe permette di salvare le immagine che poi verranno visualizzate dal client

    @PostMapping(path="/uploadme", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(
            @RequestPart("file")
            MultipartFile file) {

        try {

            Map result = cloudinary.uploader()
                    .upload(file.getBytes(),  Cloudinary.asMap("folder", "FS0824", "public_id", file.getOriginalFilename()));

            String url = result.get("secure_url").toString();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

}