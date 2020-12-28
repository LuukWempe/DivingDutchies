package nl.luuk.model.gasblender;

public class Blender {

   Cylinder current_cylinder;
   Cylinder desired_cylinder;
   BlendMethod blendMethod;
   Compressor compressor;
   BlendPlan blendPlan;
   
   //Constructors
   public Blender(){}
   
   public Blender(Cylinder current_cylinder, Cylinder desired_cylinder, Compressor compressor){
     this.current_cylinder = current_cylinder;
     this.desired_cylinder = desired_cylinder;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
   
   public Cylinder generateDelta(){
       double delta_o2 = ((desired_cylinder.o2_fraction * desired_cylinder.cylinder_pressure) - (current_cylinder.o2_fraction * current_cylinder.cylinder_pressure))* current_cylinder.cylinder_size;
       double delta_n2 = ((desired_cylinder.n2_fraction * desired_cylinder.cylinder_pressure) - (current_cylinder.n2_fraction * current_cylinder.cylinder_pressure))* current_cylinder.cylinder_size;
       double delta_he = ((desired_cylinder.he_fraction * desired_cylinder.cylinder_pressure) - (current_cylinder.he_fraction * current_cylinder.cylinder_pressure))* current_cylinder.cylinder_size;
       int delta_press = desired_cylinder.cylinder_pressure - current_cylinder.cylinder_pressure;
       int size = current_cylinder.cylinder_size;
       Cylinder delta_cylinder = new Cylinder(delta_o2, delta_n2, delta_he, size, delta_press);
       //delta_cylinder.printAttribute();
       return delta_cylinder;
   }
}