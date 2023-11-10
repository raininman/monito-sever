package com.raininman.monito.products;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository repository){
        return args -> {
            Product product1 = new Product(
                    "title1",
                    "desc1",
                    "10.0",
                    List.of("img1", "img2")
            );
            Product product2 = new Product(
                    "title2",
                    "desc2",
                    "10.0",
                    List.of("img1", "img2")
            );

            repository.saveAll(
                    List.of(product1, product2)
            );
        };
    }
}
