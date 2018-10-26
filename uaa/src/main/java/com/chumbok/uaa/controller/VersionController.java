package com.chumbok.uaa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Returns artifact info.
 */
@Slf4j
@RestController
public class VersionController {

    private Environment environment;

    public VersionController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(value = "/version")
    public Map<String, String> appVersion() {
        return Collections.singletonMap("version",
                environment.getProperty("info.build.version", "NOT_DEFINED"));
    }
}
