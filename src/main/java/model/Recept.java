package model;

/***********************************************************************
 * Module:  Recept.java
 * Author:  23nik
 * Purpose: Defines the Class Recept
 ***********************************************************************/

import java.util.*;

/** @pdOid e1586b60-c481-47b3-86a6-11c5acb74e66 */
public class Recept {
   /** @pdRoleInfo migr=no name=MedicinskaSestra assc=association34 mult=1..1 */
   public MedicinskaSestra medicinskaSestra;
   /** @pdRoleInfo migr=no name=Lekar assc=association35 mult=1..1 */
   public Lekar lekar;

}