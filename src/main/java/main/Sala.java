package main;

import javax.persistence.Column;
import javax.persistence.Entity;


//@Entity
public class Sala {
	
	@Column(name = "naziv", nullable = false)
   private int naziv;
   
   public java.util.Collection<Pregled> pregled;
   public Klinika klinika;
   public java.util.Collection<Operacija> operacija;
   
  

}