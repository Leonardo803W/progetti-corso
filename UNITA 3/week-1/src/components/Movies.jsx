//3ec99fb7

import { Carousel, Spinner } from 'react-bootstrap';
import React, { useEffect, useState } from 'react';

const Movies = () => {
    const [data, setData] = useState([]);
    const [index, setIndex] = useState(0);
    const [loading, setLoading] = useState(true); 
    const [error, setError] = useState(null); 

    const handleSelect = (selectedIndex) => {
        setIndex(selectedIndex);
    };

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            setError(null); 
            try {
                const response = await fetch('http://www.omdbapi.com/?apikey=3ec99fb7&s=Movies');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const result = await response.json();
                console.log(result)
                setData(result.Search || []);
            } catch (error) {
                console.error('There was a problem with the fetch operation:', error);
                setError(error.message); 
            } finally {
                setLoading(false); 
            }
        };
        fetchData();
    }, []);

    if (loading) {
        <Spinner animation="border" role="status" variant="success">
            <span className="visually-hidden">Loading...</span>
        </Spinner>
    }

    if (error) {
        return <div className="error">There was an error: {error}</div>; 
    }

    return (
        <Carousel activeIndex={index} onSelect={handleSelect} interval={null} className='movies-carousel'>
            {data.map((item) => (
                <Carousel.Item key={item.imdbID}>
                    <div className="carousel-item-content">
                        <img src={item.Poster} alt={item.Title} />
                    </div>
                    <Carousel.Caption>
                        <h3>{item.Title}</h3>
                        <p>Anno d'uscita: {item.Year}</p>
                    </Carousel.Caption>
                </Carousel.Item>
            ))}
        </Carousel>
    );
};

export default Movies;