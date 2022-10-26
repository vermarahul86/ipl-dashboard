import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import { TeamPage } from './pages/TeamPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/teams/:teamNameParam" element={<TeamPage/>}/>
          </Routes>
      </Router>
     </div>
  );
}

export default App;
