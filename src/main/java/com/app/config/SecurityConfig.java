package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        // El httpSecurity es el filtro que pasa por todo el flujo de peticiones
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests( http -> {
//                    // configurar los end points publico
//                    http.requestMatchers(HttpMethod.GET,"/auth/hello").permitAll();
//                    // Configurar los end poitns privados
//                    http.requestMatchers(HttpMethod.GET,"/auth/hello-secured").hasAuthority("CREATE");
//                    // Configuar el resto de endpoints - No Especificados
//                    //Recomendabble es el http.anyRequest().denyAll();
//                    http.anyRequest().denyAll(); // Rechaza todo lo que no esta especificado
//                 //   http.anyRequest().authenticated(); //Cualquier otra request debe estar autenticado
//                })
//                .build();
//    }


    //Trabajar con notaciones
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        // El httpSecurity es el filtro que pasa por todo el flujo de peticiones
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // El authenticationManager es el que se encarga de autenticar las credenciales
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(
                User.withUsername("edwin")
                        .password("1234")
                        .roles("ADMIN")
                        .authorities("READ","CREATE")
                        .build());

        userDetailsList.add(
                User.withUsername("ricardo")
                        .password("1234")
                        .roles("USER")
                        .authorities("READ")
                        .build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); // es Para hacer las pruebas
        // return new BCryptPasswordEncoder(); // es Para producción
    }

// https://www.youtube.com/watch?v=IPWBQDMIYkc
    // minuto 54


}
