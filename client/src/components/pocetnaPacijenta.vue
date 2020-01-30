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
                <i v-on:click="listaKlinika" class="zmdi zmdi-view-dashboard"> LISTA KLINIKA
                </i>                   
                </a>
                <a href="#">
                <i class="zmdi zmdi-view-dashboard"> ISTORIJA PREGLEDA I OPERACIJA
                </i>     
                              
              </a>
              <a href="#">
                <i class="zmdi zmdi-view-dashboard" v-on:click="otvoriFormuPREGLED"> ZAKAZI PREGLED
                </i>     
                              
              </a>
              <a href="#">
                <i class="zmdi zmdi-view-dashboard" style="color: red" v-on:click="odjava"> ODJAVA
                </i>     
                              
              </a>	    	  	    	               
           </ul>
        </div>
          <!-- Content -->
          <div id="content">                    
            <div class="container-fluid">



              <h1 style="color: #b3b3b3;"> Pacijent - {{ user.ime }} {{ user.prezime }} </h1>         
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
                            <input type="text" v-model="user.email" id="Form-username" class="form-control" disabled>
                            
                            <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                            <input type="text" v-model="user.ime" id="Form-ime" class="form-control" :disabled="!izmeni">
                            
                            <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                            <input type="text" v-model="user.telefon" id="Form-phone" class="form-control" :disabled="!izmeni">
                            
                            <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                            <input type="text" v-model="user.adresa" id="Form-email4" class="form-control" :disabled="!izmeni">

                            <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                            <input type="text" v-model="user.jmbg" id="Form-email4" class="form-control" disabled>
                          
                            
              
                          </div>
                          </div>
                          <div class="col">
                          <div class="md-form pb-3">
              
                            <label for="Form-city" style="color: #b3b3b3;">Lozinka</label>
                            <input type="text" v-model="user.lozinka" id="Form-city" class="form-control" disabled>
                            
                            <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                            <input type="text" v-model="user.prezime" id="Form-prezime" class="form-control" :disabled="!izmeni">
              
                            
                            <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                            <input type="text" v-model="user.grad" id="Form-city" class="form-control" :disabled="!izmeni">
              
                        
                            <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                            <input type="text" v-model="user.drzava" id="Form-city" class="form-control" :disabled="!izmeni">
                           
                         

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
<form v-if="prikazPREGLED"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 690px; height: 260px; background-color: rgba(130, 206, 209, 0.733); ">

</form>
<form v-if="prikazUDPREGLEDI"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 40%; height: 600px; background-color: rgba(130, 206, 209, 0.733); ">
  <button v-on:click="otvoriKliniku(klinika)" class="btn btn-warning" style=" margin-left: 15px; margin-top: 10px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na profil klinike</i></button>
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 99.5%; height: 99.5%;margin-top: 20px; margin-bottom: 5px">	
      <table style="width: 100%;">
       
                <tr>
                  <th class="bg-info  text-white">Datum</th>
                  <th class="bg-info  text-white">Satnica</th>
                  <th class="bg-info  text-white">Sala</th>
                  <th class="bg-info  text-white">Lekar</th>
                  <th class="bg-info  text-white">Tip pregleda</th>
                  <th class="bg-info  text-white">Cena</th>
                  <th class="bg-info  text-white">Popust</th>
                  <th class="bg-info  text-white"></th>
                </tr>
                <tr v-for="k,i in pregledi.length" >
                  <td>{{pregledi[i].datum}}</td>
                  <td>{{pregledi[i].vreme}}</td>
                  <td>{{pregledi[i].sala.naziv}}</td>
                  <td>{{pregledi[i].lekar.ime}}</td>
                  <td>{{pregledi[i].tipPregleda.naziv}}</td>
                  <td>{{pregledi[i].cena}}</td>
                  <td></td>
                  <td style="text-align: center">   <button v-on:click="zakaziPregled(pregledi[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Zakazi pregled</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
</form>

<form   v-if="prikazListaKlinika" class="message-form" style="position: relative; top: 10px; left: 400px; width: 40%; height: 600px; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
      <table style="width: 100%;">
       
                <tr>
                  <th class="bg-info  text-white">Naziv Klinike</th>
                  <th class="bg-info  text-white">Adresa Klinike</th>
                  <th class="bg-info  text-white"></th>
                </tr>
                <tr v-for="k,i in klinike.length">
                  <td>{{klinike[i].naziv}}</td>
                  <td>{{klinike[i].adresa}}</td>
                  <td style="text-align: center">   <button v-on:click="otvoriKliniku(klinike[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Prikazi profil klinike</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
  </form>
  <form   v-if="prikazKlinike" class="message-form" style="position: relative; top: 10px; left: 400px; width: 40%; height: 600px; background-color: rgba(130, 206, 209, 0.733); ">
    <button v-on:click="listaKlinika" class="btn btn-warning" style=" margin-left: 15px; margin-top: 10px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na listu klinika</i></button>

    <div  class="container d-flex justify-content-center" >	  
                      
      <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 20px; margin-bottom: 5px">	

        <table style="width: 100%; " class="table table-striped" >
          <tbody>
                  <tr >
                    <th  >Naziv: </th>
                    <th >{{klinika.naziv}}</th>
                  </tr>
                  <tr>
                    <th >Adresa: </th>
                    <th >{{klinika.adresa}}</th>
                  </tr>
                  <tr>
                    <th>Email: </th>
                    <th>{{klinika.email}}</th>
                  </tr>
                  <tr>
                    <th >Grad: </th>
                    <th >{{klinika.grad}}</th>

                  </tr>
                  <tr>
                    <th >Drzava: </th>
                    <th >{{klinika.drzava}}</th>
                  </tr>
                  <tr>
                    <th >Telefon: </th>
                    <th >{{klinika.telefon}}</th>
                  </tr>
                  <tr>
                    <th>Opis: </th>
                    <th >{{klinika.opis}}</th>
                  </tr>
                  <tr>
                    <th>Ocena: </th>
                    <th >{{klinika.ocena}}</th>
                  </tr>
                  <tr>
                    <th>Broj recenzija: </th>
                    <th >{{klinika.brojRecenzija}}</th>
                  </tr>
                </tbody>
              </table>     
      </div>
    </div>   
    <button v-on:click="udpregledi(klinika)" class="btn btn-warning" style=" margin-left: 270px; margin-top: 10px; height: 40px; width: 330px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> Prikazi unapred definisane preglede &#8594;</i></button>

    </form>
     
</div>


</template>



<script>
  import axios from 'axios'
      export default {
   data() {
       return {

        user: {},
        
        klinike: {},
        klinika: {},
        zdravstveniK: {},
        korisnik: {},
        pregledi: {},
        pregled: {},
        prikaz:false,
        prikazZK:false,
        prikazPREGLED:false,
        prikazUDPREGLEDI:false,
        prikazListaKlinika: false,
        prikazKlinike: false,
        izmeni:false,
        id: 1

        }
    },
    methods: {
  otvoriFormu(){
              this.prikaz=!this.prikaz;
              this.prikazZK = false;
              this.prikazPREGLED=false;
              this.prikazListaKlinika=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
          },
  odjava(){
              localStorage.removeItem("jwt");
              this.$store.state.user = {
              role: {
              authority: ""
          }
        };
        this.$router.push("/");
          },

  otvoriFormuZK(){
            axios
              .get("/zdravstveniKarton/pronadjiZdravstveniKarton/" + this.id)

              .then(zdravstveniK =>{
                this.zdravstveniK = zdravstveniK.data;
              })
              .catch(error => {
                  console.log(error)
              });
              this.prikazZK = !this.prikazZK;
              this.prikazPREGLED=false;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
               },

  otvoriKliniku(k){
      axios

	        .get("/klinika/pronadjiKliniku1/"+ k.id)

	        .then(kl =>{
	          this.klinika = kl.data;
          })
              this.prikazKlinike=!this.prikazKlinike; 
              this.prikazPREGLED=false;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazUDPREGLEDI=false;
    
    },
   zakaziPregled(p){
        axios
        .post("/pregled/zakaziPregled/"+this.$store.state.user.id,p)
        .then(() => {
              alert('Uspesno ste zakazali pregled');
	        })
	
		    .catch(function (error) {
		        alert('Neuspesno zakazivanje pregleda');
		    
		    });
    
    },
  otvoriFormuPREGLED(){
              this.prikazPREGLED=!this.prikazPREGLED;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
         },
  izmena() {
              this.izmeni = true;
  },
  udpregledi(klinika) {
              this.prikaz=false;
              this.prikazUDPREGLEDI=!this.prikazUDPREGLEDI;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazKlinike=false;

    axios
      .get('/pregled/izlistajUDP/'+ klinika.id)
      .then(pregledi =>{
        this.pregledi = pregledi.data;
      })
      .catch(error => {
          console.log(error)
      });
  },
  listaKlinika(){
	 	
            this.prikazListaKlinika=!this.prikazListaKlinika;
            this.prikaz=false;
            this.prikazZK=false;
            this.prikazPREGLED=false;
            this.prikazUDPREGLEDI=false;
            this.prikazKlinike=false;
    axios
      .get('/klinika/izlistajK')
      .then(klinika =>{
        this.klinike = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
	 },
  odustani() {
            this.izmeni = false
    axios
      .get("/pacijent/get/"  + this.$store.state.user.id)
      .then(pacijent =>{
        this.user = pacijent.data;
    })
    .catch(error => {
        console.log(error)
    });
        },
  sacuvaj() {
        if(this.user.ime === "" || this.user.prezime === "" || this.user.adresa === "" || this.user.grad === "" || this.user.drzava === ""
        || this.user.telefon === "") {
          alert("Polja ne smeju biti prazna!");
          return;
        }
        var rex = /^\+381\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
        if (!rex.test(String(this.user.telefon.trim()))) {
          alert("Broj telefona treba da bude oblika +381/65-504205");
  
          return;
        }
        axios
        .put("/pacijent/izmeni", this.user)
        .then(pacijent =>{
          this.user = pacijent.data;
          this.izmeni = false;
        })
        .catch(error => {
            console.log(error)
        });
      }
      },
     
   mounted() {
     
        axios
        .get("/pacijent/get/"  + this.$store.state.user.id)
        .then(pacijent =>{
          this.user = pacijent.data;
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