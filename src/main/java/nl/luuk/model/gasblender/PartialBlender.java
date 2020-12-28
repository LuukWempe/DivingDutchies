package nl.luuk.model.gasblender;

public class PartialBlender extends Blender {

  public PartialBlender(){
     
  }
  
  public PartialBlender(Cylinder current_cylinder, Cylinder desired_cylinder, Compressor compressor){
     this.current_cylinder = current_cylinder;
     this.desired_cylinder = desired_cylinder;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
  
  

  public BlendPlan blend(Cylinder delta, double topOff_o2_fraction) {
	  
	  //TopOff gas needs to be a fraction of Oxygen and Nitrogen.
	  
	  //Determine how much O2 needs to be added if > 0, pure O2 is added first, if < 0, some gas needs to be vented first
	  double o2_add = (delta.o2_fraction - ((delta.n2_fraction / (1-topOff_o2_fraction)) * topOff_o2_fraction)) / current_cylinder.cylinder_size;
	  
	  if (o2_add > 0) { // The initial cylinder contects is not to rich for partial blending
		  double air_add = (delta.n2_fraction / (1 - topOff_o2_fraction)) / current_cylinder.cylinder_size;
		  double he_add = delta.he_fraction / current_cylinder.cylinder_size;
		  blendPlan.taskList.add("Add " + String.format("%.1f",o2_add) + " Bar of pure O2");
		  blendPlan.taskList.add("Add " + String.format("%.1f",he_add) + " Bar of Helium");
		  blendPlan.taskList.add("Add " + String.format("%.1f",air_add) + " Bar of air");
		  blendPlan.taskList.add("Resulting mix is: " + 
				  				String.format("%.0f", (desired_cylinder.o2_fraction*100)) + "/" + 
				  				String.format("%.0f", (desired_cylinder.he_fraction*100)) + "/" + 
				  				String.format("%.0f", (desired_cylinder.n2_fraction*100)) + "  [O2/He/N2]");
				  				
	  } else { 
		  System.out.println("Gas needs to be vented");
		  double gas_vent = 0;
		  
		  //Release pressure until the O2 content is low enough to top of with the desired gas
		  while (o2_add < 0 && current_cylinder.cylinder_pressure > 0) {
			  current_cylinder.cylinder_pressure -= 1;
			  gas_vent += 1.0;
			  delta = generateDelta();
			  o2_add = (delta.o2_fraction - ((delta.n2_fraction / (1-topOff_o2_fraction)) * topOff_o2_fraction)) / current_cylinder.cylinder_size;		  
			  //System.out.println(current_cylinder.cylinder_pressure);
			  //System.out.println(gas_vent);
			  //System.out.println(o2_add);
		  }
		  
		  double air_add = (delta.n2_fraction / (1 - topOff_o2_fraction)) / current_cylinder.cylinder_size;
		  double he_add = delta.he_fraction / current_cylinder.cylinder_size;
		  blendPlan.taskList.add("Vent " + String.format("%.1f", gas_vent) + " Bar of gas from the cylinder");
		  blendPlan.taskList.add("Add " + String.format("%.1f",o2_add) + " Bar of pure O2");
		  blendPlan.taskList.add("Add " + String.format("%.1f",he_add) + " Bar of Helium");
		  blendPlan.taskList.add("Add " + String.format("%.1f",air_add) + " Bar of air");
		  
	  }
	  return blendPlan;
	  }
}
