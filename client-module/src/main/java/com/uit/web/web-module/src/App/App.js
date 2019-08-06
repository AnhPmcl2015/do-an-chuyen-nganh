import React from 'react';
import HomePage from '../pages/HomePage/HomePage';
import {BrowserRouter as Router, Route} from "react-router-dom";
import {APP_LINK} from '../constants/constants';
import './style.scss';
import LoginRegisterUser from './../pages/LoginRegister/LoginRegisterUser';
import LoginRegisterRecruitment from './../pages/LoginRegister/LoginRegisterRecruitment';
import ListJobs from './../pages/ListJobs/ListJobs';
import ProcessEvalution from './../pages/ProcessEvalution/ProcessEvalution';
import ListEvalution from '../pages/ListEvalution/ListEvalution';


function App() {
    return (
        <Router>
                <Route exact path={APP_LINK.homePage} component={HomePage}/>
                <Route path={APP_LINK.authCandidate + ':type'} component={LoginRegisterUser}/>
                <Route
                    path={APP_LINK.authRecruitment + ':type'}
                    component={LoginRegisterRecruitment}/>
                <Route path={APP_LINK.listJobs} component={ListJobs}/>
                <Route path={APP_LINK.processEvalution} component={ProcessEvalution}/>
                <Route path={APP_LINK.listEvalutions} component={ListEvalution}/>
        </Router>
    );
}

export default App;
