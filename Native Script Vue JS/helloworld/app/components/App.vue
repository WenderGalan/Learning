<template>
    <Page>
        <ActionBar title="Welcome to NativeScript-Vue!"/>
        <GridLayout columns="*" rows="*">
            <Label class="message" :text="msg" col="0" row="0"/>
            <Button class="message" @tap="legal">hahah</Button>
        </GridLayout>
    </Page>
</template>

<script>
  import Http from '../axiosConfig'
  export default {
    data() {

      return {
        msg: 'Carai cachoerra'
      }
    },
    methods: {
      legal(){
        console.log("Deu certo");
        Http.get('/09103131000179')
          .then(response => {
              console.log(response.data);
            }
          ).catch(error => {
        });
      }
    },
    mounted() {
      var Sqlite = require("nativescript-sqlite");
      var db_promise = new Sqlite("db-tagnos-professor", function (err, db) {
        db.version(function (err, ver) {
          if (ver === 0) {
            db.execSQL("CREATE TABLE IF NOT EXISTS `people` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `nome`TEXT NOT NULL, `telefone`TEXT NOT NULL);");
            db.version(1);
            debugger
            db.execSQL("INSERT INTO people (id, nome, telefone) VALUES (?, ?, ?)", [1, "Wender Galan", "67981121278"], function (erro, id) {
              console.log("O id do novo registro é: " + id);
            });
          }
        });
        if (err) {
          console.error("Falha ao abrir o banco de dados", err);
        } else {
          // This should ALWAYS be true, db object is open in the "Callback" if no errors occurred
          console.log("Are we open yet (Inside Callback)? ", db.isOpen() ? "Yes" : "No"); // Yes
        }
      });

      db_promise.then(function (db) {
        db.version(function (err, ver) {
          console.log(ver)
          debugger
        });
        db.execSQL("INSERT INTO people (nome, telefone) VALUES (?, ?)", ["Wender Galan", "67981121278"], function (erro, id) {
          console.log("O id do novo registro é: " + id);
        });
        db.all('SELECT * FROM people', [], function (erro, resultSet) {
          console.log("Total de tuplas encontradas: ", resultSet.length);
          console.log("As linhas inseridas são: ", resultSet);
        });
        // This should ALWAYS be true, db object is open in the "then"
        console.log("Are we open yet (Inside Promise)? ", db.isOpen() ? "Yes" : "No"); // Yes
        db.close();
      }, function (err) {
        console.error("falha ao abrir o banco de dados", err);
      });

    }
  }
</script>

<style scoped>
    ActionBar {
        background-color: #53ba82;
        color: #ffffff;
    }

    .message {
        vertical-align: center;
        text-align: center;
        font-size: 30px;
        color: red;
    }
</style>
