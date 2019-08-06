import React from 'react';
import '../../style.scss';
import './ThongTinUngVien.scss';

import UngVienNavigation from './../../components/UngVienNavigation/UngVienNavigation';
import ThongTinHeader from '../../components/ThongTinHeader/ThongTinHeader';
import ThongTinCaNhan from './../../components/ThongTinCaNhan/ThongTinCaNhan';
import { Carousel } from 'antd';

function ThongTinUngVien(){
    return(
        <section id="thong-tin-ung-vien">
            <ThongTinHeader/>
            <UngVienNavigation/>

            <main className="container">
                <section className="row">
                    <section className="col-6"><ThongTinCaNhan/></section>
                    <section className="col-6"><ThongTinCaNhan/></section>
                </section>
            
                <Carousel>
                    <section>
                        <section>
                            Đây là 1
                        </section>

                        <section>Đây là 2</section>
                    </section>
                    <section>
                        2
                    </section>
                </Carousel>

            </main>


        </section>
    );
}

export default ThongTinUngVien;
