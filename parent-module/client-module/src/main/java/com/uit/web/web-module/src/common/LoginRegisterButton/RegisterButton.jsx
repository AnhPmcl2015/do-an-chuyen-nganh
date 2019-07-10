import React from 'react';
import './LoginRegisterButton.scss';
import { Button } from 'antd';

const RegisterButton = (props) => {

    const clickButton = () => {
        props.onClick();
    }

    return (
        <Button id='btn-dang-ky' onClick={()=>clickButton()}>
            Đăng ký
        </Button>
    );
}

export default RegisterButton;