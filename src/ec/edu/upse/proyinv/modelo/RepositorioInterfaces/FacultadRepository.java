package ec.edu.upse.proyinv.modelo.RepositorioInterfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.proyinv.modelo.Facultad;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long> {

	@Query("SELECT f FROM Facultad f WHERE f.universidad.idUniversidad = :universidad")
	public List<Facultad> facultadPorUniversidad(@Param("universidad") Long universidad);
	
}
