<template>
  <div>
     <router-view></router-view>
  </div>
</template>

<script>
  import login from './components/login.vue';
  import pocetna from './components/pocetna.vue';

  import Vue from 'vue';
  import BootstrapVue from 'bootstrap-vue';
  import VueJwtDecode from "vue-jwt-decode";

  Vue.use(BootstrapVue);

export default {
  components:{
      'login': login,
      'pocetna': pocetna
  },
   mounted() {
    if (localStorage.getItem("jwt") != undefined) {
      this.$store.state.user = VueJwtDecode.decode(localStorage.getItem("jwt"));
    }
  }
 
}

</script>

