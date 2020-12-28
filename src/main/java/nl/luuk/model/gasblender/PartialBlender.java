package nl.luuk.model.gasblender;

public class PartialBlender extends Blender {

  public PartialBlender(){
     
  }
  
  public PartialBlender(Cylinder current_cylinder, Cylinder desired_cylinder, TopOffGas topOffGas, Compressor compressor){
     this.current_cylinder = current_cylinder;
     this.desired_cylinder = desired_cylinder;
     this.topOffGas = topOffGas;
     this.compressor = compressor;
     this.blendPlan = new BlendPlan();
   }
  
  public BlendPlan blend(Cylinder delta){
   
     switch(topOffGas){
       case AIR:
       blendPlan.taskList.add("Partialy blending with AIR top off");
         break;
         
       case O2:
       blendPlan.taskList.add("Partialy blending with O2 top off");
         break;
       
       default:
       blendPlan.taskList.add("Unknown top off gas");
     }
     return blendPlan;
   }
}
