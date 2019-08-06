import React, {useState, useEffect} from 'react'
import './ProcessEvalution.scss'
import {withRouter} from 'react-router-dom';
import MainNavigation from './../../common/Navigation/MainNavigation';
import EvalutionForm from './../../common/EvalutionForm/EvalutionForm';
import Footer from '../../common/Footer/Footer';
import AvatarProfile from './../../common/AvatarProfile/AvatarProfile';
import {Collapse, Icon, Divider, Button} from 'antd';
import EvalutionDetail from './../../common/EvalutionDetail/EvalutionDetail';
import {AUTO_COMPLETE_MOCKUP} from './../../mockup/mockup';
const {Panel} = Collapse;

/**
 *
 * @param {match} param0
 *      match.params.id
 *      match.params.session
 */

const defaultState = {
    dataForDetail: AUTO_COMPLETE_MOCKUP,
    skills: []
}

const ProcessEvalution = ({match}) => {

    const [state,
        setState] = useState(defaultState);

    useEffect(() => {
        console.log(match.params);
    });

    // Xử lý các thông tin cơ bản của Evalution Form
    const handleSubmitEvalutionForm = (values) => {}

    // Xử lý xóa thông tin đánh giá kỹ năng
    const handleDeletingSkillDetail = (obj) => {}

    // Xử lý thêm và chỉnh sửa thông tin kỹ năng
    const handleChangeEvalutionDetail = obj => {
        let temp = state.skills.find(tempObj => tempObj.mainSkill.trim() === obj.mainSkill.trim());

        // Thêm mới
        if(temp === null) {
            let tempList = state.skills;
            tempList.push(obj);
            setState({
                ...state,
                skills: tempList
            });
        // cập nhật
        }else{
            let tempList = state.skills;
            for(let i = 0; i < tempList.length; i++){
                if(tempList[i].mainSkill.trim() === obj.mainSkill.trim()){
                    tempList[i] = obj;
                }
            }
            setState({
                ...state,
                skills: tempList
            });
        }
    }

    // Xử lý thêm trường để thêm kỹ năng mới
    const addSkill = () => {
        
        if(state.skills.length !== 0){
            let space = state.skills.filter(obj => obj.mainSkill() === '');

            if(space !== null){
                return;
            }
        }

        let temp = state.skills;
        temp.push({
            mainSkill: '',
            subSkills: [],
            point: 1,
            evalution: ''
        });

        setState({
            ...state,
            skills: temp
        });

    }

    return (
        <section id="process-evalution-page">
            <MainNavigation blueBackground={true}/>

            <section className="container-fluid">
                <section className="row">
                    <section className="col-md-8 col-12">
                        <h4 className='title text-3dabd0'>ĐÁNH GIÁ NĂNG LỰC ỨNG VIÊN: &nbsp;
                            <span className='text-ff8c00'>PHAN THẾ ANH</span>
                            &nbsp;
                        </h4>

                        <EvalutionForm
                            handleEvalutionForm={(values) => handleSubmitEvalutionForm(values)}/>
                    </section>

                    <section
                        className="col-md-4 col-12"
                        style={{
                        padding: '10px'
                    }}>
                        <AvatarProfile/>

                        <Collapse
                            accordion
                            expandIcon={() =>< Icon type = 'user' style = {{fontSize:'20px', marginTop: '-2px'}}/>}>
                            <Panel header='Người đánh giá 1' key='1'>
                                <ul>
                                    <li>
                                        <strong>Công ty:</strong>
                                    </li>
                                    <li>
                                        <strong>Điểm đánh giá:</strong>
                                    </li>
                                </ul>
                            </Panel>
                        </Collapse>
                    </section>
                </section>

            </section>
            <section className="container" id='evalution-details'>
                <section className="row">
                    <section
                        className="col-12 text-ff8c00"
                        style={{
                        padding: '10px 20px',
                        textAlign: 'center'
                    }}>
                        <h4
                            className='text-ff8c00'
                            style={{
                            fontWeight: '700'
                        }}>TIÊU CHÍ ĐÁNH GIÁ</h4>
                        <p>Anh/Chị vui lòng chọn vào ô tương ứng cho từng tiêu chí theo từng mức độ. Nếu
                            có nhận xét Anh/Chị vui lòng điền vào ô “Nhận xét, đánh giá”</p>
                        <Divider/>
                    </section>

                    <section className="col-12 text-center mb-4">
                        <section className="container-fluid">
                            <section className="row">
                                <section className="col-4"></section>
                                <section className="col-4">
                                    <h5 className='text-ff8c00'>Tổng điểm</h5>
                                    <section
                                        className="progress"
                                        style={{
                                        borderRadius: '10px'
                                    }}>
                                        <section
                                            className="progress-bar"
                                            role="progressbar"
                                            aria-valuenow="50"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            style={{
                                            width: '50%',
                                            backgroundColor: '#ff8c00'
                                        }}></section>
                                    </section>
                                </section>
                                <section className="col-4"></section>
                            </section>
                        </section>
                    </section>
                </section>

                <section className="row text-center font-weight-700">
                    <section className="col-4"></section>
                    <section className="col-4 container-fluid">
                        <section className="row">
                            <section className="col-12">
                                Điểm đánh giá
                            </section>
                        </section>

                        <section className="row mt-2">
                            <section className="col-3">1</section>
                            <section className="col-3">2</section>
                            <section className="col-3">3</section>
                            <section className="col-3">4</section>
                        </section>
                    </section>
                    <section className="col-4">Nhận xét, đánh giá</section>
                </section>

                <Divider/> 
                {state
                    .skills
                    .map((val, key) => {
                        return (<EvalutionDetail
                            handleDeletingSkillDetail={(obj) => handleDeletingSkillDetail(obj)}
                            dataSource={state.dataForDetail}
                            index={1}
                            handleChangeEvalutionDetail={(obj) => handleChangeEvalutionDetail(obj)}/>);
                    })}

                <section className='btn-skill'>
                    <Button type='dashed' onClick={() => addSkill()}><Icon type='plus-circle'/>Thêm kỹ năng
                    </Button>
                </section>
            </section>
            <Footer/>
        </section>
    )
}

export default withRouter(ProcessEvalution);