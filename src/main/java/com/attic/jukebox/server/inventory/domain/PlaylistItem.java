package com.attic.jukebox.server.inventory.domain;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class PlaylistItem {
    private long id;

    private String url;

    private double position;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(final double position) {
        this.position = position;
    }
}
