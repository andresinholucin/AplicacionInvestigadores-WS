package ec.edu.upse.proyinv.modelo.RepositorioInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.proyinv.modelo.EnunciadoCampo;

@Repository
public interface EnunciadoCampoRepository extends JpaRepository<EnunciadoCampo, Long>{

}
