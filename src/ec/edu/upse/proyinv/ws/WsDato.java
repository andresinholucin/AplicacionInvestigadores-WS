package ec.edu.upse.proyinv.ws;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;





import ec.edu.upse.proyinv.modelo.Dato;
import ec.edu.upse.proyinv.modelo.RepositorioInterfaces.DatoRepository;


@RestController
@RequestMapping(value="/Dato")
public class WsDato {
	
	@Autowired
	DatoRepository datoRepository;


	 
	@Value("${server.hostname}")
    private String serverHostname;

    @Value("${server.bucket}")
    private String serverBucket;

    @Value("${server.password}")
    private String serverPassword;
    
    @Value("${bucket.password}")
    private String serverBucketPassword;

    @Value("${gateway.hostname}")
    private String gatewayHostname;
    
    @Value("${gateway.database}")
    private String gatewayDatabase;
    
    @Value("${server.username}")
    private String serverUsername;

	@RequestMapping(value="/",
			method= RequestMethod.GET,
			headers="Accept=application/json")
		public List<Dato> getDato(){
		List<Dato> lista= new ArrayList<Dato>();
		lista=datoRepository.findAll();
		return lista;
		}
	
	
	
	@RequestMapping(value="/prueba/{valor}", 
	 	    method= RequestMethod.GET)
		public Object getObtener(@PathVariable("valor") String valor) {

		System.out.println(valor);
		return (valor);
   }
	
	@RequestMapping(value="/prueba2/{valor}/{llave}", 
	 	    	    method= RequestMethod.GET)
		public Object getObtener2(@PathVariable("valor") String valor,@PathVariable("llave") String llave) {

		System.out.println(valor+"  "+llave);
		String a=valor+"  ,  "+llave;
		return (a);
   }
}
