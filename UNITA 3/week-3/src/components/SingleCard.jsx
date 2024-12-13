const SingleCard = (props) => {
    return (
        <div>
            <div>
                <img className="terzo" src={props.music.cover.picture_medium} alt="" />
            </div>

            <h5>
                {props.music.title_short}
            </h5>

            <p>
                {props.music.artist.name}
            </p>
        </div>
    )
}

export default SingleCard