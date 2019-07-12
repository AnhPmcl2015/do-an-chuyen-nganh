import React, { Component } from 'react';
import { Alert, Button, TextInput, View, StyleSheet, Image, Text } from 'react-native';
//import SplashScreen from 'react-native-splash-screen'
import { Images } from '../Themes/index'
import styles from './Logo.Styles'

export default class Logo extends Component {
  render (){
    return(
      <View style={styles.container}>
      <Image style={styles.backgroundImage} source={Images.images.logo} />
      <Text
        style={{
          fontFamily: 'Roboto-Bold',
          lineHeight: 24,
          color: 'white',
          marginTop: 44,
          marginLeft: 33,
          fontSize: 16
        }}>
        TOPFACTORS
      </Text>
      </View>
    )
  }
}

/* const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: ' center'
  }
}); */