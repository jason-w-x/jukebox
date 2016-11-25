package com.attic.jukebox.server.inventory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.mongodb.MongoClient;
import com.netflix.governator.guice.lazy.LazySingleton;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@LazySingleton
public class DatastoreProvider implements Provider<Datastore> {

    private Morphia morphia;

    private MongoClient client;

    private String dbName;

    @Inject
    public DatastoreProvider(final Morphia morphia, final MongoClient client, @Named("dbName") final String dbName) {
        this.morphia = morphia;
        this.client = client;
        this.dbName = dbName;
    }

    @Override
    public Datastore get() {
        final Datastore datastore = morphia.createDatastore(client, dbName);
        datastore.ensureIndexes();
        return datastore;
    }
}
