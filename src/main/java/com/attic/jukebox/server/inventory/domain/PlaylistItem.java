package com.attic.jukebox.server.inventory.domain;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class PlaylistItem {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

}
