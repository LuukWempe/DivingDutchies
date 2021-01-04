package nl.luuk.model.gasblender;

public class Blender {

   Cylinder start_cyl;	
   Cylinder current_cyl;
   Cylinder desired_cyl;
   String blendMethod;
   Compressor compressor;
   BlendPlan blendPlan;
   double topOff_o2_fraction;
   
   //Constructors
   public Blender(){
	   this.start_cyl = new Cylinder();
	   this.desired_cyl = new Cylinder();
	   this.current_cyl = start_cyl;
	   this.compressor = new Compressor();
	   this.blendPlan = new BlendPlan();
	   this.topOff_o2_fraction = 0.21;
   }
   
   public Blender(Cylinder start_cyl, Cylinder desired_cyl, Compressor compressor){
	 this.start_cyl = start_cyl;
	 //set the current_cylinder equal to the starting_cylinder
     this.current_cyl = start_cyl;
     this.desired_cyl = desired_cyl;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
     this.topOff_o2_fraction = 0.21;
   }
   
   public Cylinder generateDelta(){
       double delta_o2 = desired_cyl.o2_vol - start_cyl.o2_vol;
       double delta_n2 = desired_cyl.n2_vol - start_cyl.n2_vol;
       double delta_he = desired_cyl.he_vol - start_cyl.he_vol;
       double delta_press = desired_cyl.cyl_press - start_cyl.cyl_press;
       double size = start_cyl.cyl_size;
       Cylinder delta_cyl = new Cylinder(delta_o2, delta_n2, delta_he, delta_press);
       System.out.println("inside generateDelta() ");
       delta_cyl.printAttribute();
       return delta_cyl;
   }
   
   public Cylinder generateDelta(Cylinder c){
       c.o2_vol = desired_cyl.o2_vol - current_cyl.o2_vol;
       c.n2_vol = desired_cyl.n2_vol - current_cyl.n2_vol;
       c.he_vol = desired_cyl.he_vol - current_cyl.he_vol;
       c.cyl_press = desired_cyl.cyl_press - current_cyl.cyl_press;
       c.printAttribute();
       return c;
   }

public Cylinder getStart_cyl() {
	return start_cyl;
}

public void setStart_cyl(Cylinder start_cyl) {
	this.start_cyl = start_cyl;
}

public Cylinder getCurrent_cyl() {
	return current_cyl;
}

public void setCurrent_cyl(Cylinder current_cyl) {
	this.current_cyl = current_cyl;
}

public Cylinder getDesired_cyl() {
	return desired_cyl;
}

public void setDesired_cyl(Cylinder desired_cyl) {
	this.desired_cyl = desired_cyl;
}

public String getBlendMethod() {
	return blendMethod;
}

public void setBlendMethod(String blendMethod) {
	this.blendMethod = blendMethod;
}

public Compressor getCompressor() {
	return compressor;
}

public void setCompressor(Compressor compressor) {
	this.compressor = compressor;
}

public BlendPlan getBlendPlan() {
	return blendPlan;
}

public void setBlendPlan(BlendPlan blendPlan) {
	this.blendPlan = blendPlan;
}

public double getTopOff_o2_fraction() {
	return topOff_o2_fraction;
}

public void setTopOff_o2_fraction(double topOff_o2_fraction) {
	this.topOff_o2_fraction = topOff_o2_fraction;
}
   
   
}