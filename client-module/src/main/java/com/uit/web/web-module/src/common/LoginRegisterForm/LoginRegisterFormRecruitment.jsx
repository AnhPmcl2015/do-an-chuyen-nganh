import React from 'react';
import './LoginRegisterForm.scss';
import { APP_LINK } from './../../constants/constants';
import { Link } from 'react-router-dom';
import LoginFormRecruitment from './LoginFormRecruitment';
import RegisterFormRecruitment from './RegisterFormRecruitment';

const LoginRegisterFormRecruitment = ({type, handleSubmitLoginRegister}) => {

    const handleSubmitLogin = (value) => {
        handleSubmitLoginRegister(value);
    }

    const handleSubmitRegister = (value) => {
        handleSubmitLoginRegister(value);
    }

    return (
        <section id='login-register-form'>
            <section id='login-register-form-nav'>
                <Link
                    className={type === 'dang-nhap'
                    ? 'underline-orange'
                    : ''}
                    to={APP_LINK.authRecruitment + 'dang-nhap'}>Đăng nhập</Link>
                <Link
                    className={type === 'dang-ky'
                    ? 'underline-orange'
                    : ''}
                    to={APP_LINK.authRecruitment + 'dang-ky'}>Đăng ký</Link>
            </section>

            <section id="login-register-form-body">
                {type === 'dang-nhap' && <LoginFormRecruitment handleSubmit={(value) => handleSubmitLogin(value)}/>}

                {type === 'dang-ky' && <RegisterFormRecruitment handleSubmit={(value)=>handleSubmitRegister(value)}/>}
            </section>

        </section>
    )
}

export default LoginRegisterFormRecruitment;