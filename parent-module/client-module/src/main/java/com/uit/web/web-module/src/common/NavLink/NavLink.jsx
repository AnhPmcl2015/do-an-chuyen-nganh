import React from 'react'
import './NavLink.scss'
import { Icon } from 'antd';

function NavLink({iconPath, text}){
    return(
        <section className='nav-link-custom'>
            <Icon style={{fontSize: '25px', marginRight: '10px'}} type={iconPath} />
            <span>{text}</span>
        </section>
    );
}


export default NavLink;