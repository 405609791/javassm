package org.javaboy.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.javaboy.interceptor.MyIntercepter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.javaboy",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type =
FilterType.ANNOTATION,classes = Controller.class),@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)})
public class SpringMVCConfig extends WebMvcConfigurationSupport {
    /**
     * 访问静态资源的坑：发送请求的路径
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置拦截器，这是将朗结绮装配到Java中
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
                                                //路径规则，哪些路径需要经过这个拦截器 /** 所有
        registry.addInterceptor(myIntercepter()).addPathPatterns("/**");
    }

    public MyIntercepter myIntercepter(){
        return new MyIntercepter();
    }

    /**
     * fastjson 需自己配置
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        converters.add(fastJsonHttpMessageConverter);
    }
}
