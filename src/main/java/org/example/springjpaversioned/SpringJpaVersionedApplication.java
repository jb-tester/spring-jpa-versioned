package org.example.springjpaversioned;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaVersionedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaVersionedApplication.class, args);
    }

    @Bean
        public CommandLineRunner commandLineRunner(PostService postService) {
            return args -> {
                System.out.println("--------------------------------------");
                postService.setupBd();
                postService.testBulkUpdate();
                System.out.println("--------------------------------------");

            };
        }
}
