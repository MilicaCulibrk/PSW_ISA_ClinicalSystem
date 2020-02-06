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
              <i  v-on:click="dodajKliniku" class="zmdi zmdi-view-dashboard">DODAJ KLINIKU</i>
          </a>
          <a href="#">
             <i v-on:click="listaKlinika" class="zmdi zmdi-link"> LISTA KLINIKA</i> 
          </a>
          <a href="#">
             <i  v-on:click="listaAdmina" class="zmdi zmdi-link"> LISTA ADMINISTRATORA</i> 
          </a>
           <a href="#">
             <i  v-on:click="listaLekova" class="zmdi zmdi-link"> LEKOVI</i> 
          </a>
          <a href="#">
             <i  v-on:click="listaDijagnoza" class="zmdi zmdi-link">  DIJAGNOZE</i> 
          </a>
           <a href="#">
             <i v-on:click="pogledajZahteve" class="zmdi zmdi-link" style="color: rgba(130, 206, 209, 0.733); " >ZAHTEVI ZA REGISTRACIJU : {{zahtevi.length}}</i> 
          </a>
           <a href="#">
	                <i class="zmdi zmdi-view-dashboard" style="color: red" v-on:click="odjava"> ODJAVA
	                </i>     
                                
	              </a>	    	  
        </ul>
                    
      </div>

      <div id="content">
        <div class="container-fluid">
          <h1 style="color: #b3b3b3;">Administrator Klinickog Centra - {{ korisnik.ime }} {{ korisnik.prezime }} </h1>
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
 <form v-if="prikazZ"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
            <div>
                    
                
                  <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                
                    
                    <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                      <div class="form-group">
                
                        <div class="card-body mx-4 mt-4">
                          <div class="row">
                
                            <div class="col">
                            <div class="md-form">
                              <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                              <input type="text" v-model="pacijent.email" id="Form-username" class="form-control" disabled>
                              
                              <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                              <input type="text" v-model="pacijent.ime" id="Form-ime" class="form-control" disabled>
                              
                              <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                              <input type="text" v-model="pacijent.telefon" id="Form-phone" class="form-control" disabled>
                              
                              <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                              <input type="text" v-model="pacijent.adresa" id="Form-email4" class="form-control" disabled>

                              <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                              <input type="text" v-model="pacijent.jmbg" id="Form-email4" class="form-control" disabled>
                            
                              
                
                            </div>
                            </div>
                            <div class="col">
                            <div class="md-form pb-3">
                
                              <label for="Form-city" style="color: #b3b3b3;">Lozinka</label>
                              <input type="text" v-model="pacijent.lozinka" id="Form-city" class="form-control" disabled>
                              
                              <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                              <input type="text" v-model="pacijent.prezime" id="Form-prezime" class="form-control" disabled>
                
                              
                              <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                              <input type="text" v-model="pacijent.grad" id="Form-city" class="form-control" disabled>
                
                          
                              <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                              <input type="text" v-model="pacijent.drzava" id="Form-city" class="form-control" disabled>

                              <label for="Form-city" style="color: #b3b3b3;">Jmbg</label>
                              <input type="text" v-model="pacijent.jmbg" id="Form-city" class="form-control" disabled>
                             
                           

                            </div>
                            </div>
                          </div>
                          
                          <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button v-if="!obradjen"  type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);  " v-on:click="prihvatiZahtev">Prihvati</button>
                                        </template>
                                        <template>
                                        <button v-if="!obradjen"   type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odbijZahtev">Odbij</button>
                                        </template>
                                      </div>
                
  
                
                        </div>
                
                      </div>
                
                
                    </div>
                    
                
                  </div>
                  </div>
    </form>
       <form v-if="prikaz1"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">       
         <option v-on:click="prikaziZahtev(zahtev)" class="card border-info" style="font-size:25px; text-align: center; position:relative;  left: 165px;  height: 3rem; width: 30rem; top: 20px"
                    v-for="zahtev in zahtevi"
                    :value="zahtev.id"
                    :key="zahtev.id"
               
                  >                              
                    Zahtev {{zahtev.id}} -    Status: {{zahtev.status}}	              
        </option>           
       </form>

       <form   v-if="prikazListaAdmina" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 280px; width: 35%; background-color: rgba(130, 206, 209, 0.733); ">
 
        <div  class="container d-flex justify-content-center" >	                        
          <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
              <h3 style=" text-align: center; color: dimgray;">LISTA ADMINISTRATORA</h3>
          <table style="width: 100%; max-height: 300px; overflow:auto; " class="table table-striped table-fixed" >   
          <tbody> 
                      <tr>
                        <th  >Ime</th>
                        <th >Prezime</th>
                        <th >Email</th>
                      </tr>
                      <tr v-for="k,i in admini.length">
                        <td >{{admini[i].ime}}</td>
                        <td >{{admini[i].prezime}}</td>
                        <td >{{admini[i].email}}</td>
                      
                      </tr>
                      </tbody>  
                  </table>     
          </div>
        </div>   
      </form>
      <form v-if="prikazListaAdmina" class="message-form position: fixed; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: fixed; top: 60px; left: 870px; width: 35%; background-color: rgba(130, 206, 209, 0.733); ">
   
        <div  class="container d-flex justify-content-center" >	                        
            <div class="card" style="width: 95%; height: 600px; margin-top: 30px; margin-bottom: 30px">	
                

                <table style="width: 100%;  " class="table table-striped" >
                     <tr> 
                        <th> Ime</th>
                        <th> Prezime </th>
                     </tr> 
                     <tr>
                       <td> <input type="text" v-model=administrator.ime /> </td>
                       <td> <input type="text" v-model=administrator.prezime  /> </td>
                     </tr>
                     <tr> 
                        <th> Email</th>
                        <th> Lozinka </th>
                     </tr> 
                     <tr>
                        <td> <input type="text" v-model=administrator.email /> </td>
                        <td> <input type="text" v-model=administrator.lozinka  /> </td>
                      </tr>
                      <tr> 
                          <th> Klinika</th>
                          <th> Grad </th>
                       </tr> 
                       <tr>
                          <td>  
                              <b-form-select style="width: 180px; overflow: visible;" v-model="administrator.idKlinike">
                                <option
                                  v-for="kl in klinike"
                                  :value="kl.id"
                                  :key="kl.id"
                                >{{kl.naziv}}</option>
                              </b-form-select> </td>
                         
                          <td> <input type="text" v-model=administrator.grad  /> </td>
                        </tr>
                        <tr> 
                            <th> Drzava</th>
                            <th> Telefon </th>
                         </tr> 
                         <tr>
                            <td> <input type="text" v-model=administrator.drzava /> </td>
                            <td> <input type="text" v-model=administrator.telefon  /> </td>
                          </tr>
                          <tr> 
                              <th> JMBG</th>
                              <th> Adresa </th>
                           </tr>
                           <tr>
                              <td> <input type="text" v-model=administrator.jmbg /> </td>
                              <td> <input type="text" v-model=administrator.adresa /> </td>
                            </tr>
                            <tr>
                              <td align="right">
                                  <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 40px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajAdministratora">Dodaj</button>
                                </td> 
                                <td align="left">
                                  <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 40px ; border-color: lightpink;  background-color: lightpink; " v-on:click="odustani1">Odustani</button>
                                  </td>
          <td>

          </td>
          </tr>
          </table>
              
          
            </div>
            </div>
</form>


       <form   v-if="prikazListaKlinika" class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
				<li v-for="k,i in klinike.length">
 					<a href="#" class="list-group-item list-group-item-action">{{klinike[i].naziv}}, {{klinike[i].adresa}}</a>		
				</li>        
          </div>
          </div>        
       </form>
       <form   v-if="prikazListaLekova" class="message-form" style="position: relative; top: 10px; left: 400px; width: 40%; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
						  <table style="width: 100%;">
			                  <tr>
			                    <th class="bg-info  text-white">Sifra</th>
			                    <th class="bg-info  text-white">Naziv</th>
			                    <th class="bg-info  text-white">Obrisi</th>
			                  </tr>
			                  <tr v-for="k,i in lekovi.length">
			                    <td>{{lekovi[i].sifra}}</td>
			                    <td>{{lekovi[i].naziv}}</td>
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiLek(lekovi[i].id)"><i class="fa fa-trash">Obrisi</i></button>
			                    </td>
			                  </tr>
			              </table>     
          	</div>
          </div>   
          <form class="message-form" style="position: relative; top: -70px; left: 700px; width: 40%; height: 58%;  background-color: rgba(130, 206, 209, 0.733); ">
                <div>
                  <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                   <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">
                      <div class="form-group">                        
                        <div class="card-body mx-4 mt-4">
                          <div class="row">                            
                            <div class="col">
                            <div class="md-form">
                              
                              <label for="Form-ime" style="color: #b3b3b3;">Sifra</label>
                              <input type="text" id="Form-ime" class="form-control" v-model="lek.sifra">
                
                              <label for="Form-email4" style="color: #b3b3b3;">Naziv</label>
                              <input type="text"  id="Form-email4" class="form-control" v-model="lek.naziv">
                            
                            </div>
                            </div>
                          </div>
                          <div class="text-center mb-4 mt-4">
                            <template>
                            <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajLek">Dodaj</button>
                            <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustani">Odustani</button>
                            </template>
                          </div>                            
                        </div>                         
                      </div>
                   </div>
                  </div>
                  </div>
                </form>          
       </form>
       <form v-if="prikazListaDijagnoza" class="message-form" style="position: relative; top: 10px; left: 400px; width: 40%; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
						  <table style="width: 100%;">
			                  <tr>
			                    <th class="bg-info  text-white">Sifra</th>
			                    <th class="bg-info  text-white">Naziv</th>
			                    <th class="bg-info  text-white">Obrisi</th>
			                  </tr>
			                  <tr v-for="k,i in dijagnoze.length">
			                    <td>{{dijagnoze[i].sifra}}</td>
			                    <td>{{dijagnoze[i].naziv}}</td>
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiDijagnozu(dijagnoze[i].id)"><i class="fa fa-trash">Obrisi</i></button>
			                    </td>
			                  </tr>
			              </table>     
          	</div>
          	
          </div>        
          <form class="message-form" style="position: relative; top: -45px; left: 700px; width: 40%; height: 58%;  background-color: rgba(130, 206, 209, 0.733); ">
                <div>
                  <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                   <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">
                      <div class="form-group">                        
                        <div class="card-body mx-4 mt-4">
                          <div class="row">                            
                            <div class="col">
                            <div class="md-form">
                              
                              <label for="Form-ime" style="color: #b3b3b3;">Sifra</label>
                              <input type="text" id="Form-ime" class="form-control" v-model="dijagnoza.sifra">
                
                              <label for="Form-email4" style="color: #b3b3b3;">Naziv</label>
                              <input type="text"  id="Form-email4" class="form-control" v-model="dijagnoza.naziv">
                            
                            </div>
                            </div>
                          </div>
                          <div class="text-center mb-4 mt-4">
                            <template>
                            <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajDijagnozu" >Dodaj</button>
                            <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustani" >Odustani</button>
                            </template>
                          </div>                            
                        </div>                         
                      </div>
                   </div>
                  </div>
                  </div>
                </form>         
       </form>
    
		         
</div>

</template>

<script>
import axios from 'axios'
    export default {
 data() {
     return {
      korisnik: {},
      pacijent: {},
      klinike: {},
      zahtevi: [],
      prikaz:false,
      prikaz1:false,
      izmeni:false,
      prikazZ: false,
      obradjen: false,
      trenutni: {},
      text: {},
      prikazListaAdmina: false,
      prikazListaKlinika: false,
      admini: {},
      prikazListaLekova: false,
      prikazListaDijagnoza: false,
      lekovi: [],
      dijagnoze: [],
      lek: {},
      dijagnoza: {},
      administrator: {
          ime: "",
          prezime: "",
          email: "",
          lozinka: "",
          adresa: "",
          grad: "",
          drzava: "",
          telefon: "",
          jmbg: "",
          idKlinike: "",
        }
      }
  },
  methods: {
         ucitajZahteve(){
          axios
          .get("/zahtevZaReg/getAll")
          .then(zahtevi =>{
          
          
         
          this.zahtevi = zahtevi.data;

           
          
      })
      .catch(error => {
          console.log(error)
      });
        },
        
     dodajKliniku(){
           	this.$router.push("/dodajKliniku");
        },
     prikaziZahtev(zahtev){
     	 	this.prikazListaLekova = false;
	 		this.prikazListaDijagnoza = false;
            this.prikaz = false;
            this.prikaz1 = false;
            this.prikazZ = true;
            this.trenutni = zahtev;
            axios
	        .get("/zahtevZaReg/getPacijenta/"+ zahtev.id)
	        .then(z =>{
	          this.pacijent = z.data;


      })
      .catch(error => {
          console.log(error)
      });
             
        },
        odbijZahtev(){
        	this.trenutni.status = "ODBIJEN";
        	this.obradjen = true;
        	var razlog = prompt("Molimo vas navedite razlog odbijanja:");
        	this.text = "Nazalost,"
                    + "\n\n vas zahtev je odbijen!" + "\n\nRazlog odbijanja: "+ razlog;
        	axios
          .post("/registracija/odbijen", this.pacijent.email)
        	
        },
        prihvatiZahtev(){
        	this.trenutni.status = "PRIHVACEN";
        	this.obradjen = true;
        	this.text = "Cestitamo,"
                    + "\n\n Upravo ste registrovani kao pacijent na sajt Klinickog centra!";
        	axios
          .post("/registracija/register", this.pacijent)
          .then(() => {
              alert('Pacijent uspesno registrovan!');
	        })
	
		    .catch(function (error) {
		        alert('Neuspesna registracija!');
		    
		    });

        },
        pogledajZahteve(){
        	this.prikazListaLekova = false;
	 		this.prikazListaDijagnoza = false;
          this.prikaz = false;
          this.prikazZ = false;
          this.prikaz1=!this.prikaz1;
             
        },




        dodajAdministratora(){
          
        if(this.administrator.ime=="" || this.administrator.prezime=="" || this.administrator.email==""  || this.administrator.lozinka=="" ||
         this.administrator.adresa=="" || this.administrator.grad=="" || this.administrator.drzava=="" ||
         this.administrator.telefon=="" || this.administrator.jmbg=="")
         {
          alert("Molimo vas popunite sva polja.");
          return;
         }

        axios
        .post("/adminKlinike/dodaj", this.administrator)
        .then(administrator => {
           
          this.administrator.ime="";
          this.administrator.prezime="";
          this.administrator.email="";
          this.administrator.lozinka="";
          this.administrator.adresa="";
          this.administrator.grad="";
          this.administrator.drzava="";
          this.administrator.telefon="";
          this.administrator.jmbg="";
          this.administrator.idKlinike="";
          alert("Dodat administrator!");
          this.ucitajOpetAd();
       
        })
        .catch(error => {
			alert("Administrator sa ovim email-om vec postoji.");
        });
      },
ucitajOpetAd(){
  axios
		      .get('/adminKlinike/izlistaj')
		      .then(admini =>{
		        this.admini = admini.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
},

        otvoriFormu(){
        	this.prikazListaLekova = false;
	 		this.prikazListaDijagnoza = false;
            this.prikaz1 = false;
            this.prikazZ = false;
            this.prikazListaAdmina=false;
            this.prikaz=!this.prikaz;
        },
        izmena() {
        this.izmeni = true
        },
        odustani1(){
          this.administrator.ime="";
          this.administrator.prezime="";
          this.administrator.email="";
          this.administrator.lozinka="";
          this.administrator.adresa="";
          this.administrator.grad="";
          this.administrator.drzava="";
          this.administrator.telefon="";
          this.administrator.jmbg="";
          this.administrator.idKlinike="";
        },

      odustani() {
        this.izmeni = false
        axios
        .get("/adminKlinickogCentra/get/" + this.$store.state.user.id)
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
	      .put("/adminKlinickogCentra/izmeni", this.korisnik)
	      .then(adminKlinike =>{
	        this.korisnik = adminKlinike.data;
	        this.izmeni = false;
	      })
	      .catch(error => {
	          console.log(error)
	      });
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
	 listaAdmina(){
	 	this.prikazListaLekova = false;
	 	this.prikazListaDijagnoza = false;
	 	this.prikazListaAdmina=!this.prikazListaAdmina;
        this.prikaz = false;
        this.prikaz1 = false;
        this.prikazZ = false;	
        this.izlistajKlinike() ;	
        	axios
		      .get('/adminKlinike/izlistaj')
		      .then(admini =>{
		        this.admini = admini.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
   },
   izlistajKlinike(){
   
    axios
      .get('/klinika/izlistaj')
      .then(klinika =>{
		        this.klinike = klinika.data;
		      })
		      .catch(error => {
		          console.log(error)
      });
   },
	 listaKlinika(){
	 	this.prikazListaLekova = false;
	 	this.prikazListaDijagnoza = false;
	 	this.prikazListaKlinika=!this.prikazListaKlinika;
        this.prikaz = false;
        this.prikaz1 = false;
        this.prikazZ = false;	
        this.prikazListaAdmina = false; 	
        	axios
		      .get('/klinika/izlistaj')
		      .then(klinika =>{
		        this.klinike = klinika.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	 },
	 listaLekova(){
	 	this.prikazListaLekova = true;
	 	this.prikazListaDijagnoza = false;
	 	this.prikazListaKlinika=false;
        this.prikaz = false;
        this.prikaz1 = false;
        this.prikazZ = false;	
        this.prikazListaAdmina = false;
             axios
		      .get('/lek/izlistaj')
		      .then(lekovi =>{
		        this.lekovi = lekovi.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	 },
	 listaDijagnoza(){
	 	this.prikazListaDijagnoza = true;
	 	this.prikazListaLekova = false;
	 	this.prikazListaKlinika=false;
        this.prikaz = false;
        this.prikaz1 = false;
        this.prikazZ = false;	
        this.prikazListaAdmina = false; 
             axios
		      .get('/dijagnoza/izlistaj')
		      .then(dijagnoze =>{
		        this.dijagnoze = dijagnoze.data;
		      })
		      .catch(error => {
		          console.log(error)
		      });
	 },
	 dodajLek(){
			 if(this.lek.sifra=="" || this.lek.naziv=="")
	         {
	          alert("Molimo vas popunite sva polja.");
	          return;
	         }
	        axios
	        .post("/lek/dodaj", this.lek)
	        .then(lek => {
	          this.lek.sifra="";
	          this.lek.naziv="";
	          alert("Dodat lek!");
       		  this.listaLekova();
	        })
	        .catch(error => {
				alert("Lek sa ovom sifrom vec postoji.");
	        });
	        
	 },
	 dodajDijagnozu(){
			 if(this.dijagnoza.sifra=="" || this.dijagnoza.naziv=="")
	         {
	          alert("Molimo vas popunite sva polja.");
	          return;
	         }
	        axios
	        .post("/dijagnoza/dodaj", this.dijagnoza)
	        .then(dijagnoza => {
	          this.dijagnoza.sifra="";
	          this.dijagnoza.naziv="";
	          alert("Dodata dijagnoza!");
       		  this.listaDijagnoza();
	        })
	        .catch(error => {
				alert("Dijagnoza sa ovom sifrom vec postoji.");
	        });
	        
	 },
	 odustani(){
	 	          this.dijagnoza.sifra="";
	          this.dijagnoza.naziv="";
	          	          this.lek.sifra="";
	          this.lek.naziv="";
	 },
	 obrisiLek(idLek){
      		axios
		      .post("/lek/obrisi/" + idLek)
		      .then(lek => {
			        this.lek = lek.data;
			      })
		      .catch(error => {
		          console.log(error)
		      });
      }
    },

 mounted() {
      axios
      .get("/adminKlinickogCentra/get/" + this.$store.state.user.id)
      .then(adminKlinike =>{
        this.korisnik = adminKlinike.data;
        this.ucitajZahteve();
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

