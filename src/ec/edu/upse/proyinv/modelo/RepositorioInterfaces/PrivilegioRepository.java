package ec.edu.upse.proyinv.modelo.RepositorioInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.proyinv.modelo.Privilegio;
@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Long>{

}
