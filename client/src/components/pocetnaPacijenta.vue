<template>
    <div>
	    <div id="viewport">
	        <!-- Sidebar -->       
	        <div id="sidebar">
	          <header>
	            <a href="#">.</a>
	          </header>
	          <ul class="nav">
				  <a href="#">
					<i v-on:click="otvoriFormu" > PROFIL            
					</i>                                  				     
				  </a>
	              <a href="#">
	                <i class="zmdi zmdi-view-dashboard" v-on:click="otvoriFormuZK"> ZDRAVSTVENI KARTON
	                </i>                   
	              </a>
	              <a href="#">
	                <i class="zmdi zmdi-view-dashboard"> LISTA KLINIKA
	                </i>                   
                  </a>
                  <a href="#">
	                <i class="zmdi zmdi-view-dashboard"> ISTORIJA PREGLEDA I OPERACIJA
	                </i>                   
	              </a>	    	               
	           </ul>
	        </div>
            <!-- Content -->
            <div id="content">                    
              <div class="container-fluid">

                <h1 style="color: #b3b3b3;">Pacijent - {{ korisnik.ime }} {{ korisnik.prezime }} </h1>                
              </div>
            </div>
	
                               
              </div>

    
         <form v-if="prikaz"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
            <div>
                    
                
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
    </form>
    <form v-if="prikazZK"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 390px; background-color: rgba(130, 206, 209, 0.733); ">
      <div>
              
          
            <div  class="container d-flex justify-content-center" style="margin-top: 30px">
          
              
              <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                <div class="form-group">
          
                  <div class="card-body mx-4 mt-4">
                    <div class="row">
          
                      <div class="col">
                      <div class="md-form">
                        <label for="Form-dioptrija" style="color: #b3b3b3;">Dioptrija</label>
                        <input type="text" v-model="zdravstveniK.dioptrija" id="Form-username" class="form-control" disabled>
                        
                        <label for="Form-alergija" style="color: #b3b3b3;">Alergija</label>
                        <input type="text" v-model="zdravstveniK.alergije" id="Form-ime" class="form-control" :disabled="!izmeni">
                        
                        <label for="Form-visina" style="color: #b3b3b3;">Visina</label>
                        <input type="text" v-model="zdravstveniK.visina" id="Form-phone" class="form-control" :disabled="!izmeni">
                        
                        <label for="Form-tezina" style="color: #b3b3b3;">Tezina</label>
                        <input type="text" v-model="zdravstveniK.tezina" id="Form-email4" class="form-control" :disabled="!izmeni">

                       
                      </div>
                      </div>
                      <div class="col">
                      <div class="md-form pb-3">
          
                        

                      </div>
                      </div>
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
          zdravstveniK: {},
          korisnik: {},
          prikaz:false,
          prikazZK:false,
          izmeni:false
          }
      },
      methods: {
            otvoriFormu(){
                this.prikaz=!this.prikaz;
            },
            otvoriFormuZK(){
              axios
                .get("http://localhost:8081/zdravstveniKarton/pronadjiZdravstveniKarton/" + 1)
                .then(zdravstveniK =>{
                  this.zdravstveniK = zdravstveniK.data;
                })
                .catch(error => {
                    console.log(error)
                });
                this.prikazZK = !this.prikazZK;
               

    },
            izmena() {
            this.izmeni = true
            },
          odustani() {
            this.izmeni = false
            axios
            .get("http://localhost:8081/pacijent/get")
            .then(pacijent =>{
              this.korisnik = pacijent.data;
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
          .put("http://localhost:8081/pacijent/izmeni", this.korisnik)
          .then(pacijent =>{
            this.korisnik = pacijent.data;
            this.izmeni = false;
          })
          .catch(error => {
              console.log(error)
          });
        }
        },
     mounted() {
          axios
          .get("http://localhost:8081/pacijent/get")
          .then(pacijent =>{
            this.korisnik = pacijent.data;
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