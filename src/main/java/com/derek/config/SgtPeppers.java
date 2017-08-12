package com.derek.config;

import org.springframework.stereotype.Component;

/**
 * Created by qux on 12/8/17.
 */
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Peper;s Lonely Hearts";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist + ", class=" + this);
    }
}
