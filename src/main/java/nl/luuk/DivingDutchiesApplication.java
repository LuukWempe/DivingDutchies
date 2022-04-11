package nl.luuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.luuk.model.gasblender.BlendMethod;
import nl.luuk.model.gasblender.Compressor;
import nl.luuk.model.gasblender.ContinuesBlender;
import nl.luuk.model.gasblender.Cylinder;
import nl.luuk.model.gasblender.PartialBlender;

@SpringBootApplication
public class DivingDutchiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivingDutchiesApplication.class, args);
		
		System.out.println("Hello World!"); 
	    Cylinder c1 = new Cylinder(0.21, 0.79, 0.00, 10, 50); 
	    Cylinder c2 = new Cylinder(0.17, 0.48, 0.35, 10, 220);
	    Compressor c = new Compressor(200);
	    BlendMethod bm = BlendMethod.PARTIAL;
	    
	    //Create a Partial or Continues Blender depending on the BlendingMethod
	    switch (bm){
	      case PARTIAL: 
	        PartialBlender pb = new PartialBlender(c1, c2, c); 
	        pb.blend(pb.generateDelta(), 0.21).toString();
	        break;
	        
	      case CONTINUES:
	        ContinuesBlender cb = new ContinuesBlender(c1, c2, c);
	        cb.blend(cb.generateDelta(), 0.21).toString();
	        break;
	        
	      default:
	        System.out.println("Unknown blender type");
	    }
	}

}