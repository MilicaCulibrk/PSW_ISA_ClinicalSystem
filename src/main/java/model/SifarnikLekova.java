package model;

/***********************************************************************
 * Module:  SifarnikLekova.java
 * Author:  23nik
 * Purpose: Defines the Class SifarnikLekova
 ***********************************************************************/

import java.util.*;

/** @pdOid cd725010-ea54-4d65-a07e-024efbd3444d */
public class SifarnikLekova {
   /** @pdOid fe366761-ea15-4aa8-ac78-f26c0fcf8838 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=ZdravstveniKarton assc=association3 mult=1..1 side=A */
   public ZdravstveniKarton zdravstveniKarton;
   
   
   /** @pdGenerated default parent getter */
   public ZdravstveniKarton getZdravstveniKarton() {
      return zdravstveniKarton;
   }
   
   /** @pdGenerated default parent setter
     * @param newZdravstveniKarton */
   public void setZdravstveniKarton(ZdravstveniKarton newZdravstveniKarton) {
      if (this.zdravstveniKarton == null || !this.zdravstveniKarton.equals(newZdravstveniKarton))
      {
         if (this.zdravstveniKarton != null)
         {
            ZdravstveniKarton oldZdravstveniKarton = this.zdravstveniKarton;
            this.zdravstveniKarton = null;
            oldZdravstveniKarton.removeSifarnikLekova(this);
         }
         if (newZdravstveniKarton != null)
         {
            this.zdravstveniKarton = newZdravstveniKarton;
            this.zdravstveniKarton.addSifarnikLekova(this);
         }
      }
   }

}