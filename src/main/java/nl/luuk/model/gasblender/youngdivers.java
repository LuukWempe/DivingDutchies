package nl.luuk;

import nl.luuk.BlendMethod;
import nl.luuk.model.PartialBlender;
import nl.luuk.ContinuesBlender;
import nl.luuk.Compressor;
import nl.luuk.Cylinder;
import nl.luuk.TopOffGas;


public class youngdivers {

  public static void main(String[] args) {
    System.out.println("Hello World!"); 
    Cylinder c1 = new Cylinder(21, 79, 0, 10, 50); 
    Cylinder c2 = new Cylinder(32, 68, 0, 10, 220);
    Compressor c = new Compressor(200);
    BlendMethod bm = BlendMethod.PARTIAL;
    switch (bm){
      case PARTIAL: 
        Blender b = new PartialBlender(c1, c2, TopOffGas.AIR, c); 
        b.blend().toString();
        break;
        
      case CONTINUES:
        Blender b = new ContinuesBlender(c1, c2, TopOffGas.AIR, C);
        b.blend().toString();
        break;
        
      default:
        System.out.println("Unknown blender type");
    }
    
  }
}
