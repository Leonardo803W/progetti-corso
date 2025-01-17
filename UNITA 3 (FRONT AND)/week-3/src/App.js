import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'

import CustomNavbar from './components/CustomNavbar';
import Novita from './components/Novita';
import Episodi from './components/Episodi';
import Uscite from './components/Uscite';
import Esplorare from './components/Esplorare';
import CustomFooter from './components/CustomFooter';
import Layout from './components/Layout';

function App() {

  return (
    <div id='greatConteiner'>
      <header>
        <CustomNavbar/>
      </header>
      
      <main>
        <h1 className=' text-light ms-3 mt-4'>
          Novita'
        </h1>

        <hr className=' text-light ms-3 me-3'></hr>

        <Novita/>

        <h3 className=' text-light ms-3 mt-5'>
          Nuovi episodi radio 

          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
            <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
          </svg>
        </h3>

        <Episodi/>

        <h3 className=' text-light ms-3 mt-4'>
          Nuove uscite

          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
            <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
          </svg>
        </h3>

        <Uscite/>

        <h3 className=' text-light ms-3 mt-4'>
          Altro da esplorare
        </h3>

        <Esplorare/>
      </main>

      <footer>
        <CustomFooter/>

        <Layout/>
      </footer>
    </div>
  );
}

export default App;
