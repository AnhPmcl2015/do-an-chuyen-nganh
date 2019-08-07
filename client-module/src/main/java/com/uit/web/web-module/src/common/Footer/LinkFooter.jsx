import React from 'react';
import './Footer.scss';
import { Link } from 'react-router-dom';
import { APP_LINK } from '../../constants/constants';

const LinkFooter = ({title, subLinks}) =>{
    return (
        <section className='link-footer'>
            <h4>{title}</h4>
            {
                subLinks.map((value, index) => {
                    return (
                        <section key={index}>
                             <Link to={APP_LINK.searchCompany + value.link}>{value.text}</Link>
                             <br/>
                        </section>
                    );
                })
            }
        </section>
    )
}

export default LinkFooter;