import React from 'react'
import './ListJobs.scss'
import MainNavigation from './../../common/Navigation/MainNavigation';
import Footer from './../../common/Footer/Footer';
import InputSearch from './../../common/InputSearch/InputSearch';
import OrangeButton from '../../common/OrangeButton/OrangeButton';
import FilterPane from './../../common/FilterPane/FilterPane';
import {FILTER_PANE, JOB_PANE} from './../../mockup/mockup';
import JobPane from '../../common/JobPane/JobPane';

const ListJobs = () => {

    const handleOutputData = (value) => {
        console.log(value);
    }

    /**
     * Dùng cho mục đích filter các job hiện tại
     * @param {boolean} checked 
     * @param {String} value 
     */
    const choiceFilter = (checked, value) => {}

    /**
     * Dùng để lựa chọn sự thay đổi của checkbox của job
     * @param {boolean} checked 
     * @param {String} value 
     */
    const changeJobCheckbox = (checked, value) => {
    }

    return (
        <section id="list-jobs-page">
            <MainNavigation blueBackground={false}/>
            <section id='search-pane' className='container-fluid'>
                <section className="row">
                    <section id="input-pane">
                        <InputSearch handleOutputData={(value) => handleOutputData(value)}/>
                    </section>

                    <section id='button-search'>
                        <OrangeButton text='Tìm kiếm'/>
                    </section>
                </section>
            </section>

            <section
                className="container-fluid"
                style={{
                marginTop: '20px'
            }}>
                <section className="row">
                    <section className="col-12 col-md-3 mx-0 px-0" id='filter-panes'>
                        <h4>Bộ lọc tìm kiếm</h4>
                        <FilterPane
                            dataSource={FILTER_PANE}
                            hanleChoice={(e, value) => choiceFilter(e, value)}>Kỹ năng</FilterPane>
                        <FilterPane
                            dataSource={FILTER_PANE}
                            hanleChoice={(e, value) => choiceFilter(e, value)}>Kỹ năng</FilterPane>
                        <FilterPane
                            dataSource={FILTER_PANE}
                            hanleChoice={(e, value) => choiceFilter(e, value)}>Kỹ năng</FilterPane>
                        <FilterPane
                            dataSource={FILTER_PANE}
                            hanleChoice={(e, value) => choiceFilter(e, value)}>Kỹ năng</FilterPane>
                    </section>

                    <section className="col-12 col-md-9" id='job-panes'>
                        <section style={{marginBottom: '15px'}}>
                            <OrangeButton text='Ứng tuyển ngay' onClick={()=>{}}/>
                            <span style={{fontWeight: '700', marginLeft: '15px'}}>Chọn những công việc bạn muốn ứng tuyển</span>
                        </section>
                        {JOB_PANE.map((data, key) => {
                            return (
                                <JobPane key={key} handleChangeCheckBox={(checked, value) => changeJobCheckbox(checked, value)} data={data}>{data.summary}</JobPane>
                            )
                        })}

                    </section>
                </section>
            </section>
            <Footer/>
        </section>
    )
}

export default ListJobs;