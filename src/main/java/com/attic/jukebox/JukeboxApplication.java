package com.attic.jukebox;

import com.attic.jukebox.server.resources.JukeboxPlaylistResource;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JukeboxApplication extends Application<JukeboxAppConfiguration> {
    @Override
    public void initialize(final Bootstrap<JukeboxAppConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.<JukeboxAppConfiguration>newBuilder().addModule(new JukeboxModule()).setConfigClass(JukeboxAppConfiguration.class).build());
    }

    @Override
    public void run(final JukeboxAppConfiguration configuration, final Environment environment) throws Exception {
        environment.jersey().register(new JukeboxPlaylistResource());
    }

    public static void main(String[] args) throws Exception {
        new JukeboxApplication().run(args);
    }
}
