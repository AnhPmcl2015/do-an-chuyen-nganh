import React from 'react';
import './LoginRegister.scss';
import { LEFT_PANEL_RECRUITMENT } from './../../constants/constants';
import LeftPaneLoginRegister from './../../common/LeftPaneLoginRegister/LeftPaneLoginRegister';
import Footer from './../../common/Footer/Footer';
import LoginRegisterFormRecruitment from './../../common/LoginRegisterForm/LoginRegisterFormRecruitment';

const LoginRegisterRecruitment = ({match}) => {

    const handleSubmitLoginRegister = (value) => {

    }

    return (
        <section id="login-register-page">
            <main>
                <section className="container-fluid">
                    <section className="row">
                        <section id='login-register-page-left' className="col-md-12 col-lg-6 p-0 m-0">
                            <LeftPaneLoginRegister
                                title={LEFT_PANEL_RECRUITMENT.title}
                                subTitle={LEFT_PANEL_RECRUITMENT.subTitle}/>
                        </section>
                        <section id='login-register-page-right' className="col-md-12 col-lg-6 p-0 m-0">
                            <LoginRegisterFormRecruitment handleSubmitLoginRegister={(value)=>handleSubmitLoginRegister(value)} type={match.params.type}/>
                        </section>
                    </section>
                </section>

            </main>

            <Footer/>
        </section>
    );
}

export default LoginRegisterRecruitment;