import React from 'react';
import {
    Alert,
    Image,
    KeyboardAvoidingView,
    ScrollView,
    StyleSheet,
    Text,
    Button,
    TextInput,
    TouchableHighlight,
    View
} from 'react-native';

export default class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {text: ''};
        this.state = {checked: true}
    }

    _onPressButton() {
        Alert.alert('Você logou em sua conta!')
    }


    render() {
        let pic = {
            uri: 'http://www.metodista.org.br/content/interfaces/cms/userfiles/files/img-metodista-educacao01.png'
        };
        return (
            <ScrollView>
                <KeyboardAvoidingView
                    style={styles.container}
                    behavior="padding">
                    <View style={styles.container}>
                        <Image source={pic} style={{width: 200, height: 200, marginBottom: 70, marginTop: 80}}/>
                        <TextInput
                            style={{height: 50, width: 260, padding: 10, borderWidth: 1, marginBottom: 20}}
                            placeholder="Digite seu CPF"
                            onChangeText={(text) => this.setState({text})}
                            keyboardType={'numeric'}
                            multiline={false}
                        />
                        <TextInput
                            style={{height: 50, width: 260, padding: 10, borderWidth: 1, marginBottom: 40}}
                            placeholder="Digite sua senha"
                            onChangeText={(text) => this.setState({text})}
                            secureTextEntry={true}
                            multiline={false}
                        />
                        <TouchableHighlight onPress={this._onPressButton} underlayColor="white">
                            <View style={styles.button}>
                                <Text style={styles.buttonText}>Entrar</Text>
                            </View>
                        </TouchableHighlight>
                    </View>
                </KeyboardAvoidingView>
            </ScrollView>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    buttonContainer: {
        margin: 20
    },
    alternativeLayoutButtonContainer: {
        margin: 20,
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    button: {
        marginBottom: 30,
        width: 260,
        alignItems: 'center',
        backgroundColor: '#2196F3'
    },
    buttonText: {
        padding: 20,
        color: 'white'
    }
});
