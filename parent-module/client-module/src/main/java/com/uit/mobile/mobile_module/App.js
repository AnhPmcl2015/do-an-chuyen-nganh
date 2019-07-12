import React, {Component} from 'react';
import {createStackNavigator, createAppContainer} from 'react-navigation';
//import LoginForm from './App/Component/LoginForm'
//import Signup from './App/Component/Signup';
import QRScan from './App/Component/QrScan';
import Logout from './App/Component/Logout';
import Logo from './App/Component/Logo';


import { StyleSheet, Text, View, Platform, StatusBar, fontSize } from 'react-native';
import {Provider} from "react-redux";
import { PersistGate } from 'redux-persist/integration/react';

import store from './App/Config/Store';
import Main from './App/Main';
import persist from './App/Config/Store'
/* const Navigation = createStackNavigator({
    LoginForm: LoginForm,
    QRScan: QRScan,
    Logout: Logout,
    Logo: Logo,
}, {initialRouteName: 'Logo'});



const App = createAppContainer(Navigation); */

const persistStore= persist();

export default class App extends Component {
    render(){
        return (
            <Provider store={persistStore.store}>
                    <PersistGate loading={null} persistor={persistStore.persistor}>
                        <Main/>
                    </PersistGate>
            </Provider>

        );
    }
}