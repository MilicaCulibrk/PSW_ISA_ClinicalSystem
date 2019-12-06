<template>
<div class="login-page">
      <div class="form">
        <form class="login-form">
           <label for="email">Email</label>
           <input type="text" v-model="korisnik.email"  placeholder="Email" required id="email">
          <label for="password">Lozinka</label>
           <input type="password" v-model="korisnik.lozinka"  placeholder="********" required id="lozinka">
          <button v-on:click="login">Prijavite se</button>
          <p class="message">Niste registrovani? <router-link to="/registration">Napravite nalog</router-link></p>
        </form>
      </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
          korisnik: {korisnickoIme:"", lozinka:""},     
       };
  },
  methods: {
	   login(){
	    	var temp = this;
	        if (this.korisnik.email=="" || this.korisnik.lozinka==""){
	        	alert('Morate uneti sva polja!');
          		return;
	          }
	          
	  var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (!re.test(String(this.korisnik.email.trim()).toLowerCase())) {
        alert('Mail adresa nije u odgovarajucem formatu!');
        return;
     
      }axios
        .post("http://localhost:8081/prijava/login", this.korisnik)
        .then(korisnik => {
        
        	if(korisnik.data.uloga == "ADMIN_KLINIKE"){
        		this.$router.push("/pocetnaAdministratoraKlinike");
        	}else if(korisnik.data.uloga == "ADMIN_CENTRA"){
        		this.$router.push("/pocetnaAdministratorKC");
        	}else if(korisnik.data.uloga == "MEDICINSKA_SESTRA"){
        		this.$router.push("/pocetnaMedicinskeSestre");
        	}else if(korisnik.data.uloga == "LEKAR"){
        		this.$router.push("/pocetnaLekara");
        	}else if(korisnik.data.uloga == "PACIJENT"){
        		this.$router.push("/pocetnaPacijenta");
        	}else{
        		alert('Ne postoji takav korisnik!');
        	}
      
          
          
        })
        .catch(error => {
          alert('Ne postoji takav korisnik!');
        });
    }
  }
};
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