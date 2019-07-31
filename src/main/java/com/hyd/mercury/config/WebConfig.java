package com.hyd.mercury.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.hyd.mercury.interceptor.AuthorityInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport  {
    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    /**
     * 针对异步的拦截器配置，拦截异步请求
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
        //比如如下给异步服务请求添加拦截器
        //configurer.registerCallableInterceptors((CallableProcessingInterceptor) authorityInterceptor);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor).excludePathPatterns("/static/**","/login").addPathPatterns("/**");
    }
}
