package io.pivotal.spring.gemfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableGemfireRepositories
public class ReadinglistGemfireApplication {
   
    public static void main(String[] args) {
        SpringApplication.run(ReadinglistGemfireApplication.class, args);
    }
    
 
}
