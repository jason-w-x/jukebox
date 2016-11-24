package com.attic.jukebox.server.resources;

import com.attic.jukebox.server.inventory.Playlist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
public class JukeboxPlaylistResource {

    @GET
    public List<Playlist> getPlaylists() {
        return Arrays.asList(new Playlist());
    }

    @GET
    @Path("/{playlistId}")
    public Playlist getPlaylistById(@PathParam("playlistId") int playlistId) {
        Playlist playlist = new Playlist();
        playlist.setId(playlistId);
        return playlist;
    }
}
