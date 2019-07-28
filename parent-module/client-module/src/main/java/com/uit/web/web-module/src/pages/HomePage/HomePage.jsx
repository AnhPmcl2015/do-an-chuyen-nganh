import React, {useState} from 'react';
import './HomePage.scss';
import Header from './../../common/Header/Header';
import Footer from './../../common/Footer/Footer';
import {DANH_SACH_KY_NANG} from '../../mockup/mockup';
import {Link} from 'react-router-dom';
import {Icon} from 'antd';
import MainNavigation from './../../common/Navigation/MainNavigation';

function HomePage() {

    return (
        <section id='home-page'>

            <MainNavigation blueBackground={false}/>
            <Header/>

            <main className="container">
                <section className="row" id='body-1'>
                    <figure id='banner'>
                        <img src='http://localhost:3000/images/banner.gif' alt='banner quảng cáo'/>
                    </figure>
                </section>
                <section className="row" id='body-2'>
                    <section className="col-12 col-md-8">
                        <h2 className='mb-1'>Công việc được
                            <strong>tìm kiếm nhiều</strong>
                        </h2>
                        <h4 className='weak-text'>Theo kỹ năng</h4>
                        <section>
                            {DANH_SACH_KY_NANG.map((value, key) => {
                                return <Link className='list-skills' key={key} to='/'>{value}</Link>
                            })
}
                        </section>
                    </section>
                    <section className="col-12 col-md-4">
                        <figure>
                            <figure id="banner"><img src="http://localhost:3000/images/header.jpg" alt="banner"/></figure>
                        </figure>
                    </section>

                </section>
                <section className="row" id='body-3'>
                    <section className='col-12' style={{marginTop: '15px'}}>
                        <h2>Những giá trị chúng tôi mang lại</h2>
                    </section>
                    <section className="col-12 col-md-4">
                        <Icon
                            style={{
                            color: 'black',
                            fontSize: '40px',
                            marginBottom: '10px'
                        }}
                            type="arrow-right"/>
                        <br/>
                        <h4>Nhiều việc làm hấp dẫn</h4>
                    </section>
                    <section className="col-12 col-md-4">
                        <Icon
                            style={{
                            color: 'black',
                            fontSize: '40px',
                            marginBottom: '10px'
                        }}
                            type="arrow-right"/>
                        <br/>
                        <h4>Nơi thể hiện năng lực của bạn</h4>
                    </section>
                    <section className="col-12 col-md-4">
                        <Icon
                            style={{
                            color: 'black',
                            fontSize: '40px',
                            marginBottom: '10px'
                        }}
                            type="arrow-right"/>
                        <br/>
                        <h4>Sự hỗ trợ tuyệt đối</h4>
                    </section>
                </section>
            </main>

            <Footer/>
        </section>
    );
}

export default HomePage;