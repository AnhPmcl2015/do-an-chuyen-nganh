import React from 'react'
import './ThongTinHeader.scss'
import { Icon, Input } from 'antd';

function ThongTinHeader(){

    return(
        <header id='thong-tin-header'>

            <section id='left'>
                <figure>
                    <img src="" alt=""/>
                </figure>
            </section>
            
            <section id="right">

                <section className="search container">
                    <section className="row">
                        <section className="col-1" style={{textAlign: 'right'}}>
                            <Icon id='menu' style={{color: 'white', fontSize: '20px'}} type="menu" />
                        </section>

                        <section className="col-10">
                            <Input id='search-input' placeholder='Tìm kiếm...'/>
                        </section>

                        <section className="col-1">
                            <Icon id='job' style={{color: 'white', fontSize: '20px'}} type="appstore" />
                        </section>
                    </section>
                </section>


                <section className="quote">
                    <h2>TopJob - Nơi kỹ năng của bạn được đề cao</h2>
                    <blockquote>Nếu debug là quá trình loại bỏ bug trong phần mềm, thì code chính là quá trình gây ra bug.<br/>
                    <span className='tac-gia-quote'>Edsger Dijkstra - Cha đẻ của thuật toán tìm đường Dijkstra</span></blockquote>
                </section>
            </section>



            
        </header>
    );
}

export default ThongTinHeader;