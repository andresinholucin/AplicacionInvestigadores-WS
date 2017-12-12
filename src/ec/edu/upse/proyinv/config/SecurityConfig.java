package ec.edu.upse.proyinv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import ec.edu.upse.proyinv.seguridad.MySavedRequestAwareAuthenticationSuccessHandler;
import ec.edu.upse.proyinv.seguridad.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@ComponentScan("ec.edu.upse.proyinv.seguridad")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler
	authenticationSuccessHandler;

	public SecurityConfig() {
		super();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		
		// Usuarios y clave en memoria, esto debe cambiar cuando se autentica contra una base de datos.
        auth.inMemoryAuthentication()
          .withUser("temporary").password("temporary").roles("ADMIN")
          .and()
          .withUser("user").password("userPass").roles("USER");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
		.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(restAuthenticationEntryPoint)
		.and()
		.authorizeRequests()
		.antMatchers("/api/usuario/**").authenticated()
		.and()
		.formLogin()
		.successHandler(authenticationSuccessHandler)
		.failureHandler(new SimpleUrlAuthenticationFailureHandler())
		.and()
		.logout();
	}

	@Bean
	public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
		return new MySavedRequestAwareAuthenticationSuccessHandler();
	}
	@Bean
	public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
		return new SimpleUrlAuthenticationFailureHandler();
	}

}
