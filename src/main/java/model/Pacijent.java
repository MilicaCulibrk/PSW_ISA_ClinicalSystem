package model;

/***********************************************************************
 * Module:  Pacijent.java
 * Author:  23nik
 * Purpose: Defines the Class Pacijent
 ***********************************************************************/

import java.util.*;

/** @pdOid e92ec319-cfe3-44b8-8da6-fc0a824249f4 */
public class Pacijent {
   /** @pdOid 1b65f6f8-993a-4cf0-896d-b91fef329aae */
   private String ime;
   /** @pdOid 32b4d365-3072-4466-b734-b9719e3b15c7 */
   private String prezime;
   /** @pdOid b9fd6912-ef34-46c6-b28e-c2ca57545eca */
   private String email;
   /** @pdOid 341882ec-8bbb-4808-b7da-61ed65457644 */
   private String lozinka;
   /** @pdOid 49dcf230-36a1-46ef-b3fa-67027e2e47d5 */
   private String adresa;
   /** @pdOid a8a62af8-d588-4250-9b8f-5d11278b6933 */
   private String grad;
   /** @pdOid 891c34cd-a7e9-4e14-812e-3990373286d4 */
   private String drzava;
   /** @pdOid 7c40b45c-e3b0-41f6-950e-e84457c53dbc */
   private String telefon;
   /** @pdOid 8938e1e0-2605-4149-aa2e-09c8516750a8 */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pregled> pregled;
   /** @pdRoleInfo migr=no name=Operacija assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Operacija> operacija;
   /** @pdRoleInfo migr=no name=ZdravstveniKarton assc=association2 mult=1..1 side=A */
   public ZdravstveniKarton zdravstveniKarton;
   /** @pdRoleInfo migr=no name=Klinika assc=association16 mult=0..1 side=A */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=Izvestaj assc=association32 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Izvestaj> izvestaj;
   
   
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
         newPregled.setPacijent(this);      
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
            oldPregled.setPacijent((Pacijent)null);
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
            oldPregled.setPacijent((Pacijent)null);
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
         newOperacija.setPacijent(this);      
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
            oldOperacija.setPacijent((Pacijent)null);
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
            oldOperacija.setPacijent((Pacijent)null);
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
            oldKlinika.removePacijent(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addPacijent(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Izvestaj> getIzvestaj() {
      if (izvestaj == null)
         izvestaj = new java.util.HashSet<Izvestaj>();
      return izvestaj;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIzvestaj() {
      if (izvestaj == null)
         izvestaj = new java.util.HashSet<Izvestaj>();
      return izvestaj.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIzvestaj */
   public void setIzvestaj(java.util.Collection<Izvestaj> newIzvestaj) {
      removeAllIzvestaj();
      for (java.util.Iterator iter = newIzvestaj.iterator(); iter.hasNext();)
         addIzvestaj((Izvestaj)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIzvestaj */
   public void addIzvestaj(Izvestaj newIzvestaj) {
      if (newIzvestaj == null)
         return;
      if (this.izvestaj == null)
         this.izvestaj = new java.util.HashSet<Izvestaj>();
      if (!this.izvestaj.contains(newIzvestaj))
      {
         this.izvestaj.add(newIzvestaj);
         newIzvestaj.setPacijent(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldIzvestaj */
   public void removeIzvestaj(Izvestaj oldIzvestaj) {
      if (oldIzvestaj == null)
         return;
      if (this.izvestaj != null)
         if (this.izvestaj.contains(oldIzvestaj))
         {
            this.izvestaj.remove(oldIzvestaj);
            oldIzvestaj.setPacijent((Pacijent)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIzvestaj() {
      if (izvestaj != null)
      {
         Izvestaj oldIzvestaj;
         for (java.util.Iterator iter = getIteratorIzvestaj(); iter.hasNext();)
         {
            oldIzvestaj = (Izvestaj)iter.next();
            iter.remove();
            oldIzvestaj.setPacijent((Pacijent)null);
         }
      }
   }

}