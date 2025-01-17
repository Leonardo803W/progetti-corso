import { Dropdown } from "react-bootstrap"

const Introduction = () => {

    return (
        <>
            <div className=" d-flex align-items-center">
                <h1 className=" ms-4">
                    TV SHOWS
                </h1>

                <Dropdown className=" ms-4">
                <Dropdown.Toggle className=" bg-black border-light" id="dropdown-basic">
                    Generes
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                    <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                    <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                </Dropdown.Menu>
                </Dropdown>
            </div>
        </>
    )
}

export default Introduction