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
const routes = [
    { path: '/', component: pocetna},
    { path: '/login', component: login},
    { path: '/registration', component: registration},
    { path: '/dodajKliniku', component: dodajKliniku},
    { path: '/dodajAdministratora', component: dodajAdministratora},
    { path: '/pocetnaAdministratoraKlinike', component: pocetnaAdministratoraKlinike},
    { path: '/pocetnaMedicinskeSestre', component: pocetnaMedicinskeSestre},
    { path: '/pocetnaAdministratorKC', component: pocetnaAdministratorKC},
    { path: '/pocetnaPacijenta', component: pocetnaPacijenta},
    { path: '/pocetnaLekara', component: pocetnaLekara},
    { path: '/vidiLokaciju', component: vidiLokaciju}
]

const router = new VueRouter({
  routes
})

export default router