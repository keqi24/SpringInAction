package com.derek.profile.common;

import org.springframework.stereotype.Component;

/**
 * Created by qux on 12/8/17.
 */
@Component
public class CommonImpl implements CommonClass {
    public void print() {
        System.out.println("I am common class");
    }
}
