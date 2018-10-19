package com.hualuo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitLabPracticeApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GitLabPracticeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GitLabPracticeApplication.class, args);
        LOG.info("app begins...");
    }
}
