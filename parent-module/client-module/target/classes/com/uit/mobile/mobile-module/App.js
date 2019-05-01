
import React, {Component} from 'react';
import { createStackNavigator, createAppContainer } from 'react-navigation';
import LoginForm from './LoginForm';
import QRScan from './QrScan';

const Navigation = createStackNavigator({
    LoginForm: LoginForm,
    QRScan: QRScan
},{
    initialRouteName: 'QRScan'
});

const App = createAppContainer(Navigation);

export default App;