package ec.edu.upse.proyinv.ws;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import ec.edu.upse.proyinv.modelo.CarreraPersona;
import ec.edu.upse.proyinv.modelo.Facultad;
import ec.edu.upse.proyinv.modelo.Pai;
import ec.edu.upse.proyinv.modelo.Persona;
import ec.edu.upse.proyinv.modelo.Privilegio;
import ec.edu.upse.proyinv.modelo.Universidad;
import ec.edu.upse.proyinv.modelo.Usuario;
import ec.edu.upse.proyinv.modelo.UsuarioPrivilegio;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.CarreraPersonaRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.FacultadRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.PaisRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.PersonaRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.PrivilegioRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.UniversidadRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.UsuarioPrivilegioRepository;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.UsuarioRepository;

@RestController
@RequestMapping(value="/registro")
public class WsRegistro {
	@Autowired
	PaisRepository paisRepository;
	
	@Autowired
	UniversidadRepository universidadRepository;
	
	@Autowired
	FacultadRepository facultadRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CarreraPersonaRepository carreraPersonaRepository;
	
	@Autowired
	PrivilegioRepository privilegioRepository;
	
	@Autowired
	UsuarioPrivilegioRepository usuarioPrivilegioRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	/*
	 * lista de paises en Json
	 * */
	@RequestMapping(value="/paises",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Pai> getPaises(){
		List<Pai> lista = new ArrayList<Pai>();
		lista=paisRepository.findAll();
		return lista;
	}
	/*
	 * lista de universidades
	 */
	@RequestMapping(value="/universidades",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Universidad> getUniversidad(){
		List<Universidad> lista = new ArrayList<Universidad>();
		lista=universidadRepository.findAll();
		return lista;
	}
	
	/*
	 * lista de privilegios
	 */
	@RequestMapping(value="/privilegios",
			method= RequestMethod.GET,
			headers="Accept=application/json")
	public List<Privilegio> getprivegios(){
		List<Privilegio> lista = new ArrayList<Privilegio>();
		lista=privilegioRepository.findAll();
		return lista;
	}
	
	/*
	 * grabar persona
	 */
	@RequestMapping(value = "/registrapersona/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrapersona(@RequestBody Persona persona, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(persona);     
	        return personaRepository.save(persona);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
	/*
	 * grabar CarreraPersona
	 */
	@RequestMapping(value = "/registracarrerapersona/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registracarrerapersona(@RequestBody CarreraPersona carrerapersona, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(carrerapersona);
	        return carreraPersonaRepository.save(carrerapersona);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	/*
	 * grabar Usuario
	 */
	@RequestMapping(value = "/registrausuario/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrausuario(@RequestBody Usuario usuario, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(usuario);
			System.out.println("1");
	        return usuarioRepository.save(usuario); 
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	/*
	 * grabar UsuarioPrivilegio
	 */
	@RequestMapping(value = "/registrausuarioprivilegio/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrausuarioprivilegio(@RequestBody UsuarioPrivilegio usuarioprivilegio, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(usuarioprivilegio);
	        return usuarioPrivilegioRepository.save(usuarioprivilegio); 
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	/*
	 * lista de facultades por universidad
	 */
	@RequestMapping(value = "/facultades/{universidad}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public List<Facultad> getFacultadPorUniversidad(@PathVariable Long universidad) {
		return facultadRepository.facultadPorUniversidad(universidad);
	}
	
	
	
	/*
	 * grabar un usuario
	 */
	@RequestMapping(value = "/registrausuario/{datouper}/{datousu}/{datocarper}", 
	        method = RequestMethod.GET,
	        headers="Accept=application/json") 
	public Persona registroUsuario(@PathVariable String datouper,@PathVariable String datousu,@PathVariable String datocarper) {
		
		System.out.println(datouper);
		System.out.println(datousu);
		System.out.println(datocarper);
		
		return null;
	}
	/*
	 * forma de escribir un metodo post
	 
	@RequestMapping(value = "/registrausuarioprueba/", 
	        method = RequestMethod.POST) 
	public ResponseEntity<String> registroUsuarioJson(@RequestBody String json) {
		System.out.println(json);
		return new ResponseEntity(HttpStatus.CREATED);
	}*/
	 
	/*
	 * guarda una persona, metodo de prueba
	 */
	@RequestMapping(value = "/registraperson/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Persona registroUsuarioJson2(@RequestBody Persona persona, HttpServletResponse response) {
		try {
			//System.out.println(persona);
			Preconditions.checkNotNull(persona);
	        personaRepository.save(persona);      
	        return persona;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
		
	}
	
	/*
	 * graba en dos tablas CarreraPersona y Persona... fallido!!!
	 */
	@RequestMapping(value = "/registracarper/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrocarrerapersona(@RequestBody String carrerapersona) {
		try {
		
			//CarreraPersona carreraPersona2;
			
			System.out.println(carrerapersona.toString());
			Preconditions.checkNotNull(carrerapersona);
			//carreraPersonaRepository.save(carrerapersona);      
	        return carrerapersona;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
		
	}
}
