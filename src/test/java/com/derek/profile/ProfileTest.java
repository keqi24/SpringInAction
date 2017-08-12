package com.derek.profile;

import com.derek.profile.common.CommonClass;
import com.derek.profile.dev.DevConfig;
import com.derek.profile.prod.ProdConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by qux on 12/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("dev")
public class ProfileTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CommonClass common;

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() {

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        assertEquals("dev_data", dataSource.query());
        assertNotNull(common);
    }

}
