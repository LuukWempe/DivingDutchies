package nl.luuk.model.gasblender;

public class Cylinder {

   int o2_fraction;
   int n2_fraction;
   int he_fraction;
   int cylinder_size;
   int cylinder_pressure;
   
   //Constructors
   public Cylinder(){}
   
   public Cylinder(int o2_fraction, int n2_fraction, int he_fraction, int cylinder_size, int cylinder_pressure){
     this.o2_fraction = o2_fraction;
     this.n2_fraction = n2_fraction;
     this.he_fraction = he_fraction;
     this.cylinder_size = cylinder_size;
     this.cylinder_pressure = cylinder_pressure;
   }     
}
