import React, { useState, useEffect } from 'react';
import SingleCard from "./SingleCard";

const Uscite = () => {

    const [music, setMusic] = useState([])

    const url = "https://striveschool-api.herokuapp.com/api/deezer/search?q=queen";

    useEffect(() => {
        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Errore nella chiamata fetch')
                }
                return response.json()
            })
            .then((result) => {
                
                console.log(result)
                
                setMusic(result.data.slice(0, 10))
            })
            .catch((error) => {
                //console.log(error);
            })
            
        }, [url])
        
        console.log(music)

    return (
        <div className=' d-flex text-light ms-2 overflow-hidden'>
            {music.map((m) => {

                //console.log(m)
                return <SingleCard key={m.id} music={m} />
            })}
        </div>
    );
}

export default Uscite;