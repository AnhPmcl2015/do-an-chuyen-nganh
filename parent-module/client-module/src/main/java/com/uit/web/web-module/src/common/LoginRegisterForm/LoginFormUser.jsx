import React, {Component} from 'react';
import './LoginRegisterForm.scss';
import { Form, Input, Divider } from 'antd';
import OrangeButton from './../OrangeButton/OrangeButton';
import { APP_LINK, REGEX } from '../../constants/constants';
import { Link } from 'react-router-dom';
import { QRCode } from 'react-qr-svg';

class LoginFormUserTemp extends Component {

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, value) => {
            if(!err){
                console.log(value);
            }
        })
    }

    render() {
        const {getFieldDecorator} = this.props.form;

        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Item>
                    {getFieldDecorator('phoneNumberOrUserName', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập số điện thoại hoặc Tên đăng nhập!'
                            }
                        ]
                    })(
                        <Input placeholder="Số điện thoại hoặc Tên đăng nhập"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('password', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập mật khẩu'
                            },{
                                pattern: REGEX.password,
                                message: 'Mật khẩu bao gồm 1 ký tự hoa, 1 ký tự thường và 1 số'
                            }
                        ]
                    })(
                        <Input type='password' placeholder="Mật khẩu (từ 5 ~ 20 ký tự)"/>,)}
                </Form.Item>

                <Form.Item>
                    <OrangeButton onClick={()=>{}} htmlType='submit' text='ĐĂNG NHẬP'/>
                    <Link to={APP_LINK.forgotPasswordUser}>Quên mật khẩu</Link>
                </Form.Item>

                
                <Divider
                    style={{
                    backgroundColor: '#3dabd0'
                }}/>

                <h4>Đăng nhập bằng mã QR</h4>

                <section id="qr-scan">
                    <QRCode
                        bgColor="#FFFFFF"
                        fgColor="#000000"
                        level="Q"
                        style={{
                        width: 70
                    }}
                        value="some text"/>
                </section>
            </Form>

        );
    }
}

const LoginFormUser = Form.create({name: 'login-form'})(LoginFormUserTemp);

export default LoginFormUser;