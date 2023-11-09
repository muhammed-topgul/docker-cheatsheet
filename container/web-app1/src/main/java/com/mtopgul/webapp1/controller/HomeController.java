package com.mtopgul.webapp1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author muhammed-topgul
 * @since 02/11/2023 13:26
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Value("${file.path}")
    private String filePath;

    @Value("${webapp2.url}")
    private String webapp2Url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String homePage() {
        log.info("[WEB-APP1]> Getting home page {}", LocalDateTime.now());
        return "Welcome to Home Page";
    }

    @GetMapping("/app2")
    public String app2() {
        log.info("WEP-APP2 url {}", webapp2Url);
        return restTemplate.getForEntity(webapp2Url, String.class).getBody();
    }

    @GetMapping("/write/{text}/{fileName}")
    public String write(@PathVariable String text, @PathVariable String fileName) {
        return writeFile(fileName, text);
    }

    @GetMapping("/read/{fileName}")
    public String read(@PathVariable String fileName) {
        return readFile(fileName);
    }

    private String writeFile(String fileName, String text) {
            try {
                FileWriter writer = new FileWriter(getFilePath(fileName), true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(text);
                bufferedWriter.newLine();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readFile(fileName);
    }

    private String readFile(String fileName) {
        try {
            FileReader reader = new FileReader(getFilePath(fileName));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "--NO DATA--";
    }

    private String getFilePath(String fileName) {
        String path = "%s%s.txt".formatted(filePath, fileName);
        log.info("Path: {}", path);
        return path;
    }
}
