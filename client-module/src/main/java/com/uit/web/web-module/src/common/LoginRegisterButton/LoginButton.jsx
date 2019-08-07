import React from 'react';
import './LoginRegisterButton.scss';
import { Icon } from 'antd';

const LoginButton = (props) => {

    const clickButton = () => {
        props.onClick();
    }

    return (
        <button id='btn-dang-nhap' onClick={()=>clickButton()}>
            <Icon type='lock'/>
            Đăng nhập
        </button>
    )
}

export default LoginButton;