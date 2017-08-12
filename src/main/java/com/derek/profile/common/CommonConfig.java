package com.derek.profile.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qux on 12/8/17.
 */
@Configuration
public class CommonConfig {

    @Bean
    public CommonClass commonClass() {
        return new CommonImpl();
    }
}
