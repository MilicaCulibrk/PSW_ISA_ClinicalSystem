import login from './components/login.vue';
import pocetna from './components/pocetna.vue';
import registration from './components/registration.vue';
import pocetnaAdministratorKC from './components/pocetnaAdministratorKC.vue';
import dodajKliniku from './components/dodavanjeKlinike.vue';
import dodajAdministratora from './components/dodavanjeAdministratora.vue';
import pocetnaAdministratoraKlinike from './components/pocetnaAdministratoraKlinike.vue';
import pocetnaMedicinskeSestre from './components/pocetnaMedicinskeSestre.vue';
import pocetnaLekara from './components/pocetnaLekara.vue';

export default [
    { path: '', component: pocetnaAdministratorKC},
    { path: '/pocetna', component: pocetna},
    { path: '/login', component: login},
    { path: '/registration', component: registration},
    { path: '/dodajKliniku', component: dodajKliniku},
    { path: '/dodajAdministratora', component: dodajAdministratora},
    { path: '/pocetnaAdministratoraKlinike', component: pocetnaAdministratoraKlinike},
    { path: '/pocetnaMedicinskeSestre', component: pocetnaMedicinskeSestre},
    { path: '/pocetnaLekara', component: pocetnaLekara}

]