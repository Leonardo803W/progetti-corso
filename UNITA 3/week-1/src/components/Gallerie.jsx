import { Container } from 'react-bootstrap';

import Movies from './Movies';
import MyList from './MyList';
import Series from './Series';

const Gallerie = () => {
    return (
        <>
        <h3>
          Film
        </h3>

        <Container>
            <Movies/>
        </Container>

        <h3>
          Serie
        </h3>

        <Container>
            <Series/>
        </Container>

        <h3>
          Visti di Recente
        </h3>

        <Container>
            <MyList/>
        </Container>
        </>
    );
};

export default Gallerie;