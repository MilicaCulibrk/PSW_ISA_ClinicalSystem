<template>
  <div class="login-page">
        <div class="form">
          <form class="registration-form">
            <label for="ime">Ime</label>
            <input type="text" v-model=administrator.ime />
            <label for="prezime">Prezime</label>
            <input type="text" v-model=administrator.prezime  />
            <label for="email">Email</label>
            <input type="text" v-model=administrator.email />
            <label for="lozinka">Lozinka</label>
            <input type="password" v-model=administrator.lozinka  />
            <label for="adresa">Adresa</label>
            <input type="text" v-model=administrator.adresa />
            <label for="grad">Grad</label>
            <input type="text" v-model=administrator.grad />
            <label for="drzava">Drzava</label>
            <input type="text" v-model=administrator.drzava />
            <label for="telefon">Telefon</label>
            <input type="text" v-model=administrator.telefon />
            <label for="jmbg">Jmbg</label>
            <input type="text" v-model=administrator.jmbg />
            <label for="klinika">Klinika</label>
            <div class="listbox-area">
                <div class="left-area">
                  <ul id="ss_elem_list"
                      tabindex="0"
                      role="listbox"
                      aria-labelledby="ss_elem">
				<li v-for="k,i in klinike.length">
 					<button type="button" href="#" class="list-group-item list-group-item-action" v-on:click="izabranaKlinika(klinike[i])">{{klinike[i].naziv}}</button>		
				</li>  
                    
                  </ul>
                </div>
              </div>
            
            <button @click="dodajAdministratora">Dodaj administratora</button>
            <p class="message">Zelite da odustanete? <router-link to="/pocetnaAdministratorKC">Odustani</router-link></p>
          </form>


        </div>
      </div>
  </template>
  


<script >

import axios from "axios";
  export default{
    data() {
      return{
        klinike: {},
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
          alert("Dodat administrator!");
          this.$router.push("/login");
       
        })
        .catch(error => {
			alert("Administrator sa ovim email-om vec postoji.");
        });
      },
	  izabranaKlinika(klinika){
		 this.administrator.idKlinike = klinika.id;
	  }
    },
    mounted() {
      axios
      .get('/klinika/izlistaj')
      .then(klinika =>{
		        this.klinike = klinika.data;
		      })
		      .catch(error => {
		          console.log(error)
		});
  	}
  }

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