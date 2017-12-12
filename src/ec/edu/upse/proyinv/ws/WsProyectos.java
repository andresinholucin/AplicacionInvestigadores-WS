package ec.edu.upse.proyinv.ws;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import ec.edu.upse.proyinv.modelo.Persona;
import ec.edu.upse.proyinv.modelo.Proyecto;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.ProyectoRepository;

@RestController
@RequestMapping(value="/proyectos")
public class WsProyectos {
	@Autowired
	ProyectoRepository proyectoRepository;
	
	/*
	 * lista de proyectos
	 */
	@RequestMapping(value="/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Proyecto> getProyecto(){
		List<Proyecto> lista = new ArrayList<Proyecto>();
		lista=proyectoRepository.findAll();
		return lista;
	}

	/*
	 * lista de interfaces del proyecto
	 */
	@RequestMapping(value="/interfaces/{proyecto}",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Proyecto> getinterfaces(){
		List<Proyecto> lista = new ArrayList<Proyecto>();
		lista=proyectoRepository.findAll();
		
		
		return lista;
	}
	
	
	/*
	 * crear un proyecto
	 */
	@RequestMapping(value = "/registraproyecto/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrapersona(@RequestBody Proyecto proyecto, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(proyecto);     
	        return proyectoRepository.save(proyecto);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
}
