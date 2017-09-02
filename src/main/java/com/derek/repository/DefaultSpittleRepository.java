package com.derek.repository;

import com.derek.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qux on 22/8/17.
 */
@Component
public class DefaultSpittleRepository implements SpittleRepository {

    private final List<Spittle> mSpittleList;
    private long mMaxId;

    public DefaultSpittleRepository() {
        mSpittleList = createSpittleList(10);
        mMaxId = mSpittleList.get(0).getId();
    }

    public List<Spittle> findSpittle(long max, int count) {
        List<Spittle> resultList = new ArrayList<Spittle>();

        for (Spittle spittle : mSpittleList) {
            if (spittle.getId() < max) {
                resultList.add(spittle);
                count--;
                if (count == 0) {
                    break;
                }
            }
        }

        return resultList;
    }

    public Spittle findOne(long id) {
        for (Spittle spittle : mSpittleList) {
            if (spittle.getId() == (int)id) {
                return spittle;
            }
        }
        return null;
    }

    public void save(Spittle spittle) {
        spittle.setId(++mMaxId);
        mSpittleList.add(0, spittle);
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = count - 1; i >= 0; i--) {
            spittles.add(new Spittle(i, "Default Msg " + i, System.currentTimeMillis() / 1000L));
        }
        return spittles;
    }
}
