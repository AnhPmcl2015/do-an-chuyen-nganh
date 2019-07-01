import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'antd/dist/antd.css';
import { BrowserRouter as Router } from 'react-router-dom';

ReactDOM.render(
    <Router>
    <App/>
</Router>, document.getElementById('root'));

serviceWorker.register();
