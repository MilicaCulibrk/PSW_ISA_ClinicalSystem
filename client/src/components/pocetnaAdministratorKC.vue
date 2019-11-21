

<template>

    
    <div>
    <nav class="mb-1 navbar navbar-expand-lg navbar-light navbar-toggler bg-info">
     	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
    aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
    	<ul class="navbar-nav mr-auto">
	      <li class="li">
	        <router-link to="/dodajKliniku">Dodaj klinike<span class="sr-only">(current)</span></router-link>
	      </li>
	       <li class="li">
	     	 <router-link to="/">Lista klinika<span class="sr-only">(current)</span></router-link>
	      </li>
	       <li class="li">
	         <router-link to="/dodajAdministratora">Dodaj administratora<span class="sr-only">(current)</span></router-link>
	      </li>
	      <li class="nav-item">
	          <router-link to="/">Lista administratora<span class="sr-only">(current)</span></router-link>
	      </li>
            
     
      
      
    </ul>
    <div class="navbar-nav ml-auto">
       <li class="nav-item">
	        <router-link to="/pocetna">ODJAVA</router-link>
	      </li>
    </div>
  </div>
    </nav>
         <router-view></router-view>
 
    </div>






</template>


<style>
.li {
   display: inline;
   margin-right: 20px;
   }
 </style>