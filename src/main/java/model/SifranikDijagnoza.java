package model;

/***********************************************************************
 * Module:  SifranikDijagnoza.java
 * Author:  23nik
 * Purpose: Defines the Class SifranikDijagnoza
 ***********************************************************************/

import java.util.*;

/** @pdOid 0cd877f6-3972-4099-986b-013d8612d268 */
public class SifranikDijagnoza {
   /** @pdRoleInfo migr=no name=ZdravstveniKarton assc=association4 mult=1..1 side=A */
   public ZdravstveniKarton zdravstveniKarton;
   
   
   /** @pdGenerated default parent getter */
   public ZdravstveniKarton getZdravstveniKarton() {
      return zdravstveniKarton;
   }
   
   /** @pdGenerated default parent setter
     * @param newZdravstveniKarton */
   public void setZdravstveniKarton(ZdravstveniKarton newZdravstveniKarton) {
      if (this.zdravstveniKarton == null || !this.zdravstveniKarton.equals(newZdravstveniKarton))
      {
         if (this.zdravstveniKarton != null)
         {
            ZdravstveniKarton oldZdravstveniKarton = this.zdravstveniKarton;
            this.zdravstveniKarton = null;
            oldZdravstveniKarton.removeSifranikDijagnoza(this);
         }
         if (newZdravstveniKarton != null)
         {
            this.zdravstveniKarton = newZdravstveniKarton;
            this.zdravstveniKarton.addSifranikDijagnoza(this);
         }
      }
   }

}