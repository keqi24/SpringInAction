package com.derek.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qux on 31/8/17.
 */
public class SpittleForm {
    @NotNull
    @Size(min = 1, max = 140)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
