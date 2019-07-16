import React, {Component} from 'react';
import './LoginRegisterForm.scss';
import {Form, Input, Checkbox, notification, Modal} from 'antd';
import OrangeButton from './../OrangeButton/OrangeButton';
import {REGEX} from '../../constants/constants';

class RegisterFormUserTemp extends Component {

    handleModalOk = () => {
        if (this.props.registerState.otp === document.getElementById('modal-input').value) {
            notification.success({message: 'Đăng ký ứng viên', description: 'Đăng ký ứng viên thành công'});

            this.setState({visibleModal: false});
        } else {
            notification.error({message: 'Đăng ký ứng viên', description: 'Mã OTP không trùng khớp. Hãy thử lại!'})
        }
    }

    handleModalCancel = () => {}

    handleSubmit = (e) => {
        e.preventDefault();

        this
            .props
            .form
            .validateFields((err, value) => {
                if (!err) {
                    this.props.handleSubmit(value);
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
                            }, {
                                pattern: REGEX.username,
                                message: 'Tên đăng nhập bao gồm 1 chữ in hoa, 1 chữ thường và 1 chữ số'
                            }, {
                                min: 5,
                                message: 'Tên đăng nhập từ 5 ~ 15 ký tự'
                            }, {
                                max: 15,
                                message: 'Tên đăng nhập từ 5 ~ 15 ký tự'
                            }
                        ]
                    })(
                        <Input placeholder="Tên đăng nhập (từ 5 ~ 15 ký tự)"/>,)}
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
                        <Input type='password' placeholder="Nhập lại mật khẩu"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('confirmTerm', {
                        valuePropName: 'checked',
                        initialValue: false,
                        rules: [
                            {
                                required: true,
                                message: 'Bạn cần phải chấp nhận điều khoản sử dụng'
                            }
                        ]
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

                <Modal
                    id='modal-register-form'
                    onOk={this.handleModalOk}
                    okText='Xác nhận'
                    cancelText='Gửi lại mã'
                    onCancel={this.handleModalCancel}
                    title='Xác thực mã OTP'
                    visible={this.props.registerState.visibleModal}>
                    <section className="container-fluid">
                        <section className="row align-items-center">
                            <section
                                className="col-3"
                                style={{
                                textAlign: 'right'
                            }}>
                                Mã OTP:
                            </section>
                            <section className="col-9">
                                <Input id='modal-input' placeholder='Nhập mã OTP'/>
                            </section>
                        </section>
                    </section>
                </Modal>
            </Form>

        );
    }
}

const RegisterFormUser = Form.create({name: 'register-form'})(RegisterFormUserTemp);

export default RegisterFormUser;