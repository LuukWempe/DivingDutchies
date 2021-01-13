package nl.luuk.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class websiteControllerTest {
	
	@Autowired
	private WebsiteController websiteController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(websiteController).isNotNull();
	}
	
	@Test
	public void testHomeMapping() {
		assertThat(this.websiteController.home().contains("website/home"));	
	}

}
