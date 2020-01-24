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
						  <table style="width: 100%;">
			                  <tr>
			                  	<th class="bg-info  text-white">Id</th>
			                    <th class="bg-info  text-white">Ime</th>
			                    <th class="bg-info  text-white">Prezime</th>
			                    <th class="bg-info  text-white">JMBG</th>
			                    <th class="bg-info  text-white">Email</th>
			                  </tr>
			                  <tr v-for="k,i in pacijenti.length">
			                    <td>{{pacijenti[i].id}}</td>
			                    <td>{{pacijenti[i].ime}}</td>
			                    <td>{{pacijenti[i].prezime}}</td>
			                    <td>{{pacijenti[i].jmbg}}</td>
			                    <td>{{pacijenti[i].email}}</td>
			                    </td>
			                  </tr>
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
export default {
	data() {
		return{
			korisnik: {},
			pacijenti: {},
			prikaz: false,
			izmeni: false,
			prikazListaPacijenata: false,
			selektovan: {},
			sortBy: {},
		}
	},
	methods: {
		otvoriFormu(){
			this.prikaz=!this.prikaz
			this.prikazKlinika=false
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
	  	azuriraj(nes){
	  		axios
		      .put("/pacijent/azuriraj", nes)
		      .then(pacijent => {
			        this.pacijenti = pacijent.data;
			      })
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


