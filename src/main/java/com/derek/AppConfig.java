package com.derek;

import com.derek.mvc.RootConfig;
import com.derek.mvc.WebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by qux on 22/8/17.
 */

@Configuration
@Import({WebConfig.class, RootConfig.class})
public class AppConfig {
}
