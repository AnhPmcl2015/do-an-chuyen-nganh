import React, {Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    TextInput,
    Button,
    TouchableHighlight,
    Image,
    Alert,
    TouchableOpacity,
    StatusBar,
} from 'react-native';
import {Icon, Header} from 'react-native-elements';
import { Actions } from 'react-native-router-flux';
import {connect} from 'react-redux';
import Routes from './Component/Routes';


class Main extends Component {

    render() {
        return (
           
                    <View style={styles.container}>
                        <StatusBar
                            backgroundColor="#3DABD0"
                            barStyle="light-content"
                        />
                        <Routes/>
                    </View>
           

        )
    }
} 


const styles = StyleSheet.create({
    container: {
        //backgroundColor: '#3DABD0',
        flex: 1,
        //justifyContent: "center",
        //alignItems: "center",
        
    }

});

//export default Main;
export default connect (null, null)(Main)