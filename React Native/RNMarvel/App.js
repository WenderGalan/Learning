import React from 'react'
import { StatusBar, Platform } from 'react-native'
import Home from './src/screens/Home'
import Description from './src/screens/Description'
import { createStackNavigator } from 'react-navigation'

const App = createStackNavigator({
        Home: {
            screen: Home
        },
        Description: {
            screen: Description
        },
    },
    {
        cardStyle: {
            paddingTop: Platform.OS === 'ios' ? 0 : StatusBar.currentHeight
        }
    })

export default App