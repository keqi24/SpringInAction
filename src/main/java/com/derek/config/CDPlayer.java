package com.derek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qux on 12/8/17.
 */
public class CDPlayer implements MediaPlayer {

    @Autowired
    CompactDisc cd;

    @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
