import React, {useState} from 'react'
import './Navigation.scss'
import LoginRegisterDrawer from './../LoginRegisterDrawer/LoginRegisterDrawer';
import RegisterButton from './../LoginRegisterButton/RegisterButton';
import LoginButton from './../LoginRegisterButton/LoginButton';
import OrangeBadge from './../OrangeBadge/OrangeBadge';
import {ACCESS_TOKEN, BASE_LINK, SPLASH, APP_LINK} from './../../constants/constants';
import { IMAGE_CONST } from './../../constants/StaticConstants';

function Navigation({blueBackground = false}) {

    const [typeDrawer,
        setTypeDrawer] = useState('dang-nhap');
    const [visibleDrawer,
        setVisibleDrawer] = useState(false);

    const openLoginDrawer = () => {
        setTypeDrawer('dang-nhap');
        setVisibleDrawer(true);
    }

    const openRegisterDrawer = () => {
        setTypeDrawer('dang-ky');
        setVisibleDrawer(true);
    }

    const closeLoginRegisterDrawer = () => {
        setVisibleDrawer(false);
    }

    return (
        <nav id='nav' className={`navbar navbar-expand-lg navbar-light bg-light ${blueBackground && 'nav-blue-background'}`}>
            <LoginRegisterDrawer
                type={typeDrawer}
                close={closeLoginRegisterDrawer}
                visible={visibleDrawer}/>

            <a className="navbar-brand" href={BASE_LINK + SPLASH}>
                <figure>
                    {!blueBackground && <img id='logo' src={IMAGE_CONST.logo} alt='logo'/>}
                    {blueBackground && <img id='logo' src={IMAGE_CONST.logoFullWhite} alt='logo'/>}
                </figure>
            </a>
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <a className="nav-link" href="#">CV</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href={APP_LINK.listJobs}>Việc làm</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Công ty</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Đánh giá</a>
                    <OrangeBadge text='hot'/>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Blog</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Liên hệ</a>
                </li>

            </ul>

            {sessionStorage.getItem(ACCESS_TOKEN) === null && <span className="navbar-text">
                <LoginButton onClick={() => openLoginDrawer()}/>

                <RegisterButton onClick={() => openRegisterDrawer()}/>
            </span>}

        </nav>
    );
}

export default Navigation;