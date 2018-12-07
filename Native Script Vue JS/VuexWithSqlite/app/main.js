import Vue from 'nativescript-vue'
import App from './src/components/App'
import VueDevtools from 'nativescript-vue-devtools'
import store from './src/store/index'

if (TNS_ENV !== 'production') {
  Vue.use(VueDevtools)
}
// Prints Vue logs when --env.production is *NOT* set while building
Vue.config.silent = (TNS_ENV === 'production')


new Vue({
  store,
  render: h => h('frame', [h(App)])
}).$start()

