package checkpointjava.cpjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import checkpointjava.cpjava.domain.Brinquedo;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {

}
