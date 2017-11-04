<template>
  <div class="slider">
    <h3>{{titulo}}</h3>
    <span v-on:mouseover="scrollEsquerda()" v-on:mouseout="clearScroll()" class="handle handlePrev active">
      <i class="fa fa-caret-left" aria-hidden="true"></i>
    </span>

    <div ref="scroller" class="row">
      <div class="row__inner">
        <filme v-for="filme in filmes" v-bind:key="filme.id" v-bind:titulo="filme.titulo" v-bind:imagem="filme.imagem"></filme>
        
      </div>
    </div>

    <span v-on:mouseover="scrollDireita()" v-on:mouseout="clearScroll()"  class="handle handleNext active">
      <i class="fa fa-caret-right" aria-hidden="true"></i>
    </span>

  </div>

</template>

<script>
import Filme from './Filme.vue';

export default{
  props:['titulo','filmes'],
  components:{
    Filme
  },
  methods:{
    scrollDireita(){
      this.intervalo = setInterval(() => { this.$refs.scroller.scrollLeft += 1 }  , 5);
    },
    scrollEsquerda(){
      this.intervalo = setInterval(() => { this.$refs.scroller.scrollLeft -= 1 }  , 5);
    },
    clearScroll(){
      clearInterval(this.intervalo);
    }
  }
}

</script>

<style lang="scss">


</style>
