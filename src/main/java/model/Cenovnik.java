package model;

/***********************************************************************
 * Module:  Cenovnik.java
 * Author:  23nik
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 53a7ca44-83de-43db-9b2c-fb11530116b4 */
public class Cenovnik {
   /** @pdOid 28d9da7c-691c-4b3d-aab4-88c6a9bb8cd5 */
   private float cena;
   
   /** @pdRoleInfo migr=no name=Klinika assc=association23 mult=1..1 */
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
            oldKlinika.removeCenovnik(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addCenovnik(this);
         }
      }
   }

}