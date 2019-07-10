import React from 'react';
import './LeftPaneLoginRegister.scss';

// title subTitle color

const LeftPaneLoginRegister = (props) => {
    return (
        <section id="left-pane-login-register">
            <section id='background-image'></section>
            <section className='orange-cover'></section>

            <section className="container-fluid">
                <section id='content' className='row align-items-center'>
                    <section className="col-12">
                        <h3>{props.title}</h3>
                        <p>{props.subTitle}</p>
                    </section>
                </section>
            </section>

        </section>
    );
}

export default LeftPaneLoginRegister;