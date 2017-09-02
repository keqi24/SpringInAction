package com.derek.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qux on 19/8/17.
 */
public class Spitter {

    private long id;

    @NotNull
    @Size(min = 4, max = 16, message = "user name must be more than 4 less than 16")
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 20, message = "password must be more than 8 less than 20")
    private String password;

    public Spitter() {

    }

    public Spitter(String email, String username, String password) {
        this(0, email, username, password);
    }

    public Spitter(long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                .append(username, spitter.username)
                .append(email, spitter.email)
                .append(password, spitter.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(username)
                .append(email)
                .append(password)
                .toHashCode();
    }
}
