package model;

/***********************************************************************
 * Module:  Pregled.java
 * Author:  23nik
 * Purpose: Defines the Class Pregled
 ***********************************************************************/

import java.util.*;

/** @pdOid 58fbdf65-13ad-456d-aeed-d02c0eb7b223 */
public class Pregled {
   /** @pdOid f36a0aa4-fe78-4fd1-ba4f-29b8c04198f5 */
   private long datumVreme;
   /** @pdOid dc172693-2a3d-4df0-8235-970225c0f3b4 */
   private long trajanje;
   /** @pdOid d8c089c1-8a91-42bc-9a8b-bc9dfd65225d */
   private double cena;
   
   /** @pdRoleInfo migr=no name=Klinika assc=association28 mult=1..1 */
   public Klinika klinika;
   /** @pdRoleInfo migr=no name=Pacijent assc=association1 mult=1..1 side=A */
   public Pacijent pacijent;
   /** @pdRoleInfo migr=no name=Lekar assc=association6 mult=1..1 side=A */
   public Lekar lekar;
   /** @pdRoleInfo migr=no name=TipPregleda assc=association22 mult=1..1 side=A */
   public TipPregleda tipPregleda;
   /** @pdRoleInfo migr=no name=Sala assc=association27 mult=1..1 side=A */
   public Sala sala;
   
   
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
            oldKlinika.removePregled(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addPregled(this);
         }
      }
   }
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
            oldPacijent.removePregled(this);
         }
         if (newPacijent != null)
         {
            this.pacijent = newPacijent;
            this.pacijent.addPregled(this);
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
            oldLekar.removePregled(this);
         }
         if (newLekar != null)
         {
            this.lekar = newLekar;
            this.lekar.addPregled(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TipPregleda getTipPregleda() {
      return tipPregleda;
   }
   
   /** @pdGenerated default parent setter
     * @param newTipPregleda */
   public void setTipPregleda(TipPregleda newTipPregleda) {
      if (this.tipPregleda == null || !this.tipPregleda.equals(newTipPregleda))
      {
         if (this.tipPregleda != null)
         {
            TipPregleda oldTipPregleda = this.tipPregleda;
            this.tipPregleda = null;
            oldTipPregleda.removePregled(this);
         }
         if (newTipPregleda != null)
         {
            this.tipPregleda = newTipPregleda;
            this.tipPregleda.addPregled(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Sala getSala() {
      return sala;
   }
   
   /** @pdGenerated default parent setter
     * @param newSala */
   public void setSala(Sala newSala) {
      if (this.sala == null || !this.sala.equals(newSala))
      {
         if (this.sala != null)
         {
            Sala oldSala = this.sala;
            this.sala = null;
            oldSala.removePregled(this);
         }
         if (newSala != null)
         {
            this.sala = newSala;
            this.sala.addPregled(this);
         }
      }
   }

}