import React, {Component} from 'react';
import {createStackNavigator, createAppContainer} from 'react-navigation';
import LoginForm from './component/LoginForm';
import QRScan from './component/QrScan';
import Login from './component/Login';


const Navigation = createStackNavigator({
    LoginForm: LoginForm,
    QRScan: QRScan,
    Login: Login
}, {initialRouteName: 'Login'});

const App = createAppContainer(Navigation);

export default App;