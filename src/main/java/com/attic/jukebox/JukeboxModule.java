package com.attic.jukebox;

import com.attic.jukebox.server.inventory.DatastoreProvider;
import com.attic.jukebox.server.inventory.MorphiaProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.netflix.governator.guice.lazy.LazySingleton;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class JukeboxModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Morphia.class).toProvider(MorphiaProvider.class).in(LazySingleton.class);
        bind(Datastore.class).toProvider(DatastoreProvider.class).in(LazySingleton.class);
    }

    @Provides
    @Named("dbName")
    public String provideDbName(final JukeboxAppConfiguration configuration) {
        return configuration.getDbName();
    }
}
