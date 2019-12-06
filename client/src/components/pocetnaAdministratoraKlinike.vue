<template>
  <div>
    <div id="viewport">
      <div id="sidebar">
        <header>
          <a href="#">.</a>
        </header>
                      
        <ul class="nav">
          <a href="#">
              <i v-on:click="otvoriFormu" >    PROFIL          
              </i>
          </a>
          <a href="#">
              <i v-on:click="otvoriKliniku"> IZMENA KLINIKE </i>
          </a>
          <a href="#">
             <i class="zmdi zmdi-link">  DEFINISANJE PREGLEDA</i> 
          </a>
        </ul>
                    
      </div>

      <div id="content">
        <div class="container-fluid">
          <h1 style="color: #b3b3b3;">Administrator Klinike - {{ korisnik.ime }} {{ korisnik.prezime }} </h1>
        </div>
      </div>
    </div>
    
                  <form   class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
                        <div v-if="prikaz">
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">
                                          <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                                          <input type="text" v-model="korisnik.email" id="Form-username" class="form-control" disabled>
                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                                          <input type="text" v-model="korisnik.ime" id="Form-ime" class="form-control" :disabled="!izmeni">
                                          
                                          <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                                          <input type="text" v-model="korisnik.telefon" id="Form-phone" class="form-control" :disabled="!izmeni">
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                                          <input type="text" v-model="korisnik.adresa" id="Form-email4" class="form-control" :disabled="!izmeni">

                                          <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                                          <input type="text" v-model="korisnik.jmbg" id="Form-email4" class="form-control" disabled>
                                        
                                          
                            
                                        </div>
                                        </div>
                                        <div class="col">
                                        <div class="md-form pb-3">
                            
                                          <label for="Form-city" style="color: #b3b3b3;">Lozinka</label>
                                          <input type="text" v-model="korisnik.lozinka" id="Form-city" class="form-control" disabled>
                                          
                                          <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                                          <input type="text" v-model="korisnik.prezime" id="Form-prezime" class="form-control" :disabled="!izmeni">
                            
                                          
                                          <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                                          <input type="text" v-model="korisnik.grad" id="Form-city" class="form-control" :disabled="!izmeni">
                            
                                      
                                          <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                                          <input type="text" v-model="korisnik.drzava" id="Form-city" class="form-control" :disabled="!izmeni">
                                         
                                       

                                        </div>
                                        </div>
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  v-if="!izmeni" type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);  " v-on:click="izmena">Izmeni</button>
                                        </template>
                                        <template>
                                        <button v-if="izmeni" type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="sacuvaj">Sacuvaj</button>
                                        <button v-if="izmeni" type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustani">Odustani</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                       <div v-if="prikazKlinike">
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">
                                          <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                                          <input type="text" v-model="klinika.email" id="Form-username" class="form-control" :disabled="!izmeniKliniku">
                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Naziv</label>
                                          <input type="text" v-model="klinika.naziv" id="Form-ime" class="form-control" :disabled="!izmeniKliniku">
                                          
                                          <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                                          <input type="text" v-model="klinika.telefon" id="Form-phone" class="form-control" :disabled="!izmeniKliniku">
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                                          <input type="text" v-model="klinika.adresa" id="Form-email4" class="form-control" :disabled="!izmeniKliniku">

                                          <label for="Form-email4" style="color: #b3b3b3;">Opis</label>
                                          <input type="text" v-model="klinika.opis" id="Form-email4" class="form-control" :disabled="!izmeniKliniku">
                                        
                                          
                            
                                        </div>
                                        </div>
                                        <div class="col">
                                        <div class="md-form pb-3">
                            
                                          <label for="Form-city" style="color: #b3b3b3;">Broj recenzija</label>
                                          <input type="text" v-model="klinika.brojRecenzija" id="Form-city" class="form-control" disabled>
                                          
                                          <label for="Form-prezime" style="color: #b3b3b3;">Ocena</label>
                                          <input type="text" v-model="klinika.ocena" id="Form-prezime" class="form-control" disabled>
                            
                                          
                                          <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                                          <input type="text" v-model="klinika.grad" id="Form-city" class="form-control" :disabled="!izmeniKliniku">
                            
                                      
                                          <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                                          <input type="text" v-model="klinika.drzava" id="Form-city" class="form-control" :disabled="!izmeniKliniku">
                                         
                                       

                                        </div>
                                        </div>
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  v-if="!izmeniKliniku" type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);  " v-on:click="izmenaKlinika">Izmeni</button>
                                        </template>
                                        <template>
                                        <button v-if="izmeniKliniku" type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="sacuvajKlinika">Sacuvaj</button>
                                        <button v-if="izmeniKliniku" type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustaniKlinika">Odustani</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>
                  
</div>

</template>

<script>
import axios from 'axios'
    export default {
 data() {
     return {
      korisnik: {},
      klinika: {},
      prikaz:false,
      prikazKlinike: false,
      izmeni:false,
      izmeniKliniku:false,
      }
  },
  methods: {
        otvoriFormu(){
            this.prikaz=!this.prikaz;
            this.prikazKlinike=false;
        },
        izmena() {
        this.izmeni = true
        },
      odustani() {
        this.izmeni = false
        axios
        .get("http://localhost:8081/adminKlinike/get")
        .then(adminKlinike =>{
          this.korisnik = adminKlinike.data;
      })
      .catch(error => {
          console.log(error)
      });
      },
      sacuvaj() {
      if(this.korisnik.ime === "" || this.korisnik.prezime === "" || this.korisnik.adresa === "" || this.korisnik.grad === "" || this.korisnik.drzava === ""
      || this.korisnik.telefon === "") {
        alert("Polja ne smeju biti prazna!");
        return;
      }
      var rex = /^\+381\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
      if (!rex.test(String(this.korisnik.telefon.trim()))) {
        alert("Broj telefona treba da bude oblika +381/65-504205");

        return;
      }
      axios
      .put("http://localhost:8081/adminKlinike/izmeni", this.korisnik)
      .then(adminKlinike =>{
        this.korisnik = adminKlinike.data;
        this.izmeni = false;
      })
      .catch(error => {
          console.log(error)
      });
    },
    otvoriKliniku(){
   	   axios
      .get("http://localhost:8081/klinika/pronadjiKliniku/" + this.korisnik.idKlinike)
      .then(klinika =>{
        this.klinika = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
    	this.prikazKlinike = !this.prikazKlinike;
    	this.prikaz = false;

    },
      izmenaKlinika() {
        this.izmeniKliniku = true
        },
      odustaniKlinika() {
        this.izmeniKliniku = false
        axios
        .get("http://localhost:8081/klinika/pronadjiKliniku/" + this.klinika.id)
        .then(klinika =>{
          this.klinika = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
      },
      sacuvajKlinika() {
      if(this.klinika.naziv === "" || this.klinika.opis === "" || this.klinika.adresa === "" || this.klinika.grad === "" || this.klinika.drzava === ""
      || this.klinika.telefon === "") {
        alert("Polja ne smeju biti prazna!");
        return;
      }
      var rex = /^\+381\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
      if (!rex.test(String(this.klinika.telefon.trim()))) {
        alert("Broj telefona treba da bude oblika +381/65-504205");

        return;
      }
      axios
      .put("http://localhost:8081/klinika/izmeni", this.klinika)
      .then(klinika =>{
        this.klinika = klinika.data;
        this.izmeniKliniku = false;
      })
      .catch(error => {
          console.log(error)
      });
      }
    },
 mounted() {
      axios
      .get("http://localhost:8081/adminKlinike/get")
      .then(adminKlinike =>{
        this.korisnik = adminKlinike.data;
      })
      .catch(error => {
          console.log(error)
      });
  }
};

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500');

body {
  overflow-x: hidden;
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
}

/* Toggle Styles */

#viewport {
  padding-left: 250px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#content {
  width: 100%;
  position: relative;
  height: 52px;
  margin-right: 0;
  background-color: #37474F;
  
}

/* Sidebar Styles */

#sidebar {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 250px;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: #37474F;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#sidebar header {
    background: url('https://i.ibb.co/FBXWKxW/doctor.jpg') center center no-repeat;
    background-size: cover;
  
  line-height: 52px;
  
}

#sidebar header a {
  color: #fff;
  display: block;
  text-decoration: none;
}

#sidebar header a:hover {
  color: #fff;
}



#sidebar .nav a{
  background: none;
  border-bottom: 1px solid #455A64;
  color: #b3b3b3;
  font-size: 14px;
  padding: 16px 24px;
}

#sidebar .nav a:hover{
  background: none;
  color: #b3b3b3;
}

#sidebar .nav a i{
  margin-right: 16px;
  
}

.popup-box {
  position: absolute;
  left: 50%;
  top: 50px;
  transform: translateX(-50%);
  background: #F0F8FF;
  border-radius: 1px;
  box-shadow: 1px 1px 15px 0 rgba(0,0,0,0.2);
  padding: 40px;
  color: #555585;
}



</style>


