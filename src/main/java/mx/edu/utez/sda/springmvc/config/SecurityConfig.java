package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user1 = User.withUsername("user1")
                .password(
                        passwordEncoder().encode("1234")
                )
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(
                        passwordEncoder().encode("admin123")
                )
                .roles("ADMIN")
                .build();
        UserDetails recepcion = User.withUsername("recepcion")
                .password(
                        passwordEncoder().encode("recepcion123")
                )
                .roles("RECE")
                .build();
        UserDetails adulto = User.withUsername("adulto")
                .password(
                        passwordEncoder().encode("123")
                )
                .roles("ADUL")
                .build();
        UserDetails niño = User.withUsername("niño")
                .password(
                        passwordEncoder().encode("123")
                )
                .roles("NI")
                .build();
        return new InMemoryUserDetailsManager(user1, admin,recepcion,adulto,niño);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("/", "/index").permitAll();
            requests.anyRequest().authenticated();
        });
        httpSecurity.formLogin((login) -> {
            login.loginPage("/login").permitAll();
        });
        httpSecurity.logout((logout) -> {
            logout.permitAll();
        });
        return httpSecurity.build();
    }



}
