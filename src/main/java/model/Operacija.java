package model;

/***********************************************************************
 * Module:  Operacija.java
 * Author:  23nik
 * Purpose: Defines the Class Operacija
 ***********************************************************************/

import java.util.*;

/** @pdOid 778cee73-cab2-4f32-8aab-6f66db95bf48 */
public class Operacija {
   /** @pdOid f5bffba4-0c19-435a-a003-29ed4035ff03 */
   private long datumVreme;
   /** @pdOid 9cbfc3c2-3ec7-4888-9cd6-4d0937d5fa66 */
   private long trajanje;
   /** @pdOid db623b07-e6a3-4a6d-bc91-1e8841435843 */
   private double cena;
   
   /** @pdRoleInfo migr=no name=Sala assc=association30 mult=1..1 */
   public Sala sala;
   /** @pdRoleInfo migr=no name=Lekar assc=association7 mult=1..* side=A */
   public Lekar[] lekar;
   /** @pdRoleInfo migr=no name=Pacijent assc=association18 mult=1..1 side=A */
   public Pacijent pacijent;
   
   
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
            oldSala.removeOperacija(this);
         }
         if (newSala != null)
         {
            this.sala = newSala;
            this.sala.addOperacija(this);
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
            oldPacijent.removeOperacija(this);
         }
         if (newPacijent != null)
         {
            this.pacijent = newPacijent;
            this.pacijent.addOperacija(this);
         }
      }
   }

}