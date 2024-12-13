const SingleCard = (props) => {
    return (
        <div className=" m-2">
            <div>
                <img className="terzo" src={props.music.album.cover_medium} alt="" />
            </div>

            <p>
                {props.music.title_short}
            </p>

            <p>
                {props.music.artist.name}
            </p>
        </div>
    )
}

export default SingleCard