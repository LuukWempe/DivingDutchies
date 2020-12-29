package nl.luuk.model.gasblender;

public class Compressor {

    int capacity; //in Liters/minute
    
    public Compressor() {
    	this.capacity = 1;
    }
    
    public Compressor(int capacity){
      this.capacity = capacity;
    }

}
