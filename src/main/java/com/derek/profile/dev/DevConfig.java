package com.derek.profile.dev;

import com.derek.profile.DataSource;
import com.derek.profile.common.CommonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by qux on 12/8/17.
 */
@Configuration
@Import(CommonConfig.class)
@Profile("dev")
public class DevConfig {

    @Bean
    public DataSource dataSource() {
        return new DevDataSource();
    }
}
