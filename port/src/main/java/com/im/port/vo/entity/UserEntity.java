package com.im.port.vo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.im.port.config.security.oauth.provider.ProviderType;
import com.im.port.vo.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String email;
    
    private String password;
    
    private String role; // ROLE_USER, ROLE_ADMIN
    
    // 구글 로그인
    @ColumnDefault("'N'")
    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private ProviderType provider; // "google"
    
    @ColumnDefault("'https://i.esdrop.com/d/f/14rMlVHaTh/lxwXM7NJnb.svg'")
    private String profile_image; // "sub"
    
    @CreationTimestamp
    private Timestamp reg_date;

    public UserDto toDto(){
        return UserDto.builder()
                .id(id)
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .provider(provider)
                .profile_image(profile_image)
                .reg_date(reg_date)
                .build();
    }
}
