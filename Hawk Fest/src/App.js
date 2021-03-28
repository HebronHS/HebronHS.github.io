import './App.css';
import { BrowserRouter, Route } from 'react-router-dom'
import Map from './components/Map'

function App() {
  return (
    <BrowserRouter>
      <Map />
      <Route exact path='/pages/Lesotho/General%20Info.html' render={() => { window.location.href = "/pages/Lesotho/General%20Info.html" }} />
    </BrowserRouter>

  );
}

export default App;
