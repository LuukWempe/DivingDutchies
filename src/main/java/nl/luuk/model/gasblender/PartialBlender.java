package nl.luuk.model.gasblender;

public class PartialBlender extends Blender {

  public PartialBlender(){}
  
  public PartialBlender(Cylinder start_cyl, Cylinder desired_cyl, Compressor compressor){
     this.start_cyl = start_cyl;
     //set the current cylinder equal to the start cylinder
     this.current_cyl = start_cyl;
     this.desired_cyl = desired_cyl;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
  
  public BlendPlan blend(Cylinder delta, double topOff_o2_fraction) {
	  
	  //TopOff gas needs to be a fraction of Oxygen and Nitrogen.
	  //Determine how much O2 needs to be added if > 0, pure O2 is added first, if < 0, some gas needs to be vented first
	  double o2_add = (delta.o2_vol - ((delta.n2_vol / (1-topOff_o2_fraction)) * topOff_o2_fraction));
	  System.out.println("start of blend() " + o2_add);
	  double gas_vent = 0;
	  
	  //if there is to much oxygen in the cylinder this loop will vent the cylinder 1/2 bar at the time and check is this is enough
	  while (o2_add < 0 && current_cyl.cyl_press > 0) {
		  current_cyl.releasePressure(0.5);
		  gas_vent += 0.5;
		  delta = generateDelta(delta);
		  o2_add = (delta.o2_vol - ((delta.n2_vol / (1-topOff_o2_fraction)) * topOff_o2_fraction));	
		  System.out.println("in while loop" + o2_add + gas_vent);
	  }
	  	  
	  // If gas was vented, add this to the tasklist
	  if (gas_vent != 0) {
		  blendPlan.taskList.add("Vent " + String.format("%.1f", gas_vent) + " Bar of gas from the cyl");  
	  }
	  	  
	  //Add the oxygen to the current cylinder
	  current_cyl.addGas(current_cyl, Gasses.OXYGEN, o2_add);

	  //Add the helium to the current cylinder
	  double he_add = delta.he_vol;
	  current_cyl.addGas(current_cyl, Gasses.HELIUM, he_add);

	  //Add the air to the current cylinder
	  double air_add = (delta.n2_vol / (1 - topOff_o2_fraction));
	  current_cyl.addGas(current_cyl, Gasses.NITROGEN, air_add*(1-topOff_o2_fraction));
	  current_cyl.addGas(current_cyl, Gasses.OXYGEN, air_add*topOff_o2_fraction);

	  //Fill the tasklist with steps and end figures
	  blendPlan.taskList.add("Add " + String.format("%.1f",o2_add/start_cyl.cyl_size) + " Bar of pure O2");
	  blendPlan.taskList.add("Add " + String.format("%.1f",he_add/start_cyl.cyl_size) + " Bar of Helium");
	  blendPlan.taskList.add("Add " + String.format("%.1f",air_add/start_cyl.cyl_size) + " Bar of air");
	  blendPlan.taskList.add("Resulting mix is: " + 
			  String.format("%.0f", (current_cyl.o2_vol/(current_cyl.cyl_press*current_cyl.cyl_size))*100) + "/" + 
			  String.format("%.0f", (current_cyl.he_vol/(current_cyl.cyl_press*current_cyl.cyl_size))*100) + "/" + 
			  String.format("%.0f", (current_cyl.n2_vol/(current_cyl.cyl_press*current_cyl.cyl_size))*100) + " " +
			  "[O2/He/N2]");
	  
	  return blendPlan;
	  }
}
