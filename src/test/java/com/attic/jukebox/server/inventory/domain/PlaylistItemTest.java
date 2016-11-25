package com.attic.jukebox.server.inventory.domain;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class PlaylistItemTest {
    @Test
    public void testPlaylistItemBean() {
        new BeanTester().testBean(PlaylistItem.class);
    }
}
