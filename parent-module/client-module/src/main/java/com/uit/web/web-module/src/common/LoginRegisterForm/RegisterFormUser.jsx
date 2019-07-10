import React, {Component} from 'react';
import './LoginRegisterForm.scss';
import {Form, Input, Checkbox} from 'antd';
import OrangeButton from './../OrangeButton/OrangeButton';
import {REGEX} from '../../constants/constants';

class RegisterFormUserTemp extends Component {

    handleSubmit = (e) => {
        e.preventDefault();

        this
            .props
            .form
            .validateFields((err, value) => {
                if (!err) {
                    console.log(value);
                }
            })

    }

    render() {
        const {getFieldDecorator} = this.props.form;

        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Item>
                    {getFieldDecorator('fullName', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Họ và Tên'
                            }
                        ]
                    })(
                        <Input placeholder="Họ và Tên"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('phoneNumber', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập số điện thoại'
                            }
                        ]
                    })(
                        <Input placeholder="Số điện thoại"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('username', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Tên đăng nhập'
                            }, {
                                whitespace: false,
                                message: 'Tên đăng nhập không được chứa khoảng trắng'
                            }
                        ]
                    })(
                        <Input placeholder="Tên đăng nhập"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('password', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Mật khẩu'
                            }, {
                                pattern: REGEX.password,
                                message: 'Mật khẩu bao gồm 1 ký tự hoa, 1 ký tự thường và 1 số'
                            }, {
                                min: 5,
                                message: 'Mật khẩu từ 5 ~ 20 ký tự'
                            }, {
                                max: 20,
                                message: 'Mật khẩu từ 5 ~ 20 ký tự'
                            }, {
                                whitespace: false,
                                message: 'Mật khẩu không được chứa khoảng trắng'
                            }
                        ]
                    })(
                        <Input type='password' placeholder="Mật khẩu (từ 5 ~ 20 ký tự)"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('confirmPassword', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng không để trống trường này'
                            }
                        ]
                    })(
                        <Input placeholder="Nhập lại mật khẩu"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('confirmTerm', {
                        valuePropName: 'checked',
                        initialValue: false
                    })(
                        <Checkbox>Chấp nhận điều khoản sử dụng</Checkbox>
                    )}
                    <OrangeButton onClick={() => {}} htmlType='submit' text='ĐĂNG KÝ'/>
                    <section
                        style={{
                        color: 'red',
                        fontSize: '11px'
                    }}>
                        <em>(*) Các trường thông tin là bắt buộc</em>
                    </section>
                </Form.Item>

            </Form>

        );
    }
}

const RegisterFormUser = Form.create({name: 'register-form'})(RegisterFormUserTemp);

export default RegisterFormUser;