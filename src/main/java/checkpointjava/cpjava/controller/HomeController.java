package checkpointjava.cpjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import checkpointjava.cpjava.domain.Brinquedo;
import checkpointjava.cpjava.repository.BrinquedoRepository;

@Controller
public class HomeController {

	@Autowired
	BrinquedoRepository repo;
	
	
	@GetMapping
	public String retornaTodosBrinquedos(Model model){
		
	List<Brinquedo> brinquedos = repo.findAll();	
	model.addAttribute("brinquedos",brinquedos);
	return "index";
		
	
	}
	}
