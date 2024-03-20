package com.example.restapi05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.AuthorizeRequestsDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebMvcConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 스프링 부트 3버전은 람다를 써야 에러가 안난다
    // jwt 토큰 인증을 달겠다

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // 스프링부트 2버전 문법
//        httpSecurity.csrf().disable();
        // post 방식 put 방식 delete 방식을 사용할때 csrf 토큰을 사용하지 않겠다. 허용하겠다
        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        httpSecurity
                .authorizeRequests(
//                    expressionInterceptUrlRegistry ->
//                            expressionInterceptUrlRegistry.requestMatchers("/member", "/test").permitAll()
//                                    .anyRequest().authenticated()
                        // member나 test가 아닌 다른페이지를 요청했을때는 403 에러가 뜬다
                        expressionInterceptUrlRegistry ->
                                expressionInterceptUrlRegistry.anyRequest().permitAll()

                );
//        httpSecurity.addFilter(filter);

        return httpSecurity.build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests(expressionInterceptUrlRegistry ->
//                        expressionInterceptUrlRegistry.requestMatchers("/member", "/test")
//                                .permitAll().anyRequest().authenticated()
//                )
//                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login"));
//        return httpSecurity.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 유저 관리 하는 매니저 클래스
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        // 로그인 할 수 있는 유저 생성
//        UserDetails userDetails = User.withUsername("user")
//                .password(passwordEncoder().encode("1234"))
//                .roles("USER")
//                .build();
//        // 유저관리하는 매니저 클래스에 유저 등록
//        inMemoryUserDetailsManager.createUser(userDetails);
//        // 유저관리하는 매니저 IOC 컨테이너에 등록 -> securituConfig에서 사용
//        return inMemoryUserDetailsManager;
//    }


}
