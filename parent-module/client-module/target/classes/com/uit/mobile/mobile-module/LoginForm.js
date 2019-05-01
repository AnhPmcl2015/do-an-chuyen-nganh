import React, {Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    TextInput,
    Button,
    TouchableHighlight,
    Image,
    Alert
} from 'react-native';
import {Icon, Header} from 'react-native-elements';

const soDienThoaiPattern = '(070|079|077|076|078|089|090|093|083|084|085|081|082|088|091|094|032|033|034|035' +
        '|036|037|038|039|086|096|097|098|056|058|092|059|099)+([0-9]{7})\b';

export default class LoginForm extends Component {

    constructor(props) {
        super(props);
        state = {
            soDienThoai: '',
            matKhau: ''
        }
    }

    login = () => {

        // if (this.state.soDienThoai !== '') {     if
        // (this.state.soDienThoai.match(soDienThoaiPattern)) {
        // Alert.alert('Khớp số điện thoại');     } else {         Alert.alert('Không
        // khớp số điện thoại');     } }

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
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#DCDCDC'
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