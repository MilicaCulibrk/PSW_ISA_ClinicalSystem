import Vue from 'vue'
import App from './App.vue'
import router from './routes'
import store from './store'
import axios from "axios";
import BootstrapVue from 'bootstrap-vue'
import * as VueGoogleMaps from 'vue2-google-maps'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


axios.defaults.baseURL = "http://localhost:8081"

axios.interceptors.request.use(config => {
  config.headers['Authorization'] = "Bearer " + localStorage.getItem("jwt");
  return config;
})

Vue.config.productionTip = false

Vue.use(VueGoogleMaps, {
	  load: {
	    key: 'AIzaSyCX9E-02Uy7_0OnGkWsgpiss3XbXwsh5Sk',
	    libraries: 'places',
	  }
	})

Vue.use(BootstrapVue)


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')