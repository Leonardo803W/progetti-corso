import { Card, Button } from "react-bootstrap"

const CardMeteo = (props) => {
    // Log dei dati per il debug
    //console.log(props.data);

    // Controllo se i dati sono disponibili
    if (!props.data || !props.data.coord) {
        return <p>Loading...</p>; // O un messaggio di errore
    }

    return (
        <>
            <Card className=" w-50 m-3 text-center">
                
                <Card.Body>
                    <Card.Title className=" p-2">{props.data.name}</Card.Title>
                    <div className=" d-flex justify-content-around">
                        <p>temperatura massima: {props.data.main.temp_max}</p>
                        <p>temperatura minima: {props.data.main.temp_min}</p>
                    </div>
                    <div className=" d-flex justify-content-around">
                        <p>logitudine: {props.data.coord.lon}</p> {/* Mostra le coordinate in modo leggibile */}
                        <p>latitudine: {props.data.coord.lat}</p> {/* Mostra le coordinate in modo leggibile */}
                    </div>
                    <Button variant="primary" className=" m-4">details</Button>
                </Card.Body>
            </Card>
        </>
    )
}

export default CardMeteo;