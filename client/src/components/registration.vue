<template>
<div class="login-page">
      <div class="form">
        <form class="register-form">
          <label for="ime">Ime</label>
          <input type="text" v-model = "korisnik.ime" placeholder="ime"/>
          <label for="prezime">Prezime</label>
          <input type="text"  v-model = "korisnik.prezime" placeholder="prezime"/>
          <label for="password">Lozinka</label>
          <input type="password"  v-model = "lozinka" placeholder="****"/>
          <label for="password">Ponovi unos lozinke</label>
          <input type="password"  v-model = "lozinka2" placeholder="****"/>
          <label for="email">Email adresa</label>
          <input type="email"  v-model = "korisnik.email" placeholder="email@email.com"/>
          <label for="adresa">Adresa</label>
          <input type="text"  v-model = "korisnik.adresa" placeholder="adresa"/>
          <label for="grad">Grad</label>
          <input type="text"  v-model = "korisnik.grad" placeholder="grad"/>
          <label for="drzava">Drzava</label>
          <input type="text"  v-model = "korisnik.drzava" placeholder="drzava"/>
          <label for="telefon">Telefon</label>
          <input type="text"  v-model = "korisnik.telefon" placeholder="telefon"/>
          <label for="jmbg">JMBG</label>
          <input type="text"  v-model = "korisnik.jmbg" placeholder="jmbg"/>         
          <button  v-on:click="reg">Registrujte se</button>
          <p class="message">Vec posedujete nalog? <router-link to="/login">Prijavite se na svoj nalog</router-link></p>
        </form>       
      </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
          korisnik: { ime : '', prezime:'', email:'', adresa:'', grad:'', drzava:'', telefon:'', jmbg: ''},     
          lozinka2: "",
          lozinka: ""
       }
  },
  methods: { 
  		reg(){
	        var temp = this;
	        if (this.korisnik.ime=="" || this.korisnik.prezime=="" || this.lozinka=="" 
	        || this.lozinka2=="" || this.korisnik.email=="" || this.korisnik.adresa=="" || this.korisnik.grad=="" || this.korisnik.drzava=="" || this.korisnik.telefon=="" || this.korisnik.jmbg==""){
	          alert('Morate uneti sva polja!');
	          return;
	        }
	        if (this.lozinka != this.lozinka2){
	          alert('Lozinke se ne poklapaju!');
	          return;
          }
          var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          if (!re.test(String(this.korisnik.email.trim()).toLowerCase())) {
           
            return;
          }

          var rex = /^\+38[0-9]\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
          if (!rex.test(String(this.korisnik.telefon.trim()))) {
            alert("Broj telefona treba da bude oblika +381/60-0771088!")
            return;
          }

          this.korisnik["lozinka"] = this.lozinka;

          axios
          .post("/auth/posalji", this.korisnik)
          .then(() => {
              alert('Zahtev za registraciju poslat!');
              this.$router.push("/login")
        })

	    .catch(function (error) {
	        alert('Neuspesna registracija!');
	    
	    });
	    }
	    },
 };
</script>



<style scoped>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 2% 0 0;
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
  display:initial;
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