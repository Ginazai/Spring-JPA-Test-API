package com.dashboard.Config;
<<<<<<< HEAD
import java.util.Arrays;

=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
import org.springframework.security.config.Customizer;
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
<<<<<<< HEAD
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
<<<<<<< HEAD
	    http.cors(Customizer.withDefaults())
	    .csrf(csrf -> csrf.disable())
=======
	    http.csrf(csrf -> csrf.disable())
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
	    .exceptionHandling(exception -> exception
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Token invalido o no proporcionado");
                })
            )
	        .sessionManagement(session -> session
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        )
	        .authorizeHttpRequests(auth -> auth
	        	.antMatchers(HttpMethod.POST, "/login").permitAll()
<<<<<<< HEAD
	        	.antMatchers("/register").permitAll()
	            .antMatchers("/productos").hasAuthority("ROLE_USER")
	            .antMatchers("/productos/**").hasAuthority("ROLE_USER")
	            .antMatchers("/categorias").hasAuthority("ROLE_USER")
	            .antMatchers("/categorias/**").hasAuthority("ROLE_USER")
=======
	            .antMatchers("/productos").permitAll()
	            .antMatchers("/productos/**").permitAll()
	            .antMatchers("/register").permitAll()
	            .antMatchers("/categorias").permitAll()
	            .antMatchers("/categorias/**").permitAll()
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
	            .antMatchers("/usuarios/**").hasRole("ADMIN")
	            .antMatchers(HttpMethod.GET,"/usuarios").hasAuthority("ROLE_ADMIN")
	            .antMatchers(HttpMethod.POST,"/usuarios").hasAuthority("ROLE_ADMIN")
	            .antMatchers(HttpMethod.PUT,"/usuarios").hasAuthority("ROLE_ADMIN")
<<<<<<< HEAD
	            .antMatchers(HttpMethod.DELETE,"/usuarios").hasAuthority("ROLE_ADMIN")
=======
	            .antMatchers(HttpMethod.PUT,"/usuarios").hasAuthority("ROLE_ADMIN")
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
	            .anyRequest().authenticated()
	        )
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Configurar codificación para contraseñas
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
<<<<<<< HEAD
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf

}
