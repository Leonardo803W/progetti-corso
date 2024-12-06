const ListaLuoighi = (props) =>{

    //console.log('sei nella lista:' + JSON.stringify(props))

    if (!props.data || !props.data.main || !props.data.main.temp) {
        return <p>Caricamento in corso...</p>;
    }

    const temperaturaAttuale = `${props.data.main.temp} °C`;

    //console.log(temperaturaAttuale)

    return (
        <div className=" mt-3 w-25 p-2" id="lista">
            <h3>Citta salvate</h3>
            <hr />
            <div>
                <h4>{props.data.name}</h4>
                <p>temperatura attuale: {temperaturaAttuale}</p>
                <p>velocita del vento: {props.data.wind.speed}</p>
            </div>
        </div>
    )
}

export default ListaLuoighi