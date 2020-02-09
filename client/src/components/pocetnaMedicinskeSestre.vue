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
	                <i v-on:click="otvoriListaPacijenata"> LISTA PACIJENATA
	                </i>                   
                </a>	  
                <a href="#">
	                <i v-on:click="otvoriRecepte"> OVERA RECEPATA
	                </i>                   
                </a>	
                <a href="#">
                  <i v-on:click="otvoriZahtevZaOdmor" class="zmdi zmdi-link">ZAHTEV ZA ODMOR</i> 
               </a>
               <a href="#">
                <i v-on:click="otvoriKalendar">KALENDAR</i>
                <i></i>
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
                <h1 style="color: #b3b3b3;">Medicinska Sestra - {{ korisnik.ime }} {{ korisnik.prezime }}</h1>                
              </div>
            </div>
	     </div>
	
       <form v-if="prikaz" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 5px; left: 400px; width: 40%; background-color: rgba(130, 206, 209, 0.733); ">
        <div >	                    
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">
              
                  
            <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">
              <div class="form-group">
        
                <div class="card-body mx-4 mt-4">
                  <div class="row">
        
                    <div class="col">
                    <div class="md-form">
                      <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                      <input type="text" id="Form-username" class="form-control" v-model=korisnik.email disabled>
                      
                      <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                      <input type="text" id="Form-ime" class="form-control" v-model=korisnik.ime :disabled="!izmeni">
                      
                      <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                      <input type="text" id="Form-phone" class="form-control" v-model=korisnik.telefon :disabled="!izmeni">
                    
                      
                      <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                      <input type="text" id="Form-email4" class="form-control" v-model=korisnik.jmbg :disabled="!izmeni">
        
                    </div>
                    </div>
                    <div class="col">
                    <div class="md-form pb-3">
        
                   
                      
                      <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                      <input type="text" id="Form-prezime" class="form-control" v-model=korisnik.prezime :disabled="!izmeni">
        
                        
                      <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                      <input type="text" id="Form-email4" class="form-control" v-model=korisnik.adresa :disabled="!izmeni">
                      
                      <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                      <input type="text" id="Form-city" class="form-control" v-model=korisnik.grad :disabled="!izmeni">
        
                  
                      <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                      <input type="text" id="Form-city" class="form-control" v-model=korisnik.drzava :disabled="!izmeni">
                  
                    </div>
                    </div>
                  </div>
                
                  <div class="text-center mb-4 mt-4">
                    <template>
                    <button type="button" v-if="!izmeni" v-on:click="izmena" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " >Izmeni</button>
                    </template>
                    <template>
                    <button type="button" v-if="izmeni" v-on:click="sacuvaj" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " >Sačuvaj</button>
                    <button type="button" v-if="izmeni" v-on:click="odustani" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " >Odustani</button>
                    <button v-if="izmeni" v-b-modal.promenaLozinke type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 200px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); ">Promeni lozinku</button>
                  </template>
                  </div>
        
                </div>
        
              </div>
        
        
            </div>
            
        
          </div>
          </div>

    </form>
     

        <form   v-if="prikazListaPacijenata" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 520px; width: 45%; background-color: rgba(130, 206, 209, 0.733); ">
 
          <div  class="container d-flex justify-content-center" >	                        
            <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
              <table id="tablePreview" style="width: 100%;" class="table table-hover table-fixed">
             
               <tr>
                 <td align="right">
                   Sortiraj po:
                 </td>
                 <td colspan="4">
                <b-form-select v-model="odabirSortiranja" @change="azuriraj()" >
                  <option 
                    v-for="i in sortiranje"
                  >{{i}}</option>
        
                </b-form-select>
                
                  </td>
              </tr>
                        <tr>
                          <th class="th-lg">Id</th>
			                    <th class="th-lg">Ime</th>
			                    <th class="th-lg">Prezime</th>
			                    <th class="th-lg">JMBG</th>
			                    <th class="th-lg">Email</th>
                        </tr>
                        <tr v-for="k,i in pacijenti.length" v-on:click="otvoriPacijenta(pacijenti[i])">
			                    <td>{{pacijenti[i].id}}</td>
			                    <td>{{pacijenti[i].ime}}</td>
			                    <td>{{pacijenti[i].prezime}}</td>
			                    <td>{{pacijenti[i].jmbg}}</td>
			                    <td>{{pacijenti[i].email}}</td>
			                    
                        </tr>
                        
                    </table>     
            </div>
          </div>   
          </form>

        <form v-if="prikazPacijenta"  >
          <button v-on:click="otvoriListaPacijenata" class="btn btn-warning" style=" margin-left: 420px; margin-top: 10px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na listu pacijenata</i></button>

          <div style="position: relative; top: -30px; left: 400px; width: 800px; height: 630px; ">	                    
           <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
             <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
               <h1 style="text-align: center; background-color: rgba(179, 227, 233, 0.733); color: #37474F">Pacijent - {{trenutniPacijent.ime}} {{trenutniPacijent.prezime}}</h1>
               <div  >
                <div >
                  <button class="btn btn-light" style="background-color: #eeeeee; width: 765px; height: 100px; font-size : 30px;" v-on:click="otvoriZK(trenutniPacijent.idZdravstveniKarton)">Zdravstveni karton</button>
                </div>                 
              
                </div>
               <div class="row">
               <div class="column"  style="width:100%;">
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
                  <div >
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
          </div>
			  </div>
			</div>
    </div>
  </form>

  <form v-if="prikazKalendara" >
    <vue-cal style="height: 400px; width: 84%; margin-left: 250px; " selected-date="2020-02-03"
    class="vuecal--blue-theme"
      :time-from="8 * 60 "
      :time-to="23 * 60"
      :disable-views="['years']"
      editable-events
      resize-x
      :events="events"
      >
    </vue-cal>

  </form>

<form   v-if="prikazZahtevZaOdmor" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 520px; width: 45%; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
  
        <date-picker v-model="time3" range></date-picker>
    
        <button v-on:click="posaljiZahtev"  style=" position: fixed; margin-left: 30px;  height: 40px; width: 220px;  background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Posalji zahtev</i></button>
   
    </div>
  </div>   
  </form>


 
<form   v-if="prikazRecepata" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 520px; width: 45%; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
      <table style="width: 100%;" class="table table-hover table-fixed">
                <tr>
                  <th class="th-lg">Id recepta</th>
                  <th class="th-lg">Lekovi</th>
                  <th class="th-lg">Overa recepta</th>
                </tr>
                <tr v-for="k,i in recepti.length" >
                  <td>{{recepti[i].id}}</td>
                  <td>{{recepti[i].lekovi}}</td>
                  <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="overiRecept(recepti[i])" ><i class="fa fa-trash">Overi</i></button>
                  </td>
                  
                </tr>
            </table>     
    </div>
  </div>   
  </form>

  <b-modal ref="my-modal" id="promenaLozinke" hide-footer title="Promeni Lozinku">
      <label for="Form-city" style="color: #b3b3b3;">Stara lozinka</label>
      <input type="text" v-model="drugaLozinka.staraLozinka" id="Form-city" class="form-control">
    
      <label for="Form-city" style="color: #b3b3b3;">Nova lozinka</label>
      <input type="text" v-model="drugaLozinka.novaLozinka" id="Form-city" class="form-control">
    
      <label for="Form-city" style="color: #b3b3b3;">Ponovljena lozinka</label>
      <input type="text" v-model="drugaLozinka.ponovljenaLozinka" id="Form-city" class="form-control">
      <br>
    
      <b-button v-b-modal.greska @click="sacuvajDruguLozinku"  style="color: black; border-color:  rgba(130, 206, 209, 0.733); background-color: rgba(130, 206, 209, 0.733);">Sacuvaj</b-button>
      <b-button @click="odustaniDrugaLozinka"  style="color: black; border-color:  rgba(130, 206, 209, 0.733); background-color: rgba(130, 206, 209, 0.733);">Odustani</b-button>
    
    </b-modal>

    <b-modal ref="my-modal" id="greska" hide-footer title="Klinicki Centar">
        <b-alert v-if="error" show variant="danger" class="d-flex justify-content-center">{{errormessage}}</b-alert>
        <b-alert v-else show variant="success" class="d-flex justify-content-center">{{errormessage}}</b-alert>
</b-modal>
              
</div>





</template>

<script>
import axios from 'axios'
import VueCal from 'vue-cal';
import 'vue-cal/dist/vuecal.css';
import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';
export default {
  components: { VueCal ,
    DatePicker},
	data() {
		return{
			korisnik: {},
      pacijenti: {},
      izvestaji: {},

			prikaz: false,
			izmeni: false,
			selektovan: {},
			sortBy: {},
      trenutniPacijent: {},
      error: "",
      errormessage: "",
      izmeni:false,
      izmeniZK:false,
      zdravstveniK: {},
      recepti: {},
      drugaLozinka: {
        staraLozinka: "",
        novaLozinka: "",
        ponovljenaLozinka: "",
      },
      odabirSortiranja: {},
      sortiranje: ['id', 'ime', 'prezime', 'JMBG', 'email' ],

			prikazListaPacijenata: false,
      prikazRecepata: false,
      prikazPacijenta: false,
      prikazKalendara: false,
      prikazZahtevZaOdmor: false,
      prikazZK: false,
      time3: null,
      odmor: {},
      events: [],
		}
	},
	methods: {
    otvoriKalendar(){
      event.preventDefault();
        this.prikazKalendara = !this.prikazKalendara;
        this.prikazPacijenata = false;
        this.prikazPacijenta = false;
        this.prikaz = false;
        this. prikazListaPacijenata= false;
        this.prikazRecepata= false;
        this.prikazZahtevZaOdmor= false;
        this.prikazZK= false;
        axios
		      .get("/medicinska_sestra/izlistajOdmor/" + this.$store.state.user.id)
		      .then(odgovor => {
            //this.events = odgovor.data;

            this.events.length = 0;
            for (var i = 0; i < odgovor.data.length; i++) {
              var obj = {};
              obj.startDate = new Date(odgovor.data[i].start);
              obj.endDate = new Date(odgovor.data[i].end);
              obj.title = 'Godisnji odmor';

              this.events.unshift(obj);

             }
			      })
		      .catch(error => {
		          console.log(error)
		      });
      },
    otvoriZahtevZaOdmor(){
      event.preventDefault();

      this.prikazZahtevZaOdmor = !this.prikazZahtevZaOdmor;
      this.prikazKalendara = false;
        this.prikazPacijenata = false;
        this.prikazPacijenta = false;
        this.prikaz = false;
        this. prikazListaPacijenata= false;
        this.prikazRecepata= false;
        this.prikazZK= false;
    },
    posaljiZahtev(){
      event.preventDefault();
      this.odmor.medicinskaSestra = this.$store.state.user.id;

      this.odmor.start = this.time3[0];
      this.odmor.end = this.time3[1];
      axios
		      .post("/zahtevZaOdmor/zatrazi", this.odmor)
		      .then(odgovor => {
              alert("Poslat zahtev!");
			      })
		      .catch(error => {
		          console.log(error)
		      });
    },
		otvoriFormu(){
      event.preventDefault();

      this.prikaz=!this.prikaz;
      this.prikazZahtevZaOdmor = false;
      this.prikazKalendara = false;
        this.prikazPacijenata = false;
        this.prikazPacijenta = false;
        this. prikazListaPacijenata= false;
        this.prikazRecepata= false;
        this.prikazZK= false;
    },
    odustaniDrugaLozinka(){
        this.drugaLozinka.staraLozinka = "";
        this.drugaLozinka.novaLozinka = "";
        this.drugaLozinka.ponovljenaLozinka = "";
      },
      sacuvajDruguLozinku(){

        console.log('tu je');

        if (
        this.drugaLozinka.staraLozinka == "" ||
        this.drugaLozinka.novaLozinka == "" ||
        this.drugaLozinka.ponovljenaLozinka == ""
      ) {

        this.error = true;
        this.errormessage = "Morate popuniti sva polja!";
       
        return;
      }
      if (this.drugaLozinka.novaLozinka !== this.drugaLozinka.ponovljenaLozinka) {
        this.error = true;
        this.errormessage = "Lozinke se ne poklapaju!";
      
        return;
      }

      axios
        .post(
          "/medicinska_sestra/promeniSvojuLozinku/" + this.$store.state.user.id,
          this.drugaLozinka
        )
        .then(() => {
          this.drugaLozinka = {
            staraLozinka: "",
            novaLozinka: "",
            ponovljenaLozinka: ""
          };
          this.error = false;
          this.errormessage = "Uspesno ste promenili lozinku";
        })
        .catch(error => {
          this.error = true;
          this.errormessage = "Netacna stara lozinka!";
      
          console.log(error);
        });
      },
		izmena(){
      event.preventDefault();

			this.izmeni = true
    },
      odjava(){
        event.preventDefault();

                localStorage.removeItem("jwt");
                this.$store.state.user = {
                role: {
                authority: ""
            }
          };
          this.$router.push("/");
            },
		odustani(){
      event.preventDefault();

	        this.izmeni = false
	        axios
	        .get("/medicinska_sestra/get/"  + this.$store.state.user.id)
	        .then(medicinskaSestra =>{
		          this.korisnik = medicinska_sestra.data;
		      })
		    .catch(error => {
		          console.log(error)
		    });			
		},
		sacuvaj(){
      event.preventDefault();

			if(this.korisnik.ime === "" || this.korisnik.prezime === "" || this.korisnik.adresa === "" || this.korisnik.grad === "" || this.korisnik.drzava === ""
            	|| this.korisnik.telefon === "") 
            	{
                    alert("Polja ne smeju biti prazna!");
                    return;
				}
            var rex = /^\+381\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
            if (!rex.test(String(this.korisnik.telefon.trim()))) {
            	alert("Broj telefona treba da bude oblika +381/65-504205");    
             	return;
            }
            axios
            .put("/medicinska_sestra/izmeni", this.korisnik)
            .then(medicinskaSestra =>{
              this.korisnik = medicinskaSestra.data;
              this.izmeni = false;
            })
            .catch(error => {
                console.log(error)
            });
	  	},
	  	otvoriListaPacijenata(){
        event.preventDefault();

        this.prikazKalendara = false;
        this.prikazPacijenata = false;
        this.prikaz = false;
        this.prikazRecepata= false;
        this.prikazZahtevZaOdmor= false;
        this.prikazZK= false;
        this.prikaz=false;
        this.prikazPacijenta=false;
        this.odabirSortiranja="";
	  		this.prikazListaPacijenata=!this.prikazListaPacijenata;
	  	      axios
		      .get('/pacijent/izlistaj')
		      .then(pacijent =>{
		        this.pacijenti = pacijent.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	  	},
	  	pritisni(){
        event.preventDefault();

        console.log('pritislo');
	  	},
	  	obrisiPacijenta(id){
        event.preventDefault();

      		axios
		      .post("/pacijent/obrisi/" + id)
		      .then(pacijent => {
			        this.pacijenti = pacijent.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
      	},
        otvoriZK(idzk){
          event.preventDefault();

        axios

            .get("/zdravstveniKarton/pronadjiZdravstveniKarton/" + idzk)

            .then(z =>{
              this.zdravstveniK = z.data;
            })
        this.prikazKalendara = false;
        this.prikaz = false;
        this. prikazListaPacijenata= false;
        this.prikazRecepata= false;
        this.prikazZahtevZaOdmor= false;
        this.prikazZK=!this.prikazZK;
        this.prikazPacijenata=false;
        this.prikazPacijenta=true;

      },
      izmenaZK(){
        event.preventDefault();

        this.izmeniZK = true
      },
      sacuvajZK(){
        event.preventDefault();

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
        event.preventDefault();

        this.izmeniZK = false;
          axios

          .get("/zdravstveniKarton/pronadjiZdravstveniKarton/"+ this.zdravstveniK.id)

            .then(z =>{
              this.zdravstveniK = z.data;
            })
        .catch(error => {
            console.log(error)
        });
      },
      otvoriIzvestaje(){
        event.preventDefault();

        axios
		      .get("/izvestaj/izlistaj/" + this.trenutniPacijent.id)
		      .then(odgovor => {
			        this.izvestaji = odgovor.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
      },
      azuriraj(){
        event.preventDefault();

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
        event.preventDefault();

        this.prikazListaPacijenata = false;
	  		this.trenutniPacijent = pacijent;
        this.prikazPacijenta = ! this.prikazPacijenta;
        this.prikazKalendara = false;
        this.prikaz = false;
        this.prikazRecepata= false;
        this.prikazZahtevZaOdmor= false;
        this.prikazZK= false;
	  	},
      otvoriRecepte(){
        event.preventDefault();

        this.prikazZK = false;
        this.prikazPacijenta = false;
        this.prikazListaPacijenata = false;
        this.prikazRecepata = !this.prikazRecepata;
        this.prikazZahtevZaOdmor= false;
        this.prikazListaPacijenata = false;
        this.prikazKalendara = false;
        this.prikaz=false;

        axios
		      .get('/izvestaj/izlistaj')
		      .then(odg =>{
		        this.recepti = odg.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
      },
      overiRecept(izvestaj){
        event.preventDefault();

        izvestaj.idMedicinskeSestre = this.$store.state.user.id;
        axios
		      .put("/izvestaj/overi", izvestaj)
		      .then(odg =>{
		        this.recepti = odg.data;
		      }
		      )
		      .catch(error => {
		          console.log(error)
		      });
      }
	},
	mounted() {

    event.preventDefault();
      axios
      .get('/medicinska_sestra/get/'  + this.$store.state.user.id)
      .then(medicinskaSestra =>{
        this.korisnik = medicinskaSestra.data;
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


