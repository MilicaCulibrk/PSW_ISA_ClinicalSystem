package model;

/***********************************************************************
 * Module:  KlinickiCentar.java
 * Author:  23nik
 * Purpose: Defines the Class KlinickiCentar
 ***********************************************************************/

import java.util.*;

/** @pdOid e2e7cf22-4f37-461f-923d-f1e96da09a4b */
public class KlinickiCentar {
   /** @pdRoleInfo migr=no name=AdministratorKlinickogCentra assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<AdministratorKlinickogCentra> getAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdministratorKlinickogCentra */
   public void setAdministratorKlinickogCentra(java.util.Collection<AdministratorKlinickogCentra> newAdministratorKlinickogCentra) {
      removeAllAdministratorKlinickogCentra();
      for (java.util.Iterator iter = newAdministratorKlinickogCentra.iterator(); iter.hasNext();)
         addAdministratorKlinickogCentra((AdministratorKlinickogCentra)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdministratorKlinickogCentra */
   public void addAdministratorKlinickogCentra(AdministratorKlinickogCentra newAdministratorKlinickogCentra) {
      if (newAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra == null)
         this.administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      if (!this.administratorKlinickogCentra.contains(newAdministratorKlinickogCentra))
      {
         this.administratorKlinickogCentra.add(newAdministratorKlinickogCentra);
         newAdministratorKlinickogCentra.setKlinickiCentar(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAdministratorKlinickogCentra */
   public void removeAdministratorKlinickogCentra(AdministratorKlinickogCentra oldAdministratorKlinickogCentra) {
      if (oldAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra != null)
         if (this.administratorKlinickogCentra.contains(oldAdministratorKlinickogCentra))
         {
            this.administratorKlinickogCentra.remove(oldAdministratorKlinickogCentra);
            oldAdministratorKlinickogCentra.setKlinickiCentar((KlinickiCentar)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra != null)
      {
         AdministratorKlinickogCentra oldAdministratorKlinickogCentra;
         for (java.util.Iterator iter = getIteratorAdministratorKlinickogCentra(); iter.hasNext();)
         {
            oldAdministratorKlinickogCentra = (AdministratorKlinickogCentra)iter.next();
            iter.remove();
            oldAdministratorKlinickogCentra.setKlinickiCentar((KlinickiCentar)null);
         }
      }
   }

}