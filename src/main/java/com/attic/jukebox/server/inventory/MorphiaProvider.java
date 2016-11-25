package com.attic.jukebox.server.inventory;

import com.attic.jukebox.server.inventory.domain.Playlist;
import com.google.inject.Provider;
import org.mongodb.morphia.Morphia;

public class MorphiaProvider implements Provider<Morphia> {

    @Override
    public Morphia get() {
        final Morphia morphia = new Morphia();
        morphia.mapPackageFromClass(Playlist.class);
        return morphia;
    }
}
