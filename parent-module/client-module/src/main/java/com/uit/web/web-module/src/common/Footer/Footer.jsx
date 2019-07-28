import React from 'react';
import './Footer.scss';
import ContactForm from './../ContactForm/ContactForm';
import { IMAGE_CONST } from './../../constants/StaticConstants';
import { Link } from 'react-router-dom';
import { Icon } from 'antd';
import { APP_LINK } from '../../constants/constants';

const Footer = () => {
    return (
        <footer className='container-fluid'>
            <section className="row">
                {/* <section className="col-sm-12 col-md-6 col-lg-3">
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
                </section> */}
                <section className="col-12 col-md-6">
                    <figure>
                        <img src={IMAGE_CONST.logoFullWhite} alt='Logo'/>
                    </figure>

                    <section id='footer-nav'>
                        <Link>CV</Link>
                        <span>&nbsp;*&nbsp;</span>
                        <Link to={APP_LINK.listJobs}>Việc làm</Link>
                        <span>&nbsp;*&nbsp;</span>
                        <Link>Công ty</Link>
                        <span>&nbsp;*&nbsp;</span>
                        <Link>Đánh giá</Link>
                        <span>&nbsp;*&nbsp;</span>
                        <Link>Blog</Link>
                        <span>&nbsp;*&nbsp;</span>
                        <Link>Liên hệ</Link>
                    </section>

                    <section id='copyright'>
                        TopFactors &copy; 2019
                    </section>

                    <section id='social'>
                        <Icon type="facebook" />
                    </section>
                </section>
                <section className="col-12 col-md-6 text-right"><ContactForm /></section>
            </section>
        </footer>
    )
}

export default Footer;