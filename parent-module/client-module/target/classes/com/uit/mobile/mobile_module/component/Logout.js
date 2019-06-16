import React, {Component} from 'react';
import {StyleSheet, View, Text, Image, Alert, TouchableOpacity} from 'react-native';

export default class Logout extends Component {

    dangXuat = () =>{
        
    }

    render() {
        return (
            <TouchableOpacity style={styles.container} onPress={()=>this.dangXuat()}>
                <Image
                    style={{width: 25, height: 25, marginRight: 5}}
                    source={{
                    uri: 'https://png.icons8.com/sign-out/FFFFFF'
                }}/>
                <Text style={{color: 'white'
                }}>Đăng xuất</Text>
            </TouchableOpacity>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        width: 80,
        flexDirection: 'row',
        justifyContent: 'space-between',
        backgroundColor: 'transparent',
        alignItems: 'center',
        height: 40,
    }
});