<template>
    <div class="login-page">
          <div class="form">
            <form class="login-form">
               <label for="password"> Nova lozinka</label>
               <input type="password" v-model="lozinka"  placeholder="******" required id="lozinka">
              <label for="password">Ponovi unos nove lozinke</label>
               <input type="password" v-model="lozinka2"  placeholder="******" required id="lozinka">
              <button v-on:click="login">Potvrdi</button>
            </form>
          </div>
        </div>
     </template>
    
    <script>
    import axios from "axios";
    import VueJwtDecode from "vue-jwt-decode";
    
    export default {
      data() {
        return {
         
            lozinka2: "",
            lozinka: "",
          	korisnik: {},
              
           }
      },
      methods: {
           login(){
            event.preventDefault();
                var temp = this;
                if (this.lozinka2=="" || this.lozinka==""){
                    alert('Morate uneti sva polja!');
                      return;
                  }
                if (this.lozinka != this.lozinka2){
	                alert('Lozinke se ne poklapaju!');
	                  return;
                  }
                  this.korisnik.lozinka=this.lozinka;
                  if(this.$store.state.user.role.authority == "LEKAR"){
			      	axios
				      .put("/lekar/izmeniLozinku", this.korisnik)
				      .then(lekar =>{
				        this.korisnik = lekar.data;
						this.$router.push('/pocetnaLekara')
				        
				      })
				      .catch(error => {
				          console.log(error)
				      });
				  } else if (this.$store.state.user.role.authority == "ADMIN_KLINIKE"){
			      	axios
				      .put("/adminKlinike/izmeniLozinku", this.korisnik)
				      .then(admin =>{
				        this.korisnik = admin.data;
						this.$router.push('/pocetnaAdministratoraKlinike')
				        
				      })
				      .catch(error => {
				          console.log(error)
				      });
				  } else if (this.$store.state.user.role.authority == "ADMIN_CENTRA"){
			      	axios
				      .put("/adminKlinickogCentra/izmeniLozinku", this.korisnik)
				      .then(admin =>{
				        this.korisnik = admin.data;
						this.$router.push('/pocetnaAdministratorKC')
				        
				      })
				      .catch(error => {
				          console.log(error)
				      });
				  } else if (this.$store.state.user.role.authority == "MEDICINSKA_SESTRA"){
			      	axios
				      .put("/medicinska_sestra/izmeniLozinku", this.korisnik)
				      .then(ms =>{
				        this.korisnik = ms.data;
						this.$router.push('/pocetnaMedicinskeSestre')
				        
				      })
				      .catch(error => {
				          console.log(error)
				      });
				  }
          
          
                }
            },
           mounted() {
           		if (this.$store.state.user.role.authority == "LEKAR"){
			         axios
			      .get("/lekar/get/" + this.$store.state.user.id)
			      .then(lekar =>{
			        this.korisnik = lekar.data;
			      })
			      .catch(error => {
			          console.log(error)
			      });
		      	} else if (this.$store.state.user.role.authority == "ADMIN_KLINIKE"){
			         axios
			      .get("/adminKlinike/get/" + this.$store.state.user.id)
			      .then(admin =>{
			        this.korisnik = admin.data;
			      })
			      .catch(error => {
			          console.log(error)
			      });
		      	} else if (this.$store.state.user.role.authority == "ADMIN_CENTRA"){
			         axios
			      .get("/adminKlinickogCentra/get/" + this.$store.state.user.id)
			      .then(admin =>{
			        this.korisnik = admin.data;
			      })
			      .catch(error => {
			          console.log(error)
			      });
		      	} else if (this.$store.state.user.role.authority == "MEDICINSKA_SESTRA"){
			         axios
			      .get("/medicinska_sestra/get/" + this.$store.state.user.id)
			      .then(ms =>{
			        this.korisnik = ms.data;
			      })
			      .catch(error => {
			          console.log(error)
			      });
		      	}
		      	
		      	
		      	
		  }    
}     
    </script>
    
    
    
    
    
    
    <style scoped>
    @import url(https://fonts.googleapis.com/css?family=Roboto:300);
    
    .login-page {
      width: 360px;
      padding: 8% 0 0;
      margin: auto;
      background: rgb(253, 253, 253);
    }
    .form {
      position: relative;
      z-index: 1;
      color: #b3b3b3;
      background: rgb(253, 253, 253);
      max-width: 360px;
      margin: 0 auto 100px;
      padding: 45px;
      text-align: left;
      box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    .form input {
      font-family: "Roboto", sans-serif;
      outline: 0;
      background: #f2f2f2;
      width: 100%;
      border: 0;
      margin: 0 0 15px;
      padding: 15px;
      box-sizing: border-box;
      font-size: 14px;
    }
    .form button {
      font-family: "Roboto", sans-serif;
      text-transform: uppercase;
      outline: 0;
      background: rgba(130, 206, 209, 0.733); 
      width: 100%;
      border: 0;
      padding: 15px;
      color: rgb(255, 255, 255);
      font-size: 14px;
      -webkit-transition: all 0.3 ease;
      transition: all 0.3 ease;
      cursor: pointer;
    }
    .form button:hover,.form button:active,.form button:focus {
      background: rgba(130, 206, 209, 0.842);
    }
    .form .message {
      margin: 15px 0 0;
      color: #b3b3b3;
      font-size: 12px;
    }
    .form .message a {
      color:  rgba(130, 206, 209, 0.842); 
      text-decoration: none;
    }
    .form .register-form {
      display: none;
    }
    .container {
      position: relative;
      z-index: 1;
      max-width: 300px;
      margin: 0 auto;
      
      
    }
    .container:before, .container:after {
      content: "";
      display: block;
      clear: both;
      
    }
    .container .info {
      margin: 50px auto;
      text-align: center;
      
    }
    .container .info h1 {
      margin: 0 0 15px;
      padding: 0;
      font-size: 36px;
      font-weight: 300;
      color: #1a1a1a;
    }
    .container .info span {
      color: #4d4d4d;
      font-size: 12px;
    }
    .container .info span a {
      color: #000000;
      text-decoration: none;
    }
    .container .info span .fa {
      color: #EF3B3A;
    
    }
    body {
       background: rgba(130, 206, 209, 0.842);
      
          
    }
    
    </style>