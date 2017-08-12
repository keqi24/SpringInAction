package com.derek.config;

import org.springframework.stereotype.Component;

/**
 * Created by qux on 12/8/17.
 */
public class BlankDisc implements CompactDisc {
    public void play() {
        System.out.println("I am blank disc");
    }
}
