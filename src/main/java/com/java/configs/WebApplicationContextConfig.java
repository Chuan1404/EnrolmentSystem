package com.java.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author AnChuPC
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.java.controllers",
    "com.java.repositories",
    "com.java.services"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/resources/assets/fonts/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/assets/css/");
        registry.addResourceHandler("/assets/img/**")
                .addResourceLocations("/resources/assets/img/");
        registry.addResourceHandler("/assets/js/**").addResourceLocations("resources/assets/js/");
    }
//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        
//        return resolver;
//    }   
}
