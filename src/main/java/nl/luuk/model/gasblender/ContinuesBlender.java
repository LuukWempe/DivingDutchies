package nl.luuk.model.gasblender;

import nl.luuk.model.gasblender.ContinuesBlender;


public class ContinuesBlender extends Blender {

   public ContinuesBlender(){}
   
   public ContinuesBlender(Cylinder current_cylinder, Cylinder desired_cylinder, Compressor compressor){
	     this.current_cylinder = current_cylinder;
	     this.desired_cylinder = desired_cylinder;
	     this.compressor = compressor;
	     this.blendPlan = new BlendPlan();
	   }
  
   public BlendPlan blend(Cylinder delta, double topOff_o2_fraction){
	   
     return blendPlan;
   }

}
