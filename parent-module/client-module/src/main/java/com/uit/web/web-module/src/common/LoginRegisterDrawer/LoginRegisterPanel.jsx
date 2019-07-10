import React from 'react'
import './LoginRegisterDrawer.scss'
import {Link, withRouter}  from 'react-router-dom'
import OrangeButton from './../OrangeButton/OrangeButton';

// data{
    // title
    // quote
    // buttonText
    // redirectUrl
    // smallUrl
// }

const LoginRegisterPanel = (props) => {

    const redirect = () => {
        if(props.data.redirectUrl === null && props.data.redirectUrl === undefined){
            return;
        }

        props.history.push(props.data.redirectUrl);
    }


    return (
        <section className='login-register-panel'>
            <h2>{props.data.title}</h2>
            <p>{props.data.quote}</p>
            <br/>

            <OrangeButton text={props.data.buttonText} onClick={() => redirect()}/>
            <br/>
            <Link to={props.data.smallUrl}>Chưa có tài khoản? {props.data.buttonText === 'Đăng nhập' ? 'Đăng ký' : 'Đăng nhập'}</Link>
        </section>
    )
}

export default withRouter(LoginRegisterPanel);