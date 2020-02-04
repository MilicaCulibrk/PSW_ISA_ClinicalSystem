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
                <i v-on:click="listaKlinika();izlistajTipove()" class="zmdi zmdi-view-dashboard"> LISTA KLINIKA
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
  <form v-if="prikazZK"  class="message-form" style=" box-shadow: 25px 25px 50px 0 white inset, -25px -25px 50px 0 white inset; position: relative; top: 10px; left: 400px; width: 800px; height: 390px; background-color: rgba(130, 206, 209, 0.733); ">
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
<form v-if="prikazUDPREGLEDI"  class="message-form" style="position: relative; top: 10px; left: 400px; width: fit-content; height: 600px; background-color: rgba(130, 206, 209, 0.733); ">
  <button v-on:click="otvoriKliniku(klinika)" class="btn btn-warning" style=" margin-left: 15px; margin-top: 10px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na profil klinike</i></button>
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 99.5%; height: 99.5%;margin-top: 20px; margin-bottom: 5px; overflow-x:auto" >	
      <table style="width: 100%;" class="table table-hover table-fixed">
       
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
                <tr v-for="k,i in udpregledi.length" >
                  <td align="center" >{{udpregledi[i].datum}}</td>
                  <td align="center" >{{udpregledi[i].vreme}}</td>
                  <td align="center" >{{udpregledi[i].sala.naziv}}</td>
                  <td align="center" >{{udpregledi[i].lekar.ime}}</td>
                  <td align="center" >{{udpregledi[i].tipPregleda.naziv}}</td>
                  <td align="center" >{{udpregledi[i].cena}}</td>
                  <td></td>
                  <td style="text-align: center">   <button v-on:click="zakaziUDPregled(udpregledi[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Zakazi pregled</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
</form>

<form   v-if="prikazListaKlinika" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 20px 20px 20px 0 white inset, -20px -20px 20px 0 white inset; position: relative; top: 50px; left: 400px; width: 40%; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 93%; height: 93%; margin-top: 30px; margin-bottom: 30px">	
      <table style="width: 100%;" class="table table-hover table-fixed">
       
                <tr>
                  <th class="bg-info  text-white" >Naziv Klinike</th>
                  <th class="bg-info  text-white">Adresa Klinike</th>
                  <th class="bg-info  text-white">Ocena Klinike</th>
                  <th class="bg-info  text-white">Cena pregleda</th>
                  <th class="bg-info  text-white"></th>
                </tr>
                <tr v-for="k,i in klinike.length">
                  <td align="center" >{{klinike[i].naziv}}</td>
                  <td align="center" >{{klinike[i].adresa}}</td>
                  <td align="center" >{{klinike[i].ocena}}</td>
                  <td></td>
                  <td style="text-align: center">   <button v-on:click="prikazLekara(klinike[i]); otvoriKliniku(klinike[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Prikazi profil klinike</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
  </form>

  <form v-if="prikazListaKlinika" class="message-form" style="position: relative;  border-radius: 25px; box-shadow: 20px 20px 20px 0 white inset, -20px -20px 20px 0 white inset; top: -250px; left: 1050px; width: 450px; height: 300px; border-color:rgba(130, 206, 209, 0.733); background-color:white ">
    <div  class="container d-flex justify-content-center" style="margin-top: 30px; ">	                        
<div class="card" style="border-color: rgba(130, 206, 209, 0.733); width: 93%; height: 93%; margin-top: 30px; margin-bottom: 30px">	

<table style="width: 100%; " class="table table-hover table-fixed">

  <tr>
    <th  >Izaberi tip pregleda</th>
    

  <td>
    <b-form-select  v-model="pretragaKlinika.tipPregleda">
      <option
        v-for="tipp in tipovi"
        :value="tipp.naziv"
        :key="tipp.id"
      >{{tipp.naziv}}</option>
    </b-form-select>
</b-form-select>
  
  </td>
  </tr>
  <tr>
    <th  > Izaberi datum pregleda</th>
<td >
  <input type="text"  class="form-control"  v-model="pretragaKlinika.datum" >

</td>
  </tr>
  <tr>
    <th > 
      <button  type="button"  class="btn btn-warning"  style="border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;"  v-on:click="pretragaKlinike">Pretraga</button>
  
    </th>
    <td align="center" >  
      <button  type="button"  class="btn btn-warning"  style=" border-color: rgb(233, 233, 233);  background-color: rgb(233, 233, 233); color: #37474F;" v-on:click="ponistiPretraguKlinika">Ponisti</button>
  
    </td>
  </tr>
</table>

</div>

</div>

</form>

  <form   v-if="prikazKlinike" class="message-form" style=" border-radius: 25px; box-shadow: 20px 20px 20px 0 white inset, -20px -20px 20px 0 white inset;  position: relative; top: 10px; left: 290px; width: 75%; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
    
    <button v-on:click="listaKlinika" class="btn btn-warning" style=" margin-left: 30px; margin-top: 20px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na listu klinika</i></button>

    
      <div class="card" style="width: 45%; height: 450px; margin-top: 30px; margin-left: 30px;   ">	

        <table style="width: 100%;   " class="table table-striped" >
          <tbody>
                  <tr >
                    <th  >Naziv: </th>
                    <td align="center" >{{klinika.naziv}}</td>
                  </tr>
                  <tr>
                    <th >Adresa: </th>
                    <td align="center" >{{klinika.adresa}}</td>
                  </tr>
                  <tr>
                    <th>Email: </th>
                    <td align="center" >{{klinika.email}}</td>
                  </tr>
                  <tr>
                    <th >Grad: </th>
                    <td align="center"  >{{klinika.grad}}</td>

                  </tr>
                  <tr>
                    <th >Drzava: </th>
                    <td align="center"  >{{klinika.drzava}}</td>
                  </tr>
                  <tr>
                    <th >Telefon: </th>
                    <td align="center" >{{klinika.telefon}}</td>
                  </tr>
                  <tr>
                    <th>Opis: </th>
                    <td align="center" >{{klinika.opis}}</td>
                  </tr>
                  <tr>
                    <th>Ocena: </th>
                    <td align="center" >{{klinika.ocena}}</td>
                  </tr>
                  <tr>
                    <th>Broj recenzija: </th>
                    <td align="center" >{{klinika.brojRecenzija}}</td>
                  </tr>
                </tbody>
              </table>     
            
              <button v-on:click="prikazudpregledi(klinika)" class="btn btn-warning" style=" margin-left: 180px; margin-top: 10px; height: 40px; width: 330px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> Prikazi unapred definisane preglede &#8594;</i></button>
            </div>

            <div class="card" style="width: 45%;  margin-top: -450px; margin-left: 600px;   ">	


        <table style="width: 100%; " class="table table-striped" >
          <tbody>
            <tr>
              <th ></th>
              <th>Ime</th>
              <th >Prezime</th>
              <th >Ocena</th>
              <th >Lista vremena</th>
              <th ></th>
            </tr>
            <tr v-for="k,i in lekari.length">
              <td></td>
              <td>{{lekari[i].ime}}</td>
              <td>{{lekari[i].prezime}}</td>
              <td>{{lekari[i].ocena}}</td>
              <td></td>
              <td style="text-align: center">   <button v-on:click="" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Dalje</i></button>
              </td>
            </tr>
                </tbody>
              </table>     
      
    </div>   
  
    </form>
  </div>   

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
        udpregledi: {},
        udpregled: {},
        lekari: {},
        tipovi: {},
        rezultatiPretrage: [],
        pretragaKlinika: {
	        tipPregleda: "",
	        datum: "",
        },
        ukljucenaPretraga: false,
        prikaz:false,
        prikazZK:false,
        prikazPREGLED:false,
        prikazUDPREGLEDI:false,
        prikazListaKlinika: false,
        prikazKlinike: false,
        izmeni:false,
        id: 1,
        filteri: ['Tip pregleda', 'Datum pregleda'],

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

  pretragaKlinike(){
          
             axios
        .post("/klinika/pretraga/" + this.$store.state.user.id, this.pretragaKlinika)
        .then(klinike =>{
         this.klinike = klinike.data;
            this.rezultatiPretrage = klinike.data;
            this.ukljucenaPretraga = true;
      })
      .catch(error => {
          console.log(error)
      });
           
       
    },    
    ponistiPretraguKlinika(){
        
        axios
        axios
      .get('/klinika/izlistajK')
      .then(klinika =>{
        this.klinike = klinika.data;
      
       this.pretragaKlinika.datum = "", 
       this.pretragaKlinika.tipPregleda = "",
        
        this.ukljucenaPretraga = false;
    })
    .catch(error => {
      console.log(error);
    });
        
    },
  prikazLekara(k) {

        axios
        .get('/lekar/izlistajLekare/'+ k.id)
        .then(lekari =>{
            this.lekari = lekari.data;
          })
        .catch(error => {
            console.log(error)
      });
    },

  izlistajTipove() {
        axios
		    .get("/tipPregleda/TipoviKlinike1/")
		    .then(tipovi => {
		        this.tipovi = tipovi.data;
		      })
		    .catch(error => {
		        console.log(error);
	      });
    },

   zakaziUDPregled(p){
        axios
        .post("/pregled/zakaziUDPregled/"+this.$store.state.user.id, p)
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
  prikazudpregledi(klinika) {
              this.prikaz=false;
              this.prikazUDPREGLEDI=!this.prikazUDPREGLEDI;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazKlinike=false;

    axios
      .get('/pregled/izlistajUDP/'+ klinika.id)
      .then(udpregledi =>{
        this.udpregledi = udpregledi.data;
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

th {
  display: table-cell;
  vertical-align: inherit;
  font-weight: bold;
  text-align: center;
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