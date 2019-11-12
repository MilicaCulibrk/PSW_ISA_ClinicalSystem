package model;

/***********************************************************************
 * Module:  ZdravstveniKarton.java
 * Author:  23nik
 * Purpose: Defines the Class ZdravstveniKarton
 ***********************************************************************/

import java.util.*;

/** @pdOid b57cbf0c-24f1-4056-ba91-f8e062902178 */
public class ZdravstveniKarton {
   /** @pdOid aad2d602-de0b-4049-abb7-cbdc0feb0cc8 */
   private String dioptrija;
   /** @pdOid 52d3159a-7cad-4bed-a218-a350c613f53c */
   private String alergije;
   /** @pdOid 64bac034-b42d-4d9e-a63b-b9fef0c392fc */
   private String visina;
   /** @pdOid 14dafa91-66af-4e65-96e7-b06b58264430 */
   private String tezina;
   
   /** @pdRoleInfo migr=no name=Pacijent assc=association2 mult=1..1 */
   public Pacijent pacijent;
   /** @pdRoleInfo migr=no name=SifarnikLekova assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<SifarnikLekova> sifarnikLekova;
   /** @pdRoleInfo migr=no name=SifranikDijagnoza assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<SifranikDijagnoza> sifranikDijagnoza;
   /** @pdRoleInfo migr=no name=Izvestaj assc=association31 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Izvestaj> izvestaj;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<SifarnikLekova> getSifarnikLekova() {
      if (sifarnikLekova == null)
         sifarnikLekova = new java.util.HashSet<SifarnikLekova>();
      return sifarnikLekova;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSifarnikLekova() {
      if (sifarnikLekova == null)
         sifarnikLekova = new java.util.HashSet<SifarnikLekova>();
      return sifarnikLekova.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSifarnikLekova */
   public void setSifarnikLekova(java.util.Collection<SifarnikLekova> newSifarnikLekova) {
      removeAllSifarnikLekova();
      for (java.util.Iterator iter = newSifarnikLekova.iterator(); iter.hasNext();)
         addSifarnikLekova((SifarnikLekova)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSifarnikLekova */
   public void addSifarnikLekova(SifarnikLekova newSifarnikLekova) {
      if (newSifarnikLekova == null)
         return;
      if (this.sifarnikLekova == null)
         this.sifarnikLekova = new java.util.HashSet<SifarnikLekova>();
      if (!this.sifarnikLekova.contains(newSifarnikLekova))
      {
         this.sifarnikLekova.add(newSifarnikLekova);
         newSifarnikLekova.setZdravstveniKarton(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSifarnikLekova */
   public void removeSifarnikLekova(SifarnikLekova oldSifarnikLekova) {
      if (oldSifarnikLekova == null)
         return;
      if (this.sifarnikLekova != null)
         if (this.sifarnikLekova.contains(oldSifarnikLekova))
         {
            this.sifarnikLekova.remove(oldSifarnikLekova);
            oldSifarnikLekova.setZdravstveniKarton((ZdravstveniKarton)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSifarnikLekova() {
      if (sifarnikLekova != null)
      {
         SifarnikLekova oldSifarnikLekova;
         for (java.util.Iterator iter = getIteratorSifarnikLekova(); iter.hasNext();)
         {
            oldSifarnikLekova = (SifarnikLekova)iter.next();
            iter.remove();
            oldSifarnikLekova.setZdravstveniKarton((ZdravstveniKarton)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<SifranikDijagnoza> getSifranikDijagnoza() {
      if (sifranikDijagnoza == null)
         sifranikDijagnoza = new java.util.HashSet<SifranikDijagnoza>();
      return sifranikDijagnoza;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSifranikDijagnoza() {
      if (sifranikDijagnoza == null)
         sifranikDijagnoza = new java.util.HashSet<SifranikDijagnoza>();
      return sifranikDijagnoza.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSifranikDijagnoza */
   public void setSifranikDijagnoza(java.util.Collection<SifranikDijagnoza> newSifranikDijagnoza) {
      removeAllSifranikDijagnoza();
      for (java.util.Iterator iter = newSifranikDijagnoza.iterator(); iter.hasNext();)
         addSifranikDijagnoza((SifranikDijagnoza)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSifranikDijagnoza */
   public void addSifranikDijagnoza(SifranikDijagnoza newSifranikDijagnoza) {
      if (newSifranikDijagnoza == null)
         return;
      if (this.sifranikDijagnoza == null)
         this.sifranikDijagnoza = new java.util.HashSet<SifranikDijagnoza>();
      if (!this.sifranikDijagnoza.contains(newSifranikDijagnoza))
      {
         this.sifranikDijagnoza.add(newSifranikDijagnoza);
         newSifranikDijagnoza.setZdravstveniKarton(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSifranikDijagnoza */
   public void removeSifranikDijagnoza(SifranikDijagnoza oldSifranikDijagnoza) {
      if (oldSifranikDijagnoza == null)
         return;
      if (this.sifranikDijagnoza != null)
         if (this.sifranikDijagnoza.contains(oldSifranikDijagnoza))
         {
            this.sifranikDijagnoza.remove(oldSifranikDijagnoza);
            oldSifranikDijagnoza.setZdravstveniKarton((ZdravstveniKarton)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSifranikDijagnoza() {
      if (sifranikDijagnoza != null)
      {
         SifranikDijagnoza oldSifranikDijagnoza;
         for (java.util.Iterator iter = getIteratorSifranikDijagnoza(); iter.hasNext();)
         {
            oldSifranikDijagnoza = (SifranikDijagnoza)iter.next();
            iter.remove();
            oldSifranikDijagnoza.setZdravstveniKarton((ZdravstveniKarton)null);
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
         newIzvestaj.setZdravstveniKarton(this);      
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
            oldIzvestaj.setZdravstveniKarton((ZdravstveniKarton)null);
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
            oldIzvestaj.setZdravstveniKarton((ZdravstveniKarton)null);
         }
      }
   }

}