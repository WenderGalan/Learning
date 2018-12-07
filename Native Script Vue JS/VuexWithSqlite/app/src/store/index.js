import Vue from 'nativescript-vue';
import Vuex from 'vuex';

const Sqlite = require("nativescript-sqlite");
Vue.use(Vuex);
const store = new Vuex.Store({
  state: {
    database: null,
    data: []
  },
  mutations: {
    init(state, data) {
      state.database = data.database;
    },
    load(state, data) {
      state.data = [];
      for (var i = 0; i < data.data.length; i++) {
        state.data.push({
          firstname: data.data[i][0],
          lastname: data.data[i][1]
        });
      }
    },
    save(state, data) {
      state.data.push({
        firstname: data.data.firstname,
        lastname: data.data.lastname
      });
    },
  },
  actions: {
    init(context) {
      let versaoAtual = 1;
      (new Sqlite("my.db")).then(db => {
        db.version(function (error, versao) {
          do {
            switch (versao) {
              case 0:
                db.execSQL("CREATE TABLE IF NOT EXISTS people (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT)").then(id => {
                  console.log("CREATE TABLE SUCCESS", id)
                }, error => {
                  console.log("CREATE TABLE ERROR", error);
                });
                console.log("Versão: ", versao);
                db.version(1);
                break;
              case 1:
                console.log("Versão: ", versao);
                break;
            }
            versao++;
          } while (versao <= versaoAtual);
        });
        context.commit("init", {database: db});
      }, error => {
        console.log("OPEN DB ERROR", error);
      });
    },


    insert(context, data) {
      context.state.database.execSQL("INSERT INTO people (firstname, lastname) VALUES (?, ?)", [data.firstname, data.lastname]).then(id => {
        data.id = id;
        context.commit("save", {data: data});
      }, error => {
        console.log("INSERT ERROR", error);
      });
    },
    query(context) {
      context.state.database.all("SELECT firstname, lastname FROM people", []).then(result => {
        context.commit("load", {data: result});
      }, error => {
        console.log("SELECT ERROR", error);
      });
    }
  }
});
Vue.prototype.$store = store;
store.dispatch("init");
export default store;

