package kz.iitu.springlab.web;

import kz.iitu.springlab.config.AppProperties;
import kz.iitu.springlab.config.EnvironmentProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lab3")
public class Lab3Controller {

    private final AppProperties props;
    private final EnvironmentProvider env;

    public Lab3Controller(AppProperties props, EnvironmentProvider env) {
        this.props = props;
        this.env = env;
    }

    @GetMapping("/config")
    public Map<String, Object> config() {
        return Map.of(
                "owner",      props.owner(),
                "datePattern", props.datePattern(),
                "mail", Map.of(
                        "host",       props.mail().host(),
                        "port",       props.mail().port(),
                        "retryCount", props.mail().retryCount(),
                        "from",       props.mail().from()
                ),
                "activeProfile", env.name(),
                "description",   env.describe()
        );
    }
}