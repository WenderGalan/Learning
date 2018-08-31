/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
    android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

var SQLite = require('react-native-sqlite-storage')
var db = SQLite.openDatabase({name: 'database.db', createFromLocation: '~database.db'})
var nome = "Wender Galan"

type Props = {};
export default class App extends Component<Props> {
    constructor(props) {
        super(props);

        this.state = {
            telefone: "",
        };

        db.transaction((tx) => {
            tx.executeSql('SELECT * FROM usuarios WHERE nome = ?', [nome], (tx, results) => {
                var len = results.rows.length;
                if (len > 0) {
                    var row = results.rows.item(0);
                    this.setState({telefone: row.telefone});
                }
            });
        });
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>SQLite Example</Text>
                <Text>{'O número do ' + nome + ' é ' + this.state.telefone}</Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
