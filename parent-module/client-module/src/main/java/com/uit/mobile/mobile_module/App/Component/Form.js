import React, { Component } from 'react';
import { Alert, Button, TextInput, View, StyleSheet, Image, Text, StatusBar, justifyContent, alignItems, TouchableOpacity, TouchableHighlight } from 'react-native';
//import SplashScreen from 'react-native-splash-screen'
import { Images } from '../Themes/index'
//import styles from './Logo.Styles'

export default class Logo extends Component {
/* constructor(props){
    super(props)
} */
  render (){
    return(
      <View style={styles.container}>
        <TextInput style={styles.inputBox} 
            underlineColorAndroid='rgba(0,0,0,0)' 
            placeholder="Số điện thoại"
            placeholderTextColor="#ffffff"
            selectionColor="#fff"
            keyboardType="phone-pad"
            onSubmitEditing={()=> this.password.focus()}
        />
        <TextInput style={styles.inputBox} 
            underlineColorAndroid='rgba(0,0,0,0)' 
            placeholder="Mật khẩu"
            secureTextEntry={true}
            placeholderTextColor="#ffffff"
            ref={(input)=> this.password = input}
        />
        
        <TouchableOpacity style={styles.button} onPress={this.props.onAuthButtonPress}>
            <Text style={styles.buttonText}> {this.props.type} </Text>
        </TouchableOpacity>
      </View>
    )
  }
}
/* export default class LoginForm extends Component {

  constructor(props) {
      super(props);
      state = {
          soDienThoai: '',
          matKhau: ''
      }
  }
  static navigationOptions = {
      header: null
  };
  login = () => {

      this
          .props
          .navigation
          .navigate('QRScan');
  }

  register = () => {
      Alert.alert('Không khớp số điện thoại');
  }

  render() {
      return (
          <View style={styles.container}>
              <View style={{
                  marginBottom: 30
              }}>

              </View>
              <View style={styles.inputContainer}>
                  <Image
                      style={styles.inputIcon}
                      source={{
                      uri: 'https://png.icons8.com/phone/ultraviolet/50/3498db'
                  }}/>
                  <TextInput
                      style={styles.inputs}
                      placeholder="Số điện thoại"
                      keyboardType="numeric"
                      underlineColorAndroid='transparent'
                      onChangeText={(soDienThoai) => this.setState({soDienThoai})}/>
              </View>

              <View style={styles.inputContainer}>
                  <Image
                      style={styles.inputIcon}
                      source={{
                      uri: 'https://png.icons8.com/key-2/ultraviolet/50/3498db'
                  }}/>
                  <TextInput
                      style={styles.inputs}
                      placeholder="Mật khẩu"
                      secureTextEntry={true}
                      underlineColorAndroid='transparent'
                      onChangeText={(matKhau) => this.setState({matKhau})}/>
              </View>

              <View style={styles.loginContainer}>

                  <TouchableHighlight
                      style={[styles.buttonContainer, styles.loginButton]}
                      onPress={() => this.login()}>
                      <Text style={styles.loginText}>Đăng nhập</Text>
                  </TouchableHighlight>

                  <View
                      onPress={() => this.register()}
                      style={{
                      height: 45,
                      justifyContent: 'center',
                      alignItems: 'center'
                  }}>
                      <Image
                          style={{
                          width: 20,
                          height: 20
                      }}
                          source={{
                          uri: 'https://png.icons8.com/plus/ultraviolet/50/3498db'
                      }}/>
                  </View>

                  <TouchableHighlight
                      style={styles.registerButton}
                      onPress={() => this.register()}>
                      <Text>Đăng ký</Text>
                  </TouchableHighlight>
              </View>

          </View>
      );
  }
} */


const styles = StyleSheet.create({
  container: {
    flexGrow: 1,
    justifyContent: "center",
    alignItems: "center"
  },

  inputBox: {
      width: 300,
      backgroundColor:'rgba(255, 255, 255, 0.2)',
      borderRadius: 25,
      paddingHorizontal: 16,
      fontSize:16,
      color:'#ffffff',
      marginVertical: 10,
  },
 button: {
     width: 300,
     backgroundColor: '#FF8C00',
     borderRadius: 25,
     marginVertical: 10,
     paddingVertical: 13    
  },
  buttonText: {
      fontSize: 16,
      fontWeight: '500',
      color: '#ffffff',
      textAlign:"center",
  },
  signupbutton: {
    fontSize: 16,
    fontWeight: '500',
    color: '#ffffff',
    textAlign:"center",
  },

  inputContainer: {
    borderBottomColor: '#F5FCFF',
    backgroundColor: '#FFFFFF',
    borderRadius: 30,
    borderBottomWidth: 1,
    width: 300,
    height: 45,
    marginBottom: 20,
    flexDirection: 'row',
    alignItems: 'center'
},
inputs: {
    height: 45,
    marginLeft: 16,
    borderBottomColor: '#FFFFFF',
    flex: 1
},
inputIcon: {
    width: 30,
    height: 30,
    marginLeft: 15,
    justifyContent: 'center'
},
buttonContainer: {
    height: 45,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20,
    borderRadius: 30

},
loginButton: {
    backgroundColor: "#00b5ec",
    width: 180
},
loginText: {
    color: 'white'
},
loginContainer: {
    position: 'relative',
    width: 300,
    height: 40,
    textAlign: 'left',
    flexDirection: 'row',
    justifyContent: 'space-between'
},
registerButton: {
    width: 70,
    height: 45,
    justifyContent: 'center'
} 
}) 