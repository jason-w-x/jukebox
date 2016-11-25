package com.attic.jukebox.server.inventory;

import com.attic.jukebox.server.inventory.domain.Playlist;
import com.google.inject.Provider;
import com.netflix.governator.guice.lazy.LazySingleton;
import org.mongodb.morphia.Morphia;

@LazySingleton
public class MorphiaProvider implements Provider<Morphia> {

    @Override
    public Morphia get() {
        final Morphia morphia = new Morphia();
        morphia.mapPackageFromClass(Playlist.class);
        morphia.getMapper().getOptions().setStoreEmpties(true);
        return morphia;
    }
}
