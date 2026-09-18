package kz.iitu.springlab.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app")
@Validated
public record AppProperties(

        @NotBlank
        String owner,

        @NotBlank
        String datePattern,

        @Valid
        Mail mail

) {
    public record Mail(

            @NotBlank
            String host,

            @Min(1) @Max(65535)
            int port,

            @Min(1) @Max(10)
            @DefaultValue("3")
            int retryCount,

            @NotBlank @Email
            String from
    ) {}
}