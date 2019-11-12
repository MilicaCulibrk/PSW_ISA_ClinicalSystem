package model;

/***********************************************************************
 * Module:  AdministratorKlinike.java
 * Author:  23nik
 * Purpose: Defines the Class AdministratorKlinike
 ***********************************************************************/

import java.util.*;

/** @pdOid f8b572dd-8730-4e45-8890-9abf718c8517 */
public class AdministratorKlinike {
   /** @pdOid 1f709456-c661-4c16-a960-586247327e81 */
   private String ime;
   /** @pdOid a2fc36a8-9613-4128-8834-f703d5d358b5 */
   private String prezime;
   /** @pdOid ba7e2037-8a6c-401c-a2ee-1f0cd5996266 */
   private String email;
   /** @pdOid c7ccf596-176d-45f5-a1ec-ae21cb407292 */
   private String lozinka;
   /** @pdOid 33f5b465-205c-45d0-b607-b660cac09fb0 */
   private String adresa;
   /** @pdOid b278419e-951a-4bf6-8249-80f1c75f6eec */
   private String grad;
   /** @pdOid 7aed2a4b-3804-41c6-bb66-d30f16c68098 */
   private String drzava;
   /** @pdOid 45a3a121-8432-41e7-9ee5-2f27c67d70c4 */
   private String telefon;
   /** @pdOid 9f875289-542f-4f15-9d85-a80ea7fa5f94 */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=Klinika assc=association15 mult=0..1 side=A */
   public Klinika klinika;
   
   
   /** @pdGenerated default parent getter */
   public Klinika getKlinika() {
      return klinika;
   }
   
   /** @pdGenerated default parent setter
     * @param newKlinika */
   public void setKlinika(Klinika newKlinika) {
      if (this.klinika == null || !this.klinika.equals(newKlinika))
      {
         if (this.klinika != null)
         {
            Klinika oldKlinika = this.klinika;
            this.klinika = null;
            oldKlinika.removeAdministratorKlinike(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addAdministratorKlinike(this);
         }
      }
   }

}