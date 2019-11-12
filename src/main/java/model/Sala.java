package model;

/***********************************************************************
 * Module:  Sala.java
 * Author:  23nik
 * Purpose: Defines the Class Sala
 ***********************************************************************/

import java.util.*;

/** @pdOid ae3d60c9-59ab-44b4-8c23-1cc82fc2e478 */
public class Sala {
   /** @pdOid 4465b639-9959-4cf9-8b13-5359fb088ea8 */
   private int naziv;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association27 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pregled> pregled;
   /** @pdRoleInfo migr=no name=Klinika assc=association29 mult=1..1 */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=Operacija assc=association30 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Operacija> operacija;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pregled> getPregled() {
      if (pregled == null)
         pregled = new java.util.HashSet<Pregled>();
      return pregled;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPregled() {
      if (pregled == null)
         pregled = new java.util.HashSet<Pregled>();
      return pregled.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPregled */
   public void setPregled(java.util.Collection<Pregled> newPregled) {
      removeAllPregled();
      for (java.util.Iterator iter = newPregled.iterator(); iter.hasNext();)
         addPregled((Pregled)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPregled */
   public void addPregled(Pregled newPregled) {
      if (newPregled == null)
         return;
      if (this.pregled == null)
         this.pregled = new java.util.HashSet<Pregled>();
      if (!this.pregled.contains(newPregled))
      {
         this.pregled.add(newPregled);
         newPregled.setSala(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPregled */
   public void removePregled(Pregled oldPregled) {
      if (oldPregled == null)
         return;
      if (this.pregled != null)
         if (this.pregled.contains(oldPregled))
         {
            this.pregled.remove(oldPregled);
            oldPregled.setSala((Sala)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPregled() {
      if (pregled != null)
      {
         Pregled oldPregled;
         for (java.util.Iterator iter = getIteratorPregled(); iter.hasNext();)
         {
            oldPregled = (Pregled)iter.next();
            iter.remove();
            oldPregled.setSala((Sala)null);
         }
      }
   }
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
            oldKlinika.removeSala(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addSala(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Operacija> getOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOperacija */
   public void setOperacija(java.util.Collection<Operacija> newOperacija) {
      removeAllOperacija();
      for (java.util.Iterator iter = newOperacija.iterator(); iter.hasNext();)
         addOperacija((Operacija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOperacija */
   public void addOperacija(Operacija newOperacija) {
      if (newOperacija == null)
         return;
      if (this.operacija == null)
         this.operacija = new java.util.HashSet<Operacija>();
      if (!this.operacija.contains(newOperacija))
      {
         this.operacija.add(newOperacija);
         newOperacija.setSala(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOperacija */
   public void removeOperacija(Operacija oldOperacija) {
      if (oldOperacija == null)
         return;
      if (this.operacija != null)
         if (this.operacija.contains(oldOperacija))
         {
            this.operacija.remove(oldOperacija);
            oldOperacija.setSala((Sala)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOperacija() {
      if (operacija != null)
      {
         Operacija oldOperacija;
         for (java.util.Iterator iter = getIteratorOperacija(); iter.hasNext();)
         {
            oldOperacija = (Operacija)iter.next();
            iter.remove();
            oldOperacija.setSala((Sala)null);
         }
      }
   }

}