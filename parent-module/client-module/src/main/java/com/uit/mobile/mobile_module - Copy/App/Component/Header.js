import React, {Component} from 'react';
import {Header} from 'react-native-elements';
import {StyleSheet} from 'react-native';
import Logout from './Logout';
import AvatarCustom from './Avatar';

export default class HeaderCustom extends Component {

    render() {
        return (
            <Header containerStyle={styles.container} backgroundColor={'#00B5EC'} leftComponent={< Logout />} rightComponent={< AvatarCustom />}/>
        );
    }  
}

const styles = StyleSheet.create({
    container: {
        height: 50,
        paddingTop: 5
    }
});
