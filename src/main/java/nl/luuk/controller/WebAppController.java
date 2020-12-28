package nl.luuk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebAppController {
	
	@Autowired
	public WebAppController () {}
	
	@GetMapping("login")
	public String login(){
		return "webapp/login";
	}
	
	@PostMapping("/login")
	public String validateLogin() {
		return "webapp/dashboard";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "website/home";
	}
}
