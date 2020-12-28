package nl.luuk.model;

import nl.luuk.TopOffGas;
import nl.luuk.Blender;
import nl.luuk.Cylinder;
import nl.luuk.BlendPlan;


public class PartialBlender extends Blender {

  public PartialBlender(){
     
  }
  
  public PartialBlender(Cylinder current_cylinder, Cylinder desired_cylinder, TopOffGas topOffGas, Compressor compressor){
     this.current_cylinder = current_cylinder;
     this.desired_cylinder = desired_cylinder;
     this.blendMethod = blendMethod;
     this.topOffGas = topOffGas;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
  
  public BlendPlan blend(BlendPlan bp, Cylinder delta){
   
     switch(topOffGas){
       case TopOffGas.AIR:
       bp.taskList.add("Partialy blending with AIR top off");
         break;
         
       case TopOffGas.O2:
       bp.taskList.add("Partialy blending with O2 top off");
         break;
       
       default:
       bp.taskList.add("Unknown top off gas");
     }
     return bp;
   }
}
