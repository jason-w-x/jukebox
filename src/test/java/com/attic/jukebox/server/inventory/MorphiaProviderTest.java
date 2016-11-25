package com.attic.jukebox.server.inventory;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Morphia;

import static org.junit.Assert.assertTrue;

public class MorphiaProviderTest {
    private MorphiaProvider provider;

    @Before
    public void setup() {
        provider = new MorphiaProvider();
    }

    @Test
    public void assertProviderGetSetsUpMorphia() {
        final Morphia morphia = provider.get();
        assertTrue(morphia.getMapper().getOptions().isStoreEmpties());
    }
}
