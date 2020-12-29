package nl.luuk.services;

import org.springframework.stereotype.Service;

import nl.luuk.model.gasblender.Blender;
import nl.luuk.model.gasblender.ContinuesBlender;
import nl.luuk.model.gasblender.PartialBlender;

@Service
public class GasBlenderService {
	
	public void blend(Blender blender) { 
    
    
    //Create a Partial or Continues Blender depending on the BlendingMethod
    switch (blender.getBlendMethod()){
      case PARTIAL: 
        PartialBlender pb = new PartialBlender(blender.getStart_cyl(), blender.getDesired_cyl(), blender.getCompressor()); 
        pb.blend(pb.generateDelta(), blender.getTopOff_o2_fraction());
        break;
        
      case CONTINUES:
        ContinuesBlender cb = new ContinuesBlender(blender.getStart_cyl(), blender.getDesired_cyl(), blender.getCompressor());
        cb.blend(cb.generateDelta(), blender.getTopOff_o2_fraction());
        break;
        
      default:
        System.out.println("Unknown blender type");
    	}
	}

	public Blender getBlender() {
		Blender blender = new Blender();
		return blender;
	}
}
