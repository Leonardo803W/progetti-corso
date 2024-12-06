import { Card, Button } from "react-bootstrap"

const CardMeteo = (props) => {

    return (
        <>
           <Card style={{ width: '18rem' }}>
                <div>
                    <p>{JSON.stringify(props.coord.lon)}</p> {/* Mostra le coordinate in modo leggibile */}
                    <p>{JSON.stringify(props.coord.lat)}</p> {/* Mostra le coordinate in modo leggibile */}
                </div>
                <Card.Body>
                    <Card.Title>{props.name}</Card.Title>
                    <div>
                        <p>{props.main.temp_max}</p>
                        <p>{props.main.temp_min}</p>
                    </div>
                    <Button variant="primary">details</Button>
                </Card.Body>
            </Card>
        </>
    )
}

export default CardMeteo;