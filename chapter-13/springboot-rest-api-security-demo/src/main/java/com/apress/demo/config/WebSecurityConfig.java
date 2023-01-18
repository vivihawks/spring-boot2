/**
 * 
 */
package com.apress.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.apress.demo.security.RestAuthenticationSuccessHandler;

/**
 * @author Siva
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
       
    @Autowired
    private UserDetailsService customUserDetailsService;
    
    @Autowired
    private RestAuthenticationSuccessHandler authenticationSuccessHandler;
    
    //password = abcd, encoded form = asdfasdasfsdafa
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
        throws Exception 
    {
        auth
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder())
            ;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.csrf().disable()
	   
    		// To login, POST form with "username" and "password" to http://localhost:8080/login
    		//	admin@gmail.com/admin (or) siva@gmail.com/siva (or) user@gmail.com/user
    		// Copy the response set-header value that starts with JSessionId
    		// GET http://localhost:8080/api/posts
    		// Include the copied Jsession id as a cookie in the above request 
    		
	        .authorizeRequests()
		        .antMatchers("/","/login","/contact").permitAll()
		        .antMatchers("/api/admin/**").hasRole("ADMIN")
		        .antMatchers("/api/**").authenticated()
		        .and()
        
            .exceptionHandling()
            	.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            	.and()
            	
            .formLogin()
                .permitAll()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
            .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
             ;
        
    }
}

