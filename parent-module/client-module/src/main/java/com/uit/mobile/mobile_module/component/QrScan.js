import React, {Component} from 'react';

import {
    Text,
    View,
    Image,
    TouchableHighlight,
    PermissionsAndroid,
    Platform,
    StyleSheet,
    AsyncStorage,
    Alert,
    TouchableOpacity
} from 'react-native';

import {CameraKitCameraScreen} from 'react-native-camera-kit';
import {Header, Overlay, Divider} from 'react-native-elements';
import HeaderCustom from './Header';

export default class QRScan extends Component {
    constructor() {
        super();
        this.state = {
            qrvalue: '',
            hostIp: '',
            soDienThoai: '',
            opneScanner: false,
            diaDiem: '',
            openOverlay: true
        };
    }

    componentDidMount() {
        // this.getStorage();
    }

    static navigationOptions = {
        header: null
    };

    getStorage = async() => {
        try {
            await AsyncStorage
                .getItem('userName')
                .then(res => {
                    if (!res) {
                        this
                            .props
                            .navigation
                            .navigate('LoginForm');
                        Alert.alert('loi');
                    }
                });
        } catch (error) {}
    }

    onBarcodeScan(qrvalue) {
        //called after te successful scanning of QRCode/Barcode
        this.setState({qrvalue: qrvalue});
        this.setState({opneScanner: false});
    }

    closeOverlay = () => {
        this.setState({
            openOverlay: false
        });
    }

    onOpneScanner() {
        var that = this;
        if (Platform.OS === 'android') {
            async function requestCameraPermission() {
                try {
                    const granted = await PermissionsAndroid.request(PermissionsAndroid.PERMISSIONS.CAMERA, {
                        'title': 'CameraExample App Camera Permission',
                        'message': 'CameraExample App needs access to your camera '
                    })
                    if (granted === PermissionsAndroid.RESULTS.GRANTED) {
                        that.setState({qrvalue: ''});
                        that.setState({opneScanner: true});
                    } else {
                        alert("CAMERA permission denied");
                    }
                } catch (err) {
                    alert("Camera permission err", err);
                }
            }
            requestCameraPermission();
        }
    }
    render() {
        let displayModal;
        if (!this.state.opneScanner) {
            return (
                <View>
                    <HeaderCustom/>

                    <View style={styles.container}>
                        <Text
                            style={{
                            color: '#696969',
                            marginLeft: 15,
                            marginTop: 20,
                            marginBottom: 20,
                            fontSize: 16
                        }}>
                            Công cụ
                        </Text>

                        <TouchableHighlight onPress={() => this.onOpneScanner}>

                            <View style={styles.qrButtonContainer}>

                                <Image
                                    style={{
                                    width: 50,
                                    height: 50,
                                    marginRight: 5
                                }}
                                    source={{
                                    uri: 'https://png.icons8.com/qrcode'
                                }}/>

                                <View
                                    style={{
                                    flexWrap: 'wrap',
                                    flex: 1
                                }}>
                                    <Text
                                        style={{
                                        fontSize: 16,
                                        color: 'black'
                                    }}>Quét mã QR</Text>
                                    <Text
                                        style={{
                                        fontSize: 12,
                                        color: '#696969'
                                    }}>Theo dõi hành vi gửi yêu cầu đánh giá là từ chính bản thân của bạn</Text>
                                </View>
                            </View>
                        </TouchableHighlight>
                    </View>

                    <Overlay height={400} isVisible={this.state.openOverlay}>

                        <View>
                            <View
                                style={{
                                alignItems: 'center'
                            }}>
                                <Text
                                    style={{
                                    width: 200,
                                    fontSize: 18,
                                    marginBottom: 30,
                                    textAlign: 'center',
                                    marginTop: 30
                                }}>Thông tin yêu cầu gửi bản đánh giá</Text>
                            </View>

                            <View
                                style={{
                                flexDirection: 'row',
                                alignItems: 'center',
                                marginBottom: 10
                            }}>
                                <Text
                                    style={{
                                    fontSize: 17,
                                    color: 'black'
                                }}>Host IP:
                                </Text>
                                <Text
                                    style={{
                                    fontSize: 16,
                                    color: '#696969',
                                    marginLeft: 15
                                }}>192.168.1.1</Text>
                            </View>

                            <Divider
                                style={{
                                backgroundColor: '#696969'
                            }}/>

                            <View
                                style={{
                                flexDirection: 'row',
                                alignItems: 'center',
                                marginBottom: 10,
                                marginTop: 10
                            }}>
                                <Text
                                    style={{
                                    fontSize: 17,
                                    color: 'black'
                                }}>Số điện thoại:
                                </Text>
                                <Text
                                    style={{
                                    fontSize: 16,
                                    color: '#696969',
                                    marginLeft: 15
                                }}>0783550324</Text>
                            </View>

                            <Divider
                                style={{
                                backgroundColor: '#696969'
                            }}/>

                            <View
                                style={{
                                flexDirection: 'row',
                                alignItems: 'center',
                                marginBottom: 10,
                                marginTop: 10
                            }}>
                                <Text
                                    style={{
                                    fontSize: 17,
                                    color: 'black'
                                }}>Địa điểm:
                                </Text>
                                <Text
                                    style={{
                                    fontSize: 16,
                                    color: '#696969',
                                    marginLeft: 15,
                                    width: 200
                                }}>55/15T, khu phố 7, phường tân thới nhất, quận 12, thành phố hồ chí minh</Text>
                            </View>

                            <Divider
                                style={{
                                backgroundColor: '#696969'
                            }}/>

                            <View
                                style={{
                                flexDirection: 'row',
                                alignItems: 'center',
                                marginBottom: 10,
                                marginTop: 30,
                                justifyContent: 'space-around'
                            }}>
                                <TouchableOpacity style={styles.btnQuayLai} onPress={()=>this.closeOverlay()}>
                                    <Text style={{fontSize: 15}}>Quay lại</Text>
                                </TouchableOpacity>

                                <TouchableOpacity style={styles.btnDongY}>
                                    <Text style={{fontSize: 15, color: 'white'}}>Đồng ý</Text>
                                </TouchableOpacity>
                            </View>

                        </View>
                    </Overlay>
                </View>

            );

        }
        return (
            <View style={{
                flex: 1
            }}>
                <CameraKitCameraScreen showFrame={false} //Show/hide scan frame
                    scanBarcode={true} //Can restrict for the QR Code only
                    laserColor={'blue'} //Color can be of your choice
                    frameColor={'yellow'} //If frame is visible then frame color
                    colorForScannerFrame={'black'} //Scanner Frame color
                    onReadQRCode={event => this.onBarcodeScan(event.nativeEvent.codeStringValue)} cameraOptions={{
                    flashMode: 'auto',
                    focusMode: 'on',
                    zoomMode: 'on',
                    ratioOverlay: '1:1',
                    ratioOverlayColor: '#00000077'
                }}/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#DCDCDC',
        height: '100%'
    },

    qrButtonContainer: {
        backgroundColor: 'white',
        flexDirection: 'row',
        alignItems: 'center',
        paddingLeft: 15,
        height: 100
    },

    btnQuayLai: {
        borderWidth: 1,
        borderRadius: 30,
        borderColor: '#696969',
        width: 100,
        height: 30,
        justifyContent: 'center',
        alignItems: 'center'
    },
    btnDongY: {
        borderRadius: 30,
        backgroundColor: '#00B5EC',
        width: 100,
        height: 30,
        justifyContent: 'center',
        alignItems: 'center'
    }
});