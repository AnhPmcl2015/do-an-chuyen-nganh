import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'antd/dist/antd.css';
import App from './App/App';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import myReducer from './redux/reducers';

ReactDOM.render(
    <Provider store={createStore(myReducer)}><App/></Provider>, document.getElementById('root'));

serviceWorker.register();
