package nl.luuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.luuk.model.gasblender.BlendMethod;
import nl.luuk.model.gasblender.Blender;
import nl.luuk.model.gasblender.Compressor;
import nl.luuk.model.gasblender.ContinuesBlender;
import nl.luuk.model.gasblender.Cylinder;
import nl.luuk.model.gasblender.PartialBlender;
import nl.luuk.model.gasblender.TopOffGas;

@SpringBootApplication
public class YoungdiversApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoungdiversApplication.class, args);
		
		System.out.println("Hello World!"); 
	    Cylinder c1 = new Cylinder(21, 79, 0, 10, 50); 
	    Cylinder c2 = new Cylinder(32, 68, 0, 10, 220);
	    Compressor c = new Compressor(200);
	    BlendMethod bm = BlendMethod.PARTIAL;
	    
	    //Create a Partial or Continues Blender depending on the BlendingMethod
	    switch (bm){
	      case PARTIAL: 
	        PartialBlender pb = new PartialBlender(c1, c2, TopOffGas.AIR, c); 
	        pb.blend(pb.blendDelta()).toString();
	        break;
	        
	      case CONTINUES:
	        ContinuesBlender cb = new ContinuesBlender(c1, c2, TopOffGas.AIR, c);
	        cb.blend(cb.blendDelta()).toString();
	        break;
	        
	      default:
	        System.out.println("Unknown blender type");
	    }
	}

}
