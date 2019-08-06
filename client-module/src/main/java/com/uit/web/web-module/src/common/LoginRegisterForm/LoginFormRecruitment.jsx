import React, {Component} from 'react';
import './LoginRegisterForm.scss';
import { Form, Input, Divider, notification } from 'antd';
import OrangeButton from './../OrangeButton/OrangeButton';
import { APP_LINK, REGEX } from '../../constants/constants';
import { Link, withRouter } from 'react-router-dom';
import { QRCode } from 'react-qr-svg';
import {login} from '../../service/AuthRequest';
import { ACCESS_TOKEN } from './../../constants/constants';
import ErrorMessage from './../../constants/ErrorMessage';

class LoginFormRecruitmentTemp extends Component {

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, value) => {
            if(!err){
 

            }
        })
    }

    render() {
        const {getFieldDecorator} = this.props.form;

        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Item>
                    {getFieldDecorator('usernameOrEmail', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Email hoặc Tên đăng nhập!'
                            }
                        ]
                    })(
                        <Input placeholder="Email hoặc tên đăng nhập"/>,)}
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
                    <Link to={APP_LINK.forgotPasswordRecruitment}>Quên mật khẩu</Link>
                </Form.Item>
            </Form>

        );
    }
}

const LoginFormRecruitment = Form.create({name: 'login-form'})(LoginFormRecruitmentTemp);

export default withRouter(LoginFormRecruitment);