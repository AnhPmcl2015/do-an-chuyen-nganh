import React from 'react';
import './LoginRegister.scss';
import Footer from './../../common/Footer/Footer';
import LeftPaneLoginRegister from '../../common/LeftPaneLoginRegister/LeftPaneLoginRegister';
import LoginRegisterFormUser from './../../common/LoginRegisterForm/LoginRegisterFormUser';
import { LEFT_PANEL_CANDIDATE } from '../../constants/constants';

const LoginRegisterUser = ({match}) => {
    return (
        <section id="login-register-page">
            <main>
                <section className="container-fluid">
                    <section className="row">
                        <section id='login-register-page-left' className="col-md-12 col-lg-6 p-0 m-0">
                            <LeftPaneLoginRegister title={LEFT_PANEL_CANDIDATE.title} subTitle={LEFT_PANEL_CANDIDATE.subTitle}/>
                        </section>
                        <section id='login-register-page-right' className="col-md-12 col-lg-6 p-0 m-0">
                            <LoginRegisterFormUser type={match.params.type}/>
                        </section>
                    </section>
                </section>

            </main>

            <Footer/>
        </section>
    )
}

export default LoginRegisterUser;