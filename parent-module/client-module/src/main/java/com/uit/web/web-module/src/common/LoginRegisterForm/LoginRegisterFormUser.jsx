import React, {useEffect} from 'react';
import './LoginRegisterForm.scss';
import {Link} from 'react-router-dom';
import {APP_LINK} from '../../constants/constants';
import LoginFormUser from './LoginFormUser';
import RegisterFormUser from './RegisterFormUser';

const LoginRegisterFormUser = ({type}) => {

    useEffect(() => {}, [type])

    return (
        <section id='login-register-form'>
            <section id='login-register-form-nav'>
                <Link
                    className={type === 'dang-nhap'
                    ? 'underline-orange'
                    : ''}
                    to={APP_LINK.authCandidate + 'dang-nhap'}>Đăng nhập</Link>
                <Link
                    className={type === 'dang-ky'
                    ? 'underline-orange'
                    : ''}
                    to={APP_LINK.authCandidate + 'dang-ky'}>Đăng ký</Link>
            </section>

            <section id="login-register-form-body">
                {
                    type === 'dang-nhap' && <LoginFormUser/>
                }

                {
                    type === 'dang-ky' && <RegisterFormUser />
                }

            </section>

        </section>
    );
}

export default LoginRegisterFormUser;