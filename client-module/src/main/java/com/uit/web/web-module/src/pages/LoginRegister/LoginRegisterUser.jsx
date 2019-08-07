import React, {useState} from 'react';
import './LoginRegister.scss';
import Footer from './../../common/Footer/Footer';
import LeftPaneLoginRegister from '../../common/LeftPaneLoginRegister/LeftPaneLoginRegister';
import LoginRegisterFormUser from './../../common/LoginRegisterForm/LoginRegisterFormUser';
import {LEFT_PANEL_CANDIDATE} from '../../constants/constants';
import { login, signUp } from '../../service/AuthRequest';
import { ACCESS_TOKEN } from './../../constants/constants';
import ErrorMessage from './../../constants/ErrorMessage';
import { notification } from 'antd';
import { withRouter } from 'react-router-dom';


const LoginRegisterUser = ({match, history}) => {

     const [registerState, setRegisterState] = useState({
        otpCode: '',
        visibleModal: false
     });
    

    const handleSubmitLoginRegisterUser = (value) => {
        if (match.params.type === 'dang-nhap') {
            let loginRequest = Object.assign({}, value);

            login(loginRequest).then(res => {
                sessionStorage.setItem(ACCESS_TOKEN, res.accessToken);
                history.push('/');
            }).catch(err => {
                if (err.status === 401) {
                    notification.error({message: 'Đăng nhập ứng viên', description: ErrorMessage.loginCandidate_401});
                } else {
                    notification.error({
                        message: 'Đăng nhập ứng viên',
                        description: err.message || ErrorMessage.undefinedError
                    })
                }
            })
        } else {
            let signUpRequest = Object.assign({}, value);
            signUp(signUpRequest).then(res => {
                setRegisterState({otpCode: res.message, visibleModal: true});
            }).catch(err => {
                if (err.status === 400) {
                    notification.error({message: 'Đăng ký ứng viên', description: err.message});
                } else {
                    notification.error({
                        message: 'Đăng ký ứng viên',
                        description: err.message || ErrorMessage.undefinedError
                    });
                }
            })
        }
    }

    return (
        <section id="login-register-page">
            <main>
                <section className="container-fluid">
                    <section className="row">
                        <section id='login-register-page-left' className="col-md-12 col-lg-6 p-0 m-0">
                            <LeftPaneLoginRegister
                                title={LEFT_PANEL_CANDIDATE.title}
                                subTitle={LEFT_PANEL_CANDIDATE.subTitle}/>
                        </section>
                        <section id='login-register-page-right' className="col-md-12 col-lg-6 p-0 m-0">
                            <LoginRegisterFormUser
                                registerState={registerState}
                                handleSubmitLoginRegisterUser={(value) => handleSubmitLoginRegisterUser(value)}
                                type={match.params.type}/>
                        </section>
                    </section>
                </section>

            </main>

            <Footer/>
        </section>
    )
}

export default withRouter(LoginRegisterUser);