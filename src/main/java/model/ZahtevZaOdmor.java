package model;

/***********************************************************************
 * Module:  ZahtevZaOdmor.java
 * Author:  23nik
 * Purpose: Defines the Class ZahtevZaOdmor
 ***********************************************************************/

import java.util.*;

/** @pdOid 7a7ce414-d7fc-4329-a5da-0e28a4f925de */
public class ZahtevZaOdmor {
   /** @pdRoleInfo migr=no name=MedicinskaSestra assc=association25 mult=1..1 */
   public MedicinskaSestra medicinskaSestra;
   /** @pdRoleInfo migr=no name=Lekar assc=association26 mult=1..1 */
   public Lekar lekar;
   
   
   /** @pdGenerated default parent getter */
   public MedicinskaSestra getMedicinskaSestra() {
      return medicinskaSestra;
   }
   
   /** @pdGenerated default parent setter
     * @param newMedicinskaSestra */
   public void setMedicinskaSestra(MedicinskaSestra newMedicinskaSestra) {
      if (this.medicinskaSestra == null || !this.medicinskaSestra.equals(newMedicinskaSestra))
      {
         if (this.medicinskaSestra != null)
         {
            MedicinskaSestra oldMedicinskaSestra = this.medicinskaSestra;
            this.medicinskaSestra = null;
            oldMedicinskaSestra.removeZahtevZaOdmor(this);
         }
         if (newMedicinskaSestra != null)
         {
            this.medicinskaSestra = newMedicinskaSestra;
            this.medicinskaSestra.addZahtevZaOdmor(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Lekar getLekar() {
      return lekar;
   }
   
   /** @pdGenerated default parent setter
     * @param newLekar */
   public void setLekar(Lekar newLekar) {
      if (this.lekar == null || !this.lekar.equals(newLekar))
      {
         if (this.lekar != null)
         {
            Lekar oldLekar = this.lekar;
            this.lekar = null;
            oldLekar.removeZahtevZaOdmor(this);
         }
         if (newLekar != null)
         {
            this.lekar = newLekar;
            this.lekar.addZahtevZaOdmor(this);
         }
      }
   }

}