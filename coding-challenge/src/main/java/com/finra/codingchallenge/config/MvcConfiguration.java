package com.finra.codingchallenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.finra.codingchallenge.interceptor.LoggingInterceptor;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

	private final static String REAL_CSS_PATH = "classpath:/webapp/resources/css/";
	
	private final static String REAL_IMG_PATH = "classpath:/webapp/resources/img/";

    private final static String REAL_JS_PATH = "classpath:/webapp/resources/js/";

    @Value("/WEB-INF/resources/css/*")
    private String versionedCssPath;
    
    @Value("/WEB-INF/resources/img/*")
    private String versionedImgPath;

    @Value("/WEB-INF/resources/js/*")
    private String versionedJsPath;
    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/webapp/WEB-INF/views/");
        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(versionedCssPath).addResourceLocations(REAL_CSS_PATH)
            .setCachePeriod(Integer.MAX_VALUE);
        
        registry.addResourceHandler(versionedImgPath).addResourceLocations(REAL_IMG_PATH)
        .setCachePeriod(Integer.MAX_VALUE);

        registry.addResourceHandler(versionedJsPath).addResourceLocations(REAL_JS_PATH)
            .setCachePeriod(Integer.MAX_VALUE);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return new CommonsMultipartResolver();
    }

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor());
    }
}