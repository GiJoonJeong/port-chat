package com.im.port.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.im.port.vo.entity.UserEntity;

// CRUD 함수를 JpaRepository가 들고 있음
// @Repository라는 어노테이션이 없어도 Ioc된다. 이유는 상속받았기 때문에
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // findBy규칙 - > Username문법
    // select * from user where username = parameter의 username
    public UserEntity findByUsername(String username); // Jpa query methods
    public UserEntity findByEmail(String email); // Jpa query methods
    Optional<UserEntity> findByProviderAndEmail(String provider, String Email);
}
