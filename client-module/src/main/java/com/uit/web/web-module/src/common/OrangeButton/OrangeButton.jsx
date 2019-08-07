import React from 'react';
import './OrangeButton.scss';
import { Button } from 'antd';

// text
// onClick (event click)
const OrangeButton = (props) => {


    return (
        <Button className='orange-button' htmlType={props.htmlType || ''} onClick={()=>{props.onClick()}}>
            {props.text}
        </Button>
    );
}

export default OrangeButton;