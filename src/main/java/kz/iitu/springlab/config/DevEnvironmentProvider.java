package kz.iitu.springlab.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevEnvironmentProvider implements EnvironmentProvider {

    @Override
    public String name() { return "dev"; }

    @Override
    public String describe() { return "Local development — Mailtrap, DEBUG logging"; }
}