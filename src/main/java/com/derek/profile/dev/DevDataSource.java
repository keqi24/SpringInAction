package com.derek.profile.dev;

import com.derek.profile.DataSource;

/**
 * Created by qux on 12/8/17.
 */
public class DevDataSource implements DataSource {

    public String query() {
        return "dev_data";
    }
}
