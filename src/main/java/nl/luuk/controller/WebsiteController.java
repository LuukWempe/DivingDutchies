package nl.luuk.controller;

import nl.luuk.database.BlenderDaoRepository;
import nl.luuk.database.DiverRepository;
import nl.luuk.model.gasblender.BlendMethod;
import nl.luuk.model.gasblender.BlendPlan;
import nl.luuk.model.gasblender.Blender;
import nl.luuk.model.gasblender.BlenderDao;
import nl.luuk.model.gasblender.ContinuesBlender;
import nl.luuk.model.gasblender.PartialBlender;
import nl.luuk.services.DiverService;
import nl.luuk.services.GasBlenderService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebsiteController {
	

	@Autowired
	private DiverService diverService;
	
	@Autowired
	private GasBlenderService gbs;
	
	@Autowired
	private DiverRepository diverRepository;
	
	@Autowired  //more session friendly
	private BlenderDaoRepository blenderDaoRepository;
	
	@Autowired
	public WebsiteController() {}
	
	private static final Logger logger = LoggerFactory.getLogger(WebsiteController.class);
	
	@GetMapping({"/home","/"})
	public String home() {
		return "website/home";
	}
	
	@GetMapping("/error")
	public String error() {
		return "website/error";
	}
	
	@GetMapping("/ssispecialty")
	public String ssispecialty() {
		return "website/ssispecialty";
	}
	
	@GetMapping("/photos")
	public String photos() {
		return "website/photos";
	}
	
	@GetMapping("/gasblender")
	public String gasblenderInit(Model model) {
		BlenderDao blenderdao = new BlenderDao();
		blenderDaoRepository.save(blenderdao);
				model.addAttribute("blenderdao", blenderDaoRepository.findByBlenderId(blenderdao.getBlenderId()));
		return "website/gasblender";
	}
	
	@GetMapping("/gasblender/{blenderId}")
	public String gasblender(Model model, @PathVariable("blenderId") long blenderId) {
		model.addAttribute("blenderdao", blenderDaoRepository.findByBlenderId(blenderId));
		model.addAttribute("blendPlan", blenderDaoRepository.findByBlenderId(blenderId).getListBlendPlan());
		return "website/gasblender";
	}
	
	
	@PostMapping("/gasblender/{blenderId}")
	public String postGasBlender(BlenderDao blenderDao, @RequestParam(value="blenderId", required=false) Long blenderId) {
		blenderDaoRepository.save(blenderDao);
		
		//get de blenderId from the repository
		BlendPlan plan = gbs.startBlender(blenderDaoRepository.findByBlenderId(blenderDao.getBlenderId()));
		blenderDao.setBlendPlan(plan.toString());
		blenderDaoRepository.save(blenderDao);
		String id = Long.toString(blenderDao.getBlenderId());
				
		return "redirect:/gasblender/"+ id;
	}

	
	@GetMapping("/calendar")
	public String calendar() {
		return "website/calendar";
	}
	
	@GetMapping("/contactdetails")
	public String contactdetails() {
		return "website/contactdetails";
	}
	
	
}
