package com.stussy.stussyclone20220903SHC.config;

import com.stussy.stussyclone20220903SHC.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests() //인증요청한다.
                .antMatchers("/account/mypage", "/index") //지정된 주소(/account/mypage, /index)로 요청이 들어오면
                .authenticated() //인증을 거쳐라
                .antMatchers("/admin/**") //admin하위에 있는 모든 주소로 들어오는 어떠한 권한이든간에
                .hasRole("ADMIN") //ADMIN을 가져야한다.
                .anyRequest() //그외에 어떤 요청이든
                .permitAll() //모두 허용한다.
                .and() //그리고
                .formLogin() //로그인폼에 대한 설정을 할거다.
                .usernameParameter("email")
                .loginPage("/account/login") //해당 주소를 로그인페이지로 사용할거다. login service get요청
                .loginProcessingUrl("/account/login") //login service post 요청
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index"); //따로 지정된 주소가 없이 로그인하면 /index로 간다.
    }
}
