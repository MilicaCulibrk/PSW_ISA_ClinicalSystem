import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import login from './components/login.vue';
import pocetna from './components/pocetna.vue';
import registration from './components/registration.vue';
import dodajKliniku from './components/dodavanjeKlinike.vue';
import dodajAdministratora from './components/dodavanjeAdministratora.vue';
import pocetnaAdministratoraKlinike from './components/pocetnaAdministratoraKlinike.vue';
import pocetnaAdministratorKC from './components/pocetnaAdministratorKC.vue';
import pocetnaMedicinskeSestre from './components/pocetnaMedicinskeSestre.vue';
import pocetnaLekara from './components/pocetnaLekara.vue';
import pocetnaPacijenta from './components/pocetnaPacijenta.vue';
import vidiLokaciju from './components/vidiLokaciju.vue';
import promenaLozinke from './components/promenaLozinke.vue';
const routes = [
    { path: '/', 
      component: pocetna,  
      meta: {
           requiresAuth: true
        } 
    },
    { path: '/login', 
      component: login,
       meta: {
        requiresAuth: true
      } 
    },
    { path: '/registration', 
      component: registration,
      meta: {
        requiresAuth: true
      } 
    },
    { path: '/pocetnaAdministratoraKlinike', 
      component: pocetnaAdministratoraKlinike,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/pocetnaMedicinskeSestre', 
      component: pocetnaMedicinskeSestre,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/pocetnaAdministratorKC', 
      component: pocetnaAdministratorKC,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/pocetnaPacijenta', 
      component: pocetnaPacijenta,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/pocetnaLekara', 
      component: pocetnaLekara,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/vidiLokaciju',
      component: vidiLokaciju,
      meta: {
        requiresAuth: false
      } 
    },
    { path: '/promenaLozinke', 
      component: promenaLozinke,
      meta: {
        requiresAuth: false
      } 
    }

]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {

  if (to.meta.requiresAuth) {
    next();
    return;
  }
  
  if(localStorage.getItem('jwt'))
  {
    next();
    return;
  }
   
  next("/")
  
})


export default router