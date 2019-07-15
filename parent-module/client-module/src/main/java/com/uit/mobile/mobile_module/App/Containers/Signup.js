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
    field
} from 'react-native';
import {Icon, Header} from 'react-native-elements';
import { Actions } from 'react-native-router-flux';
import { Field, reduxForm } from 'redux-form'


import Logo from '../Component/Logo';
import Form from '../Component/Form';
import InputText from '../Component/InputText';


class Signup extends Component {
    goBack() {
        Actions.pop();
    }
 
    createNewUser = ()=> {
        alert("boom")
    }

    onSubmit = (values) => {
        console.log(values);
    }

    renderTextInput = (field) => {
        const {meta: {touched, error}, placeholder, iconPassword, label, secureTextEntry, maxLength, keyboardType, value, onSubmitEditing, input: {onChange, ...restInput}} = field;
        return (
            <View>
                <InputText
                    onChangeText={onChange}
                    maxLength={maxLength}
                    placeholder={placeholder}
                    keyboardType={keyboardType}
                    secureTextEntry={secureTextEntry}
                    label={label}
                    {...restInput} />
                {(touched && error) && <Text style={styles.errorText}>{error}</Text>}
            </View>
        );
    }

    render() {
        const {handleSubmit} = this.props;
        return(
            <View style={styles.container}>
                <Logo/>
    
                <Field 
                    name="name" 
                    placeholder="Họ và tên"
                    component={this.renderTextInput}/>
                <Field 
                    name="phone" 
                    placeholder="Số điện thoại"
                    keyboardType="phone-pad"
                    component={this.renderTextInput}/>
                <Field 
                    name="password" 
                    placeholder="Mật khẩu"
                    secureTextEntry={true}
                    component={this.renderTextInput}/>

                <TouchableOpacity style={styles.button} onPress={this.props.handleSubmit(this.onSubmit)}>
                        <Text style={styles.buttonText}> Đăng ký </Text>
                </TouchableOpacity>

                <View style={styles.loginTextCont}>
                    <Text style={styles.loginText}> Bạn đã có tài khoản? </Text>
                    <TouchableOpacity onPress={this.goBack}>
                        <Text style={styles.loginbutton}> Đăng nhập </Text>
                    </TouchableOpacity>
                </View>
            </View>
        )
    }
}

const validate = (values) => {
    const errors = {};
    if(!values.name) {
        errors.name= "*Họ và tên bắt buộc*"
    }

    if(!values.phone) {
        errors.phone= "*Sđt bắt buộc*"
    }

    if(!values.password) {
        errors.password= "*Mật khẩu bắt buộc*"
    }
    return errors;
    }

    


export default reduxForm({
    form: 'register',
    validate
  })(Signup)
  

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#3DABD0',
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        
    },
    loginTextCont: {
        flexGrow: 1,
        alignItems: "flex-end",
        justifyContent: "center",
        paddingVertical: 16,
        flexDirection: "row",
    },
    loginText: {
        color: 'rgba(255, 255, 255, 0.7)',
        fontSize: 16
    },
    loginbutton: {
        color:'#ffffff',
        fontSize: 16,
        fontWeight: '500',
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
     errorText: {
         color: "#ffffff",
         fontSize: 12,
         paddingHorizontal: 16,
         paddingBottom: 8
     }
});