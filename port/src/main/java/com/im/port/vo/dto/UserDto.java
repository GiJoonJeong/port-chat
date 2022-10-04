package com.im.port.vo.dto;

import java.sql.Timestamp;

import com.im.port.vo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password; // pass
    private String role; // ROLE_USER, ROLE_ADMIN
    // 구글 로그인
    private String provider; // "google"
    private String picture; // "프로필사진"
    private Timestamp reg_date;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .provider(provider)
                .picture(picture)
                .reg_date(reg_date)
                .build();
    }
}
