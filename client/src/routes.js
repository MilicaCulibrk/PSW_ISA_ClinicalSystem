import login from './components/login.vue';
import pocetna from './components/pocetna.vue';
import registration from './components/registration.vue';
import pocetnaAdministratorKC from './components/pocetnaAdministratorKC.vue';
import dodajKliniku from './components/dodavanjeKlinike.vue';
import dodajAdministratora from './components/dodavanjeAdministratora.vue';

export default [
    { path: '', component: pocetnaAdministratorKC},
    { path: '/pocetna', component: pocetna},
    { path: '/login', component: login},
    { path: '/registration', component: registration},
    { path: '/dodajKliniku', component: dodajKliniku},
    { path: '/dodajAdministratora', component: dodajAdministratora},
]