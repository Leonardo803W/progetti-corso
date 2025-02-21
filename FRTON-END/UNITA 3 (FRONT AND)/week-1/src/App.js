import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';

import Introduction from './components/Introduction';
import CustomNavbar from './components/CustomNavbar';
import Gallerie from './components/Gallerie';
import CustomFooter from './components/CustomFooter';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <CustomNavbar />
      </header>

      <main>
        <Introduction/>

        <Gallerie/>
      </main>

      <footer>
        <CustomFooter/>
      </footer>
    </div>
  );
}

export default App;
