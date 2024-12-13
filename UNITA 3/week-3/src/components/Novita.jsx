import image1 from "./assets/images/1a.png"
import image2 from "./assets/images/1b.png"

const Novita = () => {
    return(
        <div>
            <article className=" d-flex align-items-end text-light overflow-hidden">
                <div>
                    <p>
                        NUOVA STAZIONE RADIO
                    </p>
                    <p>
                        Rilassati, al resto ci pensiamo noi.
                        Ascolta Apple Music Chill
                    </p>
                    <div>
                        <img className="first" src={image1} alt="immagine" />
                    </div>
                </div>

                <div>
                    <p>
                        NUOVA STAZIONE RADIO
                    </p>
                    <p>
                        Ecco la nuova casa della musica latina
                    </p>
                    <div>
                        <img className="first" src={image2} alt="immagine" />
                    </div>
                </div>
            </article>
        </div>
    )
}

export default Novita