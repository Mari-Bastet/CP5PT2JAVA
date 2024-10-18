package checkpointjava.cpjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import checkpointjava.cpjava.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	@Query(" from Usuario u where username = :username")
	Optional<Usuario> findByUsername(@Param("username") String username);
}
