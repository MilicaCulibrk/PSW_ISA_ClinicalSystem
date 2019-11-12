package model;

/***********************************************************************
 * Module:  Klinika.java
 * Author:  23nik
 * Purpose: Defines the Class Klinika
 ***********************************************************************/

import java.util.*;

/** @pdOid 2f617a34-db61-4784-a9b5-3801ed25b40d */
public class Klinika {
   /** @pdOid fdb8cae0-3d82-4151-ad80-4149b1ebd391 */
   private String naziv;
   /** @pdOid 0f75ab0b-262b-4287-bcbd-c21fd9ee42c8 */
   private String adresa;
   /** @pdOid a5fddf59-a293-4379-9cc5-6f2b9cf06175 */
   private String email;
   /** @pdOid 631696cf-0af9-4c35-9339-19698301ce54 */
   private String grad;
   /** @pdOid 4d4ac785-5a05-4f2e-9781-9a642cea89a5 */
   private String telefon;
   /** @pdOid fb462867-e8b6-4080-a218-4cf55fc25bdb */
   private String opis;
   /** @pdOid 21c37f91-f4a9-47da-a468-ae1d5474ccde */
   private int ocena;
   /** @pdOid cf6b9d63-b39d-452f-a839-3d01c9923171 */
   private int brojRecenzija;
   
   /** @pdRoleInfo migr=no name=MedicinskaSestra assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MedicinskaSestra> medicinskaSestra;
   /** @pdRoleInfo migr=no name=AdministratorKlinike assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<AdministratorKlinike> administratorKlinike;
   /** @pdRoleInfo migr=no name=Pacijent assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pacijent> pacijent;
   /** @pdRoleInfo migr=no name=Lekar assc=association17 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Lekar> lekar;
   /** @pdRoleInfo migr=no name=KlinickiCentar assc=association24 mult=1..1 */
   public KlinickiCentar klinickiCentar;
   /** @pdRoleInfo migr=no name=Cenovnik assc=association23 coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Cenovnik> cenovnik;
   /** @pdRoleInfo migr=no name=Pregled assc=association28 coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Pregled> pregled;
   /** @pdRoleInfo migr=no name=Sala assc=association29 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Composition side=A */
   public java.util.Collection<Sala> sala;
   
   
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
         newMedicinskaSestra.setKlinika(this);      
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
            oldMedicinskaSestra.setKlinika((Klinika)null);
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
            oldMedicinskaSestra.setKlinika((Klinika)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<AdministratorKlinike> getAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdministratorKlinike */
   public void setAdministratorKlinike(java.util.Collection<AdministratorKlinike> newAdministratorKlinike) {
      removeAllAdministratorKlinike();
      for (java.util.Iterator iter = newAdministratorKlinike.iterator(); iter.hasNext();)
         addAdministratorKlinike((AdministratorKlinike)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdministratorKlinike */
   public void addAdministratorKlinike(AdministratorKlinike newAdministratorKlinike) {
      if (newAdministratorKlinike == null)
         return;
      if (this.administratorKlinike == null)
         this.administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      if (!this.administratorKlinike.contains(newAdministratorKlinike))
      {
         this.administratorKlinike.add(newAdministratorKlinike);
         newAdministratorKlinike.setKlinika(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAdministratorKlinike */
   public void removeAdministratorKlinike(AdministratorKlinike oldAdministratorKlinike) {
      if (oldAdministratorKlinike == null)
         return;
      if (this.administratorKlinike != null)
         if (this.administratorKlinike.contains(oldAdministratorKlinike))
         {
            this.administratorKlinike.remove(oldAdministratorKlinike);
            oldAdministratorKlinike.setKlinika((Klinika)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdministratorKlinike() {
      if (administratorKlinike != null)
      {
         AdministratorKlinike oldAdministratorKlinike;
         for (java.util.Iterator iter = getIteratorAdministratorKlinike(); iter.hasNext();)
         {
            oldAdministratorKlinike = (AdministratorKlinike)iter.next();
            iter.remove();
            oldAdministratorKlinike.setKlinika((Klinika)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Pacijent> getPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPacijent */
   public void setPacijent(java.util.Collection<Pacijent> newPacijent) {
      removeAllPacijent();
      for (java.util.Iterator iter = newPacijent.iterator(); iter.hasNext();)
         addPacijent((Pacijent)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPacijent */
   public void addPacijent(Pacijent newPacijent) {
      if (newPacijent == null)
         return;
      if (this.pacijent == null)
         this.pacijent = new java.util.HashSet<Pacijent>();
      if (!this.pacijent.contains(newPacijent))
      {
         this.pacijent.add(newPacijent);
         newPacijent.setKlinika(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPacijent */
   public void removePacijent(Pacijent oldPacijent) {
      if (oldPacijent == null)
         return;
      if (this.pacijent != null)
         if (this.pacijent.contains(oldPacijent))
         {
            this.pacijent.remove(oldPacijent);
            oldPacijent.setKlinika((Klinika)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPacijent() {
      if (pacijent != null)
      {
         Pacijent oldPacijent;
         for (java.util.Iterator iter = getIteratorPacijent(); iter.hasNext();)
         {
            oldPacijent = (Pacijent)iter.next();
            iter.remove();
            oldPacijent.setKlinika((Klinika)null);
         }
      }
   }
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
         newLekar.setKlinika(this);      
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
            oldLekar.setKlinika((Klinika)null);
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
            oldLekar.setKlinika((Klinika)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Cenovnik> getCenovnik() {
      if (cenovnik == null)
         cenovnik = new java.util.HashSet<Cenovnik>();
      return cenovnik;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCenovnik() {
      if (cenovnik == null)
         cenovnik = new java.util.HashSet<Cenovnik>();
      return cenovnik.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCenovnik */
   public void setCenovnik(java.util.Collection<Cenovnik> newCenovnik) {
      removeAllCenovnik();
      for (java.util.Iterator iter = newCenovnik.iterator(); iter.hasNext();)
         addCenovnik((Cenovnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCenovnik */
   public void addCenovnik(Cenovnik newCenovnik) {
      if (newCenovnik == null)
         return;
      if (this.cenovnik == null)
         this.cenovnik = new java.util.HashSet<Cenovnik>();
      if (!this.cenovnik.contains(newCenovnik))
      {
         this.cenovnik.add(newCenovnik);
         newCenovnik.setKlinika(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldCenovnik */
   public void removeCenovnik(Cenovnik oldCenovnik) {
      if (oldCenovnik == null)
         return;
      if (this.cenovnik != null)
         if (this.cenovnik.contains(oldCenovnik))
         {
            this.cenovnik.remove(oldCenovnik);
            oldCenovnik.setKlinika((Klinika)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCenovnik() {
      if (cenovnik != null)
      {
         Cenovnik oldCenovnik;
         for (java.util.Iterator iter = getIteratorCenovnik(); iter.hasNext();)
         {
            oldCenovnik = (Cenovnik)iter.next();
            iter.remove();
            oldCenovnik.setKlinika((Klinika)null);
         }
      }
   }
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
         newPregled.setKlinika(this);      
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
            oldPregled.setKlinika((Klinika)null);
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
            oldPregled.setKlinika((Klinika)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Sala> getSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSala */
   public void setSala(java.util.Collection<Sala> newSala) {
      removeAllSala();
      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
         addSala((Sala)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSala */
   public void addSala(Sala newSala) {
      if (newSala == null)
         return;
      if (this.sala == null)
         this.sala = new java.util.HashSet<Sala>();
      if (!this.sala.contains(newSala))
      {
         this.sala.add(newSala);
         newSala.setKlinika(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSala */
   public void removeSala(Sala oldSala) {
      if (oldSala == null)
         return;
      if (this.sala != null)
         if (this.sala.contains(oldSala))
         {
            this.sala.remove(oldSala);
            oldSala.setKlinika((Klinika)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSala() {
      if (sala != null)
      {
         Sala oldSala;
         for (java.util.Iterator iter = getIteratorSala(); iter.hasNext();)
         {
            oldSala = (Sala)iter.next();
            iter.remove();
            oldSala.setKlinika((Klinika)null);
         }
      }
   }

}