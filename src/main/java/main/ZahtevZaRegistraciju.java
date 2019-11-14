package main;

import javax.persistence.Entity;

//@Entity
public class ZahtevZaRegistraciju {
	
   public java.util.Collection<NeautentifikovaniKorisnik> neautentifikovaniKorisnik;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<NeautentifikovaniKorisnik> getNeautentifikovaniKorisnik() {
      if (neautentifikovaniKorisnik == null)
         neautentifikovaniKorisnik = new java.util.HashSet<NeautentifikovaniKorisnik>();
      return neautentifikovaniKorisnik;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNeautentifikovaniKorisnik() {
      if (neautentifikovaniKorisnik == null)
         neautentifikovaniKorisnik = new java.util.HashSet<NeautentifikovaniKorisnik>();
      return neautentifikovaniKorisnik.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNeautentifikovaniKorisnik */
   public void setNeautentifikovaniKorisnik(java.util.Collection<NeautentifikovaniKorisnik> newNeautentifikovaniKorisnik) {
      removeAllNeautentifikovaniKorisnik();
      for (java.util.Iterator iter = newNeautentifikovaniKorisnik.iterator(); iter.hasNext();)
         addNeautentifikovaniKorisnik((NeautentifikovaniKorisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNeautentifikovaniKorisnik */
   public void addNeautentifikovaniKorisnik(NeautentifikovaniKorisnik newNeautentifikovaniKorisnik) {
      if (newNeautentifikovaniKorisnik == null)
         return;
      if (this.neautentifikovaniKorisnik == null)
         this.neautentifikovaniKorisnik = new java.util.HashSet<NeautentifikovaniKorisnik>();
      if (!this.neautentifikovaniKorisnik.contains(newNeautentifikovaniKorisnik))
      {
         this.neautentifikovaniKorisnik.add(newNeautentifikovaniKorisnik);
         newNeautentifikovaniKorisnik.setZahtevZaRegistraciju(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldNeautentifikovaniKorisnik */
   public void removeNeautentifikovaniKorisnik(NeautentifikovaniKorisnik oldNeautentifikovaniKorisnik) {
      if (oldNeautentifikovaniKorisnik == null)
         return;
      if (this.neautentifikovaniKorisnik != null)
         if (this.neautentifikovaniKorisnik.contains(oldNeautentifikovaniKorisnik))
         {
            this.neautentifikovaniKorisnik.remove(oldNeautentifikovaniKorisnik);
            oldNeautentifikovaniKorisnik.setZahtevZaRegistraciju((ZahtevZaRegistraciju)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNeautentifikovaniKorisnik() {
      if (neautentifikovaniKorisnik != null)
      {
         NeautentifikovaniKorisnik oldNeautentifikovaniKorisnik;
         for (java.util.Iterator iter = getIteratorNeautentifikovaniKorisnik(); iter.hasNext();)
         {
            oldNeautentifikovaniKorisnik = (NeautentifikovaniKorisnik)iter.next();
            iter.remove();
            oldNeautentifikovaniKorisnik.setZahtevZaRegistraciju((ZahtevZaRegistraciju)null);
         }
      }
   }

}