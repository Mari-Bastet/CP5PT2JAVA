package checkpointjava.cpjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import checkpointjava.cpjava.domain.Usuario;
import checkpointjava.cpjava.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository repo;
	
	@GetMapping("bri/login")
	public String retornaLogin()
	{
		return "login";
	}

//	@PostMapping("/bri/login")
//	public String login(@RequestParam String username, @RequestParam String password, Model model) {
//
//		Usuario user = repo.findByUsername(username);
//
//		if (user != null) {
//
//			if (user.getSenha().equals(password)) {
//
//				model.addAttribute(user);
//				return "index";
//			}
//
//		}
//
//		return "login";
//
//	}

	@GetMapping("/bri/signup")
	public String signup() {
		return "signup";

	}
}
