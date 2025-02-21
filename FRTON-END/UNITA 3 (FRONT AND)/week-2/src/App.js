import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import { Form } from 'react-bootstrap';
import { useState } from 'react';

import CustomNavbar from './components/CustomNavbar';
import MainComponent from './components/MainComponent';
import GiorniFuturi from './components/GiorniFuturi';
import CustomFooter from './components/CustomFooter';

function App() {

  const [inputValue, setInputValue] = useState('londra')

  const handelInputChange = (event) => {
    setInputValue(event.target.value)

  }

  return (
    <div className="App">
      <header>
        <CustomNavbar/>
      </header>

      <main>
      <Form.Control
          size="sm"
          type="text"
          placeholder="Enter city"
          value={inputValue}
          onChange={handelInputChange}
          className=' w-50 m-3 me-auto ms-auto'
        />

        <MainComponent inputValue = {inputValue}/>

        <GiorniFuturi inputValue = {inputValue}/>

      </main>

      <footer>
        <CustomFooter/>
      </footer>
    </div>
  );
}

export default App;
