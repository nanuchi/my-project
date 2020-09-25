package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void init()
    {
        Logger log = LoggerFactory.getLogger(App.class);

        try {
            log.info("I am a Java app");
            log.info("Just logging stuff");

            throw new NullPointerException("Ooh noes! Something bad happened");
        }
        catch (Exception e) {
            log.error("Error occurred!", e);
        }
    }
}
