package com.github.jjrt.security.auth.client.configuration;

import com.github.jjrt.security.auth.client.config.ServiceAuthConfig;
import com.github.jjrt.security.auth.client.config.UserAuthConfig;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
@ComponentScan({"com.github.jjrt.security.auth.client","com.github.jjrt.security.auth.common.event"})
@RemoteApplicationEventScan(basePackages = "com.github.jjrt.security.auth.common.event")
public class AutoConfiguration {
    @Bean
    ServiceAuthConfig getServiceAuthConfig(){
        return new ServiceAuthConfig();
    }

    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }

}
