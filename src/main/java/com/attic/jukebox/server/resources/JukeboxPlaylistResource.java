package com.attic.jukebox.server.resources;

import com.attic.jukebox.server.inventory.domain.Playlist;
import com.google.inject.Inject;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
public class JukeboxPlaylistResource {

    private Datastore datastore;

    @Inject
    public JukeboxPlaylistResource(final Datastore datastore) {
        this.datastore = datastore;
    }

    @GET
    public List<Playlist> getPlaylists() {
        return datastore.find(Playlist.class).asList();
    }

    @GET
    @Path("/{playlistId}")
    public Playlist getPlaylistById(@PathParam("playlistId") int playlistId) {
        Playlist playlist = new Playlist();
        datastore.save(playlist);
        return playlist;
    }
}
