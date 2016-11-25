package com.attic.jukebox;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class JukeboxAppConfiguration extends Configuration {

    @NotEmpty
    private String dbName;


    @JsonProperty
    public String getDbName() {
        return dbName;
    }

    @JsonProperty
    public void setDbName(final String dbName) {
        this.dbName = dbName;
    }
}
