package com.jojoldu.book.springboot.config.auth;
import com.jojoldu.book.springboot.domain.user.Role;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			/* NOTE : h2-console 사용을 위해 해당 옵션을 disable*/
			.csrf().disable()
			.headers().frameOptions().disable()
			.and()
			/* NOTE : URL별 권한 관리를 설정하는 옵션의 시작점*/
			.authorizeRequests()
			/* NOTE : 권한 관리 대상을 지정*/
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
			.antMatchers("/api/v1/**").hasRole(Role.USER.name())
			/* NOTE : 설정된 값들 이외 나머지 URL 설정 (authenticated: 인증된 사용자들만 허용)*/
			.anyRequest().authenticated()
			.and()
			/* NOTE : 로그아웃 기능에 대한 여러 설정의 진입점*/
			.logout()
			.logoutSuccessUrl("/")
			.and()
			/* NOTE : OAuth2 로그인 기능에 대한 여러 설정의 진입점*/
			.oauth2Login()
			/* NOTE : OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당*/
			.userInfoEndpoint()
			/* NOTE : 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현제를 등록*/
			.userService(customOAuth2UserService);
	}
}