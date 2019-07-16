import React, {Component} from 'react';
import './LoginRegisterForm.scss';
import {Form, Input, Checkbox, Icon, Button} from 'antd';
import {REGEX} from '../../constants/constants';
import OrangeButton from './../OrangeButton/OrangeButton';
class RegisterFormRecruitmentTemp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            keys: [1]
        }
    }

    handleSubmit = (e) => {
        e.preventDefault();

        this
            .props
            .form
            .validateFields((err, value) => {
                if (!err) {
                    this
                        .props
                        .handleSubmit(value);
                }
            })

    }

    // addAddress = () => {
    //     const {keys} = this.state;
    //     let temp = [...keys];
    //     temp.push(temp.length + 1);
    //     this.setState({
    //         keys: [...temp]
    //     });
    // }

    // removeAddress = (address) => {
    //     let temp = this.state.keys.filter(k => address !== k);
    //     this.setState({
    //         keys: temp
    //     });
    // }

    render() {

        const {getFieldDecorator} = this.props.form;

        // const formItems = this.state.keys.map((k, index) => (

        //     <Form.Item key={index}>
        //         {getFieldDecorator(`address_${k}`, {
        //             rules: [
        //                 {
        //                     required: true,
        //                     message: 'Trường này không được để trống hoặc xóa đi'
        //                 }
        //             ]
        //         })(<Input placeholder={`Địa chỉ ${this.state.addressCount}`}/>)}

        //         {this.state.keys.length > 1
        //             ? (<Icon type='minus-circle-o' onClick={this.removeAddress(k)}/>)
        //             : null}
        //     </Form.Item>

        // ));

        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Item>
                    {getFieldDecorator('email', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Họ và Tên'
                            }, {
                                pattern: REGEX.email,
                                message: 'Định dạng email không đúng'
                            }
                        ]
                    })(
                        <Input placeholder="Email"/>,)}
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
                    {getFieldDecorator('companyName', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng không để trống trường này'
                            }
                        ]
                    })(
                        <Input placeholder="Tên công ty"/>,)}
                </Form.Item>

                {/* {formItems} */}

                {/* <Form.Item>
                    <Button type='dashed' onClick={this.addAddress}>
                        <Icon type='plus'/>
                        Thêm địa chỉ
                    </Button>
                </Form.Item> */}

                <Form.Item>
                    {getFieldDecorator('companyAddress', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng không để trống trường này'
                            }
                        ]
                    })(
                        <Input placeholder="Địa chỉ công ty (trụ sở chính)"/>,)}
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
            </Form>
        )
    }
}

const RegisterFormRecruitment = Form.create({name: 'register-form'})(RegisterFormRecruitmentTemp);

export default RegisterFormRecruitment;