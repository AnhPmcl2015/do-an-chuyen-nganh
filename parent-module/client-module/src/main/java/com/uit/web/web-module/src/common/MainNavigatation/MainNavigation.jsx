import React, {useState, useEffect} from 'react';
import Navigation from './../Navigation/Navigation';
import NavigationSmall from './../Navigation/NavigationSmall';

const MainNavigation = () => {
    
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
            <Navigation />
        )
    }else{
        return (
            <NavigationSmall />
        )
    }
}

export default MainNavigation;