package com.derek.model;

/**
 * Created by qux on 19/8/17.
 */
public class Spittle {
    private long id;
    private String message;
    private long timestamp;

    public Spittle(String message, long timestamp) {
        this(0, message, timestamp);
    }

    public Spittle(long id, String message, long timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spittle spittle = (Spittle) o;

        if (id != spittle.id) return false;
        if (timestamp != spittle.timestamp) return false;
        return message != null ? message.equals(spittle.message) : spittle.message == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }
}
