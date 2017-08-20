package com.derek.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by qux on 19/8/17.
 */
public class SpittrWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    /**
     * 将一个或者多个路径映射到DispatchServlet 这里是"/" 表明它会是应用的第一个servlet
     * 它会处理进入应用的所有请求
     */
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
