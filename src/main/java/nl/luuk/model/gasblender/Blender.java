package nl.luuk.model.gasblender;

public class Blender {

   Cylinder start_cyl;	
   Cylinder current_cyl;
   Cylinder desired_cyl;
   BlendMethod blendMethod;
   Compressor compressor;
   BlendPlan blendPlan;
   
   //Constructors
   public Blender(){}
   
   public Blender(Cylinder start_cyl, Cylinder current_cyl, Cylinder desired_cyl, Compressor compressor){
	 this.start_cyl = start_cyl;
	 //set the current_cylinder equal to the starting_cylinder
     this.current_cyl = start_cyl;
     this.desired_cyl = desired_cyl;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
   
   public Cylinder generateDelta(){
       double delta_o2 = desired_cyl.o2_vol - start_cyl.o2_vol;
       double delta_n2 = desired_cyl.n2_vol - start_cyl.n2_vol;
       double delta_he = desired_cyl.he_vol - start_cyl.he_vol;
       double delta_press = desired_cyl.cyl_press - start_cyl.cyl_press;
       int size = start_cyl.cyl_size;
       Cylinder delta_cyl = new Cylinder(delta_o2, delta_n2, delta_he, delta_press);
       //delta_cyl.printAttribute();
       return delta_cyl;
   }
   
   public Cylinder generateDelta(Cylinder c){
       c.o2_vol = desired_cyl.o2_vol - current_cyl.o2_vol;
       c.n2_vol = desired_cyl.n2_vol - current_cyl.n2_vol;
       c.he_vol = desired_cyl.he_vol - current_cyl.he_vol;
       c.cyl_press = desired_cyl.cyl_press - current_cyl.cyl_press;
       c.cyl_size = current_cyl.cyl_size;
       c.printAttribute();
       return c;
   }
}