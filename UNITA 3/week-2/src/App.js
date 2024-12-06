import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';

import CustomNavbar from './components/CustomNavbar';
import MainComponent from './components/MainComponent';

function App() {
  return (
    <div className="App">
      <header>
        <CustomNavbar/>
      </header>

      <main>
        <MainComponent/>
      </main>

      <footer>

      </footer>
    </div>
  );
}

export default App;
