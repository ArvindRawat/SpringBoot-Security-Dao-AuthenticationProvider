package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.security.service.CustomUserDetailsService;



/***
 * 
 * @author arvind.rawat
 * @Description This class is used to handle spring security 
 */

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired 
 private UserDetailsService userDetailsService;
 /***
  * @author arvind.rawat
  * @param auth
  * @throws Exception
  * @description To Authenticate the user
  */
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);
	 /*To use encoded password*/
	 //.passwordEncoder(passwordencoder());
	 /*In Memory Authentication*/
	// auth.inMemoryAuthentication().withUser("arvind").password("arvind").roles("ADMIN");
 }
 

 /***
  * @author arvind.rawat
  * @description To handle authorize the request
  */
 @Override
 protected void configure(HttpSecurity http) throws Exception {	 
	 http.authorizeRequests()
	 .antMatchers("/", "/home", "/js/**", "/css/**", "/fontawesome/css/**").permitAll()
	 	.anyRequest().fullyAuthenticated().
		and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/success").failureUrl("/failure").permitAll()
		.and().csrf();
 }
 /*
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }*/
}