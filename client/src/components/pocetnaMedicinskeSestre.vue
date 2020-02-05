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
                      <input type="text" id="Form-username" class="form-control" v-model=korisnik.email disabled>
                      
                      <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                      <input type="text" id="Form-ime" class="form-control" v-model=korisnik.ime :disabled="!izmeni">
                      
                      <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                      <input type="text" id="Form-phone" class="form-control" v-model=korisnik.telefon :disabled="!izmeni">
                      
                      <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                      <input type="text" id="Form-email4" class="form-control" v-model=korisnik.adresa :disabled="!izmeni">
                      
                      <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                      <input type="text" id="Form-email4" class="form-control" v-model=korisnik.jmbg disabled>
        
                    </div>
                    </div>
                    <div class="col">
                    <div class="md-form pb-3">
        
                      <label for="Form-city" style="color: #b3b3b3;">Lozinka</label>
                      <input type="text" id="Form-city" class="form-control" v-model=korisnik.lozinka disabled>
                      
                      <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                      <input type="text" id="Form-prezime" class="form-control" v-model=korisnik.prezime :disabled="!izmeni">
        
                      
                      <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                      <input type="text" id="Form-city" class="form-control" v-model=korisnik.grad :disabled="!izmeni">
        
                  
                      <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                      <input type="text" id="Form-city" class="form-control" v-model=korisnik.drzava :disabled="!izmeni">
                     
                      <label for="Form-city" style="color: #b3b3b3;">Ocene</label>
                      <input type="text" id="Form-ocene" class="form-control" v-model=korisnik.ocene :disabled="!izmeni">
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
                    </template>
                  </div>
        
                </div>
        
              </div>
        
        
            </div>
            
        
          </div>
          </div>

    </form>
     <form v-if="prikazListaPacijenata" >


 		<div style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px;  ">	                    
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
	               <label for="Form-username" style="color: #b3b3b3;">Selektuj po:</label>
	               <b-form-select  >
	               	<option v-on:click="azuriraj('Id')">Id</option>
	               	<option v-on:click="azuriraj('Ime')">Ime</option>
	               	<option v-on:click="azuriraj('Prezime')">Prezime</option>
	               	<option v-on:click="azuriraj('JMBG')">JMBG</option>
	               	<option v-on:click="azuriraj('Email')">Email</option>
	               </b-form-select>
			</div>
			</div>
			<div  class="message-form" style="position: relative; top: 10px; left: 0px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
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
			        <button v-on:click="pritisni">Pritisni me</button>
			 </div>
			 </div>
          </div>
   
        </div>
        </form>
  <form v-if="prikazPacijenta" >
 		<div style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; ">	                    
      <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
        <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
          <h1>Pacijent {{trenutniPacijent.ime}} {{trenutniPacijent.prezime}}</h1>
          <button>Zapocni pregled</button>
          <button v-on:click="otvoriZK(trenutniPacijent.idZdravstveniKarton)">Pregledaj zdravstveni karton</button>

			  </div>
			</div>
    </div>
  </form>

  <form v-if="prikazKalendara" >
    <vue-cal style="height: 400px; width: 100%; " selected-date="2020-02-03"
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
<form v-if="prikazZahtevZaOdmor" style="position: relative; top: 10px; left: 400px;">
<div>
  <date-picker v-model="time3" range ></date-picker>
  <button v-on:click="posaljiZahtev">Posalji zahtev</button>
</div>

</form>

  <form  v-if="prikazZK" class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
  

    <div >	                    
       <div  class="container d-flex justify-content-center" style="margin-top: 30px">


           <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

             <div class="form-group">
       
               <div class="card-body mx-4 mt-4">
                 <div class="row">
       
                   <div class="col">
                   <div class="md-form">
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
       
                 
               </div>
       
             </div>
       
       
           </div>
           
       
         </div>
      
      </div>
 </form>  
 <form v-if="prikazRecepata" >


  <div style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px;  ">	                    

   <div  class="message-form" style="position: relative; top: 10px; left: 0px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
   <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
   
   <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
           <table  id="tablePreview" class="table table-hover" style="width: 100%;">
             <thead>
               <tr>
                       <th class="th-lg">Id recepta</th>
                       <th class="th-lg">Lekovi</th>
                       <th class="th-lg">Overa recepta</th>
                     </tr>
                     </thead>
                     <tbody>
                     <tr v-for="k,i in recepti.length" >
                       <td>{{recepti[i].id}}</td>
                       <td>{{recepti[i].lekovi}}</td>
                       <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="overiRecept(recepti[i])" ><i class="fa fa-trash">Overi</i></button>
                       </td>
                       
                     </tr>
                     </tbody>
           </table>    
    </div>
    </div>
       </div>

     </div>
     </form>
              
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
			prikaz: false,
			izmeni: false,
			selektovan: {},
			sortBy: {},
			trenutniPacijent: {},
      izmeni:false,
      izmeniZK:false,
      zdravstveniK: {},
      recepti: {},

			prikazListaPacijenata: false,
      prikazRecepata: false,
      prikazPacijenta: false,
      prikazKalendara: false,
      prikazZahtevZaOdmor: false,
      prikazZK: false,
      time3: null,
      odmor: {},
      events: [
      {
        startDate: new Date(),
        endDate: new Date(),
        title: 'Godisnji odmor',
        //content: '<i class="v-icon material-icons">directions_run</i>',
        //class: 'sport',
      }],
		}
	},
	methods: {
    otvoriKalendar(){
        this.prikazKalendara = !this.prikazKalendara;
        this.prikazPacijenata = false;
        this.prikazPacijenta = false;
        this.prikaz = false;
        axios
		      .get("/lekar/izlistajOdmor/" + this.$store.state.user.id)
		      .then(odgovor => {
            //this.events = odgovor.data;
            for (let i = 0; i < odgovor.data.length; i++) {
              this.events[0].startDate = new Date(odgovor.data[i].start);
              this.events[0].endDate = new Date(odgovor.data[i].end);
             }
   
			      })
		      .catch(error => {
		          console.log(error)
		      });
      },
    otvoriZahtevZaOdmor(){
      this.prikazZahtevZaOdmor = !this.prikazZahtevZaOdmor;
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
			this.prikaz=!this.prikaz;
		},
		izmena(){
			this.izmeni = true
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
		odustani(){
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
	  		this.prikaz=false
	  		this.prikazListaPacijenata=!this.prikazListaPacijenata
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
	  		console.log('pritislo');
	  	},
	  	obrisiPacijenta(id){
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
        axios

            .get("/zdravstveniKarton/pronadjiZdravstveniKarton/"+ idzk)

            .then(z =>{
              this.zdravstveniK = z.data;
            })
        this.prikazZK=true;
        this.prikazPacijenata=false;
        this.prikazPacijenta=false;

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
	  	azuriraj(nes){
	  		axios
		      .put("/pacijent/azuriraj", nes)
		      .then(pacijent => {
			        this.pacijenti = pacijent.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
	  	},
	  	otvoriPacijenta(pacijent){
        this.prikazListaPacijenata = false;
	  		this.trenutniPacijent = pacijent;
	  		this.prikazPacijenta = true;
	  	},
      otvoriRecepte(){
        this.prikazZK = false;
        this.prikazPacijenta = false;
        this.prikazListaPacijenata = false;
        this.prikazRecepata = !this.prikazRecepata;
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


