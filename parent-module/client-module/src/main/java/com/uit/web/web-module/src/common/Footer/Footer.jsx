import React from 'react';
import './Footer.scss';
import LinkFooter from './LinkFooter';
import {CONG_TY_TUYEN_DUNG, CONG_VIEC_PHO_BIEN, NOI_LAM_VIEC} from './../../mockup/mockup';
import ContactForm from './../ContactForm/ContactForm';

const Footer = () => {
    return (
        <footer className='container-fluid'>
            <section className="row">
                <section className="col-sm-12 col-md-6 col-lg-3">
                    <LinkFooter title='Các công ty tuyển dụng' subLinks={CONG_TY_TUYEN_DUNG}/>
                </section>
                <section className="col-sm-12 col-md-6 col-lg-3">
                    <LinkFooter title='Công việc phổ biến' subLinks={CONG_VIEC_PHO_BIEN}/>
                </section>
                <section className="col-sm-12 col-md-6 col-lg-3">
                    <LinkFooter title='Nơi làm việc' subLinks={NOI_LAM_VIEC}/>
                </section>
                <section className="col-sm-12 col-md-6 col-lg-3">
                    <ContactForm />
                </section>
            </section>
        </footer>
    )
}

export default Footer;