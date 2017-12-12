package ec.edu.upse.proyinv.modelo.RepositorioInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.proyinv.modelo.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {

}
