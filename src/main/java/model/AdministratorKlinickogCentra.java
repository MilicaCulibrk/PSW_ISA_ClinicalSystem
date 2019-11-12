package model;

/***********************************************************************
 * Module:  AdministratorKlinickogCentra.java
 * Author:  23nik
 * Purpose: Defines the Class AdministratorKlinickogCentra
 ***********************************************************************/

import java.util.*;

/** @pdOid 9d6f329f-26e2-4f46-a0d2-7f1eadb087fc */
public class AdministratorKlinickogCentra {
   /** @pdOid 254a0610-68d2-4937-9bdc-0fa58a5d1e7f */
   private String ime;
   /** @pdOid c693e54e-9285-4a8d-8503-d388b17956af */
   private String prezime;
   /** @pdOid 3d88cb5a-3e39-445b-adc0-c954610cb7d1 */
   private String email;
   /** @pdOid 180cb09c-408a-4d91-867f-fb2f0e4b15ae */
   private String lozinka;
   /** @pdOid 5a8a3da6-025c-4a0d-a6ab-8bb0649171bf */
   private String adresa;
   /** @pdOid 70053052-190a-4338-a346-63fe05d20db6 */
   private String grad;
   /** @pdOid a95b7419-a2a2-4dfc-b020-55de449f7ced */
   private String drzava;
   /** @pdOid 7e461fce-0e5a-4bcd-a9f0-d5e4a4fc1bc8 */
   private String telefon;
   /** @pdOid 20875c38-6be2-4050-860d-0690f00f991c */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=KlinickiCentar assc=association11 mult=1..1 */
   public KlinickiCentar klinickiCentar;
   
   
   /** @pdGenerated default parent getter */
   public KlinickiCentar getKlinickiCentar() {
      return klinickiCentar;
   }
   
   /** @pdGenerated default parent setter
     * @param newKlinickiCentar */
   public void setKlinickiCentar(KlinickiCentar newKlinickiCentar) {
      if (this.klinickiCentar == null || !this.klinickiCentar.equals(newKlinickiCentar))
      {
         if (this.klinickiCentar != null)
         {
            KlinickiCentar oldKlinickiCentar = this.klinickiCentar;
            this.klinickiCentar = null;
            oldKlinickiCentar.removeAdministratorKlinickogCentra(this);
         }
         if (newKlinickiCentar != null)
         {
            this.klinickiCentar = newKlinickiCentar;
            this.klinickiCentar.addAdministratorKlinickogCentra(this);
         }
      }
   }

}