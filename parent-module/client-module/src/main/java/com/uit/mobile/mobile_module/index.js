

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import AvatarCustom from './component/Avatar';
import Logout from './component/Logout';
import HeaderCustom from './component/Header';

AppRegistry.registerComponent(appName, () => HeaderCustom);
