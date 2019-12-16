<template>

    <div  id="pocetna" class="container">
   <div class="split left">
     <h1 style="font-size: 2rem;
     color: #5F9EA0;
     position: absolute;
     left: 72%;
     top: 55%;
     transform: translateX(-50%);
     white-space: nowrap;">Posedujete nalog?</h1>
     <h2 style="font-size: 1.5rem;
     color: #5F9EA0;
     position: absolute;
     left: 72%;
     top: 60%;
     transform: translateX(-50%);
     white-space: nowrap;">Prijavite se.</h2>
     <li style=" display: block;
     position: absolute;
     left: 72%;
     top: 15%; 
     height: 250px;
     padding-top: 5rem;
     width: 250px;
     text-align: center;
     border: groove 1em rgba(130, 206, 209, 0.733);
     border-radius: 50%;
     border-color: rgba(130, 206, 209, 0.733);
     background: hsla(108, 36%, 73%, 0.3);
     font-size: 1rem;
     font-weight: bolder;
     text-transform: uppercase;
     text-decoration: none;
     transform: translateX(-50%);
     box-shadow: 0 0 200px 0 rgba(0, 0, 0, 0.2), 0 30px 50px 0 rgba(0, 0, 0, 0.24);
     "><router-link to="/login" style=" font-size: 2.1rem; color: rgb(109, 168, 170);">PRIJAVA</router-link></li>
   </div>
   <div class="split right">
     <h1 style="font-size: 2rem;
     color: #5F9EA0;
     position: absolute;
     left: 29%;
     top: 55%;
     transform: translateX(-50%);
     white-space: nowrap;">Nemate nalog?</h1>
      <h2 style="font-size: 1.5rem;
      color: #5F9EA0;
      position: absolute;
      left: 29%;
      top: 60%;
      transform: translateX(-50%);
      white-space: nowrap;">Registrujte se.</h2>
     <li style=" display: block;
     position: absolute;
     left: 29%;
     top: 15%;
     height: 250px;
     padding-top: 5rem;
     width: 250px;
     text-align: center;
     border: groove 1em rgba(130, 206, 209, 0.733);
     border-radius: 50%;
     border-color: rgba(130, 206, 209, 0.733);
     background: hsla(108, 36%, 73%, 0.3);
     font-size: 1rem;
     font-weight: bolder;
     text-transform: uppercase;
     text-decoration: none;
     transform: translateX(-50%);
     box-shadow: 0 0 200px 0 rgba(0, 0, 0, 0.2), 0 30px 50px 0 rgba(0, 0, 0, 0.24);"><router-link to="/registration" style=" font-size: 2.1rem; color: rgb(109, 168, 170);">REGISTRACIJA</router-link></li>
   </div>
 </div>

</template>

<script>
export default {
  methods: {
      odjava(){
               localStorage.removeItem("jwt");
                this.$store.state.user = {
                role: {
                authority: ""
                }
            };
   
        },
  },
   mounted() {
      this.odjava()
  }
};
</script>

<style scoped>
 
 .container {
    padding:0;
    margin:0;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    width: 100%;
    height: 100%;
    overflow-x: hidden;
  }

  .split.right {
    right:0;
    background: url('https://i.ibb.co/FBXWKxW/doctor.jpg') center center no-repeat;
    background-size: cover;
  }
  .split.left {
    left:0;
    background: url('https://i.ibb.co/c3wT6SM/doctor2.jpg') center center no-repeat;
    background-size: cover;
  }
  .split {
    position: absolute;
    width: 50%;
    height: 100%;
    overflow: hidden;
  }
  
  </style>