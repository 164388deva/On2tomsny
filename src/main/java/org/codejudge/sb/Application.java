package org.codejudge.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@ComponentScan({"org.codejudge.sb"})
@Slf4j
public class Application {

    public static void main(String[] args) {
        Logger log= LoggerFactory.getLogger(Application.class);
		log.info("Starting Application...");
        SpringApplication.run(Application.class, args);
    }
}
