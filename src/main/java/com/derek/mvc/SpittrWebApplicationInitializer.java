package com.derek.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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


    /**
     * 通过这个方法对DispatchServlet 进行额外的配置
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        /**
         * 开启多multipart支持
         * 并将相传的临时存储目录设置到 /tmp/spring/uploads
         */
        //registration.setMultipartConfig(new MultipartConfigElement("/tmp/spring/uploads"));

        /**
         * 设置启动优先级
         */
        //registration.setLoadOnStartup(5);
    }
}
