import React from 'react';
import './UngVienNavigation.scss';
import NavLink from '../NavLink/NavLink';

function UngVienNavigation(){
    
    return(
        <nav id="ung-vien-nav">
            <figure id="ung-vien-avatar">
                <img src='/images/user.png' alt='Hình đại diện'></img>
                <figcaption>
                    <span id='ung-vien-ten'><strong>Phan Thế Anh</strong></span>
                    <br/>
                    <span id='ung-vien-cap-bac'>Ứng viên</span>
                </figcaption>
            </figure>

            <section className='nav-links-custom'>
                <NavLink iconPath='home' text='Trang chủ'/>
            </section>
        </nav>
    );
}

export default UngVienNavigation;