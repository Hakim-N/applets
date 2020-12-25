package com.rongmu.applets;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
public class AppletsApplication {

    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(AppletsApplication.class);
        ConfigurableApplicationContext context=application.run(args);
        Environment env=context.getEnvironment();
        try {
            log.info("\n***************************************************************\n\t" +
                        "**  "+ "Application '{}' is running! Access URLs:\n\t" +
                        "**  "+ "Local:      http://localhost:{}\n\t" +
                        "**  "+ "External:   http://{}:{}\n\t" +
                        "**  "+ "Doc:        http://{}:{}/doc.html\n" +
                        "***************************************************************",
                    env.getProperty("spring.application.name"),
                    env.getProperty("server.port"),
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"),
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
