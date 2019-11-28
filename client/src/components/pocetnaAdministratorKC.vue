

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
	        <router-link to="/dodajKliniku"><font color="white">Dodaj klinike</font><span class="sr-only">(current)</span></router-link>
	      </li>
	       <li class="li">
	     	 <router-link to="/"><font color="white">Lista klinika</font><span class="sr-only">(current)</span></router-link>
	      </li>
	       <li class="li">
	         <router-link to="/dodajAdministratora"><font color="white">Dodaj administratora</font><span class="sr-only">(current)</span></router-link>
	      </li>
	      <li class="nav-item">
	          <router-link to="/"><font color="white">Lista administratora</font><span class="sr-only">(current)</span></router-link>
	      </li>
            
     
      
      
    </ul>
    <div class="navbar-nav ml-auto">
       <li class="nav-item">
	        <router-link to="/pocetna"><font color="white">ODJAVA</font></router-link>
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