package com.attic.jukebox.server.inventory.domain;

public class PlaylistItem {
    private long id;

    private Playlist playlist;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(final Playlist playlist) {
        this.playlist = playlist;
    }
}
