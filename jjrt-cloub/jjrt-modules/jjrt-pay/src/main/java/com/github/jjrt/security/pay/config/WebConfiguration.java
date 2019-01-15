package com.github.jjrt.security.pay.config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.github.jjrt.security.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.github.jjrt.security.auth.client.interceptor.UserAuthRestInterceptor;
import com.github.jjrt.security.common.handler.GlobalExceptionHandler;

/**
 *
 * @author ace
 * @date 2017/9/8
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getServiceAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns()).addPathPatterns("/api/user/validate");
        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns());
    }
    
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
	    registry.jsp("/WEB-INF/jsp/", ".jsp");
//	    registry.enableContentNegotiation(new MappingJackson2JsonView());
    }
    
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    	/* 是否通过请求Url的扩展名来决定media type */
//    	configurer.favorPathExtension(true) 
//    	/* 不检查Accept请求头 */
//    	.ignoreAcceptHeader(true)
//    	.parameterName("mediaType")
//    	/* 设置默认的media yype */
//    	.defaultContentType(MediaType.TEXT_HTML)
//    	/* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
//    	.mediaType("html", MediaType.TEXT_HTML)
//    	/* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
//    	.mediaType("json", MediaType.APPLICATION_JSON);
//    	}
    
    
    @Bean
    ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/element/**",
                "/gateLog/**",
                "/group/**",
                "/groupType/**",
                "/menu/**",
                "/user/**",
                "/api/permissions",
                "/api/user/un/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

}
