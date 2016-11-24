package com.attic.jukebox;

import com.attic.jukebox.resources.JukeboxResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class JukeboxApplication extends Application<JukeboxAppConfiguration> {
    @Override
    public void run(final JukeboxAppConfiguration configuration, final Environment environment) throws Exception {
        JukeboxResource resource = new JukeboxResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);
    }

    public static void main(String[] args) throws Exception {
        new JukeboxApplication().run(args);
    }
}
