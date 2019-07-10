import React, {useState} from 'react'
import './Navigation.scss'
import { Button, Icon } from 'antd';
import LoginRegisterDrawer from './../LoginRegisterDrawer/LoginRegisterDrawer';
import RegisterButton from './../LoginRegisterButton/RegisterButton';
import LoginButton from './../LoginRegisterButton/LoginButton';
import OrangeBadge from './../OrangeBadge/OrangeBadge';

function Navigation() {

    const [typeDrawer, setTypeDrawer] = useState('dang-nhap');
    const [visibleDrawer, setVisibleDrawer] = useState(false);

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
        <nav id='nav' className="navbar navbar-expand-lg navbar-light bg-light">
            <LoginRegisterDrawer type={typeDrawer} close = {closeLoginRegisterDrawer} visible={visibleDrawer}/>
            
            <a className="navbar-brand" href="http://localhost:3000/">
                <figure>
                    <img id='logo' src='http://localhost:3000/images/logo.png' alt='logo'/>
                </figure>
            </a>
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <a className="nav-link" href="#">CV</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">Việc làm</a>
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
            <span className="navbar-text">
                <LoginButton onClick={()=>openLoginDrawer()}/>

                <RegisterButton onClick={()=>openRegisterDrawer()}/>
            </span>
        </nav>
    );
}

export default Navigation;