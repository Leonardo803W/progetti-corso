import { useEffect, useState } from "react";
import { Alert } from "react-bootstrap";
import CardMeteo from "./CardMeteo";

const MainComponent = () => {

    const key = '3efe250117031385f4bd4b3fc329932b';
    const [data, setData] = useState({});
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('https://api.openweathermap.org/data/2.5/weather?q=roma&appid=' + key)
            .then((response) => {

                    console.log(response)

                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Il sito non risponde');
                }
            })
            .then((serschResults) => {
                setData(serschResults);
                setError(null);
            })
            .catch((error) => {
                setError(error.message);

                console.log('Errore', error);
            });
    }, [key]);

    if (error) {
        return <Alert variant="danger">{error}</Alert>;
    }

    console.log(data)

    return (
            <>
                <CardMeteo data = {data}/>
            </>
        )
}

export default MainComponent