import React, {useState} from 'react'
import './LoginRegisterDrawer.scss'
import {Drawer} from 'antd';
import LoginRegisterPanel from './LoginRegisterPanel';
import {LOGIN_DRAWER, REGISTER_DRAWER} from '../../constants/constants';

const LoginRegisterDrawer = (props) => {

    let drawerData = null;
    if (props.type === 'dang-nhap') {
        drawerData = LOGIN_DRAWER;
    } else {
        drawerData = REGISTER_DRAWER;
    }

    const closeDrawer = () => {
        props.close();
    }

    return (
        <section >
            <Drawer
                className='login-register-drawer'
                placement='top'
                visible={props.visible}
                onClose={closeDrawer}
                closable={true}>
                <section className="container-fluid">
                    <section className="row">
                        <section id='left' className="col-sm-12 col-md-6 col-lg-6">
                            <LoginRegisterPanel data={drawerData[0]}/>
                        </section>
                        <section id='right' className="col-sm-12 col-md-6 col-lg-6">
                            <LoginRegisterPanel data={drawerData[1]}/>
                        </section>
                    </section>
                </section>
            </Drawer>
        </section>

    )
}

export default LoginRegisterDrawer;