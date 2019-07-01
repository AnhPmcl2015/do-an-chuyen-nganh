import {API_BASE_URL} from './ApiConstants';
import {ACCESS_TOKEN, MONTH_NAME} from './contants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json'
    });

    if(localStorage.getItem(ACCESS_TOKEN)){
        headers.append('Authorization', 'JobCentral ', localStorage.getItem(ACCESS_TOKEN));
    }

    let defaults = {headers};
    options = Object.assign({}, defaults, options);
    
    return fetch(options.url, options)
        .then(res => res.json().then(json => {
            if(!res.ok){
                return Promise.reject(json);
            }

            return json;
        }));
}
    
export const formatDate = (dateString) => {
    let date = new Date(dateString);
    let monthIndex = date.getMonth();
    let year = date.getFullYear();

    return MONTH_NAME[monthIndex] + ' ' + year;
}

export const formatDateTime = (dateTimeString) => {
    let date = new Date(dateTimeString);
    let monthIndex = date.getMonth();
    let year = date.getFullYear();

    return date.getDate() + ' ' + MONTH_NAME[monthIndex] + ' ' + year + ' - ' + date.getHours() + ':' + date.getMinutes();
}