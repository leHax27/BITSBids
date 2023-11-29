//package com.bitsbids.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//        return http.build();
//    }
//
//    private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
//        return null;
//    }
//}
