package com.likelion.springstudy.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     SecurityFilterChain

     Filter : 디스페처 서블렛 앞에 있음. 클라이언트 요청을 서블렛으로 넘어가기 전에 처리
     ex) JWT 검증 필터

     .csrf().disable() : csrf 공격 방어를 꺼놓음. API의 Json은 key, value 값으로 전달하기 때문에 위조하기 어려움.
     -> REST API 서비스를 만들 때는 꺼놓아도 무방.

     .authorizeHttpRequests() : HTTP 요청을 허용하겠다.

     .anyRequest().permitAll() : 모든 요청을 허용. 서비스 출시 후 꺼놓기

     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and().build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedOriginPatterns("*")
                        .allowedMethods("*");
            }
        };
    }
}
