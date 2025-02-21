import { useEffect, useState } from "react";
import { Alert, } from "react-bootstrap";

import ListaLuoighi from "./ListaLuoighi";
import CardMeteo from "./CardMeteo";

const MainComponent = (props) => {

    const key = '5fb43d9317a963bf83907952a8a8a3f3';
    const [data, setData] = useState({});
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('https://api.openweathermap.org/data/2.5/weather?q=' + props.inputValue + '&appid=' + key)
            .then((response) => {

                    //console.log(response)

                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Il sito non risponde');
                }
            })
            .then((serschResults) => {
                setData(serschResults);
                setError(null);    
                
                //console.log(data)
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
                <div className=" d-flex justify-content-around">
                    <ListaLuoighi data = {data}/>
                    <CardMeteo data = {data}/>
                </div>
            </>
        )
}

export default MainComponent