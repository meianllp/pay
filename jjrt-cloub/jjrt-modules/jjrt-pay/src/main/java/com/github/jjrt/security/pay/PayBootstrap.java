package com.github.jjrt.security.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.jjrt.security.auth.client.EnableAceAuthClient;
import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * ${DESCRIPTION}
 *
 * @author jjrt
 * @create 2017-05-25 12:44
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.github.jjrt.security.auth.client.feign"})
@EnableScheduling
@EnableAceAuthClient
@EnableTransactionManagement
@MapperScan("com.github.jjrt.security.pay.mapper")
@EnableSwagger2Doc
public class PayBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PayBootstrap.class).web(true).run(args);    }
}
