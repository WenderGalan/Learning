import React from 'react';
import { Text, View, Button, AppRegistry } from 'react-native';


const geraNumeroAleatorio = () => {
  var numero_aleatorio = Math.random();
  numero_aleatorio = Math.floor(numero_aleatorio * 1000) ;
  alert(numero_aleatorio)
}

const App = () => {

  return (
    <View>
      <Text>Gerador de número randômico</Text>
      <Button
        title="Gerar um número randômico"
        onPress={geraNumeroAleatorio}></Button>
    </View>
  );
};

AppRegistry.registerComponent('app1', () => App);
