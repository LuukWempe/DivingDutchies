package nl.luuk.services;

import org.springframework.stereotype.Service;

import nl.luuk.model.gasblender.BlendPlan;
import nl.luuk.model.gasblender.Blender;
import nl.luuk.model.gasblender.BlenderDao;
import nl.luuk.model.gasblender.Compressor;
import nl.luuk.model.gasblender.ContinuesBlender;
import nl.luuk.model.gasblender.Cylinder;
import nl.luuk.model.gasblender.PartialBlender;

@Service
public class GasBlenderService {
	
	public BlendPlan blend(Blender blender) { 
    BlendPlan blendPlan = new BlendPlan();
    
    //Create a Partial or Continues Blender depending on the BlendingMethod
    switch (blender.getBlendMethod()){
      case "PARTIAL": 
        PartialBlender pb = new PartialBlender(blender.getStart_cyl(), blender.getDesired_cyl(), blender.getCompressor()); 
        blendPlan = pb.blend(pb.generateDelta(), blender.getTopOff_o2_fraction());
        break;
        
      case "CONTINUES":
        ContinuesBlender cb = new ContinuesBlender(blender.getStart_cyl(), blender.getDesired_cyl(), blender.getCompressor());
        blendPlan =cb.blend(cb.generateDelta(), blender.getTopOff_o2_fraction());
        break;
        
      default:
        System.out.println("Unknown blender type");
    	}
    
    	return blendPlan;
	}


	
	public BlenderDao getBlenderDao() {
		return new BlenderDao();
	}
	
	public static BlendPlan startBlender(BlenderDao bd) {
		
		//Create the cylinder from the BlenderDao
		Cylinder c1 = new Cylinder(bd.getC1_o2()/100, bd.getC1_n2()/100, bd.getC1_he()/100, bd.getC1_size(), bd.getC1_pressure());
		Cylinder c2 = new Cylinder(bd.getC2_o2()/100, bd.getC2_n2()/100, bd.getC2_he()/100, bd.getC2_size(), bd.getC2_pressure());
		
		//Create the cylinder from the BlenderDao
		Compressor comp = new Compressor();
		
		//Create the cylinder from the BlenderDao
		BlendPlan plan = new BlendPlan();
		
		//Create the correct child of Blender, dependent of the BlendMethod 
		//and blend the gas to create the BlendPlan
		switch (bd.getBm()) {
		case "PARTIAL":
			PartialBlender pb = new PartialBlender(c1,c2,comp);
			plan = pb.blend(pb.generateDelta(), bd.getTopOff()/100);
			break;
		case "CONTINUES":
			ContinuesBlender cb = new ContinuesBlender(c1,c2,comp);
			plan = cb.blend(cb.generateDelta(), bd.getTopOff()/100);
			break;
		}

		//return the BlendPlan
		return plan;
	}
}
