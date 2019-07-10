import React from 'react';
import HomePage from '../pages/HomePage/HomePage';
import {BrowserRouter as Router, Route} from "react-router-dom";
import {APP_LINK} from '../constants/constants';
import './style.scss';
import LoginRegisterUser from './../pages/LoginRegister/LoginRegisterUser';
import LoginRegisterRecruitment from './../pages/LoginRegister/LoginRegisterRecruitment';


function App() {
    return (
        <Router>
                <Route exact path={APP_LINK.homePage} component={HomePage}/>
                <Route path={APP_LINK.authCandidate + ':type'} component={LoginRegisterUser}/>
                <Route
                    path={APP_LINK.authRecruitment + ':type'}
                    component={LoginRegisterRecruitment}/>
        </Router>
    );
}

export default App;