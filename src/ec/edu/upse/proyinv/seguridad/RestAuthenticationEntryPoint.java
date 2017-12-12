package ec.edu.upse.proyinv.seguridad;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Evita que se envie a la pantalla de login al usuario cuando intenta acceder a un 
 * recurso para el que no tiene autorizacion y en su ugar retorna HTTP 401 (No autorizado)
 * @author Luis
 *
 */
@Component( "restAuthenticationEntryPoint" )
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(
			HttpServletRequest request,
			HttpServletResponse response, 
			AuthenticationException authException) throws IOException {

		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
	}
}
