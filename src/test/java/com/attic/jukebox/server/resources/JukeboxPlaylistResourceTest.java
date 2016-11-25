package com.attic.jukebox.server.resources;

import com.attic.jukebox.server.inventory.domain.Playlist;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JukeboxPlaylistResourceTest {
    @Mock
    private Datastore datastore;

    private JukeboxPlaylistResource resource;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        resource = new JukeboxPlaylistResource(datastore);
    }

    @Test
    public void assertGetPlaylistsReturnsAllFromDatastore() {
        final List<Playlist> allPlaylists = Arrays.asList(new Playlist());
        final Query<List<Playlist>> query = mock(Query.class);

        doReturn(query).when(datastore).find(Playlist.class);
        doReturn(allPlaylists).when(query).asList();

        assertEquals(allPlaylists, resource.getPlaylists());
    }

    @Test
    public void assertGetPlaylistByIdReturnsPlaylistWithMatchingObjectId() {
        final Playlist playlist = new Playlist();
        final ObjectId id = new ObjectId();

        doReturn(playlist).when(datastore).get(Playlist.class, id);
        assertEquals(playlist, resource.getPlaylistById(id.toHexString()));
    }

    @Test
    public void assertCreatePlaylistSavesPlaylistObjectFromRequest() {
        final Playlist playlist = new Playlist();

        assertEquals(playlist, resource.createPlaylist(playlist));
        verify(datastore).save(playlist);
    }
}
