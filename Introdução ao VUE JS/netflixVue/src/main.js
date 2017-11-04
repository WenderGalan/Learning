import Vue from 'vue'
//import App from './App.vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
import VueRouter from 'vue-router'
Vue.use(VueRouter)


import Home from './paginas/Home.vue'



const Contato = {template:'<p>Página de Contato</p>'}
const SemPagina = {template:'<p>Essa página não existe!</p>'}

/*const rotas = {
  '/': Home,
  '/contato': Contato
}*/

const routes = [
  { path: '/', component: Home },
  { path: '/contato', component: Contato }
]

const router = new VueRouter({
  routes // short for `routes: routes`
})

const app = new Vue({
  router
}).$mount('#app')
