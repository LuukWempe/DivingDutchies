package nl.luuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.luuk.model.gasblender.BlendPlan;
import nl.luuk.model.gasblender.BlenderDao;
import nl.luuk.services.GasBlenderService;

@SpringBootApplication
public class YoungdiversApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoungdiversApplication.class, args);
		//BlenderDao bd = new BlenderDao((long) 1,21,79,0,10,0,17,48,35,10,200,"PARTIAL", 21, "test");
		//BlendPlan plan = GasBlenderService.startBlender(bd);
		//System.out.println(plan.toString());
	    }
	}
