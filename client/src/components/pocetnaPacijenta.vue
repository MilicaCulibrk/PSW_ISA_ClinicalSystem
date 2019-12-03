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
	                <i class="zmdi zmdi-view-dashboard"> ZDRAVSTVENI KARTON
	                </i>                   
	              </a>
	              <a href="#">
	                <i class="zmdi zmdi-view-dashboard"> LISTA KLINIKA
	                </i>                   
                  </a>
                  <a href="#">
	                <i class="zmdi zmdi-view-dashboard"> ISTORIJA PREGLEDA I OPERACIJA
	                </i>                   
	              </a>	    	               
	           </ul>
	        </div>
            <!-- Content -->
            <div id="content">                    
              <div class="container-fluid">
                <h1 style="color: #b3b3b3;">Pacijent </h1>                
              </div>
            </div>
	     </div>
	
     
</div>





</template>



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


