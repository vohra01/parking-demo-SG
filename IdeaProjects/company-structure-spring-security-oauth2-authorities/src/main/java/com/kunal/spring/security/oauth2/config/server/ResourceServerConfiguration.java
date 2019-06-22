package com.kunal.spring.security.oauth2.config.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_NOTIFICATION_SCOPE = "#oauth2.hasScope('NOTIFICATIONS')";
    private static final String SECURED_PATTERN = "secured";
    private static final String PATTERN = "***";
    private static final String BACKSLASH = "/";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/").permitAll();

        /*http.authorizeRequests()
                .antMatchers(BACKSLASH+SECURED_PATTERN+BACKSLASH+PATTERN).hasAnyAuthority("NOTIFICATIONS");
                //.anyRequest().hasAnyAuthority(ROLE_USER, ROLE_ADMIN);*/

        /*http.requestMatchers()
                .antMatchers(BACKSLASH+SECURED_PATTERN+BACKSLASH+PATTERN).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_PATTERN);*/
    }
}
