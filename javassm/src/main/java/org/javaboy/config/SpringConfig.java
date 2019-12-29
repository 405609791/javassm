package org.javaboy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * java 配置spring 扫描
 */
@Configuration
@ComponentScan(basePackages = "org.javaboy",useDefaultFilters = true,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = Controller.class)})
public class SpringConfig {
}
