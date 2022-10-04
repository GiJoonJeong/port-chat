package com.im.port.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.im.port.repository.UserRepository;
import com.im.port.vo.entity.UserEntity;

import lombok.RequiredArgsConstructor;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행
@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 session(내부 Authentication(UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("===========PrincipalDetailsService========");
        System.out.println("=========== email : "+username+" ========");
        UserEntity userEntity = userRepository.findByEmail(username);
        if (userEntity != null) {
            System.out.println("===========값 있음========");
            return new PrincipalDetails(userEntity);
        }
        System.out.println("===========빈 값========");
        return null;
    }

}
