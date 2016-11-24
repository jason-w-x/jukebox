package com.attic.jukebox.server.inventory;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class PlaylistTest {
    @Test
    public void testPlaylistBean() {
        new BeanTester().testBean(Playlist.class);
    }

}
