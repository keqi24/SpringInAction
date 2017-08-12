package com.derek.profile;

import com.derek.profile.common.CommonConfig;
import com.derek.profile.dev.DevConfig;
import com.derek.profile.prod.ProdConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by qux on 12/8/17.
 */
@Configuration
@Import({CommonConfig.class, DevConfig.class, ProdConfig.class})
public class AppConfig {
}
