package com.derek.repository;

import com.derek.model.Spitter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by qux on 22/8/17.
 */
@Component
public class DefaultSpitterRespository implements SpitterRepository {

    List<Spitter> spitterList = new CopyOnWriteArrayList<Spitter>();

    public Spitter save(Spitter spitter) {
        spitter.setId(System.currentTimeMillis());
        spitterList.add(spitter);
        return spitter;
    }

    public Spitter findByUserName(String userName) {
        if (userName == null || userName.length() ==0) {
            return null;
        }

        Spitter[] spitters = new Spitter[spitterList.size()];
        spitterList.toArray(spitters);

        for (Spitter spitter : spitters) {
            if (userName.equals(spitter.getUsername())){
                return spitter;
            }
        }
        return null;
    }
}
