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

import ec.edu.upse.proyinv.modelo.Componente;
import ec.edu.upse.proyinv.modelo.EnunciadoCampo;
import ec.edu.upse.proyinv.modelo.PreviaRespuesta;
import ec.edu.upse.proyinv.modelo.Proyecto;
import ec.edu.upse.proyinv.modelo.TipoVariable;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.ComponenteRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.EnunciadoCampoRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.PreviaRespuestaRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.ProyectoRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.TipoVariableRepository;

@RestController
@RequestMapping(value="/proyectos")
public class WsProyectos {
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@Autowired
	ComponenteRepository componenteRepository;
	
	@Autowired
	EnunciadoCampoRepository enunciadoCampoRepository;
	
	@Autowired
	PreviaRespuestaRepository previaRespuestaRepository;
	
	@Autowired
	TipoVariableRepository tipoVariableRepository;
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
	 * lista de componentes
	 */
	@RequestMapping(value="/componentes/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Componente> getcomponentes(){
		List<Componente> lista = new ArrayList<Componente>();
		lista=componenteRepository.findAll();
		return lista ;
	}
	
	/*
	 * lista de enunciados de los campos mas frecuentes o comunes
	 */
	@RequestMapping(value="/enunciados/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<EnunciadoCampo> getenunciados(){
		List<EnunciadoCampo> lista = new ArrayList<EnunciadoCampo>();
		lista=enunciadoCampoRepository.findAll();
		return lista ;
	}
	
	/*
	 * lista de enunciados de los campos mas frecuentes o comunes
	 */
	@RequestMapping(value="/previarespuesta/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<PreviaRespuesta> getpreviarespuesta(){
		List<PreviaRespuesta> lista = new ArrayList<PreviaRespuesta>();
		lista=previaRespuestaRepository.findAll();
		return lista ;
	}
	
	/*
	 * registro de una respuesta previa
	 */
	@RequestMapping(value = "/registrarespuesta/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrarespuesta(@RequestBody PreviaRespuesta pr, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(pr);     
	        return previaRespuestaRepository.save(pr);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
	/*
	 * tipo de variable
	 */
	@RequestMapping(value="/tipovariable/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public TipoVariable gettipovariable(){
		TipoVariable tv= new TipoVariable();
		tv=tipoVariableRepository.findOne((long)(int)5);
		return tv ;
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
