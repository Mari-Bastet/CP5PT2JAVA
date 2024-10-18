package checkpointjava.cpjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import checkpointjava.cpjava.domain.Usuario;
import checkpointjava.cpjava.repository.UsuarioRepository;

@Controller
public class SignupController {

    @Autowired
    UsuarioRepository repo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping(value = "/bri/signup")
    public Usuario createUser(@RequestParam String username, @RequestParam String senha) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setSenha(passwordEncoder.encode(senha));
        System.out.println("senha:"+usuario.getSenha());
        System.out.println("senanormal:" + senha);
        return repo.save(usuario);
    }
}
