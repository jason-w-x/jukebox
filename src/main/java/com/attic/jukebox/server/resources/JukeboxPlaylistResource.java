package com.attic.jukebox.server.resources;

import com.attic.jukebox.server.inventory.domain.Playlist;
import com.google.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.*;
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
    public Playlist getPlaylistById(@PathParam("playlistId") final String playlistId) {
        return datastore.get(Playlist.class, new ObjectId(playlistId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Playlist createPlaylist(final Playlist playlist) {
        datastore.save(playlist);
        return playlist;
    }
}
