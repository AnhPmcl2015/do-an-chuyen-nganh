import React from 'react';
import './ListEvalution.scss';
import {Icon, Collapse, Divider} from 'antd';
import {withRouter} from 'react-router-dom';
import MainNavigation from '../../common/Navigation/MainNavigation';
import EvalutionForm from '../../common/EvalutionForm/EvalutionForm';
import Footer from '../../common/Footer/Footer';
import OrangeButton from '../../common/OrangeButton/OrangeButton';
const {Panel} = Collapse;

const evalutionDetail = {
    assessor: 'Phan Thế Anh',
    position: 'CEO TopFactors',
    company: 'TopFactors',
    major: 'Đây là 1 con người hoàn hảo về tất cả mọi mặt',
    communication: 'Đây là 1 con người hoàn hảo về tất cả mọi mặt',
    abilityOfDevelopment: 'Đây là 1 con người hoàn hảo về tất cả mọi mặt',
    otherEvalution: 'Đây là 1 con người hoàn hảo về tất cả mọi mặt'
};

const ListEvalution = ({match}) => {

    const handleSubmitEvalutionForm = values => {
        return;
    }
    
    return (
        <section id="list-evalution-page">
            <MainNavigation blueBackground={true}/>
            <article className="container-fluid">
                <section className="row">
                    <aside className='col-md-4 col-12'>
                        <h5 className='text-ff8c00 text-center mt-4'>Danh sách người đánh giá</h5>
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
                    </aside>

                    <article className='col-md-8 col-12 pt-4 pl-3'>
                    <section style={{marginLeft: '10px', marginBottom: '15px'}} className='row'>
                        <section className="col-6"><OrangeButton text='Thêm đánh giá'/></section>
                        <section className="col-6 text-right"><OrangeButton text='Xem biểu đồ'/></section>
                        <Divider/>
                    </section>
                        <EvalutionForm data={evalutionDetail}
                            handleEvalutionForm={(values) => handleSubmitEvalutionForm(values)}/>
                    </article>
                </section>
            </article>

            <Footer />
        </section>
    )
}

export default withRouter(ListEvalution);