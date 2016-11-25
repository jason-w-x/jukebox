package com.attic.jukebox;

import com.attic.jukebox.server.inventory.DatastoreProvider;
import com.attic.jukebox.server.inventory.MorphiaProvider;
import com.google.inject.AbstractModule;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class JukeboxModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Morphia.class).toProvider(MorphiaProvider.class).asEagerSingleton();
        bind(Datastore.class).toProvider(DatastoreProvider.class).asEagerSingleton();
    }
}
