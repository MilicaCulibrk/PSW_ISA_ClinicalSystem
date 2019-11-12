package model;

/***********************************************************************
 * Module:  ZahtevZaPregled.java
 * Author:  23nik
 * Purpose: Defines the Class ZahtevZaPregled
 ***********************************************************************/

import java.util.*;

/** @pdOid 3bee2965-9c09-4266-8aa0-8835a6c6454d */
public class ZahtevZaPregled {
   /** @pdOid 3e9fbffe-aa8e-48c2-a843-e91db802f082 */
   private boolean odobren;
   /** @pdOid 42c4c6a2-e224-4039-8073-12e301f2c8f9 */
   private long terminPregleda;
   /** @pdOid 4a9b7a1e-5fbd-4eab-8639-a71655f00fa1 */
   private long trajanje;
   /** @pdOid ecc7fc79-560a-4479-b1cb-f93cdd20c261 */
   private long cena;
   
   /** @pdRoleInfo migr=no name=Pacijent assc=association36 mult=1..1 */
   public Pacijent pacijent;
   /** @pdRoleInfo migr=no name=Sala assc=association37 mult=1..1 */
   public Sala sala;
   /** @pdRoleInfo migr=no name=Lekar assc=association38 mult=1..1 */
   public Lekar lekar;
   /** @pdRoleInfo migr=no name=TipPregleda assc=association42 mult=1..1 */
   public TipPregleda tipPregleda;

}