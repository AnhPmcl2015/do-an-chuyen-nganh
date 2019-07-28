import React, {useState, useEffect} from 'react'
import './InputSearch.scss';
import { Icon, Tag, AutoComplete } from 'antd';
import {TAGS_MOCKUP, AUTO_COMPLETE_MOCKUP} from './../../mockup/mockup';

/**
 * handleOutputData: Dùng để lấy data ra
 */

const state = {
    inputValue: '',
    tags: TAGS_MOCKUP,
    inputVisible: false,
    dataSource: AUTO_COMPLETE_MOCKUP
};

const InputSearch = ({handleOutputData}) => {

    const [defaultState, setDefaultState] = useState(state);

    useEffect(() => {
        handleOutputData(defaultState.tags);
    }, [defaultState.tags])

    const closeTag = (e, text) => {
        e.preventDefault();
        let newTags = defaultState.tags.filter(tag => tag !== text);
        setDefaultState({
            ...defaultState,
            tags: newTags
        });
    }

    const showInput = () => {
        setDefaultState({
            ...defaultState,
            inputVisible: true
        });
    }

    const handleInputChange = (value) => {
        setDefaultState({
            ...defaultState,
            inputValue: value
        });
    }

    const blurAutoComplete = () => {
        handleInputConfirm(defaultState.inputValue);
    }

    const handleSelectAutoComplete = (value) => {
        handleInputConfirm(value);
    }

    const handleInputConfirm = (value) => {
        let tempTags = defaultState.tags;
        if (value && defaultState.tags.indexOf(value) === -1) {
            tempTags = [
                ...defaultState.tags,
                value
            ];
        }

        setDefaultState({
            ...defaultState,
            tags: tempTags,
            inputVisible: false,
            inputValue: ''
        });
    }

    return (
        <section id="input-search">
            <Icon type="search" id='icon-search'/> 
            
            {defaultState.tags.map((text, index) => {
                return <Tag onClose={(e) => closeTag(e, text)} closable key={index} color='#ff8c00'>{text}</Tag>
            })}

            {defaultState.inputVisible && defaultState.tags.length < 3 && <AutoComplete
                allowClear={true}
                dataSource={defaultState.dataSource}
                onSearch={(value) => handleInputChange(value)}
                onBlur
                ={() => blurAutoComplete()}
                onSelect={(value) => handleSelectAutoComplete(value)}
                placeholder='Nhập từ tìm kiếm'
                filterOption={(inputValue, option) => option.props.children.toLowerCase().indexOf(inputValue.toLowerCase()) !== -1}/>}

            {!defaultState.inputVisible && defaultState.tags.length < 3 && (
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
    )
}

export default InputSearch;
 