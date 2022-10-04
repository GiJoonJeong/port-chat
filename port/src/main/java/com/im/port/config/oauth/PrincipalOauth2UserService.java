package com.im.port.config.oauth;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.im.port.config.auth.PrincipalDetails;
import com.im.port.config.oauth.provider.GitHubUserInfo;
import com.im.port.config.oauth.provider.GoogleUserInfo;
import com.im.port.config.oauth.provider.KaKaoUserInfo;
import com.im.port.config.oauth.provider.NaverUserInfo;
import com.im.port.config.oauth.provider.OAuth2UserInfo;
import com.im.port.repository.UserRepository;
import com.im.port.vo.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("unchecked")
@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;
    // userRequest 는 code를 받아서 accessToken을 응답 받은 객체
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("=============loadUser==============");
		
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회
        // code를 통해 구성한 정보
        System.out.println("userRequest clientRegistration : " + userRequest.getClientRegistration());
        // token을 통해 응답받은 회원정보
        System.out.println("oAuth2User : " + oAuth2User);
        
		return processOAuth2User(userRequest, oAuth2User);
    }
    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        // Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			System.out.println("구글 로그인 요청~~");
			System.out.println("oAuth2User.getAttributes(): " + oAuth2User.getAttributes());
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("github")) {
			System.out.println("깃 허브 로그인 요청");
			System.out.println("oAuth2User.getAttributes(): " + oAuth2User.getAttributes());
			oAuth2UserInfo = new GitHubUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			System.out.println("네이버 로그인 요청~~");
			oAuth2UserInfo = new NaverUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			System.out.println("카카오 로그인 요청~~");
			oAuth2UserInfo = new KaKaoUserInfo(oAuth2User.getAttributes());
        } else {
            System.out.println("지원하지 않는 SNS입니다.");
			return null;
        }

        Optional<UserEntity> userOptional = userRepository
											.findByProviderAndEmail(
												oAuth2UserInfo.getProvider(),
												oAuth2UserInfo.getEmail()
											);
        UserEntity userEntity;
        if (userOptional.isPresent()) {
            System.out.println("이미 존재");
            userEntity = userOptional.get();
            // user가 존재하면 update 해주기
            userEntity = UserEntity.builder()
                    .email(oAuth2UserInfo.getEmail())
                    .build();
		} else {
			System.out.println("새로가입");
			userEntity = UserEntity.builder()
					.username(oAuth2UserInfo.getName())
					.email(oAuth2UserInfo.getEmail())
					.role("MEMBER")
					.provider(oAuth2UserInfo.getProvider())
					.picture(oAuth2UserInfo.getPicture())
					.build();
			System.out.println("마지막 값: " + userEntity.toDto());
			userRepository.save(userEntity);
		}
        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}