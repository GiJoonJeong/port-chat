package com.im.port.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.im.port.config.oauth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화
// preAuthorize PostAuthroize 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOauth2UserService principalOauth2UserService;
    //private final AuthenticationFailureHandler authFailureHandler;
    // 해당 메서드의 리턴되는 오브젝트를 Ioc로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("============SecurityConfig==================");
        http.csrf().disable();
        http.logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/loginSuccess")
            .invalidateHttpSession(true).deleteCookies("JSESSIONID");
        http.authorizeRequests()
                // .antMatchers("/user/**").authenticated() // 인증만 되면 들어갈 수 있는 주소
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                // 로그인 성공시
                .defaultSuccessUrl("/loginSuccess")
                //.failureHandler(authFailureHandler)
            .and()
                .oauth2Login()
                .loginPage("/loginForm")
                // 구글 로그인이 완료된 뒤의 후처리가 필요함. 코드x (엑세스토큰+사용자프로필정보 O)
                // 1.코드받기(인증), 2. 엑세스토큰(권한), 3.사용자프로필 정보를 가져와서
                // 4. 그정보로 회원가입을 자동으로 진행시키기도 함
                // 4-2 (이메일, 전화번호, 이름, 아이디)
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
    }
}
