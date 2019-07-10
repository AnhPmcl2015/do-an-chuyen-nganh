import React, {useState} from 'react';
import './Navigation.scss'
import {Icon} from 'antd';
import LeftSideNavDrawer from './../LeftSideNavDrawer/LeftSideNavDrawer';

const NavigationSmall = () => {

    const [visibleLeftSideDrawer, setVisibleLeftSideDrawer] = useState(false);

    const openLeftSideDrawer = () => {
        setVisibleLeftSideDrawer(true);
    }

    const closeLeftSideDrawer = () => {
        setVisibleLeftSideDrawer(false);
    }

    return (
        <nav id="nav-small" className='container-fluid'>

            <LeftSideNavDrawer closeDrawer={()=>closeLeftSideDrawer()} visible={visibleLeftSideDrawer}/>

            <section className="row align-items-center">
                <section id='btn-menu' className="col-2 mx-auto">
                    <Icon type="menu" onClick={()=> openLeftSideDrawer()}/>

                </section>

                <section className="col-8 mx-auto">
                    <figure id='logo-nav-small'>
                        <img src='http://localhost:3000/images/logo.png' alt='logo'/>
                    </figure>
                </section>

                <section className="col-2"></section>
            </section>
        </nav>
    )
}

export default NavigationSmall;