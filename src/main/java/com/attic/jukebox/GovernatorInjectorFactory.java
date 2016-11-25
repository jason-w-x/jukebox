package com.attic.jukebox;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.InjectorFactory;
import com.netflix.governator.InjectorBuilder;

import java.util.List;

public class GovernatorInjectorFactory implements InjectorFactory {

    @Override
    public Injector create(final Stage stage, final List<Module> modules) {
        return InjectorBuilder.fromModules(modules).createInjector(stage);
    }
}
