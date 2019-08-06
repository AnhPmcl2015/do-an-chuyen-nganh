import React, {useState, useEffect} from 'react'
import './EvalutionForm.scss'
import {Form, Input, notification} from 'antd';
import CKEditor from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import ErrorMessage from './../../constants/ErrorMessage';
const {TextArea} = Input;
const defaultFormData = {
    assessor: '',
    currentPosition: '',
    currentCompany: '',
    major: '',
    communication: '',
    abilityOfDevelopment: '',
    otherEvalution: ''
};

const ckeditorConfig = {
    toolbar: ['bold', 'italic', 'link', 'bulletedList']
};

/**
 * Form đánh giá ứng viên
 * @param {function} handleEvalutionForm
 *      Truyền dữ liệu của form ra ngoài
 */
const EvalutionFormTemp = ({form, handleEvalutionForm, data}) => {

    const [formData,
        setFormData] = useState(defaultFormData);

    useEffect(() => {
        handleEvalutionForm(formData);
    }, [formData])

    // Khi blur khỏi trường Khả năng phát triển
    const changeAbilityOfDevelopment = (e, editor) => {
        if (data !== null) {
            return;
        }
        if (editor.getData().trim() === '') {
            let errorMess = ErrorMessage
                .blank
                .replace('%s', 'Khả năng phát triển');
            notification.error({message: 'Lỗi!', description: errorMess});
            return;
        }
        setFormData({
            ...formData,
            abilityOfDevelopment: editor.getData()
        });
    }

    // Khi blur khỏi trường khả năng giao tiếp
    const changeCommunication = (e, editor) => {
        if (data !== null) {
            return;
        }
        if (editor.getData().trim() === '') {
            let errorMess = ErrorMessage
                .blank
                .replace('%s', 'Khả năng giao tiếp');
            notification.error({message: 'Lỗi!', description: errorMess});
            return;
        }
        setFormData({
            ...formData,
            communication: editor.getData()
        });
    }

    // Khi blur trường đánh giá chuyên môn
    const changeMajor = (e, editor) => {

        if (data !== null) {
            return;
        }

        if (editor.getData().trim() === '') {
            let errorMess = ErrorMessage
                .blank
                .replace('%s', 'Chuyên môn');
            notification.error({message: 'Lỗi!', description: errorMess});
            return;
        }
        setFormData({
            ...formData,
            major: editor.getData()
        });
    }

    // Khi blur trường đánh giá khác
    const changeOtherEvalution = (e, editor) => {
        if (data !== null) {
            return;
        }
        setFormData({
            ...formData,
            otherEvalution: editor.getData()
        });
    }

    // khi blur khỏi các trường là INput của antd
    const changeInput = e => {
        let id = e
            .target
            .id
            .replace('evalution-form_', '');
        let formDataTemp = formData;
        formDataTemp[id] = e.target.value;
        setFormData({
            ...formData,
            formDataTemp
        });
    }

    const getFieldDecorator = form.getFieldDecorator;

    return (
        <Form className='evalution-form container-fluid'>
            <section className="row">
                <section className="col-md-6 col-12">
                    <label htmlFor='evalution-form_assessor' className='evalution-form-label'>Họ và tên người đánh giá</label>
                    <Form.Item>
                        {getFieldDecorator('assessor', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Vui lòng nhập tên người đánh giá!'
                                }
                            ]
                        })(<Input
                            placeholder={data.assessor || ''}
                            disabled={data === null
                            ? false
                            : true}
                            onBlur={(e) => changeInput(e)}
                            className='evalution-form-input'
                            type="text"/>)}
                    </Form.Item>
                </section>

                <section className="col-md-6 col-12">
                    <label
                        htmlFor='evalution-form_current-position'
                        className='evalution-form-label'>Chức vụ</label>

                    <Form.Item>
                        {getFieldDecorator('currentPosition', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Vui lòng nhập chức vụ hiện tại!'
                                }
                            ]
                        })(<Input
                            placeholder={data.position || ''}
                            disabled={data === null
                            ? false
                            : true}
                            onBlur={(e) => changeInput(e)}
                            className='evalution-form-input'
                            type="text"/>)}
                    </Form.Item>
                </section>
            </section>

            <section className='row'>
                <section className="col-12">
                    <label htmlFor='evalution-form_currentCompany' className='evalution-form-label'>Nơi công tác</label>

                    <Form.Item>
                        {getFieldDecorator('currentCompany', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Vui lòng nhập nơi công tác hiện tại!'
                                }
                            ]
                        })(<Input
                            placeholder={data.company || ''}
                            disabled={data === null
                            ? false
                            : true}
                            onBlur={(e) => changeInput(e)}
                            className='evalution-form-input'
                            type="text"/>)}
                    </Form.Item>
                </section>
            </section>

            <section className='row'>
                <section className="col-12">
                    <label htmlFor='major' className='evalution-form-label'>Chuyên môn</label>

                    {data === null && <CKEditor
                        id='major'
                        editor={ClassicEditor}
                        config={ckeditorConfig}
                        onBlur={(e, editor) => changeMajor(e, editor)}/>}

                        {data !== null && <section className='disable-pane'>{data.major}</section>}
                </section>

                <section className="col-12">
                    <label htmlFor='communication' className='evalution-form-label'>Kỹ năng giao tiếp</label>

                    {data === null && <CKEditor
                        id='communication'
                        editor={ClassicEditor}
                        config={ckeditorConfig}
                        onBlur={(e, editor) => changeCommunication(e, editor)}/>}

                    {data !== null && <section className='disable-pane'>{data.communication}</section>}
                </section>

                <section className="col-12">
                    <label htmlFor='ability-of-development' className='evalution-form-label'>Khả năng phát triển</label>

                    {data === null && <CKEditor
                        id='ability-of-development'
                        className='evalution-form-input'
                        editor={ClassicEditor}
                        config={ckeditorConfig}
                        onBlur={(e, editor) => changeAbilityOfDevelopment(e, editor)}/>}

                    {data !== null && <section className='disable-pane'>{data.abilityOfDevelopment}</section>}
                </section>

                <section className="col-12">
                    <label htmlFor='other-evalution' className='evalution-form-label'>Những đánh giá khác</label>

                    {data === null && <CKEditor
                        id='other-evalution'
                        className='evalution-form-input'
                        editor={ClassicEditor}
                        config={ckeditorConfig}
                        onBlur={(e, editor) => changeOtherEvalution(e, editor)}/>}

                    {data !== null && <section className='disable-pane'>{data.otherEvalution}</section>}
                </section>
            </section>

        </Form>
    )
}

const EvalutionForm = Form.create({name: 'evalution-form'})(EvalutionFormTemp);
export default EvalutionForm;
