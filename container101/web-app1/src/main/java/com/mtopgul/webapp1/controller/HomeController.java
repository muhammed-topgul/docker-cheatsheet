package com.mtopgul.webapp1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author muhammed-topgul
 * @since 02/11/2023 13:26
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {
    @GetMapping
    public String homePage() {
        log.info("Getting home page {}", LocalDateTime.now());
        return "Welcome to Home Page";
    }
}
