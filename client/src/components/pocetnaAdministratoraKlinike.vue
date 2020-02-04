<template>
  <div>
    <div id="viewport">
      <div id="sidebar">
        <header>
          <a href="#">.</a>
        </header>
                      
        <ul class="nav">
          <a href="#">
              <i v-on:click="otvoriProfil" >    PROFIL          
              </i>
          </a>
          <a href="#">
              <i v-on:click="otvoriIzmenaKlinike"> IZMENA KLINIKE </i>
          </a>
         
          <a href="#">
              <i v-on:click="otvoriLekariKlinike"> LEKARI KLINIKE </i>
          </a>
        
            <a href="#">
              <i v-on:click="otvoriUpravljanjeSalama"> UPRAVLJANJE SALAMA </i>
          </a>
            <a href="#">
              <i v-on:click="otvoriUpravljanjeTipovimaPregleda"> UPRAVLJANJE TIPOVIMA PREGLEDA </i>
          </a>
          
            <a href="#">
             <i v-on:click="otvoriDefinisanjePregleda" class="zmdi zmdi-link">  DEFINISANJE PREGLEDA</i> 
          </a>
            <a href="#">
              <i v-on:click="otvoriPretragaIfiltriranjeSala"> PRETRAGA I FILTRIRANJE SALA </i>
          </a>
          <a href="#">
              <i v-on:click="otvoriZahteveZaOdmor"> ZAHTEVI ZA ODMOR </i>
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
    			
                  <form v-if="prikazProfil"   class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
 
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
                  
                  <form v-if="prikazDefinisanjePregleda" class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
                        <div >
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">
                                          <label for="Form-username" style="color: #b3b3b3;">Datum</label>
                                          <input type="text" v-model="pregled.datum" id="Form-username" class="form-control" >
                                          
                                           <label for="Form-username" style="color: #b3b3b3;">Vreme pocetka (sati)</label>
                                            <b-form-select v-model="pregled.vreme">
							                    <option
							                      v-for="v in vremena"
							                    
							                    >{{v}}</option>
							                  </b-form-select>
                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Trajanje (sati)</label>
                                           <b-form-select v-model="pregled.trajanjePregleda">
							                    <option
							                      v-for="t in trajanja"
							                      
							                    >{{t}}</option>
							                  </b-form-select>
                                          
                                        
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Cena</label>
                                          <input type="text" v-model="pregled.cena" id="Form-email4" class="form-control" >

                                        
                                          
                            
                                        </div>
                                        </div>
                                        <div class="col">
                                        <div class="md-form pb-3">
                            
                            
                            			      
							              <label for="Form-phone" style="color: #b3b3b3;">Sala</label>
                                          <b-form-select v-model="selektovanaSala">
							                    <option
							                      v-for="s in pomocna"
							                      :value="s.id"
							                      :key="s.id"
							                    >{{s.naziv}}</option>
							                  </b-form-select>
                                          
                                          <label for="Form-email4" style="color: #b3b3b3;">Tip</label>
                                             <b-form-select v-model="selektovaniTip" @change="getLekari()">
							                    <option
							                      v-for="tipp in tipovi"
							                      :value="tipp.id"
							                      :key="tipp.id"
							                    >{{tipp.naziv}}</option>
							                  </b-form-select>
                  
							               <label for="Form-email4" style="color: #b3b3b3;">Lekar</label>
							                 <b-form-select v-model="selektovaniLekar" >
							                    <option
							                      v-for="le in lekari"
							                      :value="le.id"
							                      :key="le.id"
							                    >{{le.ime}}</option>
							                  </b-form-select>
							                                            
							            
                                       			
			                                      <div class="text-center mb-4 mt-4">
			                                        <template>
			                                        <button   type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);" v-on:click="dodajSalu()">Dodaj</button>
			                                        </template>
			                                        
			                                        
			                                         <template>
			                                        <button   type="button" class="btn btn-danger btn-block z-depth-2" style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733);" v-on:click="odustaniDodajPregled()">Odustani</button>
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
                  
                  <form v-if="prikazUpravljanjeSalama" class="message-form" style="position: relative; top: 10px; left: 300px; width: 550px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
                         <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
		            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	

						  <table style="width: 500px;">
			                 <tr>
			                    <th class="bg-info  text-white">Naziv</th>
			                    <th class="bg-info  text-white">Broj</th>
			                    <th class="bg-info  text-white">Klinika</th
			                 </tr>
			                  <tr v-for="k,i in sale.length">
			                    <td>{{sale[i].naziv}}</td>
			                    <td>{{sale[i].broj}}</td>
			                    <td>{{sale[i].klinika.naziv}}</td>
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="izaberiSaluZaIzmenu(sale[i])">IZMENI</button>
			                  	<td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiSalu(sale[i])">OBRISI</button>
			                    </td>
			                  </tr>
			              </table>
			              
			              </div>
		          </div>
			              
			       <div>
			              	<form class="message-form" style="position: relative; top: -110
			              	px; left: 650px; width: 500px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">

                       <div>
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">

                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Naziv</label>
                                          <input type="text" v-model="sala.naziv" id="Form-ime" class="form-control">
                                          
										  <label for="Form-ime" style="color: #b3b3b3;">Broj</label>
                                          <input type="text" v-model="sala.broj" id="Form-ime" class="form-control">
                                          
                                           <label for="Form-username" style="color: #b3b3b3;">Klinika</label>
                                           <button  id="Form-username" class="form-control"  disabled>{{sale[0].klinika.naziv}}</button>

                                          

                                        </div>
                                        </div>
                                      
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajNovuSalu">Dodaj</button>
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustaniDodajSalu">Odustani</button>
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="izmeniSalu">Izmeni</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>
	
       </div>
		                 
                  </form>
                  
                  <form v-if="prikazUpravljanjeTipovimaPregleda" class="message-form" style="position: relative; top: 10px; left: 300px; width: 550px; height: 480px; background-color: rgba(130, 206, 209, 0.733); ">
                           <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
		            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	

						  <table style="width: 500px;">
			                 <tr>
			                    <th class="bg-info  text-white">Naziv</th>
			                    <th class="bg-info  text-white">Oznaka</th>
			                    <th class="bg-info  text-white">Cena</th
			                 </tr>
			                  <tr v-for="k,i in tipovi.length">
			                    <td>{{tipovi[i].naziv}}</td>
			                    <td>{{tipovi[i].oznaka}}</td>
			                    <td>{{tipovi[i].cena}}</td>
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="izaberiTipPregledaZaIzmenu(tipovi[i])">IZMENI</button>
			                  	<td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiTipPregleda(tipovi[i])">OBRISI</button>
			                    </td>
			                  </tr>
			              </table>
			              
			              </div>
		          </div>
			              
			     
                  </form>
                  
             
                   <form v-if="prikazUpravljanjeTipovimaPregleda" class="message-form" style="position: relative; top: -500px; left: 900px; width: 500px; height: 500px; background-color: rgba(130, 206, 209, 0.733); ">
                         <div>
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">

                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Naziv</label>
                                          <input type="text" v-model="tipPregleda.naziv" id="Form-ime" class="form-control">
                                          
										  <label for="Form-ime" style="color: #b3b3b3;">Oznaka</label>
                                          <input type="text" v-model="tipPregleda.oznaka" id="Form-ime" class="form-control">
                                          
                                            <label for="Form-ime" style="color: #b3b3b3;">Cena</label>
                                          <input type="text" v-model="tipPregleda.cena" id="Form-ime" class="form-control">
                                          
                                      
                                           <label for="Form-username" style="color: #b3b3b3;">Klinika</label>
                                           <button  id="Form-username" class="form-control"  disabled>{{tipovi[0].klinika.naziv}}</button>

                                        </div>
                                        </div>
                                      
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="dodajNoviTipPregleda">Dodaj</button>
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="odustaniDodajTipPregleda">Odustani</button>
                                        <button type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); "  v-on:click="izmeniTipPregleda">Izmeni</button>
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                 	 </form>
                 
                  
                  <form v-if="prikazIzmenaKlinike"  class="message-form" style="position: relative; top: 10px; left: 400px; width: 800px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">

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
                

                <form v-if="prikazZahtevaZaOdmor"  class="message-form"  style="position: relative; top: 10px; left: 400px; width: 800px; height: 480px; background-color: rgba(130, 206, 209, 0.733); ">
                  <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
                  
                  <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	
                    <table  id="tablePreview" class="table table-hover" style="width: 100%;">
                      <thead>
                        <tr>
                          <th class="th-lg">Lekar</th>
                          <th class="th-lg">Od</th>
                          <th class="th-lg">Do</th>
                          <th class="th-lg">Odobri</th>
                          <th class="th-lg">Odbij</th>
                        </tr>
                      </thead>
                      <tbody>
                      <tr v-for="k,i in zahteviZaOdmor.length">
                        <td>{{zahteviZaOdmor[i].lekar}}</td>
                        <td>{{zahteviZaOdmor[i].start}}</td>
                        <td>{{zahteviZaOdmor[i].end}}</td>
                        <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="odobriZahtev(zahteviZaOdmor[i])"><i class="fa fa-trash">Odobri</i></button>
                        </td>
                        <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="odbijZahtev(zahteviZaOdmor[i])"><i class="fa fa-trash">Odbij</i></button>
                        </td>
                      </tr>
                      </tbody>
                    </table>
		          </div>
		          </div>        
		       </form>


                </form>
                  
                  <form v-if="prikazPretragaIfiltriranjeSala" class="message-form" style="position: relative; top: 10px; left: 300px; width: 550px; height: 480px; background-color: rgba(130, 206, 209, 0.733); ">
                            <div  class="container d-flex justify-content-center" style="margin-top: 30px">	                        
		            <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">	

						  <table style="width: 500px;">
			                 <tr>
			                    <th class="bg-info  text-white">Naziv</th>
			                    <th class="bg-info  text-white">Broj</th>
			                  
			                 </tr>
			                  <tr v-for="k,i in sale.length">
			                    <td>{{sale[i].naziv}}</td>
			                    <td>{{sale[i].broj}}</td>
			                   
			                    </td>
			                  </tr>
			              </table>
			              
			              </div>
		          </div>
			              
                  </form>
                  
                   	<form v-if="prikazPretragaIfiltriranjeSala"  class="message-form" style="position: relative; top: -500px; left: 900px; width: 500px; height: 500px; background-color: rgba(130, 206, 209, 0.733); ">

                       <div>
                                
                            
                              <div  class="container d-flex justify-content-center" style="margin-top: 30px">
                            
                                
                                <div class="card" style="width: 99.5%; height: 99.5%; margin-top: 5px; margin-bottom: 5px">

                                  <div class="form-group">
                            
                                    <div class="card-body mx-4 mt-4">
                                      <div class="row">
                            
                                        <div class="col">
                                        <div class="md-form">

                                          
                                          <label for="Form-ime" style="color: #b3b3b3;">Naziv</label>
                                          <input type="text" v-model="pretragaSale.naziv" id="Form-ime" class="form-control">
                                          
										  <label for="Form-ime" style="color: #b3b3b3;">Broj</label>
                                          <input type="text" v-model="pretragaSale.broj" id="Form-ime" class="form-control">
                                          
                                            <label for="Form-ime" style="color: #b3b3b3;">Datum</label>
                                          <input type="text" v-model="pretragaSale.datum" id="Form-ime" class="form-control">
                                          
                                            <label for="Form-ime" style="color: #b3b3b3;">Vreme pocetka (sati)</label>
                                         <b-form-select v-model="pretragaSale.vreme">
							                    <option
							                      v-for="v in vremena"
							                    
							                    >{{v}}</option>
							                  </b-form-select>
                                          
                                          

                                          

                                        </div>
                                        </div>
                                      
                                      </div>
                                      
                            
                            
                                      <div class="text-center mb-4 mt-4">
                                        <template>
                                        <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="pretragaSala">Pretraga</button>
                                         <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="ponistiPretraguSala">Ponisti</button>
                                         
                                        </template>
                                      </div>
                            
                                    </div>
                            
                                  </div>
                            
                            
                                </div>
                                
                            
                              </div>
                              </div>
                </form>
	 		
	 		      	<form v-if="prikazPretragaIfiltriranjeSala"  class="message-form" style="position: relative; top: -500px; left: 450px; width: 600px; height: 50px;  ">
	 		
                   <div   class="text-center mb-4 mt-4">
                                       <label for="Form-phone" style=" color: #b3b3b3;">Filtritaj po</label>
                                          <b-form-select v-model="selektovaniFilter" style= "position: relative; width: 300px;" >
							                    <option
							                      v-for="f in filteri"
							                     
							                   >{{f}}</option>
							                  </b-form-select>
							            <input type="text" v-model="filterString" id="Form-ime" class="form-control" style="position: relative; width: 300px; left: 185px;" >
                    					     <button  type="button" class="btn btn-success btn-block z-depth-2"  style=" color: #37474F; position: relative; left: 185px; width: 100px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); " v-on:click="ponistiFiltriranjeSala">Ponisti</button>
                    </div>
                 </form>
                
				<form v-if="prikazLekariKlinike"  class="message-form" style="position: relative; top: 10px; left: 950px; width: 550px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">

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
                                               
                                          <label for="Form-email4" style="color: #b3b3b3;">Tip pregleda</label>
                                          <form >
											  <select v-model="lekar.idTipaPregleda"  name="cars">
											    <option v-for="tip in tipovi" v-bind:value="tip.id">{{tip.naziv}}</option>
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

                <form   v-if="prikazLekariKlinike" class="message-form" style="position: relative; top: -650px; left: 300px; width: 550px; height: 620px; background-color: rgba(130, 206, 209, 0.733); ">
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
			                    <td style="text-align: center">   <button class="btn btn-warning" type="button" v-on:click="obrisiLekara(lekari[i])"><i class="fa fa-trash">Obrisi</i></button>
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
        pregled: {
        datum: "",
        vreme: "",
        trajanjePregleda: "",
        cena: "",
        tipPregleda: {},
        lekar: {},
        sala: {}
        },
        sala: {
        	id: "",
	        naziv: "",
	        broj: "",
	        klinika: {}
        },
        tipPregleda: {
        	id: "",
	        naziv: "",
	        oznaka: "",
	        cena: "",
	        klinika: {}
        },
         pretragaSale: {
	        naziv: "",
	        broj: "",
	        datum: "",
			vreme: "",
	        
        },
      vremena: [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24],
	  trajanja: [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	  filteri: ['Naziv sale', 'Broj sale'],
	  filter: "",
	  filterString: "",
      tipovi: [],
      sale: [],
      rezultatiPretrage: [],
      pomocna: [],
      pomocnaRezultatiPretrage: [],
      lekari: [],
      selektovaniTip: "",
      selektovanaSala: "",
      selektovaniFilter: "",
      selektovaniLekar: "",
      
      ukljucenaPretraga: false,
     
      
      flag: 0,
      prikazProfil:false,
      prikazIzmenaKlinike: false,
      prikazLekariKlinike: false,
      prikazDefinisanjePregleda: false,
      prikazUpravljanjeSalama: false,
      prikazUpravljanjeTipovimaPregleda: false,
      prikazPretragaIfiltriranjeSala: false,
     
      
      izmeni:false,
      izmeniKliniku: false,
      idKlinike: {},
      lekar: {},
      id: 2,

      zahteviZaOdmor: {},
      prikazZahtevaZaOdmor: false,
      }
 },
  methods: {
        odobriZahtev(zahtev){
          event.preventDefault();
            axios
          .put("/zahtevZaOdmor/odobri", zahtev)
          .then(odgovor =>{
            alert("Odobrili ste odmor.");
            this.prikazZahtevaZaOdmor=false;
            this.otvoriZahteveZaOdmor();

          })
          .catch(error => {
              console.log(error)
              alert("Greska!");
          });
          
        },
        odbijZahtev(zahtev){
          event.preventDefault();
            axios
          .put("/zahtevZaOdmor/odbij", zahtev)
          .then(odgovor =>{
            this.otvoriZahteveZaOdmor();
          })
          .catch(error => {
              console.log(error)
              alert("Greska!");
          });
        },
        otvoriZahteveZaOdmor(){
          this.prikazZahtevaZaOdmor = !this.prikazZahtevaZaOdmor;
          axios
		      .get("/adminKlinike/izlistajZahteveZaOdmor/" + this.$store.state.user.id)
		      .then(odgovor => {
		        this.zahteviZaOdmor = odgovor.data;
		      })
		      .catch(error => {
		        console.log(error);
		      });
        },
        otvoriProfil(){
             this.prikazProfil = !this.prikazProfil,
		     this.prikazIzmenaKlinike = false,
		     this.prikazLekariKlinike = false,
		     this.prikazDefinisanjePregleda = false,
		     this.prikazUpravljanjeSalama = false,
		     this.prikazUpravljanjeTipovimaPregleda = false,
		     this.prikazPretragaIfiltriranjeSala = false, 
		     this.ponistiPretraguSala(),
		     this.ponistiFiltriranjeSala()
		     
        },
         otvoriUpravljanjeTipovimaPregleda(){
             this.prikazProfil = false,
		     this.prikazIzmenaKlinike = false,
		     this.prikazLekariKlinike = false,
		     this.prikazDefinisanjePregleda = false,
		     this.prikazUpravljanjeSalama = false,
		     this.prikazUpravljanjeTipovimaPregleda =  !this.prikazUpravljanjeTipovimaPregleda
		     this.prikazPretragaIfiltriranjeSala = false,
		     this.ponistiPretraguSala(),
		     this.ponistiFiltriranjeSala()
		     
			  axios
		      .get("/tipPregleda/TipoviKlinike/" + this.$store.state.user.id)
		      .then(tipovi => {
		        this.tipovi = tipovi.data;
		      })
		      .catch(error => {
		        console.log(error);
		      });
        },
         otvoriUpravljanjeSalama(){
             this.prikazProfil = false,
		     this.prikazIzmenaKlinike = false,
		     this.prikazLekariKlinike = false,
		     this.prikazDefinisanjePregleda = false,
		     this.prikazUpravljanjeSalama = !this.prikazUpravljanjeSalama,
		     this.prikazUpravljanjeTipovimaPregleda =  false,
 		     this.prikazPretragaIfiltriranjeSala = false,	
 		     this.ponistiPretraguSala(),	  
 		     this.ponistiFiltriranjeSala()   
		        
		        axios
		      .get("/sala/getSale/" +  this.$store.state.user.id)
		      .then(sala =>{
		        this.sale = sala.data;
		        
		      })
		      .catch(error => {
		          console.log(error)
		      });
        },
        otvoriDefinisanjePregleda(){
          
           this.prikazProfil = false,
	       this.prikazIzmenaKlinike = false,
	       this.prikazLekariKlinike = false,
	       this.prikazDefinisanjePregleda = !this.prikazDefinisanjePregleda,
	       this.prikazUpravljanjeSalama = false,
		   this.prikazUpravljanjeTipovimaPregleda =  false,
		   this.prikazPretragaIfiltriranjeSala = false,
		   this.ponistiPretraguSala(),
		   this.ponistiFiltriranjeSala()
        },
        otvoriPretragaIfiltriranjeSala(){
          
           this.prikazProfil = false,
	       this.prikazIzmenaKlinike = false,
	       this.prikazLekariKlinike = false,
	       this.prikazDefinisanjePregleda = false,
	       this.prikazUpravljanjeSalama = false,
		   this.prikazUpravljanjeTipovimaPregleda =  false,
		   this.prikazPretragaIfiltriranjeSala =  !this.prikazPretragaIfiltriranjeSala ,
		   this.ponistiPretraguSala(),
		   this.ponistiFiltriranjeSala()
        },
        vidiLokaciju(){
			this.$router.push("/vidiLokaciju");
            },
        izmena() {
        	this.izmeni = true
        },
    
        otvoriLekariKlinike(){
            
            
              this.prikazProfil = false,
		      this.prikazIzmenaKlinike = false,
		      this.prikazLekariKlinike = !this.prikazLekariKlinike,
		      this.prikazDefinisanjePregleda = false,
		      this.prikazUpravljanjeSalama = false,
		      this.prikazUpravljanjeTipovimaPregleda =  false,
		        this.prikazPretragaIfiltriranjeSala = false,
                this.ponistiPretraguSala(),
                 this.ponistiFiltriranjeSala()
            axios
		      .get("/lekar/izlistaj/" + this.idKlinike)
		      .then(lekar =>{
		        this.lekari = lekar.data;
		        
		      })
		      .catch(error => {
		          console.log(error)
		      });
        },    
        
           pretragaSala(){
           
           	  if(this.pretragaSale.datum == "" && this.pretragaSale.vreme != ""){
          
           	  	alert("Ne mozete uneti vreme bez datuma!");
           	  
           	  }else if(this.pretragaSale.datum != "" && this.pretragaSale.vreme == ""){
           	    alert("Ne mozete uneti datum bez vremena!");
           	  }else if(this.pretragaSale.datum == "" && this.pretragaSale.vreme == ""){
           	  	alert("Morate uneti datum i vreme da vidite da li je sala slobodna!")
           	  }else{
           	  
	           	  axios
			      .post("/sala/pretraga/" + this.$store.state.user.id, this.pretragaSale)
			      .then(sale =>{
			       this.sale = sale.data;
			       	 this.rezultatiPretrage = sale.data;
			   
			       	  this.ukljucenaPretraga = true;
			       
		      })
		      .catch(error => {
		          console.log(error)
		      });
           	  }
           
        },    
        
     
      
        ponistiPretraguSala(){
        
	          axios
	      .get("/sala/getSale/" + this.$store.state.user.id)
	      .then(sale => {
	        this.sale = sale.data;
	
	        this.pretragaSale.naziv = "", 
		       this.pretragaSale.broj = "", 
		       this.pretragaSale.datum = "", 
		       this.pretragaSale.vreme = "",
		        
		        this.ukljucenaPretraga = false;
	      })
	      .catch(error => {
	        console.log(error);
	      });
            
        },
        
         ponistiFiltriranjeSala(){
	           this.filterString = ""
            
        },
        otvoriDodajLekara(){	
             
              this.prikazProfil = false,
		      this.prikazIzmenaKlinike = false,
		      this.prikazLekariKlinike = !this.prikazLekariKlinike,
		      this.prikazDefinisanjePregleda = false,
		      this.prikazUpravljanjeSalama = false,
		      this.prikazUpravljanjeTipovimaPregleda =  false,
		      this.prikazPretragaIfiltriranjeSala = false
        },
        
        dodajNoviTipPregleda(){
			 if(this.tipPregleda.naziv=="" || this.tipPregleda.oznaka=="" || this.tipPregleda.cena=="")
			         {
			          alert("Molimo vas popunite sva polja.");
			          return;
			         }
	        axios
	        .post("/tipPregleda/dodaj/" + this.$store.state.user.id, this.tipPregleda)
	        .then(tipPregleda => {
	          this.tipPregleda.naziv="";
	          this.tipPregleda.oznaka="";
	          this.tipPregleda.cena="";
	          alert("Dodat tip pregleda!");
	          this.prikazUpravljanjeTipovimaPregleda = false;
       		  this.otvoriUpravljanjeTipovimaPregleda();
	        })
	        .catch(error => {
				alert("Lekar sa ovim email-om vec postoji.");
				
	        });
	        
	        
        },
        
                dodajNovuSalu(){
			 if(this.sala.naziv=="" || this.sala.broj=="")
			         {
			          alert("Molimo vas popunite sva polja.");
			          return;
			         }
	        axios
	        .post("/sala/dodaj/" + this.$store.state.user.id, this.sala)
	        .then(sala => {
	          this.sala.naziv="";
	          this.sala.broj="";
	          alert("Dodata sala!");
	          this.prikazUpravljanjeSalama = false;
       		  this.otvoriUpravljanjeSalama();
	        })
	        .catch(error => {
				alert("Lekar sa ovim email-om vec postoji.");
				
	        });
	        
	        
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
	        .post("/lekar/dodaj" , this.lekar)
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
              this.lekar.ime="";
	          this.lekar.prezime="";
	          this.lekar.email="";
	          this.lekar.lozinka="";
	          this.lekar.adresa="";
	          this.lekar.grad="";
	          this.lekar.drzava="";
	          this.lekar.telefon="";
	          this.lekar.jmbg="";
        },
         odustaniDodajSalu(){
              this.sala.naziv="";
	          this.sala.broj="";
	        
        },
        
          odustaniDodajTipPregleda(){
              this.tipPregleda.naziv="";
	          this.tipPregleda.oznaka="";
	          this.tipPregleda.cena="";
	        
        },
        
          odustaniDodajPregled(){
               this.pregled.naziv = "";
	          this.pregled.vreme = "";
	          this.pregled.cena = "";
	          this.pregled.broj = "";
	          this.pregled.datum = "";
	          this.pregled.trajanjePregleda = "";
	          this.selektovaniTip = "";
	          this.selektovanaSala = "";
	          this.selektovaniLekar = "";
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
      getLekari() {
          
      axios
        .get("/tipPregleda/TipoviLekara/" + this.selektovaniTip)
        .then(leka => {
          this.lekari = leka.data;
        })
        .catch(error => {
          console.log(error);
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
       otvoriIzmenaKlinike(){
   	   axios
      .get("/klinika/pronadjiKliniku/" + this.idKlinike)
      .then(klinika =>{
        this.klinika = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
    	 this.prikazProfil = false;
	     this.prikazIzmenaKlinike = !this.prikazIzmenaKlinike;
	     this.prikazLekariKlinike = false,
	     this.prikazDefinisanjePregleda = false,
	     this.prikazUpravljanjeSalama =  false,
	     this.prikazUpravljanjeTipovimaPregleda =  false,
	       this.prikazPretragaIfiltriranjeSala = false
    },
       izaberiSaluZaIzmenu(sala) {
       		this.sala.id = sala.id;
     		this.sala.naziv = sala.naziv;
	        this.sala.broj = sala.broj;
	        this.sala.klinika = sala.klinika;
       },
         izmeniSalu(){
        axios
        .put("/sala/izmeniSalu", this.sala)
        .then(sala =>{
          this.sala = sala.data;
          this.prikazUpravljanjeSalama = false;
       	  this.otvoriUpravljanjeSalama();
        })
        .catch(error => {
            console.log(error)
            alert("Ne mozete da izmenite salu koja je prethodno rezervisana za pregled!");
        });
      },
      
      izaberiTipPregledaZaIzmenu(tipPregleda) {
       		this.tipPregleda.id = tipPregleda.id;
     		this.tipPregleda.naziv = tipPregleda.naziv;
	        this.tipPregleda.oznaka = tipPregleda.oznaka;
	        this.tipPregleda.cena = tipPregleda.cena;
	        this.tipPregleda.klinika = tipPregleda.klinika;
       },
         izmeniTipPregleda(){
        axios
        .put("/tipPregleda/izmeniTipPregleda", this.tipPregleda)
        .then(tipPregleda =>{
          this.tipPregleda = tipPregleda.data;
          this.prikazUpravljanjeTipovimaPregleda = false;
       	  this.otvoriUpravljanjeTipovimaPregleda();
       	  alert("Pregled je izmenjen!");
        })
        .catch(error => {
            console.log(error)
             alert("Ne mozete da izmenite tip pregleda jer postoje zakazani pregledi tog tipa!");
        });
      },
      
        obrisiSalu(sala){
        
       	
        axios
        .delete("/sala/izbrisi/" + sala.id)
      .then(sale => {
        this.sale = sale.data;
       
      })
      .catch(error => {
        console.log(error);
        alert("Ne mozete obrisati salu jer je prethodno rezervisana za pregled!");
      });
      
      },
      
          obrisiLekara(lekar){
        
       	
        axios
        .delete("/lekar/izbrisi/" + lekar.id)
      .then(lekari => {
        this.lekari = lekari.data;
      })
      .catch(error => {
        console.log(error);
        alert("Ne mozete obrisati lekara jer ima zakazane preglede!");
      });
      
      },
      
        obrisiTipPregleda(tipPregleda){
        
       	
        axios
        .delete("/tipPregleda/izbrisi/" + tipPregleda.id)
      .then(tipovi => {
        this.tipovi = tipovi.data;
      })
      .catch(error => {
        console.log(error);
        alert("Ne mozete obrisati tip pregleda jer je prethodno rezervisan pregled tog tipa ili je tip dodeljen lekaru!");
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
      
     
      izmenaKlinika(){
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
	 dodajSalu() {
     
      if (this.pregled.datum === "" || this.pregled.vreme === "" || this.pregled.trajanjePregleda === "" || this.pregled.selektovanaSala === "" || this.pregled.selektovaniLekar === "" || this.pregled.cena === ""){
         alert("Morate uneti sva polja!");
         return;
       }
    
      
      
     this.tipovi.forEach(tipPregleda => {
        if (tipPregleda.id === this.selektovaniTip) {
          this.pregled.tipPregleda = tipPregleda;
        }
      });
      this.lekari.forEach(lekar => {
        if (lekar.id === this.selektovaniLekar) {
          this.pregled.lekar = lekar;
        }
      });
      this.sale.forEach(sala => {
        if (sala.id === this.selektovanaSala) {
          this.pregled.sala = sala;
        }
      });
      axios
        .post(
          "/pregled/dodajPregled",
          this.pregled
        )
        .then(pregled => {
          this.pregled.naziv = "";
          this.pregled.vreme = "";
          this.pregled.cena = "";
          this.pregled.broj = "";
          this.pregled.datum = "";
          this.pregled.trajanjePregleda = "";
          this.selektovaniTip = "";
          this.selektovanaSala = "";
          this.selektovaniLekar = "";
        
        })
        .catch(error => {
          console.log(error);
      	  alert("Vec postoji termin u tom periodu i za tu salu i lekara");
          
        });
    },
  },
  beforeUpdate(){
  
    if(this.prikazPretragaIfiltriranjeSala){
    console.log('USAO');
    if(this.ukljucenaPretraga === false){
  		if(this.selektovaniFilter === 'Naziv sale'){
  			  for( var i = 0; i < this.sale.length; i++){ 
  			     if ( !this.sale[i].naziv.includes(this.filterString)) {
			   	 	this.sale.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
      
  
	      axios
	      .get("/sala/getSale/" + this.$store.state.user.id)
	      .then(sale => {
	        this.pomocna = sale.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
	     
        
	        if(this.selektovaniFilter === 'Naziv sale'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].naziv.includes(this.filterString)) {
			  
			   var flag = 0;
				   	for(var j = 0; j < this.sale.length; j++){
				   		if(this.sale[j].naziv === this.pomocna[i].naziv){
				   		
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag == 0){
						 this.sale.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}
  		
  			if(this.selektovaniFilter === 'Broj sale'){
  			  for( var i = 0; i < this.sale.length; i++){ 
  			     if ( !this.sale[i].broj.toString().includes(this.filterString)) {
			   	 	this.sale.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
     
	      	  axios
	      .get("/sala/getSale/" + this.$store.state.user.id)
	      .then(sale => {
	        this.pomocna = sale.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
  
	  
	      
	      if(this.selektovaniFilter === 'Broj sale'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].broj.toString().includes(this.filterString)) {
			    
			   var flag = 0;
				   	for(var j = 0; j < this.sale.length; j++){
				   		if(this.sale[j].broj === this.pomocna[i].broj){
				   		
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag == 0){
						 this.sale.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}	
      	
	      
  	}else{
 
  			if(this.selektovaniFilter === 'Naziv sale'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].naziv.includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Naziv sale'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].naziv.includes(this.filterString)) {
			   console.log('USAO');
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].naziv === this.pomocnaRezultatiPretrage[i].naziv){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.sale.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  	
  		if(this.selektovaniFilter === 'Broj sale'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].broj.toString().includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Broj sale'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].broj.toString().includes(this.filterString)) {
		
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].broj === this.pomocnaRezultatiPretrage[i].broj){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.sale.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  	
  	
    }  
    }
  	
  },
 mounted() {
            
 	  axios
      .get("/tipPregleda/TipoviKlinike/" + this.$store.state.user.id)
      .then(tipovi => {
        this.tipovi = tipovi.data;
      })
      .catch(error => {
        console.log(error);
      });
    
      axios
      .get("/adminKlinike/get/"  + this.$store.state.user.id)
      .then(adminKlinike =>{
        this.korisnik = adminKlinike.data;
        this.idKlinike = this.korisnik.idKlinike;
      })
      .catch(error => {
          console.log(error)
      });
      
       axios
      .get("/sala/getSale/" + this.$store.state.user.id)
      .then(sale => {
        this.sale = sale.data;
      
    	
      })
      .catch(error => {
        console.log(error);
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