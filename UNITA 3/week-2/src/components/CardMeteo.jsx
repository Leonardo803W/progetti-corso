import React, { useEffect, useState } from 'react';
import { Card, Button, Alert } from "react-bootstrap"

const CardMeteo = () => {
    const key = '3efe250117031385f4bd4b3fc329932b';
    const [data, setData] = useState({});
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('https://api.openweathermap.org/data/2.5/weather?q=roma&appid=' + key)
            .then((response) => {
                console.log(response); // Aggiunto per il debug
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Il sito non risponde');
                }
            })
            .then((serschResults) => {
                setData(serschResults);
                setError(null);

                console.log(data)
            })
            .catch((error) => {
                setError(error.message);
                console.log('Errore', error);
            });
    }, [key]);

    if (error) {
        return <Alert variant="danger">{error}</Alert>;
    }

    return (
        <>
            {data && <Card style={{ width: '18rem' }}>
                <div>
                    <p>{JSON.stringify(data.coord)}</p> {/* Mostra le coordinate in modo leggibile */}
                </div>
                <Card.Body>
                    <Card.Title>{data.name}</Card.Title>
                    <Card.Text>
                        Some quick example text to build on the card title and make up the
                        bulk of the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                </Card.Body>
            </Card>
            }
        </>
    )
}

export default CardMeteo;