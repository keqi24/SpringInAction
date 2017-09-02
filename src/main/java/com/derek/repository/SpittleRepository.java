package com.derek.repository;

import com.derek.model.Spittle;

import java.util.List;

/**
 * Created by qux on 19/8/17.
 */
public interface SpittleRepository {
    List<Spittle> findSpittle(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle);
}
