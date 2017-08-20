package com.derek.repository;

import com.derek.model.Spitter;

/**
 * Created by qux on 19/8/17.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUserName(String userName);
}
