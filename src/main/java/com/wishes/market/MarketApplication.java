package com.wishes.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springboot runner
 *
 * @author 郑龙
 */
@SpringBootApplication
public class MarketApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    //不进行拦截处理
    // /**
    //  * Token拦截器
    //  *
    //  * @param registry
    //  */
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // 	registry.addInterceptor(new PrivilegeInterceptor()).addPathPatterns("/**");
    //     super.addInterceptors(registry);
    // }

    /**
     * 支持跨域请求
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").maxAge(30 * 1000);
    }
}
