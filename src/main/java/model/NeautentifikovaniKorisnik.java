package model;

/***********************************************************************
 * Module:  NeautentifikovaniKorisnik.java
 * Author:  23nik
 * Purpose: Defines the Class NeautentifikovaniKorisnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 40d0323b-b7fd-4831-b8bf-9bf764b52c0f */
public class NeautentifikovaniKorisnik {
   /** @pdRoleInfo migr=no name=ZahtevZaRegistraciju assc=association12 mult=1..1 */
   public ZahtevZaRegistraciju zahtevZaRegistraciju;
   
   
   /** @pdGenerated default parent getter */
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