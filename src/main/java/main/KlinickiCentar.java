package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class KlinickiCentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   public java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra;
   
   
   public java.util.Collection<AdministratorKlinickogCentra> getAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra;
   }
   
   public java.util.Iterator getIteratorAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra.iterator();
   }
   
   
   public void setAdministratorKlinickogCentra(java.util.Collection<AdministratorKlinickogCentra> newAdministratorKlinickogCentra) {
      removeAllAdministratorKlinickogCentra();
      for (java.util.Iterator iter = newAdministratorKlinickogCentra.iterator(); iter.hasNext();)
         addAdministratorKlinickogCentra((AdministratorKlinickogCentra)iter.next());
   }
   

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