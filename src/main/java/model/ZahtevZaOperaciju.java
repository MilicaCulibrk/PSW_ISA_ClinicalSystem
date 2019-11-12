package model;

/***********************************************************************
 * Module:  ZahtevZaOperaciju.java
 * Author:  23nik
 * Purpose: Defines the Class ZahtevZaOperaciju
 ***********************************************************************/

import java.util.*;

/** @pdOid 64fcd310-4540-4b09-9926-ba8f6d0755db */
public class ZahtevZaOperaciju {
   /** @pdOid b13d15db-b144-4bf2-b069-33a9f9a4ff97 */
   private boolean odobren;
   /** @pdOid a45002f4-a75e-42b2-9d14-70bbe94bc226 */
   private long terminPregleda;
   /** @pdOid 9825b994-0a38-402e-bd92-27b088131bf3 */
   private long trajanje;
   /** @pdOid 22733f5c-b260-4a9a-b4b0-601e78773575 */
   private long cena;
   
   /** @pdRoleInfo migr=no name=Pacijent assc=association39 mult=1..1 */
   public Pacijent pacijent;
   /** @pdRoleInfo migr=no name=Lekar assc=association41 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Lekar> lekar;
   /** @pdRoleInfo migr=no name=Sala assc=association40 mult=1..1 */
   public Sala sala;
   
   
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
         this.lekar.add(newLekar);
   }
   
   /** @pdGenerated default remove
     * @param oldLekar */
   public void removeLekar(Lekar oldLekar) {
      if (oldLekar == null)
         return;
      if (this.lekar != null)
         if (this.lekar.contains(oldLekar))
            this.lekar.remove(oldLekar);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLekar() {
      if (lekar != null)
         lekar.clear();
   }

}