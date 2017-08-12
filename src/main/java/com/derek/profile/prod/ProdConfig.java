package com.derek.profile.prod;

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
@Profile("prod")
public class ProdConfig {

    @Bean("ProDataSource")
    public DataSource dataSource() {
        return new ProdDataSource();
    }
}
