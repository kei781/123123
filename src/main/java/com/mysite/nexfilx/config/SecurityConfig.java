package com.mysite.nexfilx.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

//스프링의 환경설정 파일임을 의미
@Configuration
//모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만듦
@EnableWebSecurity
//    @EnableWebSecurity 애너테이션을 사용하면 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터가 적용됨.
@RequiredArgsConstructor
public class SecurityConfig  {


        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.csrf().disable();

            //모든 인증되지 않은 요청을 허락한다는 의미.
            http.authorizeRequests().antMatchers("/**").permitAll()
//            SQL자체에는 토큰을 발행하는 기능이 없기 때문에 403 오류가 발생함.
//            SpringSecurity 실행시 SQL관련 콘솔은 예외로 처리할 수 있도록 아래와 같이 처리함.
//                .and() //HTTP객체 설정을 이어서 할 수 있도록 함.
//                    .csrf().ignoringAntMatchers("/h2-console/**") ///h2-console/로 시작하는 URL은 검증(CSRF검증)을 하지 않는다는 설정.
            //여기까지 진행하면 화면이 깨져보인다.
                .and()
                    .headers()
                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
                            XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
            //X-Frame-Option 헤더값을 sameorigin으로 설정하여 오류가 나지 않도록 설정.
            //이렇게 설정하면 frame에 포함된 페이지가 페이지를 제공하는 사이트와 동일한 경우에는 계속 사용가능.


            //스프링시큐리티의 로그인 담당 부분.
                .and()
                    //.formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/")

                    .authorizeRequests(authorize -> authorize
                            .anyRequest()
                            .permitAll()
                    )




                    ;
            return http.build();
        }





    }


