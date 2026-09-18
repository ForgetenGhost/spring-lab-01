package kz.iitu.springlab.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev & !prod")
public class DefaultEnvironmentProvider implements EnvironmentProvider {

    @Override
    public String name() { return "default"; }

    @Override
    public String describe() { return "No profile active — using shared application.yml only"; }
}
