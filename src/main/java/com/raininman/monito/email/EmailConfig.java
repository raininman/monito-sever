package com.raininman.monito.email;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmailConfig {
    @Bean
    CommandLineRunner emailCommandLineRunner(EmailRepository repository){
        return args -> {
            Email email = new Email(
                    "example1@gmail.com"
            );
            Email email2 = new Email(
                    "example2@gmail.com"
            );
            repository.saveAll(
                    List.of(email, email2)
            );
        };
    }
}
