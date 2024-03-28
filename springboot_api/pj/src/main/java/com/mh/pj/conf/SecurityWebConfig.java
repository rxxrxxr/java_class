package com.mh.pj.conf;

import com.mh.pj.interceptor.TokenInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SecurityWebConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;
    private final JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter;

// interceptor 구현 방법
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .excludePathPatterns("/token");
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.authorizeHttpRequests(req->{
                    req.anyRequest().permitAll()
                    ;
            ;
        });

        // h2 console 보이게
        httpSecurity.headers( header->{
            header.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin());
        });

        // 토큰 인증 필터 방법
        httpSecurity.addFilterAfter(jwtAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }

}
