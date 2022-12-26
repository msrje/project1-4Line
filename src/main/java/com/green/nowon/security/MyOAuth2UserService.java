package com.green.nowon.security;

import java.util.Map;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
							//class DefaultOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>
public class MyOAuth2UserService extends DefaultOAuth2UserService {

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oAuth2User =super.loadUser(userRequest);
		
		Map<String, Object> attributes= oAuth2User.getAttributes();
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		
		return new MyOAuth2User(oAuth2User, registrationId);
	}

}