package com.attic.jukebox.server.inventory;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class DatastoreProviderTest {

    @Mock
    private Morphia morphia;

    @Mock
    private MongoClient client;

    private static final String DB_NAME = "testDb";

    @Mock
    private Datastore datastore;

    private DatastoreProvider provider;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        provider = new DatastoreProvider(morphia, client, DB_NAME);
    }

    @Test
    public void assertProviderGetSetsUpDatastore() {
        doReturn(datastore).when(morphia).createDatastore(client, DB_NAME);

        assertEquals(datastore, provider.get());
        verify(datastore).ensureIndexes();
    }
}
