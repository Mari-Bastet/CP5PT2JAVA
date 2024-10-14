package checkpointjava.cpjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import checkpointjava.cpjava.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(" from Usuario u where username = :username")
	Usuario findByUsername(@Param("username") String username);
}
