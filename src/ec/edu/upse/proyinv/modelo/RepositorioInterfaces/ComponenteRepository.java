package ec.edu.upse.proyinv.modelo.RepositorioInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.proyinv.modelo.Componente;
@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long>{

}
