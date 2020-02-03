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
          <a></a>
          <a href="#">
              <i v-on:click="otvoriKalendar">KALENDAR</i>
          </a>
          <a href="#">
             <i class="zmdi zmdi-link">LISTA PREGLEDA</i> 
          </a>

            <a href="#">
            <i v-on:click="otvoriListuPacijenata" class="zmdi zmdi-link">LISTA PACIJENATA</i> 
         </a>


            <a href="#">
	                <i class="zmdi zmdi-view-dashboard" style="color: red" v-on:click="odjava"> ODJAVA
	                </i>     
                                
	              </a>	    	  

        

          <a href="#">
            <i v-on:click="otvoriListuPacijenata" class="zmdi zmdi-link">LISTA PACIJENATA</i> 
         </a>

        </ul>
                    
      </div>

      <div id="content">
        <div class="container-fluid">
          <h1 style="color: #b3b3b3;">Lekar - {{ korisnik.ime }} {{ korisnik.prezime }} </h1>
        </div>
      </div>
    </div>

                  <form  v-if="prikaz" class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
                        <div >
                                
                            
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
                
                            <form v-if="prikazPacijenata" >


                              <div  style="position: relative; top: 10px; left: 300px; width: 650px; height: 100px; background-color: rgba(130, 206, 209, 0.733); ">	                    
                                   <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
                                     <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
                                          <label for="Form-username" style="color: #b3b3b3;">Sortiraj po:</label>
                                          <b-form-select v-model="odabirSortiranja" @change="azuriraj()" >
                                            <option 
                                              v-for="i in sortiranje"
                                            >{{i}}</option>
                                          </b-form-select>
                               </div>
                               </div>
                               <div  class="message-form"  style="position: relative; top: 10px; width: 650px; height: 480px; background-color: rgba(130, 206, 209, 0.733); ">
                               <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
                               
                               <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
                                       <table  id="tablePreview" class="table table-hover" style="width: 100%;">
                                         <thead>
                                           <tr>
                                                   <th class="th-lg">Id</th>
                                                   <th class="th-lg">Ime</th>
                                                   <th class="th-lg">Prezime</th>
                                                   <th class="th-lg">JMBG</th>
                                                   <th class="th-lg">Email</th>
                                                 </tr>
                                                 </thead>
                                                 <tbody>
                                                 <tr v-for="k,i in pacijenti.length" v-on:click="otvoriPacijenta(pacijenti[i])">
                                                   <td v-on:click="otvoriPacijenta(pacijenti[i])">{{pacijenti[i].id}}</td>
                                                   <td>{{pacijenti[i].ime}}</td>
                                                   <td>{{pacijenti[i].prezime}}</td>
                                                   <td>{{pacijenti[i].jmbg}}</td>
                                                   <td>{{pacijenti[i].email}}</td>
                                                   
                                                 </tr>
                                                 </tbody>
                                       </table>    
                                </div>
                                </div>
                                   </div>
                            
                                 </div>
                                 </form>

                  <form v-if="prikazPacijenta" >
                    <div style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; ">	                    
                     <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
                       <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
                         <h1 style="text-align: center; background-color: rgba(179, 227, 233, 0.733); color: #37474F">Pacijent - {{trenutniPacijent.ime}} {{trenutniPacijent.prezime}}</h1>
                         <div class="row" >
                          <div class="column">
                            <button class="btn btn-light" style="background-color: #eeeeee; width: 395px; height: 100px; font-size : 30px;" v-on:click="otvoriZK(trenutniPacijent.idZdravstveniKarton)">Zdravstveni karton</button>
                          </div>                 
                          <div class="column" >
                            <button class="btn btn-light" style="background-color: #eeeeee; width: 395px; height: 100px; font-size : 30px;" v-on:click="zapocniPregled">Zapocni pregled</button>
                          </div>
                          

                          </div>
                         <div class="row">
                         <div class="column"  style="width:50%;">
                          <div v-if="prikazZK" >
                            <div class="form-group">                    
                          <div class="card-body mx-4 mt-4">
                            <div class="row">
                  
                              <div class="col">
                                <label for="Form-dioptrija" style="color: #b3b3b3;">Dioptrija</label>
                                <input type="text" v-model="zdravstveniK.dioptrija" id="Form-username" class="form-control" :disabled="!izmeniZK">
                                
                                <label for="Form-alergija" style="color: #b3b3b3;">Alergija</label>
                                <input type="text" v-model="zdravstveniK.alergije" id="Form-ime" class="form-control" :disabled="!izmeniZK">
                                
                                <label for="Form-visina" style="color: #b3b3b3;">Visina</label>
                                <input type="text" v-model="zdravstveniK.visina" id="Form-phone" class="form-control" :disabled="!izmeniZK">
                                
                                <label for="Form-tezina" style="color: #b3b3b3;">Tezina</label>
                                <input type="text" v-model="zdravstveniK.tezina" id="Form-email4" class="form-control" :disabled="!izmeniZK">
        
                                  
                              </div>
                              
                             
                            </div>
                            <div class="text-center mb-4 mt-4">
                              <template>
                              <button v-if="!izmeniZK" type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);  " v-on:click="izmenaZK">Izmeni</button>
                              </template>
                              <template>
                              <button v-if="izmeniZK" type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="sacuvajZK">Sacuvaj</button>
                              <button v-if="izmeniZK" type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustaniZK">Odustani</button>
                              </template>
                            </div>
                            <div class="row">
                              <b-button v-b-toggle.collapse-1 variant="primary" v-on:click="otvoriIzvestaje" style=" background-color: #b3b3b3;">Istorija bolesti</b-button>
                              <b-collapse id="collapse-1" class="mt-2">
                                <b-card>
                                  <table  id="tablePreview" class="table table-hover" style="width: 100%;">
                                    <thead>
                                      <tr>
                                              <th class="th-lg">Id</th>
                                              <th class="th-lg">Opis</th>
                                              <th class="th-lg">Dijagnoza</th>
                                              <th class="th-lg">Lek</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr v-for="k,i in izvestaji.length">
                                              <td>{{izvestaji[i].id}}</td>
                                              <td>{{izvestaji[i].opis}}</td>
                                              <td>{{izvestaji[i].dijagnoza}}</td>
                                              <td>{{izvestaji[i].lekovi}}</td>
                                              
                                            </tr>
                                            </tbody>
                                  </table>   
                                </b-card>
                              </b-collapse>
                            </div>
                         </div>                     
                        </div>
                      </div>
                    </div>
                        <div class="column "  style="width:50%;">
                          <div v-if="prikazZapocniPregled">
                        <div class="form-group">
                      
                          <div class="card-body mx-4 mt-4">
                            <div class="row">
                  
                              <div class="col">
                                <label  for="Form-dioptrija" style="color: #b3b3b3;">Dijagnoza</label>
                                <b-form-select v-model="izvestaj.dijagnoza" >
							                    <option
							                      v-for="d in dijagnoze"
							                      :value="d.sifra"
							                      :key="d.id"
							                    >{{d.naziv}}</option>
							                  </b-form-select>
                                 
                                <label for="Form-alergija" style="color: #b3b3b3;">Lek</label>
                                <form >
                                 <b-form-select v-model="izabraniLekovi"  multiple="" class="ui fluid dropdown">
                                   <option v-for="l in lekovi" v-bind:value="l.sifra">{{l.naziv}}</option>
                                 </b-form-select v-model="izabraniLekovi">
                                 </form>  
                                 <label for="Form-dioptrija" style="color: #b3b3b3;">Opis</label>
                                 <input type="text" v-model="izvestaj.opis" id="Form-phone" class="form-control" >
                               
                             
                              </div>
                             
                            </div>
                            <a href="">+Zakazi novi pregled</a>
                            <div class="text-center mb-4 mt-4">
                              

                              <template>
                              <button type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 250px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);  " v-on:click="dodajIzvestaj()">Dodaj izvestaj</button>
                              </template>
                           </div>
                  
                            </div>
                          </div>
                  
                        </div>

                      </div>
                    </div>
                       </div>
                     </div>
                   </div>
                 </form>
	
	<form v-if="prikazPacijenata"  class="message-form" style="position: relative; top: -120px; left: 1100px; width: 350px; height: 405px; background-color: rgba(130, 206, 209, 0.733); ">

                       <div>
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">

                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                                          <input type="text" v-model="pretragaPacijenta.ime" id="Form-ime" class="form-control">
                                          
										  <label for="Form-ime" style="color: #b3b3b3;">Prezime</label>
                                          <input type="text" v-model="pretragaPacijenta.prezime" id="Form-ime" class="form-control">
                                          
                                            <label for="Form-ime" style="color: #b3b3b3;">JMBG</label>
                                          <input type="text" v-model="pretragaPacijenta.jmbg" id="Form-ime" class="form-control">


                                        </div>
                                        </div>
                                      
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="pretragaPacijenata">Pretraga</button>
                                         <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="ponistiPretraguPacijenata">Ponisti</button>
                                         
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>
	 		      </form>
                              	<form v-if="prikazPacijenata"  class="message-form" style="position: relative; top: -100px; left: 980px; width: 580px; height: 50px;  ">
	 		
                   <div   class="text-center mb-4 mt-4">
                                       <label for="Form-phone" style=" color: #b3b3b3;">Filtritaj po</label>
                                          <b-form-select v-model="selektovaniFilter" style= "position: relative; width: 280px;" >
							                    <option
							                      v-for="f in filteri"
							                     
							                   >{{f}}</option>
							                  </b-form-select>
							            <input type="text" v-model="filterString" id="Form-ime" class="form-control" style="position: relative; width: 280px; left: 188px;" >
                    					     <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; position: relative; left: 185px; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="ponistiFiltriranje">Ponisti</button>
                    </div>
 
             </form>     
             <form v-if="prikazKalendara" >
                  <vue-cal style="height: 400px; width: 100%; " selected-date="2018-11-19"
                  class="vuecal--blue-theme"
                    :time-from="8 * 60"
                    :time-to="23 * 60"
                    :disable-views="['years']"
                    editable-events
                    resize-x
                    :events="events">
                  </vue-cal>

             </form>
</div>

</template>


<script>
import axios from 'axios'
import VueCal from 'vue-cal'
import 'vue-cal/dist/vuecal.css'
export default {
  components: { VueCal },
 data() {
     return {
      korisnik: {},
      pacijenti: {},
      rezultatiPretrage: [],
         pretragaPacijenta: {
	        ime: "",
	        prezime: "",
	        jmbg: "",
        },
      zdravstveniK: {},
      zapocetPregled: false,
      prikazZK: false,
      prikaz:false,
      izmeni:false,
      izmeniZK:false,
      ukljucenaPretraga: false,
      prikazPacijenata:false,
      prikazPacijenta:false,
      trenutniPacijent:{},
      prikazZapocniPregled: false,
      dijagnoze: [],
      lekovi: [],
      pregledi: [],
      dijagnoza: {},
      odabirSortiranja: "",
      lek: {},
      sortiranje: ['id', 'ime', 'prezime', 'JMBG', 'email' ],
      izvestaj: {
        idPacijenta: "",
        idLekara: "",
        lek: "",
        dijagnoza: "",
      },
      filteri: ['Ime', 'Prezime'],
	  filter: "",
	  filterString: "",
	  selektovaniFilter: "",
      izvestaji: {},
      izabraniLekovi: [],
      pomocna: [],
      rezultatiPretrage: [],
      pomocnaRezultatiPretrage: [],
            prikazKalendara: false,
      events: [
    {
      start: '2018-11-16 10:00',
      end: '2018-11-20 12:37',
      title: 'Running Marathon',
      content: '<i class="v-icon material-icons">directions_run</i>',
      class: 'sport'
    },
    {
      start: '2018-11-20 10:00',
      end: '2018-11-20 10:25',
      title: 'Drink water!',
      content: '<i class="v-icon material-icons">local_drink</i>',
      class: 'health',
    },
    {
      start: '2018-11-21 19:00',
      end: '2018-11-23 11:30',
      title: 'Trip to India',
      content: '<i class="v-icon material-icons">flight</i>',
      class: 'leisure'
    }
  ]
      
      }
  },
  
  methods: {
        otvoriFormu(){
            this.prikaz=!this.prikaz;
            this.ponistiPretraguPacijenata();
        },
        izmena() {
        this.izmeni = true
        },
      odustani() {
        this.izmeni = false
        axios
        .get("/lekar/get/" + this.$store.state.user.id)
        .then(lekar =>{
          this.korisnik = lekar.data;
      })
      .catch(error => {
          console.log(error)
      });
      },
      
      otvoriKalendar(){
        this.prikazKalendara = true;
        this.prikazPacijenata = false;
        this.prikazPacijenta = false;
        this.prikaz = false;
      },
        ponistiPretraguPacijenata(){
        
	         axios
		      .get('/pacijent/izlistaj')
		      .then(pacijent =>{
		        this.pacijenti = pacijent.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	
	           this.pretragaPacijenta.ime = "", 
		       this.pretragaPacijenta.prezime = "", 
		       this.pretragaPacijenta.jmbg = "", 
		  	   this.ukljucenaPretraga = false
		  
	    
        },
        ponistiFiltriranje(){
        	this.filterString = ""
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
      .put("/lekar/izmeni", this.korisnik)
      .then(lekar =>{
        this.korisnik = lekar.data;
        this.izmeni = false;
      })
      .catch(error => {
          console.log(error)
      });
    },
    otvoriListuPacijenata(){
	event.preventDefault();
	  		this.prikaz=false;
        this.prikazZK=false;
	  		this.prikazPacijenata=!this.prikazPacijenata;
        this.prikazPacijenta = false;
                this.prikazKalendara = false;
        
        this.ponistiPretraguPacijenata();
	  	      axios

		      .get('/pacijent/izlistaj')

		      .then(pacijenti =>{
		        this.pacijenti = pacijenti.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	  	},
	  	 pretragaPacijenata(){
          
	           	  axios
			      .post("/pacijent/pretraga/" + this.$store.state.user.id, this.pretragaPacijenta)
			      .then(pacijenti =>{
			       this.pacijenti = pacijenti.data;
			       	 this.rezultatiPretrage = pacijenti.data;
			   
			       	  this.ukljucenaPretraga = true;
			       
		      })
		      .catch(error => {
		          console.log(error)
		      });
           
        },    
        
    otvoriZK(idzk){
  event.preventDefault();

       var flag = 0;
       for(var i = 0; i < this.pregledi.length; i++){
      
          if((this.pregledi[i].idPacijenta == this.trenutniPacijent.id && this.pregledi[i].lekar.id == this.$store.state.user.id && this.pregledi[i].zavrsen == true) || (this.pregledi[i].idPacijenta == this.trenutniPacijent.id && this.pregledi[i].lekar.id == this.$store.state.user.id && this.pregledi[i].zavrsen == false && this.zapocetPregled == true)){
            flag = 1;
            break;
          }  
        }
  
      console.log(flag);
      if(flag == 1){
            axios

          .get("/zdravstveniKarton/pronadjiZdravstveniKarton/"+ idzk)

          .then(z =>{
            this.zdravstveniK = z.data;
          })
          this.prikazZK=!this.prikazZK;
          this.prikazPacijenata=false;
          // this.prikazPacijenta=false;
        this.ponistiPretraguPacijenata();
      }else{
        alert('Niste nikad pregledali tog pacijenta!');
      }
    },
    izmenaZK(){
      this.izmeniZK = true
    },
    sacuvajZK(){
      axios

      .put("/zdravstveniKarton/izmeni", this.zdravstveniK)

      .then(adminKlinike =>{
        this.zdravstveniK = adminKlinike.data;
        this.izmeniZK = false;
      })
      .catch(error => {
          console.log(error)
      });

    },
    odustaniZK(){
      this.izmeniZK = false
        axios

        .get("/zdravstveniKarton/pronadjiZdravstveniKarton/"+ this.zdravstveniK.id)

	        .then(z =>{
	          this.zdravstveniK = z.data;
          })
      .catch(error => {
          console.log(error)
      });
    },
 
    azuriraj(){
      console.log('azuriraj');
      console.log(this.odabirSortiranja);
	  		axios
		      .put("/pacijent/azuriraj", this.odabirSortiranja)
		      .then(pacijenti => {
			        this.pacijenti = pacijenti.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
	  	},
	  	otvoriPacijenta(pacijent){
        this.prikazPacijenata = false;
	  		this.trenutniPacijent = pacijent;
	  		this.prikazPacijenta = true;
	  		        this.prikazKalendara = false;
	  		
        this.prikazZK = false;
        this.prikazZapocniPregled = false;
           this.ponistiPretraguPacijenata();
      },
      izlistajPreglede(){
      
      },

      zapocniPregled(){
     
        event.preventDefault();

        this.zapocetPregled = true;

        var flag = 0;
        for(var i = 0; i < this.pregledi.length; i++){
          //samo ako postoji zakazan pregled kod tog pacijenta lekar moze da ga zapocne
          if(this.pregledi[i].idPacijenta == this.trenutniPacijent.id && this.pregledi[i].lekar.id == this.$store.state.user.id && this.pregledi[i].zavrsen == false){
            flag = 1;
            break;
          }  
        }

        if(flag == 1){
          this.prikazZapocniPregled = !this.prikazZapocniPregled;
      //  this.prikazPacijenta = false;
        }else{
          alert('Nemate zakazan pregled kod tog pacijenta!');
        }
    
      },
      probaj(){
		console.log('da vidimo jel radi');
      },
      dodajIzvestaj(){

      event.preventDefault();

      

      var flag = 0;
      for(var i = 0; i < this.pregledi.length; i++){
        //samo ako postoji zakazan pregled kod tog pacijenta lekar moze da ga zapocne
        if(this.pregledi[i].idPacijenta == this.trenutniPacijent.id && this.pregledi[i].lekar.id == this.$store.state.user.id && this.pregledi[i].zavrsen == false){
          
          axios
		      .put("/pregled/zavrsi", this.pregledi[i])
		      .then(pregledi => {
			        this.pregledi = pregledi.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });

          break;
        }  
      }

        this.izvestaj.idPacijenta = this.trenutniPacijent.id;
        this.izvestaj.idLekara = this.$store.state.user.id;
        this.izvestaj.lekovi = this.izabraniLekovi;
        this.prikazZapocniPregled = false;
           this.ponistiPretraguPacijenata();
        axios
		      .post("/izvestaj/dodaj", this.izvestaj)
		      .then(odgovor => {
			        this.izvestaj = odgovor.data;
              this.izvestaj.lek = "";
              this.izvestaj.dijagnoza = "";
              this.izvestaj.opis = "";
			      })
		      .catch(error => {
		          console.log(error)
		      });
      },
      otvoriIzvestaje(){
        axios
		      .get("/izvestaj/izlistaj/" + this.trenutniPacijent.id)
		      .then(odgovor => {
			        this.izvestaji = odgovor.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
      }
    },
 beforeUpdate(){
  
 
    if(this.prikazPacijenata){
    if(this.ukljucenaPretraga === false){
  		if(this.selektovaniFilter === 'Ime'){
  			  for( var i = 0; i < this.pacijenti.length; i++){ 
  			     if ( !this.pacijenti[i].ime.includes(this.filterString)) {
			   	 	this.pacijenti.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
      
  
	      axios
	      .get("/pacijent/izlistaj")
	      .then(pacijenti => {
	        this.pomocna = pacijenti.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
	     
        
	        if(this.selektovaniFilter === 'Ime'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].ime.includes(this.filterString)) {
			  
			   var flag = 0;
				   	for(var j = 0; j < this.pacijenti.length; j++){
				   		if(this.pacijenti[j].ime === this.pomocna[i].ime  && this.pacijenti[j].prezime === this.pomocna[i].prezime){
				   		
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag == 0){
						 this.pacijenti.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}
  		
  			if(this.selektovaniFilter === 'Prezime'){
  			  for( var i = 0; i < this.pacijenti.length; i++){ 
  			     if ( !this.pacijenti[i].prezime.includes(this.filterString)) {
			   	 	this.pacijenti.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
     
	      	  axios
	      .get("/pacijent/izlistaj")
	      .then(pacijenti => {
	        this.pomocna = pacijenti.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
  
	  
	      
	      if(this.selektovaniFilter === 'Prezime'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].prezime.includes(this.filterString)) {
			    
			   var flag = 0;
				   	for(var j = 0; j < this.pacijenti.length; j++){
				   		if(this.pacijenti[j].prezime === this.pomocna[i].prezime  && this.pacijenti[j].ime === this.pomocna[i].ime ){
				   		
				   			flag = 1;
				   			break;
				   		}
				   		
				   	
				   	}
					   			
				    if(flag == 0){
						 this.pacijenti.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}	
      	
      
  		
	      
  	}else{
 
  			if(this.selektovaniFilter === 'Ime'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].ime.includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Ime'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].ime.includes(this.filterString)) {
			   console.log('USAO');
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].ime === this.pomocnaRezultatiPretrage[i].ime && this.rezultatiPretrage[j].prezime === this.pomocnaRezultatiPretrage[i].prezime){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.pacijenti.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  	
  		if(this.selektovaniFilter === 'Prezime'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].prezime.includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Prezime'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].prezime.includes(this.filterString)) {
		
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].prezime === this.pomocnaRezultatiPretrage[i].prezime && this.rezultatiPretrage[j].ime === this.pomocnaRezultatiPretrage[i].ime){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.pacijenti.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  		}
    }
  	
  },
 mounted() {
   {
         axios
		      .get("/pregled/izlistaj")
		      .then(pregledi => {
              this.pregledi = pregledi.data;
              
              console.log(this.pregledi);
              console.log(this.pregledi.length);
			      })
		      .catch(error => {
		          console.log(error)
		      });
        }{
      axios
      .get("/lekar/get/" + this.$store.state.user.id)
      .then(lekar =>{
        this.korisnik = lekar.data;
      })
      .catch(error => {
          console.log(error)
      });
   }{
    axios
      .get("/lek/izlistaj" )
      .then(lek =>{
        this.lekovi = lek.data;
      })
      .catch(error => {
          console.log(error)
      });
   }{
    axios
      .get("/dijagnoza/izlistaj")
      .then(dijagnoza =>{
        this.dijagnoze = dijagnoza.data;
      })
      .catch(error => {
          console.log(error)
      });
   }
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


