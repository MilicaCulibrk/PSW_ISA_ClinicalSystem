package main;

import javax.persistence.Column;
import javax.persistence.Entity;


//@Entity
public class TipPregleda {
	
	@Column(name = "naziv", nullable = false)
   private String naziv;
   
   public java.util.Collection<Pregled> pregled;
   
   
  
}