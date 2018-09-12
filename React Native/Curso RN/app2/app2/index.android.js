import React, { Component } from 'react';
import {Text, AppRegistry, Button} from 'react-native';

const Estilos = {
  estiloTexto: {
    fontSize: 50

  }
};

const App = () => {
  return(
    <Button 
    onPress="botaoPressionado"/>

  );
};

AppRegistry.registerComponent('app2', () => App);
