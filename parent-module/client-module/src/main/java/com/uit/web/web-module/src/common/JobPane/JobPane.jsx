import React from 'react'
import './JobPane.scss'
import { BASE_LINK, APP_LINK } from '../../constants/constants';
import { Link } from 'react-router-dom';
import { Checkbox, Icon } from 'antd';

/**
 * Thông tin tóm tắt của Job ở danh sách công việc
 * @param data
 *     icon: logo của công ty,
        companyName: Tên công ty,
        idJob: Id của Job,
        title: 'Tên Job,
        summary: mô tả ngắn về job
        salary: Mức lương,
        expirationDate: Ngày hết hạn tuyển dụng,
        location: Địa điểm làm việc,
        time: Thời gian cập nhật
        
    @param children
    @param handleChangeCheckBox 
        Lấy dữ liệu của job khi thực hiện thao tác checkbox
 */
const JobPane = ({data, children, handleChangeCheckBox}) => {

    const changeCheckbox = (e) => {
        handleChangeCheckBox(e.target.checked, e.target.value);
    }

    return (
        <section className="job-pane container-fluid">
            <Checkbox value={data.idJob} onChange={(e)=>changeCheckbox(e)}></Checkbox>
            <section className="row">
                <section className="col-9 media">
                    <img src={data.icon} alt={data.companyName}/>

                    <section className="media-body ml-3">
                        <h5 className="mt-0">{data.title}</h5>
                        <h6 className="mt-0 weak-text">{data.companyName}</h6>
                        <section className="summary">
                            {children + `...`}
                            <Link to={APP_LINK.jobDetail + data.idJob}>Đọc thêm</Link>
                        </section>
                    </section>
                </section>

                <section className="col-3">
                    <p className='weak-text'>{data.time}</p>
                    <p><i class="fas fa-comments-dollar"></i>{data.salary}</p>
                    <p><i class="fas fa-history"></i>{data.expirationDate}</p>
                    <p><i class="fas fa-map-marker-alt"></i>{data.location}</p>
                </section>
            </section>
        </section>
    )
}

export default JobPane;