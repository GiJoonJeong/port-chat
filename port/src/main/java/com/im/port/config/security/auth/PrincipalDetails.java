package com.im.port.config.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.im.port.vo.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Authentication 객체에 저장할 수 있는 유일한 타입
public class PrincipalDetails implements UserDetails, OAuth2User{

	private static final long serialVersionUID = 1L;
	private UserEntity user;
	private Map<String, Object> attributes;

	// 일반 시큐리티 로그인시 사용
	public PrincipalDetails(UserEntity user) {
		log.info(" ##### PrincipalDetails Nomal Login");
		this.user = user;
	}
	
	// OAuth2.0 로그인시 사용
	public PrincipalDetails(UserEntity user, Map<String, Object> attributes) {
		log.info(" ##### PrincipalDetails Oauth2 Login");
		this.user = user;
		this.attributes = attributes;
	}
	// UserEntity 객체 리턴
	public UserEntity getUser() {
		return user;
	}
	// Email을 아이디로 사용하기 위해 추가
	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		collet.add(()->{ return user.getRole();});
		return collet;
	}

	// 리소스 서버로 부터 받는 회원정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	// User의 PrimaryKey
	@Override
	public String getName() {
		return user.getId()+"";
	}
	
}
