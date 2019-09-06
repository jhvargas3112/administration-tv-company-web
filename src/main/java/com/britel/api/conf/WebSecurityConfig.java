package com.britel.api.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // Every Spring configurations are made in compilation time.
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private LoginSuccessHandler loginSuccessHandler;

  @Autowired
  private DataSource dataSource; 

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .csrf().disable()
    .authorizeRequests()
    .antMatchers("/").permitAll()
    .antMatchers("/js/controller/*").permitAll()
    .antMatchers("/js/service/*").permitAll()
    .antMatchers("/css/*").permitAll()
    .antMatchers("/images/*").permitAll()
    .antMatchers("/devices").hasAnyRole("ADMIN", "COMPANY")
    .antMatchers("/company_mac_consumption").hasAnyRole("ADMIN", "COMPANY")
    .antMatchers("/global_company_consumption").hasAnyRole("ADMIN", "COMPANY")
    .antMatchers("/accounts").hasAnyRole("COMPANY")
    // .antMatchers("/companies").hasAnyRole("ADMIN", "COMPANY")
    .anyRequest().authenticated()
    .and()
    .formLogin().successHandler(loginSuccessHandler)
    .loginPage("/").permitAll()
    .and()
    .logout().permitAll();

    http.exceptionHandling().accessDeniedPage("/403");		
  }

  @Autowired
  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
    .usersByUsernameQuery("SELECT Email,Password,true FROM user "
        + "WHERE Email = ? AND (Type = 'Company' OR Type = 'Admin')")
    .authoritiesByUsernameQuery("SELECT email, authority "
        + "FROM authorities WHERE email=?")
    .passwordEncoder(new BCryptPasswordEncoder());
  }

}