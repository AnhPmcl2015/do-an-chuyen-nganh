import React, {Component} from 'react';
import {createStackNavigator, createAppContainer} from 'react-navigation';
import LoginForm from './component/LoginForm';
import QRScan from './component/QrScan';



const Navigation = createStackNavigator({
    LoginForm: LoginForm,
    QRScan: QRScan
}, {initialRouteName: 'QRScan'});

const App = createAppContainer(Navigation);

export default App;