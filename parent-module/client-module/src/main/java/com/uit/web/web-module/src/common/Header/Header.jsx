import React, {useState, useEffect} from 'react';
import './Header.scss';
import OrangeButton from './../OrangeButton/OrangeButton';
import {Icon, Tag, Input, AutoComplete} from 'antd';
import {TAGS_MOCKUP, AUTO_COMPLETE_MOCKUP} from './../../mockup/mockup';
import InputSearch from './../InputSearch/InputSearch';

const Header = () => {

    const handleOutputData = (value) => {
        
    }

    return (
        <header>
            <section className="background-image"></section>
            <section id="white-layter"></section>
            <section id="body">

                <section id="search-pane" className='mx-auto'>
                    <p>Tên công việc, kỹ năng hoặc công ty (tối đa 3)</p>
                    <InputSearch handleOutputData={(value) => handleOutputData(value)}/>
                    <section id='btn-search'>
                        <OrangeButton text='Tìm kiếm'/>
                    </section>
                </section>
            </section>
        </header>
    )
}

export default Header;