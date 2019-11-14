package main;

import javax.persistence.Entity;


//@Entity
public class NeautentifikovaniKorisnik {
   public ZahtevZaRegistraciju zahtevZaRegistraciju;
   
   
   public ZahtevZaRegistraciju getZahtevZaRegistraciju() {
      return zahtevZaRegistraciju;
   }
   
   /** @pdGenerated default parent setter
     * @param newZahtevZaRegistraciju */
   public void setZahtevZaRegistraciju(ZahtevZaRegistraciju newZahtevZaRegistraciju) {
      if (this.zahtevZaRegistraciju == null || !this.zahtevZaRegistraciju.equals(newZahtevZaRegistraciju))
      {
         if (this.zahtevZaRegistraciju != null)
         {
            ZahtevZaRegistraciju oldZahtevZaRegistraciju = this.zahtevZaRegistraciju;
            this.zahtevZaRegistraciju = null;
            oldZahtevZaRegistraciju.removeNeautentifikovaniKorisnik(this);
         }
         if (newZahtevZaRegistraciju != null)
         {
            this.zahtevZaRegistraciju = newZahtevZaRegistraciju;
            this.zahtevZaRegistraciju.addNeautentifikovaniKorisnik(this);
         }
      }
   }

}