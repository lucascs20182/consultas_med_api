package br.edu.unifeso.apiconsultasmed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.unifeso.apiconsultasmed.security.AuthService;
import br.edu.unifeso.apiconsultasmed.security.JWTAutheticationFilter;
import br.edu.unifeso.apiconsultasmed.security.JWTAuthorizationFilter;
import br.edu.unifeso.apiconsultasmed.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthService service;
	
	@Autowired
	JWTUtil jwtUtil;
	
	private static final String[] AUTH_WHITELIST = { "/create", "/swagger-ui/**" };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers(AUTH_WHITELIST).permitAll()
		.anyRequest().authenticated();
		http.addFilterBefore(new JWTAutheticationFilter(authenticationManager(),jwtUtil), 
				UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(service).passwordEncoder(bCryptPasswordEncoder());
	}
}
