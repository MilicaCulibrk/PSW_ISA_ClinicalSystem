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
              <i v-on:click="otvoriDodajLekara"> DODAJ LEKARA </i>
          </a>
          <a href="#">
              <i v-on:click="otvoriLekareKlinike"> LEKARI KLINIKE </i>
          </a>
          <a href="#">
             <i class="zmdi zmdi-link">  DEFINISANJE PREGLEDA</i> 
          </a>
            <a href="#">
	                <i class="zmdi zmdi-view-dashboard" style="color: red" v-on:click="odjava"> ODJAVA
	                </i>     
                                
	              </a>	    	  
        </ul>
                    
      </div>

      <div id="content">
        <div class="container-fluid">
          <h1 style="color: #b3b3b3;">Administrator Klinike - {{ korisnik.ime }} {{ korisnik.prezime }} </h1>
        </div>
      </div>
    </div>
    
                  <form v-if="prikaz"   class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
 
                        <div >
                                  <div class="google-map" :id="mapName"></div>
                            
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
                  <form v-if="prikazKlinike"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">

                       <div>
                                
                            
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
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="vidiLokaciju">Vidi lok</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>
				<form v-if="dodavanjeLekara"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">

                       <div>
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">

                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                                          <input type="text" v-model="lekar.ime" id="Form-ime" class="form-control">
                                          
										  <label for="Form-ime" style="color: #b3b3b3;">Prezime</label>
                                          <input type="text" v-model="lekar.prezime" id="Form-ime" class="form-control">
                                          
                                           <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                                          <input type="text" v-model="lekar.email" id="Form-username" class="form-control" >

                                          <label for="Form-username" style="color: #b3b3b3;">Lozinka</label>
                                          <input type="text" v-model="lekar.lozinka" id="Form-username" class="form-control" >
                                          
                                          <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                                          <input type="text" v-model="lekar.telefon" id="Form-phone" class="form-control" >
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                                          <input type="text" v-model="lekar.adresa" id="Form-email4" class="form-control">


                                        </div>
                                        </div>
                                        <div class="col">
                                        <div class="md-form pb-3">
                            
                                          <label for="Form-email4" style="color: #b3b3b3;">Grad</label>
                                          <input type="text" v-model="lekar.grad" id="Form-email4" class="form-control" >
                                        
                                          <label for="Form-email4" style="color: #b3b3b3;">Drzava</label>
                                          <input type="text" v-model="lekar.drzava" id="Form-email4" class="form-control" >                                        
                            
                                          <label for="Form-email4" style="color: #b3b3b3;">Jmbg</label>
                                          <input type="text" v-model="lekar.jmbg" id="Form-email4" class="form-control" >        
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Pocetak radnog vremena</label>
                                          <form >
											  <select v-model="lekar.pocetak" name="cars">
											    <option value=9>09:00</option>
											    <option value=10>10:00</option>
											    <option value=11>11:00</option>
											    <option value=12>12:00</option>
											  </select>
									      </form> 
									    
									      <label for="Form-email4" style="color: #b3b3b3;">Kraj radnog vremena</label>
                                          <form >
											  <select v-model="lekar.kraj" name="cars">
											    <option value=9>09:00</option>
											    <option value=10>10:00</option>
											    <option value=11>11:00</option>
											    <option value=12>12:00</option>
											  </select>
									      </form> 
                                               
                                          <label for="Form-email4" style="color: #b3b3b3;">Ocena</label>
                                          <input type="text" v-model="lekar.ocena" id="Form-email4" class="form-control" >                                        
                            
                                          <label for="Form-email4" style="color: #b3b3b3;">Broj recenzija</label>
                                          <input type="text" v-model="lekar.brojRecenzija" id="Form-email4" class="form-control" >
                                        </div>
                                        </div>
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajLekara">Dodaj</button>
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustaniDodajLekara">Odustani</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>

                <form   v-if="otvorenaListaLekara" class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
		          <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
		            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	

						  <table style="width: 500px;">
			                  <tr>
			                    <th class="bg-info  text-white">Ime</th>
			                    <th class="bg-info  text-white">Prezime</th>
			                    <th class="bg-info  text-white">Radno vreme</th>
			                    <th class="bg-info  text-white">Obrisi</th>
			                  </tr>
			                  <tr v-for="k,i in lekari.length">
			                    <td>{{lekari[i].ime}}</td>
			                    <td>{{lekari[i].prezime}}</td>
								<td>{{lekari[i].pocetak}}:00h - {{lekari[i].kraj}}:00h</td>
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiLekara(lekari[i].id)"><i class="fa fa-trash">Obrisi</i></button>
			                    </td>
			                  </tr>
			              </table>
	
       
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
		      dodavanjeLekara: false,
		      lekar: {},
		      otvorenaListaLekara : false,
		      lekari: {},
		      idKlinike: {},
		      mapName: 'google-map' + "-map",
		      }
  },
  methods: {
        otvoriFormu(){
            this.prikaz=!this.prikaz;
            this.prikazKlinike=false;
        },
        vidiLokaciju(){
			this.$router.push("/vidiLokaciju");
            },
        izmena() {
        this.izmeni = true
        },
    
        otvoriLekareKlinike(){
            this.prikaz=false;
            this.prikazKlinike=false;
            this.dodavanjeLekara = false;
            this.otvorenaListaLekara = !this.otvorenaListaLekara;
            axios
		      .get("/lekar/izlistaj/" + this.idKlinike)
		      .then(lekar =>{
		        this.lekari = lekar.data;
		        
		      })
		      .catch(error => {
		          console.log(error)
		      });
        },    
        otvoriDodajLekara(){
            this.prikaz=false;
            this.prikazKlinike=false;
            this.dodavanjeLekara = !this.dodavanjeLekara;
        },
        
        dodajLekara(){
			 if(this.lekar.ime=="" || this.lekar.prezime=="" || this.lekar.email==""  || this.lekar.lozinka=="" ||
			         this.lekar.adresa=="" || this.lekar.grad=="" || this.lekar.drzava=="" ||
			         this.lekar.telefon=="" || this.lekar.jmbg=="")
			         {
			          alert("Molimo vas popunite sva polja.");
			          return;
			         }
			this.lekar.idKlinike = this.korisnik.idKlinike;
	        axios
	        .post("/lekar/dodaj", this.lekar)
	        .then(lekar => {
	          this.lekar.ime="";
	          this.lekar.prezime="";
	          this.lekar.email="";
	          this.lekar.lozinka="";
	          this.lekar.adresa="";
	          this.lekar.grad="";
	          this.lekar.drzava="";
	          this.lekar.telefon="";
	          this.lekar.jmbg="";
	          alert("Dodat lekar!");
       
	        })
	        .catch(error => {
				alert("Lekar sa ovim email-om vec postoji.");
	        });
        },
        
        odustaniDodajLekara(){
            this.prikaz=false;
            this.prikazKlinike=false;
            this.dodavanjeLekara = !this.dodavanjeLekara;
        },
        
      odustani() {
        this.izmeni = false
        axios
        .get("/adminKlinike/get/" + this.$store.state.user.id)
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
      .put("/adminKlinike/izmeni", this.korisnik)
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
      .get("/klinika/pronadjiKliniku/" + this.idKlinike)
      .then(klinika =>{
        this.klinika = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
    	this.prikazKlinike = !this.prikazKlinike;
    	this.prikaz = false;

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
      izmenaKlinika() {
        this.izmeniKliniku = true
        },
      odustaniKlinika() {
        this.izmeniKliniku = false
        axios
        .get("/klinika/pronadjiKliniku/{korisnik.idKlinike}")
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
		      .put("/klinika/izmeni", this.klinika)
		      .then(klinika =>{
		        this.klinika = klinika.data;
		        this.izmeniKliniku = false;
		      })
		      .catch(error => {
		          console.log(error)
		      });
      }, 
      
      obrisiLekara(idLekara){
      		axios
		      .post("/lekar/obrisi/" + idLekara)
		      .then(lekari => {
			        this.lekari = lekari.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
      },

    },
 mounted() {

      axios
      .get("/adminKlinike/get/"  + this.$store.state.user.id)
      .then(adminKlinike =>{
        this.korisnik = adminKlinike.data;
        this.idKlinike = this.korisnik.idKlinike;
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

.google-map {
  width: 800px;
  height: 600px;
  margin: 0 auto;
  background: gray;
}

</style>


