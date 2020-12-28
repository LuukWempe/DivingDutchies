package nl.luuk.model.gasblender;

public class Cylinder {

   double o2_fraction;
   double n2_fraction;
   double he_fraction;
   int cylinder_size;
   int cylinder_pressure;
   
   //Constructors
   public Cylinder(){}
   
   public Cylinder(double o2_fraction, double n2_fraction, double he_fraction, int cylinder_size, int cylinder_pressure){
     this.o2_fraction = o2_fraction;
     this.n2_fraction = n2_fraction;
     this.he_fraction = he_fraction;
     this.cylinder_size = cylinder_size;
     this.cylinder_pressure = cylinder_pressure;
   }    
   
   public void printAttribute() {
	  System.out.println("o2 to add: " + o2_fraction);
	  System.out.println("n2 to add: " + n2_fraction);
	  System.out.println("he to add: " + he_fraction);
	  System.out.println("Size: " + cylinder_size);
	  System.out.println("delta pressure: " + cylinder_pressure);
   }
}
