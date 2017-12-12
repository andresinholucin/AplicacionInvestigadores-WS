package ec.edu.upse.proyinv.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.upse.proyinv.modelo.Usuario;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.UsuarioRepository;

@RestController
@RequestMapping(value="/Usuario")
public class WsUsuario {

	@Autowired
	UsuarioRepository usuariorepository;
	
	/*
	 * obtener lista de usuarios 
	 */
	@RequestMapping(value="/",
					method= RequestMethod.GET,
					headers="Accept=application/json")
	public List<Usuario> getUsuarios(){
		List<Usuario> lista= new ArrayList<Usuario>();
		lista=usuariorepository.findAll();
		return lista;
	}
	/*
	 * obtener Usuario con Id de parametro
	 */
	@RequestMapping(value = "/buscaPorId/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public Usuario getusuario(@PathVariable long id){
		return usuariorepository.findOne(id);
	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/busca/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public String getcadena(){
		//instanciar usuario por ejemplo
		//llenas
		//conviertes objeto usuario a string formato json
		//y transmitir como cadena
		String cadena="{\"records\":[{\"Name\":\"1\",\"City\":\"123\",\"Country\":\"A\"}]}";
		System.out.println(cadena);
		return cadena;
	}
}
