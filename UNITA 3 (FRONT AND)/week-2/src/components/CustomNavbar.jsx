import { Nav, Navbar, Container, Dropdown } from "react-bootstrap"

const CustomNavbar = () => {
    return (
        <div>
            <Navbar bg="dark" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="#home"><img src="https://www.termometropolitico.it/newmedia/2024/07/Parlare-del-meteo-in-inglese-1080x600-1.jpg" alt="logo web" /></Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#week">week</Nav.Link>
                            <Nav.Link href="#details">details</Nav.Link>
                        </Nav>
                </Container>

                <Dropdown>
                    <Dropdown.Toggle variant="" id="dropdown-basic">
                        profilo
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>

                <img src="https://static.vecteezy.com/ti/vettori-gratis/p1/35734982-avatar-icona-vettore-utente-illustrazione-cartello-account-simbolo-personale-la-zona-logo-vettoriale.jpg" alt="user" />
            </Navbar>
        </div>
    )
}

export default CustomNavbar