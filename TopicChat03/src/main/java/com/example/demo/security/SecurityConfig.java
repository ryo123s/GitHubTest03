package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Securityのコンフィグクラス
 * @author jinjinliangjie
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
        .antMatchers("/signup").permitAll()
        .anyRequest().authenticated().and()
        .formLogin().loginPage("/login").defaultSuccessUrl("/group/group").permitAll().and()
        .logout().logoutSuccessUrl("/login").permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) {
		//ログイン認証前でもアクセスできるように設定できるらしいが動作していない
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**","/bootstrap/**");
	}
}