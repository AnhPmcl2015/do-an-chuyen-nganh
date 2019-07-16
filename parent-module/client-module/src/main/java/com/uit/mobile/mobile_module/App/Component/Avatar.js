import React, { Component } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { Avatar } from 'react-native';

export default class AvatarCustom extends Component {
    render(){
        return (
            <View style={styles.container}>
                <Text style={{color: 'white', marginRight: 5}}>
                    Phan Thế Anh
                </Text>

                <Avatar style={{width: 35, height: 35}} rounded title="MD"/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        width: 170,
        backgroundColor: 'transparent',
        flexDirection: 'row',
        justifyContent: 'flex-end',
        alignItems: 'center', 
        height: 40
    }
});