import React, {useState, useEffect} from 'react';
import Navigation from './../Navigation/Navigation';
import NavigationSmall from './../Navigation/NavigationSmall';

/**
 *  MainNavigatiion dùng để điều chỉnh Navigation khi ở 2 chế độ khác nhau
 * @param {blueBackground} param0 
 *     - bludBackground: dùng để thay đổi màu của navigation khi ở chế độ màn hình PC (true, false)
 */

const MainNavigation = ({blueBackground = false}) => {
    
    const [width, setWidth] = useState(window.innerWidth);

    useEffect(() => {

        window.addEventListener('resize', updateWindowDimensions);
        return () => {
            window.removeEventListener('resize', updateWindowDimensions);
        };
    })

    const updateWindowDimensions = () => {

        setWidth(window.innerWidth);
    }

    if(width > 990){
        return (
            <Navigation blueBackground={blueBackground}/>
        )
    }else{
        return (
            <NavigationSmall />
        )
    }
}

export default MainNavigation;