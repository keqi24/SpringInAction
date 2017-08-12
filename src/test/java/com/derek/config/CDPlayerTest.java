package com.derek.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

/**
 * Created by qux on 12/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        player.play();
        player.play();


        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
//        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
