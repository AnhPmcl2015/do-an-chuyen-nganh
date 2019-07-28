import React, {useEffect} from 'react'
import './ProcessEvalution.scss'
import {withRouter} from 'react-router-dom';
import MainNavigation from './../../common/Navigation/MainNavigation';
import EvalutionForm from './../../common/EvalutionForm/EvalutionForm';
import Footer from '../../common/Footer/Footer';
import AvatarProfile from './../../common/AvatarProfile/AvatarProfile';
import { Collapse, Icon, Divider } from 'antd';

const {Panel} = Collapse;

/**
 *
 * @param {match} param0
 *      match.params.id
 *      match.params.session
 */
const ProcessEvalution = ({match}) => {

    useEffect(() => {
        console.log(match.params);
    });

    // Xử lý các thông tin cơ bản của Evalution Form
    const handleSubmitEvalutionForm = (values) => {}

    return (
        <section id="process-evalution-page">
            <MainNavigation blueBackground={true}/>

            <section className="container-fluid">
                <section className="row">
                    <section className="col-md-8 col-12">
                        <h4 className='title text-3dabd0'>ĐÁNH GIÁ NĂNG LỰC ỨNG VIÊN:
                            <span className='text-ff8c00'>PHAN THẾ ANH</span>
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
                    <section className="col-12 text-ff8c00" style={{padding: '10px 20px', textAlign: 'center'}}>
                        <h4 className='text-ff8c00' style={{fontWeight: '700'}}>TIÊU CHÍ ĐÁNH GIÁ</h4>
                        <p>Anh/Chị vui lòng chọn vào ô tương ứng cho từng tiêu chí theo từng mức độ. Nếu
                            có nhận xét Anh/Chị vui lòng điền vào ô “Nhận xét, đánh giá”</p>
                        <Divider/>
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
            </section>
            <Footer/>
        </section>
    )
}

export default withRouter(ProcessEvalution); 