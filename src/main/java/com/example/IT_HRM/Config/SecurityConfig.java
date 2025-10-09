package com.example.IT_HRM.Config;

import com.example.IT_HRM.ServiceImpl.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf
//                .ignoringRequestMatchers("/hrm/users/**") // disable CSRF for API routes
//        ).authorizeHttpRequests((authz) ->
//                 authz.requestMatchers("/login","/error")
//                //.requestMatchers(HttpMethod.POST, "/hrm/users/**").permitAll()
//                .authenticated().anyRequest().authenticated())
//                .formLogin( form -> form.defaultSuccessUrl("http://localhost:8080/",true).permitAll())
//                .logout(logout -> logout.logoutSuccessUrl("/login"))
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                //.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/login").permitAll().anyRequest()
                                .authenticated())
                .formLogin( form -> form.loginPage("/login").permitAll())
                .formLogin(Customizer.withDefaults());
                        //.defaultSuccessUrl("http://localhost:8080/",true).permitAll())
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            UserDetailService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
