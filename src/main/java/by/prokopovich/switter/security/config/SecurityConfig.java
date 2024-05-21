package by.prokopovich.switter.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * Отключена защита от CSRF-атак, STATELESS - приложение не будет создавать и управлять сессиями пользователей,
     * а вместо этого будет использовать JWT аутентификацию, Customizer.withDefaults() - механизм базовой HTTP-аутентификации
     * пользователь в заголовках запроса будет предоставлять свои учетные данные
     *
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/accounts/register").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("api/v1/demo/just-auth").authenticated()
                        .requestMatchers("/api/v1/demo/just-role-user").hasRole("USER")
                        .requestMatchers("/api/v1/demo/just-role-admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
