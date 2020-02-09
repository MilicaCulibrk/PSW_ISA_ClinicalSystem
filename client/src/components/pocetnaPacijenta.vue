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
                <i class="zmdi zmdi-view-dashboard " v-on:click="otvoriFormuZK"> ZDRAVSTVENI KARTON
                </i>                   
              </a>
              <a href="#">
                <i v-on:click="listaKlinika();izlistajTipove()" class="zmdi zmdi-view-dashboard "> LISTA KLINIKA / ZAKAZIVANJE PREGLEDA
                </i>                   
                </a>
                <a href="#">
                <i v-on:click="otvoriIstoriju()" class="zmdi zmdi-view-dashboard"> ISTORIJA PREGLEDA I OPERACIJA
                </i>     
                              
              </a>
              <a href="#">
                <i v-on:click="otvoriZahteve()" class="zmdi zmdi-view-dashboard"> ODOBRAVANJE ZAHTEVA ZA PREGLED
                </i>     
                              
              </a>
              <a href="#">
                <i class="zmdi zmdi-view-dashboard" style="color: red" v-on:click="odjava"> ODJAVA
                </i>     
                              
              </a>	    	  	    	               
           </ul>
           <div class="clear"></div>
        </div>
          <!-- Content -->
          <div id="content">                    
            <div class="container-fluid">



              <h1 style="color: #b3b3b3;"> Pacijent - {{ user.ime }} {{ user.prezime }} </h1>         
            </div>
          </div>

            </div>
         
     
                             

            

  
       <form v-if="prikaz" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 5px; left: 400px; width: 40%; background-color: rgba(130, 206, 209, 0.733); ">
          <div>
                  
              
                <div  class="container d-flex justify-content-center" style="margin-top: 30px">
              
                  
                  <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">

                    <div class="form-group">
              
                      <div class="card-body mx-4 mt-4">
                        <div class="row">
              
                          <div class="col">
                          <div class="md-form">
                            <label for="Form-username" style="color: #b3b3b3;">E-mail</label>
                            <input type="text" v-model="user.email" id="Form-username" class="form-control" disabled>
                            
                            <label for="Form-ime" style="color: #b3b3b3;">Ime</label>
                            <input type="text" v-model="user.ime" id="Form-ime" class="form-control" :disabled="!izmeni">
                            
                            <label for="Form-phone" style="color: #b3b3b3;">Telefon</label>
                            <input type="text" v-model="user.telefon" id="Form-phone" class="form-control" :disabled="!izmeni">
                            

                            <label for="Form-email4" style="color: #b3b3b3;">JMBG</label>
                            <input type="text" v-model="user.jmbg" id="Form-email4" class="form-control" :disabled="!izmeni">
                          
                            
              
                          </div>
                          </div>
                          <div class="col">
                          <div class="md-form pb-3">
              
                         
                            
                            <label for="Form-prezime" style="color: #b3b3b3;">Prezime</label>
                            <input type="text" v-model="user.prezime" id="Form-prezime" class="form-control" :disabled="!izmeni">
              
                            
                            <label for="Form-email4" style="color: #b3b3b3;">Adresa</label>
                            <input type="text" v-model="user.adresa" id="Form-email4" class="form-control" :disabled="!izmeni">
                            
                            <label for="Form-city" style="color: #b3b3b3;">Grad</label>
                            <input type="text" v-model="user.grad" id="Form-city" class="form-control" :disabled="!izmeni">
              
                        
                            <label for="Form-city" style="color: #b3b3b3;">Drzava</label>
                            <input type="text" v-model="user.drzava" id="Form-city" class="form-control" :disabled="!izmeni">
                           
                         

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
                          <button v-if="izmeni" v-b-modal.promenaLozinke type="button" class="btn btn-danger btn-block z-depth-2"  style=" color: #37474F; width: 200px; height: 35px;border-color: rgba(130, 206, 209, 0.733); ; background-color: rgba(130, 206, 209, 0.733); ">Promeni lozinku</button>
                        </template>
                        </div>
              
                      </div>
              
                    </div>
              
              
                  </div>
                  
              
                </div>
                </div>
  </form>
  <form   v-if="prikazZK" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 420px; width: 25%; background-color: rgba(130, 206, 209, 0.733); ">
    <div>
            
        
          <div  class="container d-flex justify-content-center" style="margin-top: 30px">
        
            
            <div class="card" style="width: 95%; height: 95%; margin-top: 30px; margin-bottom: 30px">

              <div class="form-group">
        
        
                    <div class="col">
                    <div class="md-form">
                      <h3 style=" text-align: center; color: dimgray;">ZDRAVSTVENI KARTON</h3>

                      <label for="Form-dioptrija" style="color: #b3b3b3;">Dioptrija</label>
                      <input type="text" v-model="zdravstveniK.dioptrija" id="Form-username" class="form-control" disabled>
                      
                      <label for="Form-alergija" style="color: #b3b3b3;">Alergija</label>
                      <input type="text" v-model="zdravstveniK.alergije" id="Form-ime" class="form-control" :disabled="!izmeni">
                      
                      <label for="Form-visina" style="color: #b3b3b3;">Visina</label>
                      <input type="text" v-model="zdravstveniK.visina" id="Form-phone" class="form-control" :disabled="!izmeni">
                      
                      <label for="Form-tezina" style="color: #b3b3b3;">Tezina</label>
                      <input type="text"  v-model="zdravstveniK.tezina" id="Form-email4" class="form-control" :disabled="!izmeni">

                     
                 
                   
                  </div>   
                </div>
        
              </div>
        
        
            </div>
            
        
          </div>
          </div>
</form>

<form v-if="prikazUDPREGLEDI" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 10px; left: 400px; width: 60%; background-color: rgba(130, 206, 209, 0.733); ">
  <button v-on:click="otvoriKliniku(klinika)" class="btn btn-warning" style=" margin-left: 25px; margin-top: 20px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na profil klinike</i></button>
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px; overflow-x:auto" >	
      <table style="width: 100%;" class="table table-hover table-fixed">
       
                <tr>
                  <th class="bg-info  text-white">Datum</th>
                  <th class="bg-info  text-white">Satnica</th>
                  <th class="bg-info  text-white">Sala</th>
                  <th class="bg-info  text-white">Lekar</th>
                  <th class="bg-info  text-white">Tip pregleda</th>
                  <th class="bg-info  text-white">Cena</th>
                  <th class="bg-info  text-white">Popust</th>
                  <th class="bg-info  text-white"></th>
                </tr>
                <tr v-for="k,i in udpregledi.length" >
                  <td align="center"><date-picker style="width: 120px" :placeholder="udpregledi[i].datum" disabled></date-picker> </td>
                  <td align="center" >{{udpregledi[i].vreme}}</td>
                  <td align="center" >{{udpregledi[i].sala.naziv}}</td>
                  <td align="center" >{{udpregledi[i].lekar.ime}}</td>
                  <td align="center" >{{udpregledi[i].tipPregleda.naziv}}</td>
                  <td align="center" >{{udpregledi[i].cena}}</td>
                  <td></td>
                  <td style="text-align: center">   <button v-on:click="zakaziUDPregled(udpregledi[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Zakazi pregled</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
</form>

<form   v-if="prikazListaKlinika" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 320px; width: 45%; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
      <table style="width: 100%;" class="table table-hover table-fixed">
     
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
                  <th class="bg-info  text-white" >Naziv Klinike</th>
                  <th class="bg-info  text-white">Adresa Klinike</th>
                  <th class="bg-info  text-white">Ocena Klinike</th>
                  <th class="bg-info  text-white">Cena pregleda</th>
                  <th class="bg-info  text-white"></th>
                </tr>
                <tr v-for="k,i in klinike.length">
                  <td align="center" >{{klinike[i].naziv}}</td>
                  <td align="center" >{{klinike[i].adresa}}</td>
                  <td align="center" >{{klinike[i].ocena}}</td>
                  <td align="center">{{cenaPregleda}}</td>
                  <td style="text-align: center">   <button v-on:click="prikazLekara(klinike[i]); otvoriKliniku(klinike[i])" class="btn btn-warning" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Prikazi profil klinike</i></button>
                  </td>
                </tr>
            </table>     
    </div>
  </div>   
  </form>

  <form v-if="prikazListaKlinika" class="message-form" style="position: fixed;  border-radius: 25px; box-shadow: 20px 20px 20px 0 white inset, -20px -20px 20px 0 white inset; top: 70px; left: 1050px; width: 450px; height: 300px; border-color:rgba(130, 206, 209, 0.733); background-color:white ">
    <div  class="container d-flex justify-content-center" style="margin-top: 30px; ">	                        
<div class="card" style="border-color: rgba(130, 206, 209, 0.733); width: 93%; height: 93%; margin-top: 30px; margin-bottom: 30px">	

<table style="width: 100%; " class="table table-hover table-fixed">

  <tr>
    <th  >Izaberi tip pregleda</th>
    

  <td>
    <b-form-select  v-model="pretragaKlinika.tipPregleda">
      <option
        v-for="tipp in tipovi"
        :value="tipp.naziv"
        :key="tipp.id"
      >{{tipp.naziv}}</option>
    </b-form-select>
  
  </td>
  </tr>
  <tr>
    <th  > Izaberi datum pregleda</th>
<td >
  <section>
    <date-picker
    v-model="pretragaKlinika.datum"
    format="YYYY-MM-DD"
    type="date"
    placeholder="Select date"
  ></date-picker>  </section>

</td>
  </tr>
  <tr>
    <td align="right" > 
      <button  type="button"  class="btn btn-warning"  style=" width: 120px; height: 40px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;"  v-on:click="pretragaKlinike">Pretraga</button>
  
    </td>
    <td align="center" >  
      <button  type="button"  class="btn btn-warning"  style=" width: 120px; height: 40px; border-color: rgb(233, 233, 233);  background-color: rgb(233, 233, 233); color: #37474F;" v-on:click="ponistiPretraguKlinika">Ponisti</button>
  
    </td>
  </tr>
</table>

</div>

</div>

</form>
<form v-if="prikazListaKlinika" class="message-form" style="position: fixed;  top: 370px; left: 1050px; width: 450px; height: 300px; background-color:white ">
     
  
  <div  class="container d-flex justify-content-center" style="margin-top: 30px; ">	                        
    <div class="card" style="border-color: rgba(130, 206, 209, 0.733); width: 93%; height: 93%; margin-top: 30px; margin-bottom: 30px">	
    
    <table style="width: 100%; " class="table table-hover table-fixed">
    
      <tr>
        <th  >Filtriraj po: </th>
        
    
      <td>
        <b-form-select v-model="selektovaniFilter"  >
          <option
            v-for="f in filteri"
           
         >{{f}}</option>
        </b-form-select>
      
      </td>
      </tr>
      <tr>
        <th  > </th>
    <td >
      <input type="text" v-model="filterString" id="Form-ime" class="form-control"  >
    
    </td>
      </tr>
      <tr>
        <th > 
      
        </th>
        <td align="center" >  
          <button  type="button"  class="btn btn-warning"  style=" width: 120px; height: 40px; border-color: rgb(233, 233, 233);  background-color: rgb(233, 233, 233); color: #37474F;" v-on:click="ponistiFiltriranjeKlinika">Ponisti</button>
      
        </td>
      </tr>
    </table>
    
    </div>
    
    </div>
    
</form>

  <form   v-if="prikazKlinike" class="message-form" style=" border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset;  position: relative; top: 10px; left: 260px; width: 82%; height: 650px; background-color: rgba(130, 206, 209, 0.733); ">
    
    <button v-on:click="listaKlinika" class="btn btn-warning" style=" margin-left: 30px; margin-top: 20px; height: 40px; width: 250px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> 	&#8592; Vrati se na listu klinika</i></button>

    
      <div class="card" style="width: 32%; height: 450px; margin-top: 20px; margin-left: 30px;   ">	

        <table style="width: 100%; " class="table table-striped" >
          <tbody>
                  <tr >
                    <th  >Naziv: </th>
                    <td align="center" >{{klinika.naziv}}</td>
                  </tr>
                  <tr>
                    <th >Adresa: </th>
                    <td align="center" >{{klinika.adresa}}</td>
                  </tr>
                  <tr>
                    <th>Email: </th>
                    <td align="center" >{{klinika.email}}</td>
                  </tr>
                  <tr>
                    <th >Grad: </th>
                    <td align="center"  >{{klinika.grad}}</td>

                  </tr>
                  <tr>
                    <th >Drzava: </th>
                    <td align="center"  >{{klinika.drzava}}</td>
                  </tr>
                  <tr>
                    <th >Telefon: </th>
                    <td align="center" >{{klinika.telefon}}</td>
                  </tr>
                  <tr>
                    <th>Opis: </th>
                    <td align="center" >{{klinika.opis}}</td>
                  </tr>
                  <tr>
                    <th>Ocena: </th>
                    <td align="center" >{{klinika.ocena}}</td>
                  </tr>
                  <tr>
                    <th>Broj recenzija: </th>
                    <td align="center" >{{klinika.brojRecenzija}}</td>
                  </tr>
                </tbody>
              </table>     
            
              <button v-on:click="prikazudpregledi(klinika)" class="btn btn-warning" style=" margin-left: 30px; margin-top: 30px; height: 50px; width: 330px; border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> Prikazi unapred definisane preglede &#8594;</i></button>
            </div>

            <div class="card" style="position:fixed; width: 30%;  margin-top: -450px; margin-left: 450px; ">	
              <h3 style=" text-align: center; color: dimgray;">LISTA LEKARA</h3>


        <table style="width: 100%; " class="table table-striped" >
          <tbody>
            <tr>
              <th ></th>
              <th>Ime</th>
              <th >Prezime</th>
              <th >Ocena</th>
              <th >Lista vremena</th>
              <th ></th>
            </tr>
            
            <tr v-for="k,l in lekari.length">
              <td></td>
              <td align="center">{{lekari[l].ime}}</td>
              <td align="center">{{lekari[l].prezime}}</td>
              <td align="center">{{lekari[l].ocena}}</td>
              <td align="center"  v-on:click="nadjiBlokiraneSate(lekari[l].pocetak, lekari[l].kraj, lekari[l].id)" > <date-picker  style="width: fit-content;"
                v-model="value[l]"           
                value-type="format"
                type="time"
                format="HH"
                placeholder="HH"
                :default-value="new Date().setHours(9)"
                :disabled-time="blokirajVreme"
              ></date-picker></td>
              <td style="text-align: center">   <button v-on:click="prikazPregleda(lekari[l],value[l]); nadjiTip(lekari[l])" type="button" class="btn btn-block z-depth-2" style=" border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;"  v-b-modal.zakazi ><i class="fa fa-trash">Dalje</i></button>
              </td>
            </tr>
            
                </tbody>
              </table>     
      
    </div>  
    
    <div  class="container d-flex justify-content-center" style=" position: fixed; top: 110px; left: 770px; ">	                        
      <div class="card" style=" position: fixed; border-color: #b3b3b3; width: 20%; height: 40%; margin-top: 30px; margin-bottom: 30px">	
      
      <table style="width: 100%; " class="table table-hover table-fixed">
      
        <tr>
          <th  >Ime lekara</th>
      <td >
        <input type="text"  class="form-control"  v-model="pretragaLekara.ime" >
      
      </td>
        </tr>
        <tr>
          <th >Prezime lekara</th>
      <td >
        <input type="text"  class="form-control"  v-model="pretragaLekara.prezime" >
      
      </td>
        </tr>
        <tr>
          <tr>
            <th >Prosecna ocena lekara </th>
        <td >
          <input type="text"  class="form-control"  v-model="pretragaLekara.ocena" >
        
        </td>
          </tr>
          
          <tr>
          <td align="right" > 
            <button  type="button"  class="btn btn-warning"  style=" width: 120px; height: 40px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;"  v-on:click="pretraziLekara">Pretraga</button>
        
          </td>
          <td align="right" >  
            <button  type="button"  class="btn btn-warning"  style=" width: 120px; height: 40px; border-color: rgb(233, 233, 233);  background-color: rgb(233, 233, 233); color: #37474F;" v-on:click="ponistiPretraguLekara">Ponisti</button>
        
          </td>
        </tr>
      </table>
      
      </div>
      
      </div>

      
        
  
    </form>

    <b-modal v-if="this.ukljucenaPretraga && this.v!=null" ref="my-modal" id="zakazi" hide-footer title="Zakazite pregled">
      
      
        <div class="card" style="width: 95%; height: 350px; margin-top: 5px; margin-left: 3%;   ">	
          <h3 style=" text-align: center; color: dimgray;">DETALJI O PREGLEDU</h3>
          <table style="width: 100%; " class="table table-striped" >
            <tbody>
                    <tr >
                      <th>Tip pregleda: </th>
                      <td align="center" >{{tip.naziv}}</td>
                    </tr>
                    <tr>
                      <th >Lekar: </th>
                      <td align="center" >{{lekar.ime}} {{lekar.prezime}}</td>
                    </tr>
                    <tr>
                      <th>Datum: </th>
                      <td align="center" ><date-picker style="width: 150px" :placeholder="this.prikaziDatum" disabled></date-picker> </td> 
                    <tr>
                      <th>Vreme: </th>
                      <td align="center"  >{{v}}</td>
  
                    </tr>
                    <tr>
                      <th >Klinika: </th>
                      <td align="center"  >{{klinika.naziv}}</td>
                    </tr>
                    <tr >
                      <th>Cena pregleda: </th>
                      <td align="center" >{{tip.cena}}</td>
                    </tr>
                  </tbody>
                </table>     
              
              </div>
              <button v-on:click="zakaziObicanPregled" class="btn btn-warning" style=" margin-left: 20px; margin-bottom: 20px; margin-top: 30px; height: 60px; width: 200px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> ZAKAZI PREGLED</i></button>
              <button v-on:click="odustaniOdPregleda" class="btn btn-warning" style=" margin-left: 20px;  margin-bottom: 20px; margin-top: 30px; height: 60px; width: 200px; border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash"> ODUSTANI</i></button>

    </b-modal>

   
      <form v-if="prikazIstorije" class="message-form" style="position: relative;  top: 70px; left: 240px; width: 1200px;  background-color:white ">
     
  
        <div  class="container d-flex justify-content-center" style="margin-top: 30px; ">	                        
          <div class="card" style="border-color: rgba(130, 206, 209, 0.733); width: 93%; height: 93%; margin-top: -50px; margin-bottom: 30px">	
          
            <h3 style=" text-align: center; color: dimgray;">LISTA PREGLEDA</h3>


            <table style="width: 100%; " class="table table-striped" >
              <tbody>
                <tr>
                  <td align="right">
                    Sortiraj po:
                  </td>
                  <td colspan="6">
                 <b-form-select v-model="odabirSortiranja1" @change="azuriraj1()" >
                   <option 
                     v-for="i in sortiranje1"
                   >{{i}}</option>
         
                 </b-form-select>
                 
                   </td>
               </tr>
                <tr>
                  <th ></th>
                  <th>Tip pregleda</th>
                  <th>Datum</th>
                  <th>Lekar</th>
                  <th>Cena</th>
                  <th></th>
                  <th></th>
                </tr>
                
                <tr v-for="k,i in basPregledi.length" >
                  <td></td>
                  <td align="center">{{basPregledi[i].tipPregleda.naziv}}</td>
                  <td align="center"><date-picker style="width: 120px" :placeholder="basPregledi[i].datum" disabled></date-picker> </td>
                  <td align="center">{{basPregledi[i].lekar.ime}}</td>
                  <td align="center">{{basPregledi[i].cena}}</td>
                  <td style="text-align: center"> <star-rating v-model="ocenaPK.ocena"></star-rating>  <button v-on:click="oceniKlinikuP(basPregledi[i].lekar.idKlinike)" type="button" class="btn btn-block z-depth-2" style=" border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;"  v-b-modal.oceni ><i class="fa fa-trash">Oceni Kliniku</i></button>
                  </td>
                  <td style="text-align: center"> <star-rating v-model="ocenaPL.ocena"></star-rating>  <button v-on:click="oceniLekaraP(basPregledi[i].lekar.id)" type="button" class="btn btn-block z-depth-2" style=" border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;"  v-b-modal.oceni ><i class="fa fa-trash">Oceni Lekara</i></button>
                  </td>


                
                </tr>
                
                    </tbody>
  
  
          </table>
          </div>
        </div>


    </form>

    <form v-if="prikazIstorije" class="message-form ; relative;" style="position: relative;  top:50px; left: 240px; width: 1200px;  background-color:white ">
     
  
      <div  class="container d-flex justify-content-center" style="margin-top: 30px; ">	                        
        <div class="card" style="border-color: rgba(130, 206, 209, 0.733); width: 93%; height: 93%; margin-top: 30px; margin-bottom: 30px">	

          <h3 style=" text-align: center; color: dimgray;">LISTA OPERACIJA</h3>


          <table style="width: 100%; " class="table table-striped" >
            <tbody>
              <tr>
                <td align="right">
                  Sortiraj po:
                </td>
                <td colspan="6">
               <b-form-select v-model="odabirSortiranja2" @change="azuriraj2()" >
                 <option 
                   v-for="i in sortiranje2"
                 >{{i}}</option>
       
               </b-form-select>
               
                 </td>
             </tr>
              <tr>
                <th ></th>
                <th>Tip operacije</th>
                <th>Datum</th>
                <th>Lekar</th>
                <th>Cena</th>
                <th></th>
                <th></th>
              </tr>
              
              <tr v-for="k,i in basOperacije.length" >
                <td></td>
                <td align="center">{{basOperacije[i].tipPregleda.naziv}}</td>
                <td align="center"><date-picker style="width: 120px" :placeholder="basOperacije[i].datum" disabled></date-picker> </td>
                <td align="center">{{basOperacije[i].lekar.ime}}</td>
                <td align="center">{{basOperacije[i].cena}}</td>
                <td style="text-align: center"> <star-rating v-model="ocenaOK.ocena"></star-rating><button v-on:click="oceniKlinikuO(basOperacije[i].lekar.idKlinike)" type="button" class="btn btn-block z-depth-2" style=" border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;"   ><i class="fa fa-trash">Oceni Kliniku</i></button>
                </td>
                <td style="text-align: center"> <star-rating v-model="ocenaOL.ocena"></star-rating>  <button v-on:click="oceniLekaraO(basOperacije[i].lekar.id)" type="button" class="btn btn-block z-depth-2" style=" border-color: dimgray; background-color: rgb(233, 233, 233); color: #37474F;"  ><i class="fa fa-trash">Oceni Lekara</i></button>
                </td>
              
              </tr>
                  </tbody>
            

        </table>
        </div>
      </div>


  </form>
  <form   v-if="prikazZahteva" class="message-form position: relative; " style="  border-radius: 25px; box-shadow: 10px 10px 10px 0 white inset, -10px -10px 10px 0 white inset; position: relative; top: 50px; left: 350px; width: 60%; background-color: rgba(130, 206, 209, 0.733); ">
 
  <div  class="container d-flex justify-content-center" >	                        
    <div class="card" style="width: 98%; height: 98%; margin-top: 30px; margin-bottom: 30px">	
      <table style="width: 100%;" class="table table-hover table-fixed">
     <thead>
          <tr>
            <th class="th-lg">Datum</th>
            <th class="th-lg">Vreme</th>
            <th class="th-lg">Vrsta Pregleda</th>
            <th class="th-lg">Cena</th>
            <th class="th-lg">Lekar</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        <tr v-for="k,i in zahtevi.length">
          <td align="center"><date-picker style="width: 117px" :placeholder="zahtevi[i].datum" disabled></date-picker> </td>
          <td align="center">{{zahtevi[i].vreme}}h</td>
          <td align="center">{{zahtevi[i].vrstaPregleda}}</td>
          <td align="center">{{zahtevi[i].cena}}</td>
          <td align="center">{{zahtevi[i].lekar.ime}} {{zahtevi[i].lekar.prezime}}</td>

          <td style="text-align: center">   <button class="btn btn-warning"  v-on:click="odobriZahtev(zahtevi[i])" style="  border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Odobri</i></button>
          </td>
          <td style="text-align: center">   <button class="btn btn-warning" v-on:click="odbijZahtev(zahtevi[i])" style=" border-color: rgb(233, 233, 233); background-color: rgb(233, 233, 233); color: #37474F;" type="button"><i class="fa fa-trash">Odbij</i></button>
          </td> 
         
        </tr>
        </tbody>
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
  import axios from 'axios';
  import VueCal from 'vue-cal';
import 'vue-cal/dist/vuecal.css';
import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';
import StarRating from 'vue-star-rating';

  export default {
    components: { VueCal ,
    DatePicker, StarRating},
   data() {
       return {

        user: {},
        preglediIstorija: {}, 
        splitedStr: "",
        klinike: {},
        klinika: {},
        zdravstveniK: {},
        korisnik: {},
        udpregledi: {},
        udpregled: {},
        lekari: {},
        lekar: {},
        tipovi: {},
        ocenaPK: {},
        ocenaPL: {},

        ocenaOK: {},
        ocenaOL: {},

        sati: [],
        basOperacije: [],
        basPregledi: [],
        sortiranje: ['Naziv', 'Adresa', 'Ocena'],
        sortiranje1: ['Tip Pregleda', 'Datum'],
        sortiranje2: ['Tip Pregleda', 'Datum'],
        odabirSortiranja2: "",
        odabirSortiranja1: "",
        odabirSortiranja: "",
        zahtevZaPregled: {
           datum: "",
           vreme: "",
           tipPregleda: "",
           lekar: "",
           cena: "",
           idPacijenta: "",
           trajanje: 0,
           vrstaPregleda: "",
        },
        pocetakRadnogVremena: 0,
        krajRadnogVremena: 0,

        prikaziDatum: "",
        rezultatiPretrage: [],
        pomocnaRezultatiPretrage: [],
        tip: {},
        pretragaKlinika: {
	        tipPregleda: "",
	        datum: null,
        },
        pretragaLekara: {
	        ime: "",
	        prezime: "",
          ocena: "",
        },
        izabraniDate: new Date(),
        filterString: "",
        selektovaniFilter: "",
        filterString1: "",
        selektovaniFilter1: "",
        cenaPregleda: "",
        pretrazeniLekari: {},
        drugaLozinka: {
        staraLozinka: "",
        novaLozinka: "",
        error: "",
        errormessage: "",
        ponovljenaLozinka: "",
      },
        pomocniLekari: {},
        pomocniLekari1: [],
        ukljucenaPretraga1: false,
        ukljucenaPretraga: false,
        prikaz:false,
        prikazZK:false,
        prikazZahteva:false,
        error: false,
        errormessage: false,
        prikazPREGLED:false,
        prikazPregled:false,
        prikazUDPREGLEDI:false,
        prikazListaKlinika: false,
        prikazKlinike: false,
        izmeni:false,
        prikazIstorije: false,
        zahtevi: {},
        id: 10,
        value: { },
        v:"",
        p:"pregled",
        pomocna: [],
        filteri: ['Naziv klinike', 'Ocena klinike'],
        filteri1: ['Ime lekara', 'Prezime lekara' ],
        ocena: {},
        }
    },
    methods: {
      odobriZahtev(zahtev){
        axios
          .put("/pregled/odobri", zahtev)
          .then(odgovor =>{
            alert("Odobrili ste pregled.");
            this.prikazZahteva=false;
            this.otvoriZahteve();

          })
          .catch(error => {
              console.log(error)
              alert("Greska!");
          });
      },
      odbijZahtev(zahtev){

axios
  .put("/pregled/odbij", zahtev)
  .then(odgovor =>{
    alert("Odbili ste pregled.");
    this.prikazZahteva=false;
    this.otvoriZahteve();

  })
  .catch(error => {
      console.log(error)
      alert("Greska!");
  });
},

      otvoriZahteve(){
              this.prikazZahteva=!this.prikazZahteva;
              this.prikaz=false;
              this.prikazZK = false;
              this.prikazPregled=false;
              this.prikazListaKlinika=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
              this.prikazIstorije=false;

              axios
		      .get("/pacijent/izlistajZahteve/" + this.$store.state.user.id)
		      .then(odgovor => {
		        this.zahtevi = odgovor.data;
		      })
		      .catch(error => {
		        console.log(error);
          });

      },

  oceniKlinikuP(id){
    this.ocenaPK.klinikaId = id;
    axios
        .post("/ocenaKlinike/dodaj" , this.ocenaPK)
        .then(response => {
          alert('Uspesno ste ocenili kliniku!');
        })
        .catch(error => {
            alert("Neuspesno ocenjivanje");
        });
  },
  oceniLekaraP(id){
    this.ocenaPL.lekarId = id;
    axios
        .post("/ocenaLekara/dodaj" , this.ocenaPL)
        .then(response => {
          alert('Uspesno ste ocenili lekara!');
        })
        .catch(error => {
          alert("Neuspesno ocenjivanje");
        });
  },
  oceniKlinikuO(id){
    this.ocenaOK.klinikaId = id;
    axios
        .post("/ocenaKlinike/dodaj" , this.ocenaOK)
        .then(response => {
          alert('Uspesno ste ocenili kliniku!');
        })
        .catch(error => {
            alert("Neuspesno ocenjivanje");
        });
  },
  oceniLekaraO(id){
    this.ocenaOL.lekarId = id;
    axios
        .post("/ocenaLekara/dodaj" , this.ocenaOL)
        .then(response => {
          alert('Uspesno ste ocenili lekara!');
        })
        .catch(error => {
          alert("Neuspesno ocenjivanje");
        });
  },
  otvoriFormu(){
              this.prikaz=!this.prikaz;
              this.prikazZK = false;
              this.prikazPregled=false;
              this.prikazListaKlinika=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;
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
  zakaziObicanPregled(){

    this.zahtevZaPregled.datum = this.pretragaKlinika.datum;
    this.zahtevZaPregled.vreme = this.v;
    this.zahtevZaPregled.tipPregleda = this.tip;
    this.zahtevZaPregled.lekar = this.lekar;
    this.zahtevZaPregled.cena = this.tip.cena;
    this.zahtevZaPregled.idPacijenta = this.$store.state.user.id;
    this.zahtevZaPregled.vrstaPregleda = "pregled";
    

    console.log(this.zahtevZaPregled);
   
    axios
        .post("/pregled/podnesiZahtevPacijent", this.zahtevZaPregled)
        .then(response => {
          this.zahtevZaPregled.datum = "",
          this.zahtevZaPregled.vreme = "",
          this.zahtevZaPregled.tipPregleda = "",
          this.zahtevZaPregled.lekar = "",
          this.zahtevZaPregled.cena = "",
          this.zahtevZaPregled.idPacijenta = "",
          this.zahtevZaPregled.vrstaPregleda = "",
          this.trajanje = 5;
          alert('Uspesno ste zakazali pregled!');
        })
        .catch(error => {
            alert("Ne mozete da zakazete pregled u navedenom terminu!");
        });


  },
  otvoriFormuZK(){
            axios
              .get("/zdravstveniKarton/pronadjiZdravstveniKarton1/" + this.$store.state.user.id)

              .then(zdravstveniK =>{
                this.zdravstveniK = zdravstveniK.data;
              })
              .catch(error => {
                  console.log(error)
              });
              this.prikazZK = !this.prikazZK;
              this.prikazPregled=false;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;

               },



  otvoriKliniku(k){
  


      axios

	        .get("/klinika/pronadjiKliniku1/"+ k.id)

	        .then(kl =>{

	          this.klinika = kl.data;
            this.prikazKlinike=!this.prikazKlinike; 
              this.prikazPregled=false;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazUDPREGLEDI=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;

          })
    },
    odustaniOdPregleda(){
      this.lekar={};
      this.klinika={};

              this.prikaz=false;
              this.prikazZK = false;
              this.prikazPregled=false;
              this.prikazListaKlinika=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;


    },
  pretraziLekara(){

  if(!this.ukljucenaPretraga){
          axios
        .post("/lekar/pretragaP/" + this.$store.state.user.id, this.pretragaLekara)
        .then(lekari =>{
         this.lekari = lekari.data;
            
            this.ukljucenaPretraga1 = true;
           
      })
      .catch(error => {
          console.log(error)
      });
  }else
  axios
        .post("/lekar/pretragaP/" + this.$store.state.user.id, this.pretragaLekara)
        .then(lekari1 =>{

          this.pomocniLekari = lekari1.data;
          
          this.ukljucenaPretraga1 = true; 

        

          for( var i = 0; i < this.pomocniLekari.length; i++){ 
            for( var j = 0; j < this.pretrazeniLekari.length; j++){
              if(this.pretrazeniLekari[j].id===this.pomocniLekari[i].id){
                  this.pomocniLekari1.push(this.pomocniLekari[i]);
              }
            }
          }  
          this.lekari=this.pomocniLekari1;  
      })
      .catch(error => {
          console.log(error)
      });
  },

  ponistiPretraguLekara(){

    this.ukljucenaPretraga1 = false;
      this.lekari= this.pretrazeniLekari;
      this.pretragaLekara.ime="";
      this.pretragaLekara.prezime="";
      this.pretragaLekara.ocena="";
    },
  pretragaKlinike(){

      if(this.pretragaKlinika.tipPregleda=="" || this.pretragaKlinika.datum==""){
        alert('Morate popuniti oba polja pretrage')
      } else{
             axios
        .post("/klinika/pretraga/" + this.$store.state.user.id, this.pretragaKlinika)
        .then(klinike =>{
         this.klinike = klinike.data;
     
            this.rezultatiPretrage = klinike.data;
            this.ukljucenaPretraga = true;
            for( var i = 0; i < this.tipovi.length; i++){ 
          if(this.tipovi[i].naziv==this.pretragaKlinika.tipPregleda)
              this.cenaPregleda=this.tipovi[i].cena;
            }
      })
      .catch(error => {
          console.log(error)
      });
           
      }
    },    


    ponistiPretraguKlinika(){

        axios
      .get('/klinika/izlistajK')
      .then(klinikaa =>{
        
        this.klinike = klinikaa.data;
      
        console.log(this.klinike);

       this.pretragaKlinika.datum = "", 
       this.pretragaKlinika.tipPregleda = "",
        
        this.ukljucenaPretraga = false;
        this.ukljucenaPretraga1 = false;
        this.pretragaLekara.ime="";
      this.pretragaLekara.prezime="";
      this.pretragaLekara.ocena="";
        this.cenaPregleda="";
    })
    .catch(error => {
      console.log('greska');
      console.log(error);
    });
        
    },

    nadjiBlokiraneSate(pocetak,kraj,id){

      this.pocetakRadnogVremena=pocetak;
      this.krajRadnogVremena=kraj;
    if(this.ukljucenaPretraga){
      
      axios
        .post('/lekar/nadjiZauzetePreglede/'+ id, this.pretragaKlinika.datum)
       .then(sati =>{
        
            this.sati = sati.data;
            console.log(this.sati);
          })
        .catch(error => {
            console.log(error)
      });
    }
      
    
    },

    blokirajVreme(date) {



      return date.getHours() < this.pocetakRadnogVremena || date.getHours() > this.krajRadnogVremena-1 || date.getHours()==this.sati[0] || date.getHours()==this.sati[1] || date.getHours()==this.sati[2] || date.getHours()==this.sati[3] || date.getHours()==this.sati[4] || date.getHours()==this.sati[5]  ;
    },

    ponistiFiltriranjeKlinika(){
	           this.filterString = "";
             this.selektovaniFilter="";
            
        },

  prikazLekara(k) {
   
     if(this.ukljucenaPretraga == false){
      axios
        .get('/lekar/izlistajLekare/'+ k.id)
        .then(lekari =>{
            this.lekari = lekari.data;
            this.pretrazeniLekari=lekari.data;
          })
        .catch(error => {
            console.log(error)
      });
     }else{
      axios
        .post('/lekar/izlistajLekarePoTP/'+ k.id, this.pretragaKlinika)
        .then(lekari =>{
            this.lekari = lekari.data;
            this.pretrazeniLekari=lekari.data;
          })
        .catch(error => {
            console.log(error)
      });
     }

        
     


    },

  izlistajTipove() {
        axios
		    .get("/tipPregleda/TipoviKlinike1/")
		    .then(tipovi => {
		        this.tipovi = tipovi.data;
		      })
		    .catch(error => {
		        console.log(error);
	      });
    },

   zakaziUDPregled(p){
        axios
        .post("/pregled/zakaziUDPregled/"+this.$store.state.user.id, p)
        .then(() => {
              alert('Uspesno ste zakazali pregled');
              this.prikazUDPREGLEDI=false;
            this.prikazudpregledi(this.klinika);
	        })
	
		    .catch(function (error) {
		        alert('Neuspesno zakazivanje pregleda');
		    
		    });
    
    },
  otvoriFormuPREGLED(){
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazUDPREGLEDI=false;
              this.prikazKlinike=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;

         },
  izmena() {
              this.izmeni = true;
  },
  nadjiTip(l) {

              axios
          .get("/tipPregleda/nadjiTip/"+ l.id)
          .then( t =>{
              this.tip = t.data;
              })

              .catch(error => {
		        console.log(error);
	      });
  },

 

  prikazPregleda(l,vv) {
    this.v=vv;
  
if(this.ukljucenaPretraga && this.v !=null ){
this.prikaziDatum=this.pretragaKlinika.datum.toString();
                  axios

              .get("/lekar/get1/"+ l.id)

              .then(l =>{

                this.lekar = l.data;
              })
            }else
            alert('Morate odabrati vreme,datum i tip pregleda');
  },
  prikazudpregledi(klinika) {
              this.prikaz=false;
              this.prikazUDPREGLEDI=!this.prikazUDPREGLEDI;
              this.prikazListaKlinika=false;
              this.prikaz=false;
              this.prikazZK=false;
              this.prikazKlinike=false;
              this.prikazPregled=false;
              this.prikazIstorije=false;
              this.prikazZahteva=false;

              


    axios
      .get('/pregled/izlistajUDP/'+ klinika.id)
      .then(udpregledi =>{
        this.udpregledi = udpregledi.data;
      })
      .catch(error => {
          console.log(error)
      });
  },
 
  listaKlinika(){
	 	
            this.prikazListaKlinika=!this.prikazListaKlinika;
            this.prikaz=false;
            this.prikazZK=false;
            this.prikazPregled=false;
            this.prikazUDPREGLEDI=false;
            this.prikazKlinike=false;
            this.prikazIstorije=false;
            this.prikazZahteva=false;

          
     if(this.ukljucenaPretraga){
       this.klinike=this.rezultatiPretrage;
      
     } else{
    axios
      .get('/klinika/izlistajK')
      .then(klinika =>{
        this.klinike = klinika.data;
      })
      .catch(error => {
          console.log(error)
      });
     }
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
          "/pacijent/promeniSvojuLozinku/" + this.$store.state.user.id,
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
  odustani() {
            this.izmeni = false
    axios
      .get("/pacijent/get/"  + this.$store.state.user.id)
      .then(pacijent =>{
        this.user = pacijent.data;
    })
    .catch(error => {
        console.log(error)
    });
        },
  sacuvaj() {
        if(this.user.ime === "" || this.user.prezime === "" || this.user.adresa === "" || this.user.grad === "" || this.user.drzava === ""
        || this.user.telefon === "") {
          alert("Polja ne smeju biti prazna!");
          return;
        }
        var rex = /^\+381\/6[0-9]-?[0-9]+(-[0-9]+)?$/;
        if (!rex.test(String(this.user.telefon.trim()))) {
          alert("Broj telefona treba da bude oblika +381/65-504205");
  
          return;
        }
        axios
        .put("/pacijent/izmeni", this.user)
        .then(pacijent =>{
          this.user = pacijent.data;
          this.izmeni = false;
        })
        .catch(error => {
            console.log(error)
        });

         },
    
    otvoriIstoriju(){


      axios
        .get('/pregled/nadjiOdradjen/'+ this.user.id)
        .then(pregledi =>{
         this.preglediIstorija=pregledi.data;
       //  console.log(this.preglediIstorija.length);

          if(this.basPregledi.length===0){
            for( var i = 0; i < this.preglediIstorija.length; i++){
            if(this.preglediIstorija[i].vrstaPregleda===this.p){
              this.basPregledi.push(this.preglediIstorija[i]);

            }else{
              this.basOperacije.push(this.preglediIstorija[i]);

            }
          }
          }else{
            if(this.preglediIstorija[i].vrstaPregleda===this.p){
               for( var i = 0; i < this.preglediIstorija.length; i++){
                 if(this.basPregledi.includes(this.preglediIstorija[i])==0){
                  this.basPregledi.push(this.preglediIstorija[i]);
                 }

          }
          }else{
          for( var i = 0; i < this.preglediIstorija.length; i++){
                 if(this.basOperacije.includes(this.preglediIstorija[i])==0){
                  this.basOperacije.push(this.preglediIstorija[i]);
                 }

          }
          }
          }


         
        })
        .catch(error => {
            console.log(error)
        });
      this.prikazIstorije=!this.prikazIstorije;
      this.prikazListaKlinika=false;
            this.prikaz=false;
            this.prikazZK=false;
            this.prikazPregled=false;
            this.prikazUDPREGLEDI=false;
            this.prikazKlinike=false;
            this.prikazZahteva=false;



    },
    azuriraj(){
    
	  		axios
		      .put("/klinika/azuriraj", this.odabirSortiranja)
		      .then(klinike => {
              this.klinike = klinike.data;

			      })
		      .catch(error => {
		          console.log(error)
		      });
	  	},
      azuriraj1(){
    
    axios
      .put("/pregled/azurirajPreglede/" + this.$store.state.user.id, this.odabirSortiranja1)
      .then(pregledi => {
          this.basPregledi = pregledi.data;

        })
      .catch(error => {
          console.log(error)
      });
  },
  azuriraj2(){
    
    axios
      .put("/pregled/azurirajOperacije/"+ this.$store.state.user.id , this.odabirSortiranja2)
      .then(pregledi => {
          this.basOperacije = pregledi.data;

        })
      .catch(error => {
          console.log(error)
      });
  },
  },
  
    beforeUpdate()
    {

      if(this.ukljucenaPretraga === false){
  		if(this.selektovaniFilter === 'Naziv klinike'){
  			  for( var i = 0; i < this.klinike.length; i++){ 
  			     if ( !this.klinike[i].naziv.includes(this.filterString)) {
			   	 	this.klinike.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
      
  
	      axios
	      .get("/klinika/izlistajK")
	      .then(klinike => {
	        this.pomocna = klinike.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
	     
        
	        if(this.selektovaniFilter === 'Naziv klinike'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].naziv.includes(this.filterString)) {
			  
			   var flag = 0;
				   	for(var j = 0; j < this.klinike.length; j++){
				   		if(this.klinike[j].naziv === this.pomocna[i].naziv && this.klinike[j].ocena === this.pomocna[i].ocena){
				   		
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag == 0){
						 this.klinike.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}
  		
  			if(this.selektovaniFilter === 'Ocena klinike'){
  			  for( var i = 0; i < this.klinike.length; i++){ 
  			     if ( !this.klinike[i].ocena.toString().includes(this.filterString)) {
			   	 	this.klinike.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
     
	      	  axios
	      .get("/klinika/izlistajK")
	      .then(klinike => {
	        this.pomocna = klinike.data;
	    	
	      })
	      .catch(error => {
	        console.log(error);
	      });
  
	  
	      
	      if(this.selektovaniFilter === 'Ocena klinike'){
  			  for( var i = 0; i < this.pomocna.length; i++){ 
		    
			   if (this.pomocna[i].ocena.toString().includes(this.filterString)) {
			    
			   var flag = 0;
				   	for(var j = 0; j < this.klinike.length; j++){
				   		if(this.klinike[j].ocena === this.pomocna[i].ocena && this.klinike[j].naziv === this.pomocna[i].naziv){
				   		
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag == 0){
						 this.klinike.push(this.pomocna[i]);
				   	}
				   			
			      }
			}
  		}	
      	
	      
  	}else{
 
  			if(this.selektovaniFilter === 'Naziv klinike'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].naziv.includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Naziv klinike'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].naziv.includes(this.filterString)) {
			 
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].naziv === this.pomocnaRezultatiPretrage[i].naziv){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.klinike.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  	
  		if(this.selektovaniFilter === 'Ocena klinike'){
  			  for( var i = 0; i < this.rezultatiPretrage.length; i++){ 
  			     if ( !this.rezultatiPretrage[i].ocena.toString().includes(this.filterString)) {
  			        var temp = this.rezultatiPretrage[i];
  			        this.pomocnaRezultatiPretrage.push(temp);
			   	 	this.rezultatiPretrage.splice(i, 1); 
			     	i--;
			     }
  		      }	
         }      
  	
  			 if(this.selektovaniFilter === 'Ocena klinike'){
  		
  			  for( var i = 0; i < this.pomocnaRezultatiPretrage.length; i++){ 
		    
			   if (this.pomocnaRezultatiPretrage[i].ocena.toString().includes(this.filterString)) {
		
			   var flag = 0;
				   	for(var j = 0; j < this.rezultatiPretrage.length; j++){
				   		if(this.rezultatiPretrage[j].broj === this.pomocnaRezultatiPretrage[i].broj){
				   		 
				   			flag = 1;
				   			break;
				   		}
				   	}
					   			
				    if(flag === 0){
				         
				          this.klinike.push(this.pomocnaRezultatiPretrage[i]);
				   	}
				   			
			      }
			}
			
  		}
  	
  	
  	
    } 

    },
   mounted() {
    event.preventDefault();

        axios
        .get("/pacijent/get/"  + this.$store.state.user.id)
        .then(pacijent =>{
          this.user = pacijent.data;
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

th {
  display: table-cell;
  vertical-align: inherit;
  font-weight: bold;
  text-align: center;
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
color: #b3b3b3 !important;;
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