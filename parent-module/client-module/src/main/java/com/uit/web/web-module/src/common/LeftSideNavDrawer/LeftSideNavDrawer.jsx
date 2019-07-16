import React, {useState} from 'react';
import './LeftSideNavDrawer.scss';
import {Drawer, Divider} from 'antd';
import LoginButton from './../LoginRegisterButton/LoginButton';
import LoginRegisterDrawer from './../LoginRegisterDrawer/LoginRegisterDrawer';
import RegisterButton from './../LoginRegisterButton/RegisterButton';
import { Link } from 'react-router-dom';
import { ACCESS_TOKEN } from './../../constants/constants';

const LeftSideNavDrawer = (props) => {

    const [typeDrawer,
        setTypeDrawer] = useState('dang-nhap');
    const [visibleDrawer,
        setVisibleDrawer] = useState(false);

    const closeLeftSideDrawer = () => {
        props.closeDrawer();
    }

    const openLoginDrawer = () => {
        setTypeDrawer('dang-nhap');
        setVisibleDrawer(true);
    }

    const closeLoginRegisterDrawer = () => {
        setVisibleDrawer(false);
    }

    const openRegisterDrawer = () => {
        setTypeDrawer('dang-ky');
        setVisibleDrawer(true);
    }

    return (
        <section>
            <LoginRegisterDrawer
                type={typeDrawer}
                close={closeLoginRegisterDrawer}
                visible={visibleDrawer}/>
            <Drawer
                className='left-side-nav-drawer'
                placement='left'
                onClose={() => closeLeftSideDrawer()}
                closable={true}
                visible={props.visible}
                width='360px'>

                <section className="container-fluid">
                    <section className="row align-items-center">
                        <section className="col-12">
                            <figure
                                style={{
                                textAlign: 'center'
                            }}><img width='150px' src="http://localhost:3000/images/logo.png" alt="logo"/></figure>
                        </section>
                        
                        {sessionStorage.getItem(ACCESS_TOKEN) === null && <><section className="col-6"><LoginButton onClick={() => openLoginDrawer()}/>
                        </section>
                        <section className="col-6"><RegisterButton onClick={() => openRegisterDrawer()}/></section></>}

                        <Divider />

                        <section className="col-12"><Link to='/'>CV</Link></section>
                        <Divider />
                        <section className="col-12"><Link to='/'>Việc làm</Link></section>
                        <Divider />
                        <section className="col-12"><Link to='/'>Công ty</Link></section>
                        <Divider />
                        <section className="col-12"><Link to='/'>Đánh giá</Link></section>
                        <Divider />
                        <section className="col-12"><Link to='/'>Blog</Link></section>
                        <Divider />
                        <section className="col-12"><Link to='/'>Liên hệ</Link></section>
                    </section>
                </section>
            </Drawer>
        </section>

    )
}

export default LeftSideNavDrawer;