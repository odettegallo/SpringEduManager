package com.alkemy.edumanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("estudiante")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitado para consumo sencillo de endpoints/H2 en entorno local
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // Permitir consola H2
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/login", "/h2-console/**").permitAll()
                .requestMatchers("/cursos/nuevo", "/cursos/guardar", "/estudiantes/nuevo", "/estudiantes/guardar").hasRole("ADMIN")
                .requestMatchers("/api/**").hasRole("ADMIN")
                .requestMatchers("/cursos/nuevo", "/cursos/guardar", "/cursos/editar/**", "/cursos/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/estudiantes/nuevo", "/estudiantes/guardar", "/estudiantes/editar/**", "/estudiantes/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/evaluaciones/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/cursos", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}