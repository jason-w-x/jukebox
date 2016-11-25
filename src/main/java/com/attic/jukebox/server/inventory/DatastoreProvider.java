package com.attic.jukebox.server.inventory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DatastoreProvider implements Provider<Datastore> {

    private Morphia morphia;

    private MongoClient client;

    @Inject
    public DatastoreProvider(final Morphia morphia, final MongoClient client) {
        this.morphia = morphia;
        this.client = client;
    }

    @Override
    public Datastore get() {
        final Datastore datastore = morphia.createDatastore(client,"JukeboxDb");
        datastore.ensureIndexes();
        return datastore;
    }
}
