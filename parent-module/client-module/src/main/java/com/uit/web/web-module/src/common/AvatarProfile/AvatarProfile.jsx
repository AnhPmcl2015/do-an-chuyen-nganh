import React from 'react'
import './AvatarProfile.scss'
import { IMAGE_CONST } from './../../constants/StaticConstants';
import { Divider } from 'antd';

const AvatarProfile = () => {
    return(
        <figure id="avatar-profile">
            <img alt='avatar' src={IMAGE_CONST.avatar}/> 

            <figcaption>
                <p id='fullname'>Phan Thế Anh</p>
                <p className='weak-text'>Java Developer</p>
            </figcaption>

            <Divider/>
        </figure>
    )
}

export default AvatarProfile;