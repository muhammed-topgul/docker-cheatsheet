package com.mtopgul.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author muhammed-topgul
 * @since 09/11/2023 10:53
 */
@RestController
@Slf4j
public class HomeController {
    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/status")
    public String status() {
        return "Client is Up";
    }

    @GetMapping("/time")
    public String getServerTime() {
        String url = appUrl.concat("/time");
        log.info("Requesting to {}", url);
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    @GetMapping("/find/{username}")
    public String getUser(@PathVariable String username) {
        String url = appUrl.concat("/find/").concat(username);
        log.info("Requesting to {}", url);
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
