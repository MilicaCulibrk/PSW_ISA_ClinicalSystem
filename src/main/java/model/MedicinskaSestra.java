package model;

/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  23nik
 * Purpose: Defines the Class MedicinskaSestra
 ***********************************************************************/

import java.util.*;

/** @pdOid b31ea8d4-491a-464f-837d-19100b443986 */
public class MedicinskaSestra {
   /** @pdOid 5618cd08-7917-4152-ada0-387db0bf25fc */
   private String ime;
   /** @pdOid 3945388b-0bac-4880-b2b1-40a3b3605804 */
   private String prezime;
   /** @pdOid 8b20dc26-3df4-4017-83a6-3cdbb92ac274 */
   private int ocena;
   /** @pdOid 3ab07706-d5bc-47a1-81c7-bc89b0dfd428 */
   private String email;
   /** @pdOid d2e84188-4ddb-47af-9e99-e4aad2df3aeb */
   private String lozinka;
   /** @pdOid 96589bc2-3475-4bd3-8bb0-f903115a8686 */
   private String adresa;
   /** @pdOid a291b7eb-745e-4728-867a-7d55357861cf */
   private String grad;
   /** @pdOid f91fcfa1-2f25-435b-8a34-49d3fbd57401 */
   private String drzava;
   /** @pdOid 8db9dd6b-8e6a-4f91-aa36-36c214b7be20 */
   private String telefon;
   /** @pdOid fd3acd95-bc9b-4db6-a554-3514f2358b75 */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=RadniKalendar assc=association20 mult=1..1 */
   public RadniKalendar radniKalendar;
   /** @pdRoleInfo migr=no name=Klinika assc=association14 mult=0..1 side=A */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=ZahtevZaOdmor assc=association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<ZahtevZaOdmor> zahtevZaOdmor;
   
   
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
            oldRadniKalendar.removeMedicinskaSestra(this);
         }
         if (newRadniKalendar != null)
         {
            this.radniKalendar = newRadniKalendar;
            this.radniKalendar.addMedicinskaSestra(this);
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
            oldKlinika.removeMedicinskaSestra(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addMedicinskaSestra(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtevZaOdmor> getZahtevZaOdmor() {
      if (zahtevZaOdmor == null)
         zahtevZaOdmor = new java.util.HashSet<ZahtevZaOdmor>();
      return zahtevZaOdmor;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaOdmor() {
      if (zahtevZaOdmor == null)
         zahtevZaOdmor = new java.util.HashSet<ZahtevZaOdmor>();
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
         this.zahtevZaOdmor = new java.util.HashSet<ZahtevZaOdmor>();
      if (!this.zahtevZaOdmor.contains(newZahtevZaOdmor))
      {
         this.zahtevZaOdmor.add(newZahtevZaOdmor);
         newZahtevZaOdmor.setMedicinskaSestra(this);      
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
            oldZahtevZaOdmor.setMedicinskaSestra((MedicinskaSestra)null);
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
            oldZahtevZaOdmor.setMedicinskaSestra((MedicinskaSestra)null);
         }
      }
   }

}