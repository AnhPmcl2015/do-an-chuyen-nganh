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
    TouchableOpacity
} from 'react-native';
import {Icon, Header} from 'react-native-elements';
import Logo from '../Component/Logo';
import Form from '../Component/Form';
import {Actions} from 'react-native-router-flux';


export default class Login extends Component {
    signup() {
        Actions.signup()
    }

    render() {
        return(
            <View style={styles.container}>
                <Logo/>
                <Form type="Đăng nhập"/>
                <View style={styles.signupTextCont}>
                    <Text style={styles.sigupText}> Bạn chưa có tài khoản? </Text>
                    <TouchableOpacity onPress={this.signup}>
                    <Text style={styles.signupbutton}> Đăng ký ngay </Text>
                    </TouchableOpacity>
                </View>
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

                    <Text style={{
                        fontSize: 30
                    }}>Đăng nhập</Text>
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
        backgroundColor: '#3DABD0',
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        
    },
    signupTextCont: {
        flexGrow: 1,
        alignItems: "flex-end",
        justifyContent: "center",
        paddingVertical: 16,
        flexDirection: "row"
    },
    sigupText: {
        color: 'rgba(255, 255, 255, 0.7)',
        fontSize: 16
    },
    signupbutton: {
        color:'#ffffff',
        fontSize: 16,
        fontWeight: '500'
    },

/*          inputContainer: {
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
    }  */
});