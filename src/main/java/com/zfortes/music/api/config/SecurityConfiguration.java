package com.zfortes.music.api.config;/*
 * @created 05/05/2020 - 01:33
 * @project api
 * @author fortes
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/**")
                .permitAll().anyRequest().authenticated().and().csrf().disable();
    }

}