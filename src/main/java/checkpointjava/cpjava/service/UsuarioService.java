package checkpointjava.cpjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import checkpointjava.cpjava.domain.Usuario;
import checkpointjava.cpjava.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = repo.findByUsername(username);
		if (usuario.isPresent()) {
			var userObj = usuario.get();
			System.out.println(userObj.getSenha());

			return User.builder().username(userObj.getUsername()).password(userObj.getSenha()).build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
