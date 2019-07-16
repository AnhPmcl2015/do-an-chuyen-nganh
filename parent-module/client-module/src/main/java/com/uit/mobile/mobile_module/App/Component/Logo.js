import React, { Component } from 'react';
import { Alert, Button, TextInput, View, StyleSheet, Image, Text, StatusBar, justifyContent, alignItems } from 'react-native';
//import SplashScreen from 'react-native-splash-screen'
import { Images } from '../Themes/index'
//import styles from './Logo.Styles'

export default class Logo extends Component {
  render (){
    return(
      <View style={styles.container}>
      <Image style={{width:200, height:200}} source={Images.images.logo} />
        <Text style={styles.logoText}> Welcome to TopFactors </Text> 
      </View>
    )
  }
}


/* export default class Logo extends Component {
  render(){ 
    return(
      <View>
        <Text>Logo</Text>
      </View>
    )
  }
} */
const styles = StyleSheet.create({
  container: {
    flexGrow: 1,
    justifyContent: "flex-end",
    alignItems: "center"
  },
  logoText:{
    marginVertical: 15,
    fontSize: 18,
    color: '#FFFFFF',
  }
}) 