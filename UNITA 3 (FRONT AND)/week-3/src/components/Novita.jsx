import image1 from "./assets/images/1a.png";
import image2 from "./assets/images/1b.png";

const Novita = () => {
    return (
        <div className="novita-container">
            <article className="d-flex align-items-end text-light">
                <div>
                    <p className="titoli">NUOVA STAZIONE RADIO</p>
                    <p>Rilassati, al resto ci pensiamo noi. Ascolta Apple Music Chill</p>
                    <div className="image-container">
                        <img className="first" src={image1} alt="immagine" />
                    </div>
                </div>

                <div className=" ms-3">
                    <p className="titoli">NUOVA STAZIONE RADIO</p>
                    <p className=" w-75">Ecco la nuova casa della musica latina</p>
                    <div className="image-container">
                        <img className="first" src={image2} alt="immagine" />
                    </div>
                </div>
            </article>
        </div>
    )
}

export default Novita;