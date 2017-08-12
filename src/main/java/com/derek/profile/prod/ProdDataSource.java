package com.derek.profile.prod;

import com.derek.profile.DataSource;

/**
 * Created by qux on 12/8/17.
 */
public class ProdDataSource implements DataSource {
    public String query() {
        return "pro_data";
    }
}
