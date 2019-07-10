import React, {useState, useEffect} from 'react';
import './Header.scss';
import OrangeButton from './../OrangeButton/OrangeButton';
import {Icon, Tag, Input, AutoComplete} from 'antd';
import {TAGS_MOCKUP, AUTO_COMPLETE_MOCKUP} from './../../mockup/mockup';

const Header = () => {

    const [tags,
        setTags] = useState(TAGS_MOCKUP);

    const [inputVisible,
        setInputVisible] = useState(false);

    const [inputValue,
        setInputValue] = useState('');

    const [dataSource,
        setDataSource] = useState(AUTO_COMPLETE_MOCKUP);

    const closeTag = (e, text) => {
        e.preventDefault();
        let newTags = tags.filter(tag => tag !== text);
        setTags(newTags);
    }

    const showInput = () => {
        setInputVisible(true);
    }

    const handleInputChange = (value) => {
        setInputValue(value);
    }

    const blurAutoComplete = () => {
        handleInputConfirm(inputValue);
    }

    const handleSelectAutoComplete = (value) => {
        handleInputConfirm(value);
    }

    const handleInputConfirm = (value) => {
        let tempTags = tags;
        if (value && tags.indexOf(value) === -1) {
            tempTags = [
                ...tags,
                value
            ];
        }
        setTags(tempTags);
        setInputVisible(false);
        setInputValue('');
    }

    return (
        <header>
            <section className="background-image"></section>
            <section id="white-layter"></section>
            <section id="body">

                <section id="search-pane" className='mx-auto'>
                    <p>Tên công việc, kỹ năng hoặc công ty (tối đa 3)</p>
                    <section id="input-search">
                        <Icon type="search" id='icon-search'/> {tags.map((text, index) => {
                            return <Tag onClose={(e) => closeTag(e, text)} closable key={index} color='#ff8c00'>{text}</Tag>
                        })}

                        {inputVisible && tags.length < 3 && <AutoComplete
                            allowClear={true}
                            dataSource={dataSource}
                            onSearch={(value) => handleInputChange(value)}
                            onBlur
                            ={() => blurAutoComplete()}
                            onSelect={(value) => handleSelectAutoComplete(value)}
                            placeholder='Nhập từ tìm kiếm'
                            filterOption={(inputValue, option) => option.props.children.toLowerCase().indexOf(inputValue.toLowerCase()) !== -1}/>
}

                        {!inputVisible && tags.length < 3 && (
                            <Tag
                                onClick={() => showInput()}
                                style={{
                                background: '#fff',
                                borderStyle: 'dashed'
                            }}>
                                <Icon type="plus"/>
                                Tìm kiếm
                            </Tag>
                        )}
                    </section>
                    <section id='btn-search'>
                        <OrangeButton text='Tìm kiếm'/>
                    </section>
                </section>
            </section>
        </header>
    )
}

export default Header;