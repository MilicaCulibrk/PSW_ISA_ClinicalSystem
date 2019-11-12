package model;

/***********************************************************************
 * Module:  Izvestaj.java
 * Author:  23nik
 * Purpose: Defines the Class Izvestaj
 ***********************************************************************/

import java.util.*;

/** @pdOid 0a15e762-bc18-4b7b-9cc4-caf0b7904f58 */
public class Izvestaj {
   /** @pdOid 6920dd59-8edc-4450-9222-cc33058130cb */
   private int datumVreme;
   /** @pdOid e6e45fab-7379-4d0b-be19-67d2273f9b8d */
   private String opis;
   
   /** @pdRoleInfo migr=no name=Pacijent assc=association32 mult=1..1 */
   public Pacijent pacijent;
   /** @pdRoleInfo migr=no name=Lekar assc=association33 mult=1..1 */
   public Lekar lekar;
   /** @pdRoleInfo migr=no name=ZdravstveniKarton assc=association31 mult=1..1 side=A */
   public ZdravstveniKarton zdravstveniKarton;
   
   
   /** @pdGenerated default parent getter */
   public Pacijent getPacijent() {
      return pacijent;
   }
   
   /** @pdGenerated default parent setter
     * @param newPacijent */
   public void setPacijent(Pacijent newPacijent) {
      if (this.pacijent == null || !this.pacijent.equals(newPacijent))
      {
         if (this.pacijent != null)
         {
            Pacijent oldPacijent = this.pacijent;
            this.pacijent = null;
            oldPacijent.removeIzvestaj(this);
         }
         if (newPacijent != null)
         {
            this.pacijent = newPacijent;
            this.pacijent.addIzvestaj(this);
         }
      }
   }
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
            oldZdravstveniKarton.removeIzvestaj(this);
         }
         if (newZdravstveniKarton != null)
         {
            this.zdravstveniKarton = newZdravstveniKarton;
            this.zdravstveniKarton.addIzvestaj(this);
         }
      }
   }

}