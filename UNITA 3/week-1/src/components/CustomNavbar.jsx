import { Navbar, Nav, Container, Dropdown } from 'react-bootstrap'
import logo from './img/netflix_logo.png'
import avatar from './img/avatar.png'


const CustomNavbar = () => {
    return (
        <>
            <div className=' d-flex'>
                <Navbar bg="dark" data-bs-theme="dark">
                    <Container>
                    <Navbar.Brand href="#home">
                        <img src={logo} alt="logo web" />
                    </Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#TV Shows">TV Shows</Nav.Link>
                        <Nav.Link href="#Movies">Movies</Nav.Link>
                        <Nav.Link href="#Recently Added">Recently Added</Nav.Link>
                        <Nav.Link href="#My List">My List</Nav.Link>
                    </Nav>
                    </Container>
                </Navbar>

                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                    </svg>

                    <p>
                        kids
                    </p>

                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bell-fill" viewBox="0 0 16 16">
                    <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2m.995-14.901a1 1 0 1 0-1.99 0A5 5 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901"/>
                    </svg>

                    <img src={avatar} alt="avatar utente" />

                    <Dropdown>
                        <Dropdown.Toggle variant="success" id="dropdown-basic">
                           
                        </Dropdown.Toggle>

                        <Dropdown.Menu>
                            <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                            <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                            <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </div>
        </>
    )
}

export default CustomNavbar