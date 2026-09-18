package kz.iitu.springlab.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEnvironmentProvider implements EnvironmentProvider {

    @Override
    public String name() { return "prod"; }

    @Override
    public String describe() { return "Production — SendGrid, WARN logging"; }
}