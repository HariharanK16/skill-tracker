// import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListAllProfiles from './components/ListAllProfiles';
import AddProfileComponent from './components/AddProfileComponent';
// import HeaderComponent from './components/HeaderComponent';
// import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
        <div className='container'>
          <Switch>
            <Route exact path="/" component = {ListAllProfiles}></Route>
            <Route path="/skill-tracker/api/v1/admin/profiles" component = {ListAllProfiles}></Route>
            <Route path="/skill-tracker/api/v1/engineer/add-profile" component={AddProfileComponent}></Route>
          </Switch>
        </div>
        <FooterComponent/>
      </Router>
    </div>
    
  );
}

export default App;
