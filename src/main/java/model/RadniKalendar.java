package model;

/***********************************************************************
 * Module:  RadniKalendar.java
 * Author:  23nik
 * Purpose: Defines the Class RadniKalendar
 ***********************************************************************/

import java.util.*;

/** @pdOid 5f9e7777-1c95-4f8f-920f-a0c82a8b8c72 */
public class RadniKalendar {
   /** @pdRoleInfo migr=no name=Lekar assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Lekar> lekar;
   /** @pdRoleInfo migr=no name=MedicinskaSestra assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<MedicinskaSestra> medicinskaSestra;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Lekar> getLekar() {
      if (lekar == null)
         lekar = new java.util.HashSet<Lekar>();
      return lekar;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLekar() {
      if (lekar == null)
         lekar = new java.util.HashSet<Lekar>();
      return lekar.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLekar */
   public void setLekar(java.util.Collection<Lekar> newLekar) {
      removeAllLekar();
      for (java.util.Iterator iter = newLekar.iterator(); iter.hasNext();)
         addLekar((Lekar)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLekar */
   public void addLekar(Lekar newLekar) {
      if (newLekar == null)
         return;
      if (this.lekar == null)
         this.lekar = new java.util.HashSet<Lekar>();
      if (!this.lekar.contains(newLekar))
      {
         this.lekar.add(newLekar);
         newLekar.setRadniKalendar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldLekar */
   public void removeLekar(Lekar oldLekar) {
      if (oldLekar == null)
         return;
      if (this.lekar != null)
         if (this.lekar.contains(oldLekar))
         {
            this.lekar.remove(oldLekar);
            oldLekar.setRadniKalendar((RadniKalendar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLekar() {
      if (lekar != null)
      {
         Lekar oldLekar;
         for (java.util.Iterator iter = getIteratorLekar(); iter.hasNext();)
         {
            oldLekar = (Lekar)iter.next();
            iter.remove();
            oldLekar.setRadniKalendar((RadniKalendar)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<MedicinskaSestra> getMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.HashSet<MedicinskaSestra>();
      return medicinskaSestra;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.HashSet<MedicinskaSestra>();
      return medicinskaSestra.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicinskaSestra */
   public void setMedicinskaSestra(java.util.Collection<MedicinskaSestra> newMedicinskaSestra) {
      removeAllMedicinskaSestra();
      for (java.util.Iterator iter = newMedicinskaSestra.iterator(); iter.hasNext();)
         addMedicinskaSestra((MedicinskaSestra)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicinskaSestra */
   public void addMedicinskaSestra(MedicinskaSestra newMedicinskaSestra) {
      if (newMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra == null)
         this.medicinskaSestra = new java.util.HashSet<MedicinskaSestra>();
      if (!this.medicinskaSestra.contains(newMedicinskaSestra))
      {
         this.medicinskaSestra.add(newMedicinskaSestra);
         newMedicinskaSestra.setRadniKalendar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMedicinskaSestra */
   public void removeMedicinskaSestra(MedicinskaSestra oldMedicinskaSestra) {
      if (oldMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra != null)
         if (this.medicinskaSestra.contains(oldMedicinskaSestra))
         {
            this.medicinskaSestra.remove(oldMedicinskaSestra);
            oldMedicinskaSestra.setRadniKalendar((RadniKalendar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicinskaSestra() {
      if (medicinskaSestra != null)
      {
         MedicinskaSestra oldMedicinskaSestra;
         for (java.util.Iterator iter = getIteratorMedicinskaSestra(); iter.hasNext();)
         {
            oldMedicinskaSestra = (MedicinskaSestra)iter.next();
            iter.remove();
            oldMedicinskaSestra.setRadniKalendar((RadniKalendar)null);
         }
      }
   }

}