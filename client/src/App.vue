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

  Vue.use(BootstrapVue);

export default {
  components:{
      'login': login,
      'pocetna': pocetna
  },
  data(){
    return{

    }
  }
 
}

</script>

