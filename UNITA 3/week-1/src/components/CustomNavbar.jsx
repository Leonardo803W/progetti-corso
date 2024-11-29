import { Navbar, Nav, Container, Dropdown } from 'react-bootstrap'
import logo from './img/netflix_logo.png'
import avatar from './img/avatar.png'


const CustomNavbar = () => {
    return (
        <>
            <div className=' d-flex justify-content-between'>
                <Navbar>
                    <Container>
                    <Navbar.Brand href="#home">
                        <img src={logo} alt="logo web" class = "topImg"/>
                    </Navbar.Brand>
                    <Nav className="me-auto">
                        <a className=' ms-2 me-2 text-decoration-none text-light' href="#home">Home</a>
                        <a className=' ms-2 me-2 text-decoration-none text-light' href="#TV Shows">TV Shows</a>
                        <a className=' ms-2 me-2 text-decoration-none text-light' href="#Movies">Movies</a>
                        <a className=' ms-2 me-2 text-decoration-none text-light' href="#Recently Added">Recently Added</a>
                        <a className=' ms-2 me-2 text-decoration-none text-light' href="#My List">My List</a>
                    </Nav>
                    </Container>
                </Navbar>

                <div className=' d-flex align-items-center'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                    </svg>

                    <p className=' ms-4 me-4 mb-0'>
                        kids
                    </p>

                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bell-fill" viewBox="0 0 16 16">
                    <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2m.995-14.901a1 1 0 1 0-1.99 0A5 5 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901"/>
                    </svg>

                    <img src={avatar} alt="avatar utente"  class = "topImg"/>

                    <Dropdown>
                        <Dropdown.Toggle className=' bg-black border-0' id="dropdown-basic">
                           
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