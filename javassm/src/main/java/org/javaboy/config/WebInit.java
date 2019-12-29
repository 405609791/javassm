package org.javaboy.config;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 相当于web.xml
 */
public class WebInit implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        //坑1：本来应该是AnnotationConfigWebApplicationContext 却 打成了AnnotationConfigApplicationContext ，一直没有想要的方法
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        //添加注册Bean，只注册了 springMVCConfig
        context.register(SpringMVCConfig.class);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(context));
        springmvc.addMapping("/");
        //第一个加载
        springmvc.setLoadOnStartup(1);

    }
}
