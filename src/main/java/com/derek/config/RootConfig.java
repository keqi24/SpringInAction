package com.derek.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by qux on 19/8/17.
 */
@Configuration
@ComponentScan(basePackages = "com.derek",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
)
public class RootConfig {
}
