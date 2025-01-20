package com.PW_Pintilie_Sergiu.Store.Security;

import com.PW_Pintilie_Sergiu.Store.User.Role;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/security/**",
                        "/produse",
                        "/laptopuri",
                        "/telefoane",
                        "/tablete",
                        "/",
                        "/*/id:{id}",
                        "/search",
                        "/inregistrare",
                        "/login")
                .permitAll()
                .requestMatchers("/admin_panel",
                        "/Admin_listaProduse",
                        "/Admin_listaAdmin",
                        "/AdaugareProdus",
                        "/UpdateProdus",
                        "/delete/**",
                        "/add/**",
                        "/addAdminPage/**",
                        "/deleteAdmin/**",
                        "/UpdateAdmin/**",
                        "/updAdmin",
                        "/update/**",
                        "/addAdmin",
                        "/UpdateProdus",
                        "/Admin_listaComenzi",
                        "/updateOrder/**",
                        "/deleteOrder/**",
                        "/UpdateOrder")
                .hasAuthority(Role.ADMIN.name())
                .requestMatchers("/addToCart","/cos","/placeOrder/**")
                .hasAuthority(Role.USER.name())
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
