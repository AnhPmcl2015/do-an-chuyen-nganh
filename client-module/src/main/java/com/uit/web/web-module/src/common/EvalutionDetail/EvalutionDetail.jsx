import React, {useState, useEffect} from 'react'
import { Input, Radio, AutoComplete, Icon, Button, Divider } from 'antd';
import {RADIO_INDEXS_EVALUTION_DETAIL} from './../../constants/constants';
/**
 * Evalution detail chứa thông tin các kỹ năng cùng với đánh giá và số điểm đánh giá
 *
 * @param {boolean} isForShowDetail
 *      Dùng chỉ để hiển thị dữ liệu chứ không có edit
 *
 * @param {function} handleChangeEvalutionDetail
 *      Dùng để truyền dữ liệu của evalution detail ra ngoài
 */

const defaultState = {
    mainSkill: '',
    subSkills: [],
    point: 1,
    evalution: ''
};

const EvalutionDetail = ({isForShowDetail, handleChangeEvalutionDetail, index, dataSource, handleDeletingSkillDetail}) => {

    const [detail,
        setDetail] = useState(defaultState);

    useEffect(() => {
        handleChangeEvalutionDetail(detail);
    }, [detail])

    // Thay đổi giá trị của Radio
    const changeRadio = e => {}

    // Chọn kỹ năng
    const selectAutoComplete = e => {
        setDetail({
            ...detail,
            mainSkill: e
        });
    }

    // Thêm trường đẻ thêm chi tiết kỹ năng
    const addSubSkill = () => {

        if(detail.subSkills.length !== 0){
            let space = detail.subSkills.filter(text => text.trim() === '');

            if(space !== null){
                return;
            }
        }

        let temp = detail.subSkills;
        temp.push('');

        setDetail({
            ...detail,
            subSkills: temp
        });
    }

    // Xóa chi tiết đánh giá hiện tại
    const deleteRecord = () => {}

    return (
        <section className="row evalution-detail">
            <section className="col-4">
                <section className='main-skill'>
                    <AutoComplete
                        allowClear={true}
                        style={{
                        width: '85%'
                    }}
                        placeholder='Nhập kỹ năng'
                        onSelect={(val) => selectAutoComplete(val)}
                        dataSource={dataSource}/>
                    <span onClick={() => deleteRecord()} className='evalution-detail-close-btn'>
                        <Icon type='close-circle'/></span>
                </section>

                {detail
                    .subSkills
                    .map((val, key) => {
                        return (
                            <section className='sub-skills' key={key}>
                                <AutoComplete
                                    style={{
                                    width: '100%'
                                }}
                                    allowClear={true}
                                    placeholder='Nhập chi tiết kỹ năng'/>
                            </section>
                        )
                    })}
                <section className='btn-skill'>
                    <Button type='dashed' onClick={()=>addSubSkill()}><Icon type='plus-circle'/>Thêm chi tiết kỹ năng</Button>
                </section>
            </section>

            {!isForShowDetail && <section className="col-4 container-fluid">

                <section className="row text-center pt-2">
                    {RADIO_INDEXS_EVALUTION_DETAIL.map((val, key) => {
                        return (
                            <section className="col-3" key={key}>
                                <section className="custom-control custom-radio">
                                    <input
                                        onChange={(e) => changeRadio(e)}
                                        type="radio"
                                        id={`radio_evalution_detail_${index}_${val}`}
                                        value={val}
                                        name={`radio_evalution_detail_${index}`}
                                        className="custom-control-input"/>
                                    <label
                                        className="custom-control-label"
                                        htmlFor={`radio_evalution_detail_${index}_${val}`}></label>
                                </section>
                            </section>
                        )
                    })}

                </section>
            </section>}

            <section className="col-4"><Input placeholder='Đánh giá'/></section>

            <section className="col-12">
                <Divider />
            </section>
        </section>
    )
}

export default EvalutionDetail;