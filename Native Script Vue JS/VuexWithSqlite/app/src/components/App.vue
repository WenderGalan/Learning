<template>
    <Page class="page">
        <ActionBar class="action-bar" title="Person"></ActionBar>
        <GridLayout rows="auto, *" columns="*">
            <StackLayout class="form" row="0" col="0">
                <StackLayout class="input-field">
                    <Label text="First Name" class="label font-weight-bold m-b-5"/>
                    <TextField class="input" v-model="input.firstname"/>
                    <StackLayout class="hr-light"></StackLayout>
                </StackLayout>
                <StackLayout class="input-field">
                    <Label text="Last Name" class="label font-weight-bold m-b-5"/>
                    <TextField class="input" v-model="input.lastname"/>
                    <StackLayout class="hr-light"></StackLayout>
                </StackLayout>
                <GridLayout rows="auto, auto" columns="*, *">
                    <Button text="Save" @tap="save" class="btn btn-primary" row="0" col="0"/>
                    <Button text="Load" @tap="load" class="btn btn-primary" row="0" col="1"/>
                    <Button text="Clear" @tap="clear" class="btn btn-primary" row="1" col="0" colSpan="2"/>
                </GridLayout>
            </StackLayout>
            <ListView for="person in $store.state.data" class="list-group" row="1" col="0">
                <v-template>
                    <StackLayout class="list-group-item">
                        <Label v-bind:text="person.firstname + ' ' + person.lastname"/>
                    </StackLayout>
                </v-template>
            </ListView>
        </GridLayout>
    </Page>
</template>

<script>
  export default {
    data() {
      return {
        input: {
          firstname: "",
          lastname: ""
        }
      }
    },
    methods: {
      save() {
        var id = this.$store.dispatch("insert", this.input);
      },
      async load() {
        await this.$store.dispatch("query");

        for (person in this.$store.state.data){
          console.log(person)
        }
      },
      clear() {
        this.input.firstname = "";
        this.input.lastname = "";
      }
    }
  };
</script>

<style scoped>
    ActionBar {
        background-color: #53ba82;
        color: #ffffff;
    }

    .message {
        vertical-align: center;
        text-align: center;
        font-size: 20;
        color: #333333;
    }
</style>
