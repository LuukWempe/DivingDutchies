package nl.luuk.model.gasblender;

public class Cylinder {

   double o2_vol;
   double n2_vol;
   double he_vol;
   double cyl_size;
   double cyl_press;
   
   //Constructors
   public Cylinder(){
	   this.o2_vol = 0.0;
	   this.n2_vol = 0.0;
	   this.he_vol = 0.0; 
	   this.cyl_size = 10;
	   this.cyl_press = 0.0;
   }
   
   public Cylinder(double o2_frac, double n2_frac, double he_frac, double cyl_size, double cyl_press){
     this.o2_vol = o2_frac * cyl_size * cyl_press;
     this.n2_vol = n2_frac * cyl_size * cyl_press;
     this.he_vol = he_frac * cyl_size * cyl_press;
     this.cyl_size = cyl_size;
     this.cyl_press = cyl_press;
     this.printAttribute();
   }    
   
   public Cylinder(double o2_vol, double n2_vol, double he_vol, double cyl_press){
	     this.o2_vol = o2_vol;
	     this.n2_vol = n2_vol;
	     this.he_vol = he_vol;
	     this.cyl_press = cyl_press;
	     this.printAttribute();
   }  
   
  
   public Cylinder addGas(Cylinder c, Gasses gas, double vol) {
	   switch(gas) {
	   		case OXYGEN:
	   			c.o2_vol += vol;
	   			c.cyl_press += vol/c.cyl_size;
	   			break;
		   
	   		case NITROGEN: 
	   			c.n2_vol += vol;
	   			c.cyl_press += vol/c.cyl_size;
	   			break;
		   
	   		case HELIUM:
	   			c.he_vol += vol;
	   			c.cyl_press += vol/c.cyl_size;
	   			break;
	   }
	   c.printAttribute("gas added to cylinder " + vol + " " + gas);
	   return c;
   }
   
   public void releasePressure(double i) {
		this.o2_vol -= (o2_vol/(this.o2_vol + this.n2_vol + this.he_vol)) * i * this.cyl_size;
		this.n2_vol -= (n2_vol/(this.o2_vol + this.n2_vol + this.he_vol)) * i * this.cyl_size;
		this.he_vol -= (he_vol/(this.o2_vol + this.n2_vol + this.he_vol)) * i * this.cyl_size;
		this.cyl_press -= i;
	}
   
   public void printAttribute() {
	  System.out.println("o2 content: " + o2_vol);
	  System.out.println("n2 content: " + n2_vol);
	  System.out.println("he content: " + he_vol);
	  System.out.println("Size: " + cyl_size);
	  System.out.println("pressure: " + cyl_press);
	  //System.out.println("--------------------- ");
   }
   
   public void printAttribute(String msg) {
		  System.out.println(msg);
		  System.out.println("o2 content: " + o2_vol);
		  System.out.println("n2 content: " + n2_vol);
		  System.out.println("he content: " + he_vol);
		  System.out.println("Size: " + cyl_size);
		  System.out.println("delta pressure: " + cyl_press);
		  //System.out.println("--------------------- ");
	   }

public double getO2_vol() {
	return o2_vol;
}

public void setO2_vol(double o2_vol) {
	this.o2_vol = o2_vol;
}

public double getN2_vol() {
	return n2_vol;
}

public void setN2_vol(double n2_vol) {
	this.n2_vol = n2_vol;
}

public double getHe_vol() {
	return he_vol;
}

public void setHe_vol(double he_vol) {
	this.he_vol = he_vol;
}

public double getCyl_size() {
	return cyl_size;
}

public void setCyl_size(double cyl_size) {
	this.cyl_size = cyl_size;
}

public double getCyl_press() {
	return cyl_press;
}

public void setCyl_press(double cyl_press) {
	this.cyl_press = cyl_press;
}
   
   

}
