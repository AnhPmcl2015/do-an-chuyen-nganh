import React, {useState} from 'react'
import './FilterPane.scss'
import { Icon, Checkbox, Divider } from 'antd';

/**
 * 
 * children: tiêu dề
 * dataSource: dữ liệu truyền vào (value, text)
 * handleChoice: truyền dữ liệu đc chọn ra ngoài (checked, value)
 */
const FilterPane = ({children, dataSource, hanleChoice}) => {

    const [visibleChoices, setVisibleChoices] = useState(true);

    const handleChangeOption = (e) => {
        hanleChoice(e.target.checked, e.target.value);
    }

    return(
        <section className="filter-pane">
            <h6 onClick={() => setVisibleChoices(!visibleChoices)} className='filter-pane-title'>
                {visibleChoices && <Icon type="minus-circle" />}
                {!visibleChoices && <Icon type="plus-circle" />}
                {children}
            </h6>

            <section className={`filter-pane-options ${!visibleChoices ? 'display-none' : ''}`}>
                {
                    dataSource && dataSource.map((option, key) => {
                        return <section key={key} className="filter-pane-option">
                            <Checkbox value={option.value} onChange={(e)=>handleChangeOption(e)}>{option.text}</Checkbox>
                        </section>
                    })
                }
            </section>

            <Divider style={{color: '#DCDCDC'}}/>
        </section>
    )
};

export default FilterPane; 