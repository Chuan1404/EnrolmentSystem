/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.configs;

import com.java.handlers.LoginSuccessHandler;
import com.java.handlers.LogoutSuccessHandler;
import com.java.services.GoogleOAuth2UserService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author AnChuPC
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.java.controllers",
    "com.java.repositories",
    "com.java.services",
    "com.java.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private GoogleOAuth2UserService googleOAuth2UserService;

    @Autowired
    private LoginSuccessHandler loginHandler;

    @Autowired
    private LogoutSuccessHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authentication
        http.formLogin()
                .loginPage("/auth/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(loginHandler)
                .failureUrl("/auth/login?error");

        http.oauth2Login()
                .loginPage("/auth/login")
                .clientRegistrationRepository(clientRegistrationRepository())
                .userInfoEndpoint()
                .userService(googleOAuth2UserService)
                .and()
                .successHandler(loginHandler)
                .failureUrl("/auth/login?error");

        http
                .logout()
                .addLogoutHandler(logoutHandler);
        // authorize
        http.exceptionHandling()
                .accessDeniedPage("/auth/login/?accessDenied");
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        http.csrf().disable();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(
                ClientRegistration.withRegistrationId("google")
                        .clientId("128479845058-anu704t9t483ohtf7ok3p67t6iau78sf.apps.googleusercontent.com")
                        .clientSecret("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")
                        .scope(Arrays.asList("email", "profile").toArray(new String[0]))
                        .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                        .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                        .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .redirectUri("http://localhost:8080/EnrolmentSystem/auth/login-google")
                        .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                        .userNameAttributeName(IdTokenClaimNames.SUB)
                        .clientName("Google")
                        .build());
    }

}
