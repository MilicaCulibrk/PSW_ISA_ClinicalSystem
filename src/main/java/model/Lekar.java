package model;

/***********************************************************************
 * Module:  Lekar.java
 * Author:  23nik
 * Purpose: Defines the Class Lekar
 ***********************************************************************/

import java.util.*;

/** @pdOid 1e02a0ab-f484-4326-bdd2-54eeea6148f3 */
public class Lekar {
   /** @pdOid cb5f2dc0-9d72-4f95-9ef8-55cf0ed573a7 */
   private String ime;
   /** @pdOid 3ac63288-39e0-440a-9797-79f9d74471be */
   private String prezime;
   /** @pdOid dd7ae564-a92c-4e6b-8aa7-296882e78364 */
   private String email;
   /** @pdOid c656932b-a549-4a24-85f6-4e6834a53021 */
   private String lozinka;
   /** @pdOid f5dc7f88-3fd3-44a1-bf10-e908903775a8 */
   private String adresa;
   /** @pdOid b5ec88f2-e818-41d6-a282-95f99a0e5072 */
   private String grad;
   /** @pdOid f5b1b22c-bb8f-4361-bb9a-177b3204c3fa */
   private String drzava;
   /** @pdOid 8dfe8d82-6eab-4db8-bb9b-d351f6775bb4 */
   private String telefon;
   /** @pdOid efa418c8-84de-405c-981d-74cdf1bd7f23 */
   private String jmbg;
   /** @pdOid d09f2117-7fd2-48d0-93fb-806ee05ba920 */
   private int ocena;
   /** @pdOid 7e7a174e-ebf7-4fb3-b6b0-cb08c953319d */
   private int brojRecenzija;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Pregled> pregled;
   /** @pdRoleInfo migr=no name=Operacija assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Operacija> operacija;
   /** @pdRoleInfo migr=no name=Klinika assc=association17 mult=1..1 side=A */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=RadniKalendar assc=association21 mult=1..1 side=A */
   public RadniKalendar radniKalendar;
   /** @pdRoleInfo migr=no name=ZahtevZaOdmor assc=association26 coll=java.util.Collection impl=java.util.ArrayList mult=0..* side=A */
   public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor;
   
   
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
         newPregled.setLekar(this);      
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
            oldPregled.setLekar((Lekar)null);
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
            oldPregled.setLekar((Lekar)null);
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
         this.operacija.add(newOperacija);
   }
   
   /** @pdGenerated default remove
     * @param oldOperacija */
   public void removeOperacija(Operacija oldOperacija) {
      if (oldOperacija == null)
         return;
      if (this.operacija != null)
         if (this.operacija.contains(oldOperacija))
            this.operacija.remove(oldOperacija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOperacija() {
      if (operacija != null)
         operacija.clear();
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
            oldKlinika.removeLekar(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addLekar(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public RadniKalendar getRadniKalendar() {
      return radniKalendar;
   }
   
   /** @pdGenerated default parent setter
     * @param newRadniKalendar */
   public void setRadniKalendar(RadniKalendar newRadniKalendar) {
      if (this.radniKalendar == null || !this.radniKalendar.equals(newRadniKalendar))
      {
         if (this.radniKalendar != null)
         {
            RadniKalendar oldRadniKalendar = this.radniKalendar;
            this.radniKalendar = null;
            oldRadniKalendar.removeLekar(this);
         }
         if (newRadniKalendar != null)
         {
            this.radniKalendar = newRadniKalendar;
            this.radniKalendar.addLekar(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtevZaOdmor> getZahtevZaOdmor() {
      if (zahtevZaOdmor == null)
         zahtevZaOdmor = new java.util.ArrayList<ZahtevZaOdmor>();
      return zahtevZaOdmor;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaOdmor() {
      if (zahtevZaOdmor == null)
         zahtevZaOdmor = new java.util.ArrayList<ZahtevZaOdmor>();
      return zahtevZaOdmor.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtevZaOdmor */
   public void setZahtevZaOdmor(java.util.Collection<ZahtevZaOdmor> newZahtevZaOdmor) {
      removeAllZahtevZaOdmor();
      for (java.util.Iterator iter = newZahtevZaOdmor.iterator(); iter.hasNext();)
         addZahtevZaOdmor((ZahtevZaOdmor)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtevZaOdmor */
   public void addZahtevZaOdmor(ZahtevZaOdmor newZahtevZaOdmor) {
      if (newZahtevZaOdmor == null)
         return;
      if (this.zahtevZaOdmor == null)
         this.zahtevZaOdmor = new java.util.ArrayList<ZahtevZaOdmor>();
      if (!this.zahtevZaOdmor.contains(newZahtevZaOdmor))
      {
         this.zahtevZaOdmor.add(newZahtevZaOdmor);
         newZahtevZaOdmor.setLekar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldZahtevZaOdmor */
   public void removeZahtevZaOdmor(ZahtevZaOdmor oldZahtevZaOdmor) {
      if (oldZahtevZaOdmor == null)
         return;
      if (this.zahtevZaOdmor != null)
         if (this.zahtevZaOdmor.contains(oldZahtevZaOdmor))
         {
            this.zahtevZaOdmor.remove(oldZahtevZaOdmor);
            oldZahtevZaOdmor.setLekar((Lekar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtevZaOdmor() {
      if (zahtevZaOdmor != null)
      {
         ZahtevZaOdmor oldZahtevZaOdmor;
         for (java.util.Iterator iter = getIteratorZahtevZaOdmor(); iter.hasNext();)
         {
            oldZahtevZaOdmor = (ZahtevZaOdmor)iter.next();
            iter.remove();
            oldZahtevZaOdmor.setLekar((Lekar)null);
         }
      }
   }

}