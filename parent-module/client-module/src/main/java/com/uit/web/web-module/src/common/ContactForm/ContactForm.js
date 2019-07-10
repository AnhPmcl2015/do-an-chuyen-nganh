import React, {Component} from 'react'
import {Form, Input, Button, Icon} from 'antd';
import './ContactForm.scss';
import { REGEX } from '../../constants/constants';

const {TextArea} = Input;

class ContactFormTemp extends Component {

    handleSubmit = e => {
        e.preventDefault();
        this
            .props
            .form
            .validateFields((err, values) => {
                if (!err) {
                    console.log('Received values of form: ', values);
                }
            });
    };

    render() {
        const {getFieldDecorator} = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <Form.Item>
                    {getFieldDecorator('email', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập Email!'
                            }, {
                                pattern: REGEX.email,
                                message: 'Email không hợp lệ!'
                            }
                        ]
                    })(
                        <Input placeholder="Email"/>,)}
                </Form.Item>

                <Form.Item>
                    {getFieldDecorator('content', {
                        rules: [
                            {
                                required: true,
                                message: 'Vui lòng nhập nội dung!'
                            }
                        ]
                    })(
                        <TextArea placeholder="Nội dung"/>,)}
                </Form.Item>

                <Form.Item>
                    <Button htmlType="submit" className="send-button">
                        Gửi
                    </Button>
                </Form.Item>
            </Form>
        );
    }
}

const WrappedContactFormTemp = Form.create({name: 'contact-form'})(ContactFormTemp);

const ContactForm = () => {
    return (
        <section id="contact-form">
            <h4>Liên hệ</h4>
            <WrappedContactFormTemp/>
        </section>
    )
}

export default ContactForm;
