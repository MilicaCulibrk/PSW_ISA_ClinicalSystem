# PS ISA Klinicki sistem

Fakultet tehnickih nauka Novi Sad <br>
Primenjene racunarske nauke<br>
Projekat iz predmeta ISA i PS<br>

Autori:<br>
Milica Culibrk<br>
Stanislava Skoric<br>
Ana Nikolasevic<br>


Veb aplikacija klinickog centra cija je osnovna namena predstavljanje klinika i online zakazivanje pregleda u istim. <br>

<h>Za uspesno pokretanje potrebno je instalirati:</h><br>
- Java SDK v1.8<br>
- Apache Maven v3.6.3 (npr Eclipse)<br>
- NodeJS v12.13.0<br>
- PostgreSQL v12.0<br>
- VueJS v2.0
- axios
- vue-bootstrap

    
Pokretanje projekta
- Prvo je potrebno napraviti kopiju ovog repozitorijuma sa git clone
- Pre pokretanja projekta potrebno je imati instaliranu PostgreSQL bazu verzije 11
- Importovati projekat kao Maven project
- Potrebno je podesiti build path kako bi se projekat mogao pokrenuti. U odeljku Source sve obrisati, i dodati sledece Source foldere:
server/src/main/java; server/src/main/resources; server/src/test/java (Output folder: target/test-classes; Contains test sources: yes)
- Ukoliko je potrebno dodati Unit4, dodati kao jar biblioteku
- Instalirati Lombok sa sledeceg linka https://www.baeldung.com/lombok-ide i dodati kao external jar file unutar libraries
- Desni klik na klasu ClinicalSystemApplication.java -> run 
- U konzoli se pozicionirati u folder projekta/client 
- Pokrenuti npm run dev

