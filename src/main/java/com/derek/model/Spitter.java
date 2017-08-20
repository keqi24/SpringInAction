package com.derek.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qux on 19/8/17.
 */
public class Spitter {

    private long id;

    @NotNull
    @Size(min = 4, max = 16)
    private String username;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    public Spitter() {

    }

    public Spitter(String username, String password) {
        this(0, username, password);
    }

    public Spitter(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Spitter spitter = (Spitter) o;

        return new EqualsBuilder()
                .append(id, spitter.id)
                .append(username, spitter.username)
                .append(password, spitter.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(username)
                .append(password)
                .toHashCode();
    }
}
