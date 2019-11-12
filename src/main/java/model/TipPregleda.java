package model;

/***********************************************************************
 * Module:  TipPregleda.java
 * Author:  23nik
 * Purpose: Defines the Class TipPregleda
 ***********************************************************************/

import java.util.*;

/** @pdOid 11a71f77-4a2f-42f7-9a16-91c6015d5b9a */
public class TipPregleda {
   /** @pdOid 2fa255ba-cbd2-40d5-956c-344bc53f1f15 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association22 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pregled> pregled;
   
   
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
         newPregled.setTipPregleda(this);      
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
            oldPregled.setTipPregleda((TipPregleda)null);
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
            oldPregled.setTipPregleda((TipPregleda)null);
         }
      }
   }

}