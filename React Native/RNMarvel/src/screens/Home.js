import React from 'react'
import {FlatList, Image, Text, TouchableOpacity, View} from 'react-native'
import md5 from 'js-md5'

const PUBLIC_KEY = '9d5dd72b6d0e4e97f9db0f642c71eb11';
const PRIVATE_KEY = '6f9cbbe89ee2d736d7ee9aa3bec8a02af1712a7c';

export default class Home extends React.PureComponent {
    static navigationOptions = {
        title: 'Heroes'
    };

    state = {
        data: []
    };

    async componentDidMount() {
        const timestamp = Number(new Date());
        const hash = md5.create();
        hash.update(timestamp + PRIVATE_KEY + PUBLIC_KEY);

        const response = await fetch(`https://gateway.marvel.com/v1/public/characters?ts=${timestamp}&orderBy=name&limit=200&apikey=${PUBLIC_KEY}&hash=${hash.hex()}`);
        const responseJson = await response.json();
        this.setState({data: responseJson.data.results})
    }

    _renderItem = ({item}) => {
        return (
            <TouchableOpacity onPress={()=>this._onItemPress(item)} style={{flexDirection:'row', padding: 10, alignItems:'center'}}>
                <Image style={{height: 50, width: 50, borderRadius: 25}} source={{uri: `${item.thumbnail.path}.${item.thumbnail.extension}` }} />
                <Text style={{marginLeft: 10}}>{item.name}</Text>
            </TouchableOpacity>
        )
    };

    _onItemPress = (item) => {
        this.props.navigation.navigate('Description', {hero: item})
    };

    render() {
        return (
            <FlatList
                data={this.state.data}
                renderItem={this._renderItem}
                keyExtractor={(item) => item.id}
                ItemSeparatorComponent={() =>
                    <View style={{height: 1, backgroundColor: '#f7f7f7'}}
                    />}
            />
        )
    }
}