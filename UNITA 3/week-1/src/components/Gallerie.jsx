import { Container } from 'react-bootstrap';
import Spinner from 'react-bootstrap';

import Movies from './Movies';
import MyList from './MyList';
import Series from './Series';

const Gallerie = () => {
    return (
        <>
        <h3 className=' m-4'>
          Film
        </h3>

        <Container>
            <Movies/>
        </Container>

        <h3 className=' m-4'>
          Serie
        </h3>

        <Container>
            <Series/>
        </Container>

        <h3 className=' m-4'>
          Visti di Recente
        </h3>

        <Container>
            <MyList/>
        </Container>
        </>
    );
};

export default Gallerie;