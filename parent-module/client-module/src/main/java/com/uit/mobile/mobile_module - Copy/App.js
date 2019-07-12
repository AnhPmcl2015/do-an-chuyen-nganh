import React, {Component} from 'react';
import {createStackNavigator, createAppContainer} from 'react-navigation';
import LoginForm from './App/Component/LoginForm'
import QRScan from './App/Component/QrScan';
import Logout from './App/Component/Logout';
import Logo from './App/Component/Logo';

const Navigation = createStackNavigator({
    LoginForm: LoginForm,
    QRScan: QRScan,
    Logout: Logout,
    Logo: Logo,
}, {initialRouteName: 'LoginForm'});



const App = createAppContainer(Navigation);

export default App;