//3ec99fb7

import { Carousel } from 'react-bootstrap';
import React, { useEffect, useState } from 'react';

const Series = () => {
    const [data, setData] = useState([]);
    const [index, setIndex] = useState(0);

    const handleSelect = (selectedIndex) => {
        setIndex(selectedIndex);
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://www.omdbapi.com/?apikey=3ec99fb7&s=series');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const result = await response.json();
                console.log(result)
                setData(result.Search); // Aggiorna lo stato con i risultati
            } catch (error) {
                console.error('There was a problem with the fetch operation:', error);
            }
        };
        fetchData(); // Chiamata alla funzione fetchData
    }, []); // Passa un array vuoto come secondo argomento per eseguire l'effetto una sola volta al montaggio

    return (
        <>
        <Carousel activeIndex={index} onSelect={handleSelect}>
                {data.map((item) => {
                    return (
                           
                            <Carousel.Item key={item.imdbID}>
                                <img src={item.Poster} />
                                <Carousel.Caption>
                                <h3>{item.Title}</h3>
                                <p>Anno d'uscita: {item.Year}</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                          
                        )
                    })}
            </Carousel>
        </>
    );
};

export default Series;